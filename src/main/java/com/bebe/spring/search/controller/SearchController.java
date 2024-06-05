package com.bebe.spring.search.controller;

import com.bebe.spring.search.service.SearchService;
import com.bebe.spring.vo.Criteria;
import com.bebe.spring.vo.pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/product")
public class SearchController {
	SearchService searchService;
	//카테고리별 페이지 처리, 제품출력
//	@RequestMapping(value ="/searchPage",method = RequestMethod.GET)
//	public ModelAndView searchList( ModelAndView mav,  Criteria cri ) {
//		pager pg = new pager();
//		if(searchService.action(cri)==0) {
//			int num =searchService.scount(cri);
//			pg.setCri(cri);
//			pg.setTotalCount(num);
//			mav.addObject("list",searchService.searchlist(cri));
//			mav.addObject("ccc",cri.getKeyword());
//			mav.addObject("pg",pg);
//			System.out.println(searchService.searchlist(cri));
//			System.out.println(mav);
//			mav.setViewName("/product/searchPage");
//		}else {
//			int num =searchService.count(cri);
//			pg.setCri(cri);
//			pg.setTotalCount(num);
//			mav.setViewName("/product/searchPage");
//			mav.addObject("list",searchService.getlist(cri));
//			mav.addObject("pg",pg);
//		}
//		return mav;
//	}
	
//	@RequestMapping(value ="/searchPage",method = RequestMethod.GET)
//	public ModelAndView searchList( ModelAndView mav,  Criteria cri ) {
//		pager pg = new pager();
//
//			int num =searchService.ccount(cri);
//			pg.setCri(cri);
//			pg.setTotalCount(num);
//			mav.addObject("list",searchService.llist(cri));
//			mav.addObject("ccc",cri.getKeyword());
//			mav.addObject("pg",pg);
//			mav.setViewName("/product/searchPage");
//		return mav;
//	}
}
