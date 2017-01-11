package org.springex01.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		
		if(userVO != null){
			System.out.println("new login success");
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			
			/* 자동 로그인을 선택한 경우 쿠키를 생성하고 
			 * 생성된 쿠키의 이름은 loginCookie로 지정하고 값은 세션의 아이디를 보관
			 * 세션 아이디는 세션 쿠키의 값을 의미 */
			if(request.getParameter("useCookie") != null) {
				logger.info("remember me...........");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);	//7주일 보관
				response.addCookie(loginCookie);
			}
			//response.sendRedirect("/");	//AuthInterceptor 적용전 : 로그인시 / 으로 이동
			/* AuthInterceptor을 통해서 이전 페이지의 정보를 갖고 로그인시 해당 페이지로 이동 */
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String) dest:"/");
		}
	}
	
	/* preHandle
	 * 기존에 HttpSession에 남아있는 정보가 있는 경우 정보를 삭제 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN) != null){
			System.out.println("clear login data before");
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}
}
