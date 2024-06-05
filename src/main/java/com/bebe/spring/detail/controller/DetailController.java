//package com.bebe.spring.detail.controller;
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.bebe.spring.detail.service.DetailService;
//import com.bebe.spring.vo.CartVO;
//import com.bebe.spring.vo.DetailVO;
//import com.bebe.spring.vo.UsersVO;
//
//@Controller
//@RequestMapping(value = "/productdetail")
//public class DetailController {
//
//	@Resource(name = "detailService")
//	private DetailService detailService;
//
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public String detail(Model model, DetailVO vo, HttpSession session) {
//
//		UsersVO  usersVO = (UsersVO) session.getAttribute("sessionUser");
//		if(usersVO != null) {
//		vo.setId(usersVO.getId());
//		}
//
//		int order= detailService.selectOrder(vo);
//		System.out.println("배송: "+order);
//		DetailVO listMain = detailService.selectDetailMain(vo);
//
//		List<DetailVO> listOne = detailService.selectOne(vo);
//		List<DetailVO> listAll = detailService.selectReview(vo);
//		List<DetailVO> listAllQuestion = detailService.selectAllQuestion(vo);
//		List<DetailVO> listOptions = detailService.selectOptions(vo);
//
//		List<DetailVO> listStar = null;
//		int starTotal = 0;
//		Double avg = 0.0;
//
//		Integer rv = detailService.selectOneReview(vo);
//		if (rv != null) {
//			listStar = detailService.starCnt(vo);
//			starTotal = detailService.starTotal(vo);
//			avg = Math.round(detailService.selectStarAvg(vo) * 10) / 10.0;
//		} else {
//		}
//
//		model.addAttribute("detMain", listMain);
//		model.addAttribute("rvOne", listOne);
//		model.addAttribute("rvAll", listAll);
//		model.addAttribute("qsAll", listAllQuestion);
//		model.addAttribute("avg", avg);
//		model.addAttribute("rvStar", listStar);
//		model.addAttribute("sTotal", starTotal);
//		model.addAttribute("detOptions", listOptions);
//		model.addAttribute("pUser", order);
//
//		return "/product/detail";
//	}
//
//	@RequestMapping(value = "/pop", method = RequestMethod.GET)
//	public String pop(Model model, DetailVO vo, HttpSession session, @RequestParam("userid") String userid) {
//		List<DetailVO> listOneQuestion = detailService.selectOneQuestion(vo);
//		model.addAttribute("qOne", listOneQuestion);
//		return "/product/pop";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/qna.del", method = RequestMethod.GET)
//	public String delQna(Model model, DetailVO vo, @RequestParam("productNo") String productNo) {
//		Integer rs = detailService.delAnswer(vo);
//		if (rs == 1) {
//			System.out.println("delAnswer 성공");
//		}
//		rs = detailService.delQuestion(vo);
//		if (rs == 1) {
//			System.out.println("delQuestion 성공");
//		}
//		return " ";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/updateQuestion", method = RequestMethod.GET)
//	public String updateQuestion(DetailVO vo) {
//		Integer rs = detailService.updateQuestion(vo);
//
//		if (rs == 1) {
//			System.out.println("업데이트 성공!");
//		} else {
//			System.out.println("실패!");
//		}
//		return " ";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/updateAnswer", method = RequestMethod.GET)
//	public String updateAnswer(DetailVO vo) {
//		Integer rs = detailService.updateAnswer(vo);
//
//		if (rs == 1) {
//			System.out.println("업데이트 성공!");
//		} else {
//			System.out.println("실패!");
//		}
//		return " ";
//	}
//
//	@RequestMapping(value = "/reveiw.do", method = RequestMethod.POST)
//	public ModelAndView insertReview(DetailVO vo, @RequestParam("productNo") String productNo,
//			HttpServletResponse response) throws IOException {
//
//		ModelAndView mv = new ModelAndView();
//			Integer rs = detailService.insertReview(vo);
//			if (rs == 1) {
//				System.out.println("성공!");
//			} else {
//				System.out.println("실패!");
//			}
//		mv.setViewName("redirect:/productdetail?productNo=" + productNo);
//		return mv;
//	}
//
//	@RequestMapping(value = "/question.do", method = RequestMethod.POST)
//	public ModelAndView insertQuestion(DetailVO vo, @RequestParam("productNo") String productNo) {
//		ModelAndView mv = new ModelAndView();
//
//		Integer rs = detailService.insertQuestion(vo);
//
//		if (rs == 1) {
//			System.out.println("성공!");
//		} else {
//			System.out.println("실패!");
//		}
//
//		mv.setViewName("redirect:/productdetail?productNo=" + productNo);
//		return mv;
//	}
//
//	@RequestMapping(value = "/reviewManage", method = RequestMethod.GET)
//	public String reviewManage(Model model, DetailVO vo, @RequestParam("productNo") String productNo) {
//		System.out.println("reviewManage 이동");
//		List<DetailVO> listRvBest1 = detailService.selectRvBest1(vo);
//		List<DetailVO> listRvBest0 = detailService.selectRvBest0(vo);
//
//		model.addAttribute("RvBest1", listRvBest1);
//		model.addAttribute("RvBest0", listRvBest0);
//		return "/product/reviewManage";
//	}
//
//	@RequestMapping(value = "/updateRvBest1", method = RequestMethod.GET)
//	public ModelAndView updateRvBest1(Model model, DetailVO vo, int[] cntRvNo,
//			@RequestParam("productNo") String productNo) {
//		System.out.println("베스트리뷰 등록");
//		detailService.updateRvBest1(cntRvNo);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("redirect:/productdetail/reviewManage?productNo=" + productNo);
//		return mv;
//	}
//
//	@RequestMapping(value = "/updateRvBest0", method = RequestMethod.GET)
//	public ModelAndView updateRvBest0(Model model, DetailVO vo, int[] cntRvNo,
//			@RequestParam("productNo") String productNo) {
//		System.out.println("베스트리뷰 삭제");
//		detailService.updateRvBest0(cntRvNo);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("redirect:/productdetail/reviewManage?productNo=" + productNo);
//		return mv;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/options.size")
//	public Map<String, List<DetailVO>> selectSecondOptions(Model model, DetailVO vo) {
//
//		Map<String, List<DetailVO>> map = new HashMap<String, List<DetailVO>>();
//		List<DetailVO> selectSecondOptions = detailService.selectSecondOptions(vo);
//		map.put("size", selectSecondOptions);
//
//		return map;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/options.stock")
//	public Map<String, Integer> selectStock(Model model, DetailVO vo) {
//
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		Integer stock = detailService.selectStock(vo);
//		map.put("stock", stock);
//		return map;
//	}
//
//	// cart
//	@ResponseBody
//	@RequestMapping(value = "/insertCart", method = RequestMethod.GET)
//	public Map<String, Integer> updateCart(DetailVO vo, Model model, @RequestParam("id") String id) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//
//		int cnt = detailService.selectDuplicateOpt(vo);
//		map.put("cnt", cnt);
//		if(cnt==0) {detailService.insertCart(vo);}
//
//		return map;
//	}
//
//	@RequestMapping(value = "/order", method = RequestMethod.GET)
//	public ModelAndView order(CartVO cv,ModelAndView mav) {
//
//		System.out.println(cv.getProductImg1());
//		ArrayList<CartVO> list = new ArrayList<>();
//		mav.setViewName("/order/order");
//		cv.setProductNo(cv.getProductNo());
//		list.add(cv);
//		mav.addObject("order",list);
//		System.out.println(list);
//		return mav;
//	}
//
//}
