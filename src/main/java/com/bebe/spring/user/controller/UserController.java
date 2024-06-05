//package com.bebe.spring.user.controller;
//
//import com.bebe.spring.user.service.UserService;
//import com.bebe.spring.usermylog.service.userMylogService;
//import com.bebe.spring.vo.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping(value="/user/*")
//@RequiredArgsConstructor
//public class UserController {
//
//	private UserService userService;
//
//	userMylogService userMylogService;
//
//	//-------------------------------------------- 유저 구매내역 페이지 --------------------------------------------
//	//유저 구매내역 검색
//	@RequestMapping(value="/purchase_history", method = RequestMethod.GET)
//	public ModelAndView userHistoryGet(HttpServletRequest req, HttpSession session) {
//
//		//세션 아이디값 받아오기
//		UsersVO userVO = (UsersVO) session.getAttribute("sessionUser");
//
//		String id ="";
//		if(userVO != null) {
//			id = userVO.getId();
//		}
//
//		List<OrdersVO> list = userService.selectOrdersList(id);
//		ModelAndView mav = new ModelAndView("/user/purchase_history");
//		mav.addObject("polist", list);
//		return mav;
//	}
//
//	@RequestMapping(value="/purchase_history", method = RequestMethod.POST)
//	public String userHistoryPost(HttpServletRequest req) {
//		return "/user/purchase_history";
//	}
//
//	//주문상세 버튼 눌렀을 때 팝업창
//	@RequestMapping(value="/post_info", method = RequestMethod.GET)
//	public ModelAndView userPostInfoGet(HttpServletRequest req, @RequestParam(value ="on") int orderNo,
//			@RequestParam(value ="name") String pName) {
//		OrdersAddressVO list =  userService.selectAddress	(orderNo);
//
//		ModelAndView mav = new ModelAndView("/user/post_info");
//		mav.addObject("orderlist",list);
//		mav.addObject("pName", pName);
//		return mav;
//	}
//
//	//취소 버튼 눌렀을때
//	@RequestMapping(value="/post_cancel", method = RequestMethod.GET)
//	public ModelAndView userPostCancelGet(HttpServletRequest req, @RequestParam(value ="on") int orderNo ) {
//
//		System.out.println("취소 컨트롤러 진입");
//		userService.updatePostCancel(orderNo);
//		HttpSession session = req.getSession();
//		UsersVO userVO = (UsersVO) session.getAttribute("sessionUser");
//		//세션에서 아이디 받아오기
//		String id ="";
//		if(userVO != null) {
//			id = userVO.getId();
//		}
//		System.out.println(id);
//
//		List<OrdersVO> list = userService.selectOrdersList(id);
//		ModelAndView mav = new ModelAndView("/user/purchase_history");
//		mav.addObject("polist", list);
//
//		return mav;
//	}
//
//	//유저 인포 첫화면
//	@RequestMapping(value ="/user_info", method = RequestMethod.GET)
//	public String modifyGET() throws Exception {
//
//		return "/user/user_info";
//	}
//
//	//유저 인포에서
//	@RequestMapping(value ="/user_info", method = RequestMethod.POST)
//	public String modifyPOST(HttpSession session, UsersVO vo, RedirectAttributes ra) throws Exception {
//
//
//
//		userService.modify(vo);
//		UsersVO userVO = (UsersVO) session.getAttribute("sessionUser");
//		userVO.setPasswd(vo.getPasswd());
//		session.setAttribute("sessionUser", userVO);
//		System.out.println(vo);
//		ra.addFlashAttribute("result", "updateOK");
//		return "redirect:/user/user_info";
//	}
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
//	public String getmyloglist(Model model, String select, HttpSession session, String logDate) throws Exception {
//
//		UsersVO userVO = (UsersVO) session.getAttribute("sessionUser");
//		String id ="";
//		if(userVO != null) {
//			id = userVO.getId();
//		}
//
//		System.out.println(logDate);
//
//		Map<String, String> map = new HashMap<>();
//		map.put("id", id);
//		map.put("logDate", logDate);
//
//		if(select.equals("question")) {
//		List<QuestionVO> list = null;
//		list = userMylogService.qlist(map);
//		model.addAttribute("list", list);
//		}
//		if(select.equals("review")) {
//		List<ReviewVO> list =null;
//		list = userMylogService.rlist(map);
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
//}
//
//
//
//
//
//
//
//
//
//
