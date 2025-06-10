package com.licenta.licenta.controller;

import com.licenta.licenta.dto.RegistrationDTO;
import com.licenta.licenta.model.Role;
import com.licenta.licenta.model.User;
import com.licenta.licenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        model.addAttribute("roles", Role.values());
        model.addAttribute("availableTeams", userService.getAvailableTeams());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegistrationDTO registrationDTO,
                               RedirectAttributes redirectAttributes) {
        try {
            if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
                redirectAttributes.addFlashAttribute("error", "Passwords do not match");
                return "redirect:/register";
            }

            User user = userService.registerUser(
                    registrationDTO.getUsername(),
                    registrationDTO.getEmail(),
                    registrationDTO.getPassword(),
                    registrationDTO.getRole(),
                    registrationDTO.getTeamName()
            );

            if (user.getRole() == Role.TEAM_MANAGER) {
                redirectAttributes.addFlashAttribute("success",
                        "Registration successful! Your account is pending approval.");
            } else {
                redirectAttributes.addFlashAttribute("success",
                        "Registration successful! You can now login.");
            }

            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);

        switch (user.getRole()) {
            case ADMIN:
                return "redirect:/admin/dashboard";
            case TEAM_MANAGER:
                return "redirect:/team-manager/dashboard";
            default:
                return "dashboard/user";
        }
    }
}