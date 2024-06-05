//package com.bebe.spring.user.controller;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.bebe.spring.usermylog.service.userMylogService;
//import com.bebe.spring.vo.QuestionVO;
//import com.bebe.spring.vo.ReviewVO;
//import com.bebe.spring.vo.UsersVO;
//
//@Controller
//@RequestMapping("/user/*")
//public class myLogController {
//
//	@Inject
//	userMylogService userMylogService;
//	
//	//사이드바에서 페이지이동
//	@RequestMapping(value ="/mylog", method = RequestMethod.GET)
//	public String getmyloglist(Model model) throws Exception {
//		
//		return "/user/my_log";
//	}
//	
//	//문의리뷰나오기
//	@RequestMapping(value ="/mylog", method = RequestMethod.POST)
//	public String getmyloglist(Model model, String select, HttpSession session) throws Exception {
//		
//		UsersVO uservo = (UsersVO) session.getAttribute("sessionUser");
//		String id = uservo.getId();
//
//		if(select.equals("question")) {
//		List<QuestionVO> list = null;
//		list = userMylogService.qlist(id);
//		model.addAttribute("list", list);
//		}
//		if(select.equals("review")) {
//		List<ReviewVO> list =null;
//		list = userMylogService.rlist(id);
//		model.addAttribute("list", list);
//		}
////		question인지 review인지 알려줌
//		System.out.println(select);		
//		
//		model.addAttribute("select", select);
//		
////		model.addAttribute("rlist", rlist);
//		
//		return "/user/my_log";
//	}
//	
//	
//}
