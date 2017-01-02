package org.springex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	//Model클래스는 스프링에서 제공되는 클래스로 뷰에 원하는 데이터를 전달하는 일종의 컨테이너나 상자 역할을 함.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr){	//RedirectAttributes - URI에 보이지 않게 데이터를 전달함
		rttr.addFlashAttribute("msg", "this msg is msg");	//addFlashAttribute 임시 데이터를 전달
		
		/* redirect: - RedirectAttributes라는 클래스를 파라미터로 같이 사용하게 되면 리다이렉트 시점에 원하는 데이터를 임시로 추가해서 넘기는 작업이 가능
		 * forward: 지원
		 * (servlet) 참조*/
		return "redirect:/doF";
		
	}
	
}
