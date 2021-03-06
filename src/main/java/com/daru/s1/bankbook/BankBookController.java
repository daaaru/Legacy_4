package com.daru.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.daru.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	@Autowired
	private BankBookService bankBookService;
	

	//update이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model )throws Exception{
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	//DB update
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO)throws Exception {
		int result = bankBookService.update(bankBookDTO);
		
		return "redirect:./list";
	}
	
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception{
		//modelandview 사용방법
		//1. 매개변수로 선언
		//2. 메서드내에서 객체 직접 생성
		//2.ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bankbook/list");
		return mv;
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookService.detail(bankBookDTO);
		
		//조회가 성공하면 출력
		//실패하면 alert으로 없는번호입니다. 다시 list로이동
		//common/result.jsp활용
		
		String view ="common/result";
		if(bankBookDTO!=null) {
			view = "bankbook/detail";
			model.addAttribute("dto", bankBookDTO);
		}else {
			model.addAttribute("message", "없는번호 입니다");
			model.addAttribute("path", "./list");
		}
		return view;
		
	}
	//insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		
	}
	//DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.add(bankBookDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.delete(bankBookDTO);
		
		return "redirect:./list";
	}
	
}
