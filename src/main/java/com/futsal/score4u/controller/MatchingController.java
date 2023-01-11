package com.futsal.score4u.controller;

import com.futsal.score4u.dto.MatchingDTO;
import com.futsal.score4u.service.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/match")
@Log4j2
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;
    @GetMapping("/join")
    public void join() {
        log.info("Get Matching join...............");
    }

    @PostMapping("/join")
    public String join(@Valid MatchingDTO matchingDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST matching join.............");
        if(bindingResult.hasErrors()) {
            log.info("has errors...........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/match/join";
        }
        log.info(matchingDTO);
        matchingService.insert(matchingDTO);
        return "redirect:/match/list";
    }

    @GetMapping("/list")
    public void list(Model model) {
        log.info("matching list....................");
        model.addAttribute("dtoList", matchingService.getAll());
    }

    @GetMapping({"/read"})
    public void read(Long seq, Model model) {
        MatchingDTO matchingDTO = matchingService.getOne(seq);

        log.info(matchingDTO);

        model.addAttribute("dto", matchingDTO);
    }

    @PostMapping("/modify")
    public String modify(@Valid MatchingDTO matchingDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("has error........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("seq", matchingDTO.getSeqNo());
            return "redirect:/match/read?seq";
        }

//        log.info(todoDTO);
//        todoService.modify(todoDTO);
//        return
        return null;
    }

    @PostMapping("/signed")
    public String signed(MatchingDTO matchingDTO, RedirectAttributes redirectAttribute){

        matchingDTO.setFinished(!matchingDTO.isFinished());

        log.info("POST matching signed..........");
        matchingService.updateFinished(matchingDTO);
        return "redirect:/match/list";
    }


}
