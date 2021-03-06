package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	@NonNull
	private final BoardService service;
	
	// 목록에 대한 처리
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	// 입력 페이지를 보여주는 역할만 하기 때문에 별도의 처리는 필요하지 않음
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 등록에 대한 처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
											// 등록 작업이 끝난 후 다시 목록 화면으로 이동하기 위함, 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달하기 위해서 이용
		log.info("register : " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		// redirect: -> 스프링 MVC가 내부적으로 response.sendRedirect()를 처리해 주기 때문에 편리함
		return "redirect:/board/list";
	}
	
	// 조회에 대한 처리
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	// 수정에 대한 처리
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("modify : " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	// 삭제에 대한 처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("remove..." + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
