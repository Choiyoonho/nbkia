package org.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import VO.ProductVO;

@Controller
public class sampleJSONController {
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON(){
		/* return type���� @ResponseBody �ֳ����̼� */
		ProductVO vo = new ProductVO("���û�ǰ", 30000);
		
		return vo;
	}
}
