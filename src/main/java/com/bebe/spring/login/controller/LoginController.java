package com.bebe.spring.login.controller;

import com.bebe.spring.login.dao.LoginDAO;
import com.bebe.spring.login.service.LoginService;
import com.bebe.spring.vo.UsersVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {


	private LoginService loginService;

	LoginDAO loginDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		System.out.println("로그인페이지 이동");
		return "/login/login";
	}


//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String loginPost(UsersVO usersVO, HttpSession session,
//			RedirectAttributes redirectAttr,HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("로그인페이지 기능 수행");
//		System.out.println("userid"+usersVO);
//		UsersVO loginUsersVO = loginService.selectUsers(usersVO);
//		System.out.println("userid"+loginUsersVO);
//
//		String saveid = request.getParameter("saveId");
//		System.out.println(saveid);
//		if (loginUsersVO != null) {
//			System.out.println("로그인 성공");
//			session.setAttribute("selectUsers", 1);
////			session.setAttribute("UsersVO", usersVO);
//			session.setAttribute("sessionUser", loginUsersVO);
//			System.out.println(session+"userid"+usersVO);
//
//			if(saveid!=null) {
//                Cookie c = new Cookie("saveId",usersVO.getId());
//                //쿠키값 저장 시간을 지정함, 숫자당 1초로 계산
//                c.setMaxAge(60*60*24*7); //7일간 저장
//                response.addCookie(c);
//            }else {
//                Cookie c = new Cookie("saveId",usersVO.getId());
//                c.setMaxAge(0);
//                response.addCookie(c);
//            }
//
//			return "redirect:/index/index";
//		} else {
//			System.out.println("실패");
//			redirectAttr.addFlashAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다.");
//			return "redirect:/login/login";
//		}
//	}

	//세션초기화
//		@RequestMapping(value = "/logout")
//		public String logout(HttpSession session) {
//			session.invalidate();
//			return "redirect:/index/index";
//		}


	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet() {
	System.out.println("회원가입페이지 이동");
	 return "/login/signup";
	 }


	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(UsersVO usersVO) {
		System.out.println("회원가입 기능 수행");

		loginService.insertUsers(usersVO);
		return "/login/login";
	}

	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST/* , produces="text/plane" */)
	public int idChkPost(@RequestBody String id) {
		UsersVO usersVO = new UsersVO();

		System.out.println(id);
		id = id.substring(3);
		System.out.println("1");
		System.out.println("아이디 중복체크 기능 수행");
		if (id == null || "".equals(id)) {
			return 0;
		}
		usersVO.setId(id);

		System.out.println("2");
		System.out.println(usersVO);
		System.out.println(loginService.idCheck(usersVO));

		int result = loginDAO.idCheck(usersVO);
		System.out.println("3");
		System.out.println(result);
		return result;


	}




	@RequestMapping(value = "/findid", method = RequestMethod.GET)
	public String findidGet() {
		System.out.println("아이디 찾기 페이지 이동");
		return "/login/find_id";
	}

	@RequestMapping(value = "/findid", method = RequestMethod.POST)
	public String findidPost(UsersVO usersVO, Model model) {
		System.out.println("아이디 찾기 기능 수행");

		List<UsersVO> result = loginService.find_id(usersVO);

		if(result.isEmpty()) model.addAttribute("check", 1);
		else model.addAttribute("check", 0);


		model.addAttribute("id", result);
		System.out.println("rs2"+result);
		return "/login/find_idOK";

	}

	@RequestMapping(value = "/findidOK", method = RequestMethod.GET)
	public String findidOKGet() {
		System.out.println("비밀번호 찾기 페이지 이동");
		return "/login/find_idOK";
	}


	@RequestMapping(value = "/findpasswd", method = RequestMethod.GET)
	public String findpasswdGet() {
		System.out.println("비밀번호 찾기 페이지 이동");
		return "/login/find_passwd";
	}

	@RequestMapping(value = "/findpasswd", method = RequestMethod.POST)
	public String findpasswdPost(UsersVO usersVO, Model model) {
		System.out.println("비밀번호 찾기 기능 수행");
		UsersVO result = loginService.find_passwd(usersVO);

		if(result == null) {
		    model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
		    model.addAttribute("passwd", result.getPasswd());
		}

		return "/login/find_passwdOK";


	}

	@RequestMapping(value = "/findpasswdOK", method = RequestMethod.GET)
	public String findpasswdOKGet() {
		System.out.println("비밀번호 찾기 페이지 이동");
		return "/login/find_passwdOK";
	}



	@RequestMapping(value = "/constent", method = RequestMethod.GET)
	public String constentGet() {
		System.out.println("약관동의 페이지 이동");
		return "/login/terms";
	}


	//***************************************소셜로그인
//	@RequestMapping(value="/socailLogin", method = RequestMethod.GET)
//	public String socialLogin(UsersVO usersVO, HttpSession session) {
//		System.out.println(usersVO);
//		String email = usersVO.getId();
//		System.out.println(email);
//
//		int rs = loginService.selectSocialLogin(usersVO);
//		if(rs == 0) {
//			int res = loginService.insertSocialLogin(usersVO);
//			System.out.println("결과 : "+res);
//		}
//
//		session.setAttribute("sessionUser", usersVO);
//
//		return "redirect:/index/index";
//	}

	@RequestMapping(value="/naverCallback", method = RequestMethod.GET)
	public String naverCallback() {
		return "/login/naverCallback";
	}

}
