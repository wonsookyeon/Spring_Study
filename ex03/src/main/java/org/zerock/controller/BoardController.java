package org.zerock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor // public final 변수명 기입된 것은 자동 주입
public class BoardController {

    private final BoardService service;

//    @GetMapping("list")
//    public void list(Model model){
//        log.info("list");
//        model.addAttribute("list",service.getList(new Criterial(2,10)));
//    }
//
    @GetMapping("list")
    public void list(Criterial cri, Model model){
        log.info("list: {}" + cri);
        model.addAttribute("list", service.getList(cri));

        int total = service.getTotal(cri);
        model.addAttribute("pageMaker", new PageDTO(cri, total));

    }


    @GetMapping("register")
    public void register(){

    }

    @PostMapping("register")
    public String register(BoardVO vo, RedirectAttributes rttr) {
        log.info("register : {}",vo);

        service.register(vo);

        rttr.addFlashAttribute("result",vo.getBno());

        return "redirect:/board/list";
    }

    @GetMapping({"get","/modify"})
    public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criterial cri, Model model) {
        log.info("/get or /modify: {}",bno);
        model.addAttribute("board",service.get(bno));
    }

    @PostMapping("remove")
    public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criterial cri, RedirectAttributes rttr) {
        log.info("remove : {}",bno);
        if(service.remove(bno)){
            rttr.addAttribute("result","success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list";
    }

    @PostMapping("modify")
    public String modify(BoardVO vo, @ModelAttribute("cri") Criterial cri, RedirectAttributes rttr){
        log.info("modify : {}",vo);

        if(service.modify(vo)){
            rttr.addFlashAttribute("result","success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list";
    }
}
