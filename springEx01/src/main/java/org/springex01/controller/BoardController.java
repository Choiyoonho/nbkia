package org.springex01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springex01.domain.BoardVO;
import org.springex01.domain.Criteria;
import org.springex01.domain.PageMaker;
import org.springex01.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	private BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO vo, Model model) throws Exception {
		logger.info("registerGET().....");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, /*Model model*/ RedirectAttributes rttr) throws Exception {
		logger.info("registerPOST().....");
		logger.info(board.toString());
		
		service.register(board);
		/* model 스프링 MVC에서 제공하는 데이터 전달용 객체.
		 * Map과 유사하게 Key, value로 데이터 저장.
		 * Servlet에서 RequestDispatcher와 유사기능*/
		//model.addAttribute("result", "success");
		
		/* model의 경우 URI에 result=success가 계속 남아 있기에 새로 고침해도 남는 문제가 있다.
		 * 이를 보완하기 위해서 스프링에서 제공하는 리다리엑트 시점에 한번만 사용되는 데이터를 전송하는
		 *  RedirectAttribute 객체의 addFlashAttribute()를 사용*/
		rttr.addFlashAttribute("msg", "success");
		
		//return "/board/success"; // 새로고침시 재등록 요청 질문을 한다.(이를 악의적으로 사용하여 도배 가능 하기에 아래와 같이 수정
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("listAll().....");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		/* @RequestParam 애노테이션은 Servlet에서 request.getParameter()의 효과와 유사*/
		model.addAttribute(service.read(bno));	//addAttribute() 작업을 할 때 아무런 이름 없이 데이터를 넣으면 자동으로 클래스의 이르믈 소문자로 시작해서 사용
	}
	
	/* 다시 목록 페이지로 돌아기기 위한 정보
	 * 1) 현재 목록 페이지의 페이지 번호
	 * 2) 현재 목록 페이지의 페이지당 데이터의 수 */
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		/* 삭제 또한 새로고침으로 데이터를 재전송 할 수 있기에 RedirectAttributes의 addFlashAttribute로 처리하고
		 * return을 redirect로 처리한다.*/
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("modifyPOST().....");
		
		service.modify(board);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("listAll criteria ()....."); 
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131); test용
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
}
