package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
// 어떤 경로로 와야 적절하게 일을 할 수 있다.
public class BoardController {
	
	private BoardService service;
	
//	@Autowired
//	public BoardController(BoardService service)
//		this.service = service;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("board/list method....");
		
		// 하는일: service getList(); 한 실행 결과를
		List<BoardVO> list = service.getList();
		// model에 attribute로 넣고
		model.addAttribute("list", list);
		
		// view로 forward
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		// service에게 등록업무 시키고
		service.register(board);  // board 의 property 는 title, content, writer 
		// redirect 목적지로 정보 전달
		rttr.addFlashAttribute("result", board.getBno());
		
		// /board/list 로 redirect
		return "redirect:/board/list";
	}
	
}
