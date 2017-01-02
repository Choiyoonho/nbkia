package org.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import VO.ProductVO;

@Controller
public class sampleJSONController {
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON(){
		/* return type에서 @ResponseBody 애노테이션 */
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		return vo;
	}
}
