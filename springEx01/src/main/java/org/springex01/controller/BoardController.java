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
		/* model ������ MVC���� �����ϴ� ������ ���޿� ��ü.
		 * Map�� �����ϰ� Key, value�� ������ ����.
		 * Servlet���� RequestDispatcher�� ������*/
		//model.addAttribute("result", "success");
		
		/* model�� ��� URI�� result=success�� ��� ���� �ֱ⿡ ���� ��ħ�ص� ���� ������ �ִ�.
		 * �̸� �����ϱ� ���ؼ� ���������� �����ϴ� ���ٸ���Ʈ ������ �ѹ��� ���Ǵ� �����͸� �����ϴ�
		 *  RedirectAttribute ��ü�� addFlashAttribute()�� ���*/
		rttr.addFlashAttribute("msg", "success");
		
		//return "/board/success"; // ���ΰ�ħ�� ���� ��û ������ �Ѵ�.(�̸� ���������� ����Ͽ� ���� ���� �ϱ⿡ �Ʒ��� ���� ����
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("listAll().....");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		/* @RequestParam �ֳ����̼��� Servlet���� request.getParameter()�� ȿ���� ����*/
		model.addAttribute(service.read(bno));	//addAttribute() �۾��� �� �� �ƹ��� �̸� ���� �����͸� ������ �ڵ����� Ŭ������ �̸��� �ҹ��ڷ� �����ؼ� ���
	}
	
	/* �ٽ� ��� �������� ���Ʊ�� ���� ����
	 * 1) ���� ��� �������� ������ ��ȣ
	 * 2) ���� ��� �������� �������� �������� �� */
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		/* ���� ���� ���ΰ�ħ���� �����͸� ������ �� �� �ֱ⿡ RedirectAttributes�� addFlashAttribute�� ó���ϰ�
		 * return�� redirect�� ó���Ѵ�.*/
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
		//pageMaker.setTotalCount(131); test��
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
}
