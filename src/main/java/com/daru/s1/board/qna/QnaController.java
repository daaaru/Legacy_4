package com.daru.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daru.s1.board.BoardDTO;
import com.daru.s1.board.notice.NoticeDTO;
import com.daru.s1.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	//model에 board라는 속성명으로 qna를 담겠다 메서드 호출할때마다 실행됨 
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
		mv.addObject("dto", qnaDTO);//부모글번호
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.update(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	//delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model)throws Exception{
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	
	//detail
	@RequestMapping(value = "detail",method =RequestMethod.GET)
	public String detail(QnaDTO qnaDTO,Model model)throws Exception{
		BoardDTO boardDTO=qnaService.detail(qnaDTO);
		model.addAttribute("dto",boardDTO);
		
		return "board/detail";
	}
	
	//list
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String list(Pager pager,Model model)throws Exception{
		List<BoardDTO> ar=qnaService.list(pager);
		model.addAttribute("list",ar);
		
		return "board/list";
		
	}
	//form으로 이동 
		@RequestMapping(value = "add", method = RequestMethod.GET)
		public ModelAndView add() throws Exception{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("board/add");
			return mv;
			
		}
		//입력받은 값을 받아서 DB로 보내 
		@RequestMapping(value = "add",method = RequestMethod.POST)
		public ModelAndView add(QnaDTO qnaDTO, MultipartFile [] files) throws Exception{
			ModelAndView mv= new ModelAndView();
			int result= qnaService.add(qnaDTO, files);
			mv.setViewName("redirect:./list");
			
			return mv;
		}
}

