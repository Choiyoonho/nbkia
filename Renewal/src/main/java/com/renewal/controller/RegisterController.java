package com.renewal.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.renewal.dto.MemberDTO;
import com.renewal.service.MemberService;

@Controller
@RequestMapping("/register")	//여기에 추가하는 이유가 뭐지?
public class RegisterController {
	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/register", method =  RequestMethod.GET)
	public String register(Model model) throws Exception{
		return "/register/register";
	}
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.POST)
	public String registerForm(MemberDTO dto) throws Exception{
		service.register(dto);
		return null;
	}
}
