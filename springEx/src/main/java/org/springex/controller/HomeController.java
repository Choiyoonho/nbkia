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
	public String home(Locale locale, Model model) {	//ModelŬ������ ���������� �����Ǵ� Ŭ������ �信 ���ϴ� �����͸� �����ϴ� ������ �����̳ʳ� ���� ������ ��.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr){	//RedirectAttributes - URI�� ������ �ʰ� �����͸� ������
		rttr.addFlashAttribute("msg", "this msg is msg");	//addFlashAttribute �ӽ� �����͸� ����
		
		/* redirect: - RedirectAttributes��� Ŭ������ �Ķ���ͷ� ���� ����ϰ� �Ǹ� �����̷�Ʈ ������ ���ϴ� �����͸� �ӽ÷� �߰��ؼ� �ѱ�� �۾��� ����
		 * forward: ����
		 * (servlet) ����*/
		return "redirect:/doF";
		
	}
	
}
