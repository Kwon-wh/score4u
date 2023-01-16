package com.futsal.score4u.controller;

import com.futsal.score4u.dto.UserDTO;
import com.futsal.score4u.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;


    @GetMapping("/join")
    public void join() {
        log.info("GET user join.............");
    }

    @PostMapping("/join")
    public String join(@Valid UserDTO userDTO, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.info("has error...........");
            redirectAttributes.addAttribute("errors", bindingResult.hasErrors());
            redirectAttributes.addAttribute("seq", userDTO.getSeqNo());

            return "redirect:/user/join";
        }

        log.info("POST USER join.............>>>");
        userService.joinUser(userDTO);
        return "redirect:/match/list";
    }
}

