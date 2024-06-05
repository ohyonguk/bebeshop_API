//package com.bebe.spring.board.controller;
//
//import java.io.PrintWriter;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.bebe.spring.board.service.BoardService;
//import com.bebe.spring.board.vo.BoardVO;
//import com.bebe.spring.board.vo.Criteria;
//import com.bebe.spring.board.vo.PageMaker;
//
//@Controller
//@RequestMapping("/board/")
//public class BoardController {
//
//	// 객체타입이 일치하는 객체타입을 자동으로 주입한다.
//	private BoardService service;
//
//	@RequestMapping(value = "admin_notice", method = RequestMethod.GET)
////	jsp, servlet으로 웹을 만들때는 request, session으로 받아오지만 spring은 model로 받아온다
//	public String list(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//		model.addAttribute("noticeList", service.noticeList(cri));
//		model.addAttribute("faqList", service.faqList());
//
//		// 페이징 관리
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(service.noticeListCount(cri));
//		model.addAttribute("pageMaker", pageMaker);
//
//		System.out.println();
//		System.out.println("admin_notice");
//		return "board/admin_notice";
//	}
//
//	@RequestMapping(value = "admin_write", method = RequestMethod.GET)
//	public String read(BoardVO boardVO, Model model, @RequestParam("b") int num, HttpServletResponse res)
//			throws Exception {
////		model.addAttribute("key", 원하는 내용)
////		BoardVO에 있는 noticeNo를 넣어서 readNotice에 저장합니다.
//		model.addAttribute("b", num);
//		model.addAttribute("category", service.category(boardVO.getNoticeCategory()));
//
//		if (num == 0) {
//
//			Integer rnum = service.rnumCount();
//			 if( rnum == null) rnum =0;
//
//			if (rnum >= 10) {
//				res.setContentType("text/html; charset=utf-8");
//				PrintWriter out = res.getWriter();
//				out.println("<script>alert('Best FAQ는 최대10개까지 게시할 수 있습니다.'); </script>");
//				out.flush();
//			}
//		} else if (num == 1) {
//			model.addAttribute("readNotice", service.readNotice(boardVO.getNoticeNo()));
//
//		} else if (num == 2) {
//			model.addAttribute("readFaq", service.readFaq(boardVO.getFaqNo()));
//		}
//
//		System.out.println("admin_write");
//		return "board/admin_write";
//	}
//
//	/*
//	 * spring에서 client로 받은 요청을 객체로 바인딩하는 방법 1.@RequestBody, 2.@ModelAttribute,
//	 * 3.@RequestParam가 있다.
//	 *
//	 * @RequestBody: 1개의 http요청 파리미터를 받기 위해 사용(반드시 해당 파라미터가 정송되어야 한다.)
//	 *
//	 * @RequestParam: Json(application/json)형태의 http body내용을 java object로 변환시켜주는 역할
//	 *
//	 * @ModelAttribute: multipart/form-data형태의 http body 내용과 http 파라키터들을 setter을 통해
//	 * 1대1로 객체에 바인딩 (어떤 데이터를 set해주는 setter함수가 없다면 매핑이 되지 않는다. 하지만 requestbody는 데이터를
//	 * 변환시키는 것이기에 setter없이도 가능)
//	 */
//	// 등록
//	@RequestMapping(value = "writeNotice", method = RequestMethod.POST)
//	public String writeNotice(BoardVO boardVO, HttpServletResponse res) throws Exception {
//		res.setContentType("text/html; charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<script>alert('등록되었습니다.'); location.href = '/board/admin_notice';</script>");
//		out.flush();
//		service.writeNotice(boardVO);
//
//		System.out.println("입 to the 력");
//		return "board/admin_notice";
//	}
//
//	@RequestMapping(value = "writeFaq", method = RequestMethod.POST)
//	public String writeFaq(BoardVO boardVO, HttpServletResponse res) throws Exception {
//		PrintWriter out = res.getWriter();
//		res.setContentType("text/html; charset=utf-8");
//
//		Integer rnum = service.rnumCount();
//		 if( rnum == null) rnum =0;
//
//		boardVO.setRnum(rnum);
//
//		if (boardVO.getRnum() >= 10) {
//			out.println("<script>alert('Best FAQ 게시물 삭제 후 진행해 주시기 바랍니다.'); </script>");
//			out.println("<script>location.href = '/board/admin_notice'; </script>");
//			out.flush();
//		} else {
//			service.writeFaq(boardVO);
//			out.println("<script>alert('등록되었습니다.'); location.href = '/board/admin_notice';</script>");
//			out.flush();
//
//		}
//
//		System.out.println("입 to the 력");
//		return "/board/admin_notice";
//	}
////	요청에 대해 어떤 controller, 어떤 메소드가 필요할지를 맵핑하기 위한 어노테이션
//	/*
//	 * value, method, params, consumes, produces를 사용할 수있다. value: url값으로 매핑 조건을 부여
//	 * method: HttpRequest메소드 값을 매핑 조건으로 부여 params: HttpRequest파라미터를 매핑 조건으로 부여
//	 * consumes: 설정과 content-type request헤더가 일치할 경우에만 url이 호출됨 produces: 설정과 accept
//	 * request 헤더가 일치할 경우에만 url이 호출
//	 */
//
//	// 삭제
//	@RequestMapping(value = "delete", method = RequestMethod.GET)
//	public String delete(BoardVO boardVO, Model model, @RequestParam("b") int num) throws Exception {
//
//		if (num == 1) {
//			service.deleteNotice(boardVO.getNoticeNo());
//		} else {
//			service.deleteFaq(boardVO.getFaqNo());
//		}
//
//		System.out.println("삭 to the 제");
//		return "redirect:/board/admin_notice";
//	}
//
//	// 수정
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(BoardVO boardVO, Model model) throws Exception {
//
//		if (boardVO.getFaqNo() == 0) {
//			service.updateNotice(boardVO);
//		} else {
//			service.updateFaq(boardVO);
//		}
//
//		System.out.println("업 to the 데");
//		return "redirect:/board/admin_notice";
//	}
//
//}
