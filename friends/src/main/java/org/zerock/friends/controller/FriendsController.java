package org.zerock.friends.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.friends.dto.FriendsDTO;
import org.zerock.friends.dto.PageRequestDTO;
import org.zerock.friends.dto.PageResponseDTO;
import org.zerock.friends.service.FriendsService;

import javax.validation.Valid;

@Controller
@RequestMapping
@Log4j2
@RequiredArgsConstructor
public class FriendsController {

    private final FriendsService friendsService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<FriendsDTO> responseDTO = friendsService.list(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO",responseDTO);
    }

    @GetMapping("/register")
    public void registerGET() {

    }

    @PostMapping("/register")
    public String register(@Valid FriendsDTO friendsDTO, BindingResult bindingResult, RedirectAttributes rttr) {

        if (bindingResult.hasErrors()) {
            rttr.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/register";
        }

        Long fno = friendsService.register(friendsDTO);
        rttr.addFlashAttribute("result",fno);


        return "redirect:/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(Long fno,PageRequestDTO pageRequestDTO,Model model){

        FriendsDTO friendDTO = friendsService.readOne(fno);
        model.addAttribute("dto",friendDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid FriendsDTO friendsDTO,
                         BindingResult bindingResult, RedirectAttributes rttr){
        if(bindingResult.hasErrors()){
            log.info("errors");
            String link = pageRequestDTO.getLink();
            rttr.addFlashAttribute("errors",bindingResult.getAllErrors());
            rttr.addAttribute("fno",friendsDTO.getFno());
            return "redirect:/modify?"+link;
        }
        friendsService.modify(friendsDTO);
        rttr.addFlashAttribute("result","modified");
        rttr.addAttribute("fno",friendsDTO.getFno());
        return "redirect:/list";
    }
    @PostMapping("/remove")
    public String remove(Long fno,RedirectAttributes rttr){
        friendsService.remove(fno);
        rttr.addFlashAttribute("result","removed");
        return "redirect:/list";


    }

}
