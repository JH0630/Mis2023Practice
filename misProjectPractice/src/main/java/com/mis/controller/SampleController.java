package com.mis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.ProductVO;

@Controller
public class SampleController {

	private static final Logger Logger = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("doA")
	public void doA() {
		Logger.info("doA() called..");
	}

	@RequestMapping("doB")
	public String doB() {
		Logger.info("doB() called..");
		return "home";
	}

	@RequestMapping("doC")
	public String doC(Model model, @ModelAttribute("msg") String msg) {
		Logger.info("doC() called.." + msg);

		ProductVO pvo = new ProductVO();

		pvo.setName("상품이름");
		pvo.setPrice(8999);

		// 화면으로 상품정보를 전달
		model.addAttribute(pvo);

		return "productDetail";
	}

	@RequestMapping("doD")
	public String doD(RedirectAttributes rttr) {

		Logger.info("doD() called..");
		rttr.addAttribute("msg", "page move..");

		return "redirect:/doC";
	}

	@RequestMapping("doJSON")
	public @ResponseBody ProductVO doJSON() {
		
		ProductVO pvo = new ProductVO();
		
		pvo.setName("상품이름");
		pvo.setPrice(8999);
		
		return pvo;
	}

}
