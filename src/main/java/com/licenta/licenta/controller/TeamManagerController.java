package com.licenta.licenta.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.licenta.licenta.model.User;

@Controller
@RequestMapping("/team-manager")
public class TeamManagerController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("assignedTeam", user.getAssignedTeam());
        return "team-manager/dashboard";
    }
}