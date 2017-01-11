package org.springex01.controller;

import javax.inject.Inject;

import org.springex01.domain.BoardVO;
import org.springex01.domain.PageMaker;
import org.springex01.domain.SearchCriteria;
import org.springex01.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() throws Exception {
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(BoardVO board, RedirectAttributes rttr) throws Exception {
		service.register(board);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/sboard/searchList";
	}
	
	@RequestMapping(value = "/searchList", method = RequestMethod.GET)
	public void searchList(@ModelAttribute("searchCri") SearchCriteria cri, Model model) throws Exception {
		//model.addAttribute("searchList", service.listCriteria(cri));
		model.addAttribute("searchList", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "removePage", method = RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.read(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/sboard/list";
	}
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPage(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "modifyPage", method = RequestMethod.POST)
	public String modifyPage(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/sboard/list";
	}
}
