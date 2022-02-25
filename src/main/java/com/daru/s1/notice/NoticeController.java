package com.daru.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daru.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		List<NoticeDTO> ar = noticeService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		return mv;
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	//add
	//이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
	}
	
	//입력
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
}
