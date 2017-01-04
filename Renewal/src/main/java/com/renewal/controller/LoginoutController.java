package com.renewal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginoutController {
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("아이디 : " + request.getParameter("memberId") + "\n" + "비밀번호 : " + request.getParameter("memberPw"));
		
		return "home";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request){
		if(request.getSession() != null){
			//invalidate();
		}
		return null;
	}
}
