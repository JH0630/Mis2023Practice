package com.mis.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.PageMaker;
import com.mis.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger Logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet() throws Exception {

		Logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String regisgerPost(BoardVO vo, Model model) throws Exception {

		Logger.info("register Post...");

		// �Խñ� ���
		service.register(vo);

		// ���� ȭ������ �̵� + �޽��� �߰�
		model.addAttribute("result", "success");

		return "redirect:/board/listAll";

	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {

		Logger.info("listAll get...");

		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {

		Logger.info("read get...");

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		Logger.info("remove Post...");

		// �Խñ� ���
		service.remove(bno);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/listAll";

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGet(@RequestParam("bno") int bno, Model model) throws Exception {

		Logger.info("modify get...");

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO vo, RedirectAttributes rttr) throws Exception {

		Logger.info("modify Post...");

		service.modify(vo);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/listAll";

	}

	// ����¡ ��� �߰�

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		Logger.info("listpage get...");

		// ���õ� �������� �Խñ� ������ 10�� ��������
		model.addAttribute("list", service.listCriteria(cri));

		// ������ �׺���̼� �߰�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));

		// ����¡ ���� ȭ�� ����
		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {

		Logger.info("readPage get...");

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPageGet(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {

		Logger.info("modifyPage get...");

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePost(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr)
			throws Exception {

		Logger.info("modifyPage Post...");

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("page", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/listPage";

	}
	
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		Logger.info("removePage...");

		service.remove(bno);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/listPage";

	}

}
