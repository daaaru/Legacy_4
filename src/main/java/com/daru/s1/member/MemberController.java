package com.daru.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//mypage
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
	//logdout
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate(); // 세션해제 
		return "redirect:../";
	}

	//insert
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile photo) throws Exception {
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getSize());
		int result = memberService.join(memberDTO, photo);
		
		return "redirect:../";
	}
	
	//insert 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
	}
	
	@RequestMapping(value = "joinCheck", method = RequestMethod.GET)
	public void joinCheck()throws Exception{
		
	}
	
	
	//login 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(value="remember", defaultValue = "",required = false)String rememberID) throws Exception {
		//model.addAttribute("rememberID", rememberID);
		 
	}
	
	//login 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, MemberDTO memberDTO, String remember, Model model, HttpServletResponse response) throws Exception {
		memberDTO = memberService.login(memberDTO);
		
		System.out.println("remember :" + remember);
		
		if(remember != null && remember.equals("1")) {
			//cookie만들때
			Cookie cookie = new Cookie("remember", memberDTO.getId());		
			//cookie.setPath("/");
			cookie.setMaxAge(-1);
			//응답
			response.addCookie(cookie);
		
		//같은이름의 쿠키를 덮어씌움(삭제)
			
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
//		
//		
//		String path ="redirect:./login";
//		
//		//로그인이 됐다면
//		if(memberDTO != null) {
//			session.setAttribute("member", memberDTO);
//			path = "redirect:../";
//		}
		String message ="Login Fail";
		String p="./login";
		
		if(memberDTO!=null) {
			session.setAttribute("member", memberDTO);
			message = "Login Success";
			p="../";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		String path="common/result";
		return path;
	}
}
