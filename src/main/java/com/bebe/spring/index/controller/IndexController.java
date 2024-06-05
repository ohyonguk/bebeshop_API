package com.bebe.spring.index.controller;

import com.bebe.spring.index.service.IndexService;
import com.bebe.spring.vo.ProductVO;
import com.bebe.spring.vo.ReviewVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
	IndexService indexService;
	
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public ModelAndView Index(ModelAndView mav,ProductVO pv, ReviewVO rv) {
		System.out.println("index페이지 접근");
		System.out.println(pv);
		mav.addObject("slide", indexService.newItem(pv));
		mav.addObject("Index", indexService.hotItem(pv));
		mav.addObject("rv",indexService.bestRv(rv));
		mav.setViewName("/index/index");
	
		return mav;
	}

}
