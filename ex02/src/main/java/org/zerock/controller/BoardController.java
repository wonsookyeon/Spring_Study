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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/")
@RequiredArgsConstructor // public final 변수명 기입된 것은 자동주입
public class BoardController {
	
	private final BoardService service; //final 자동주입
	
	@GetMapping("list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getlist());
	}
	
	@GetMapping("register")
	public void register() {
		
	}
	
	@PostMapping("register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("register : {}", vo);
		service.register(vo);
		
		rttr.addFlashAttribute("result", vo.getBno());
		
		return "redirect:/board/list"; //화면이동
	}
	
	@GetMapping({"/get","/modify"}) //상세페이지
	public void get(@RequestParam("bno") Long bno, Model model) {
		            //ControllerTest에서 넘어온 값을 받아서 넘겨줌(정확)
		log.info("/get or /modify : {}", bno);
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("remove")                              //화면전환이 필요하므로
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("/remove : {}", bno);
		if(service.remove(bno)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("modify : {}", vo);
		if(service.modify(vo)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
	
	
	
	

}
