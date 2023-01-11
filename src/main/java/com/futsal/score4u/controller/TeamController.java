package com.futsal.score4u.controller;

import com.futsal.score4u.domain.TeamVO;
import com.futsal.score4u.dto.TeamDTO;
import com.futsal.score4u.service.TeamService;
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
@RequestMapping("/team")
@RequiredArgsConstructor
@Log4j2
public class TeamController {

    private final TeamService teamService;

    @RequestMapping ("/list")
    public void list(Long mSeqNo, Model model) {
        log.info("GET Team List................");
        model.addAttribute("dto", teamService.getTeam(mSeqNo));
    }

    @GetMapping("/join")
    public void join() {
        log.info("GET TEAM JOIN..........");
    }

    @PostMapping("/join")
    public String join(@Valid TeamDTO teamDTO, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("has error........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("seq", teamDTO.getSeqNo());
            return "redirect:/team/list?mSeqNo";
        }

        log.info("POST TEAM JOIN.............");
        teamService.insertTeam(teamDTO);

        return "redirect:/match/list";
    }

}
