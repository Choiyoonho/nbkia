package org.springex01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	/* 사용자가 로그인 한 상태인지 아닌지 판별 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null){
			logger.info("current user is not logined");
			saveDest(request);
			response.sendRedirect("user/login");
			return false;
		}
		return true;
	}
	/* saveDest() 메소드를 이용해서 원래 사용자가 원하는 페이지의 정보는
	 * HttpSession에 dest라는 이름으로 저장
	 * GET 방식인 경우에는 URI 정보 뒤에 파라미터들을 함께 보관해야 함 */
	private void saveDest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if(query == null || query.equals("null")){
			query = "";
		}else {
			query = "?" + query;
		}
		
		if(request.getMethod().equals("GET")) {
			logger.info("dest : " + (uri+ query));
			request.getSession().setAttribute("dest", uri+query);
		}
			
	}
}
