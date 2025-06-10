package com.licenta.licenta.controller;

import com.licenta.licenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pendingApprovals", userService.getPendingApprovals());
        return "admin/dashboard";
    }

    @PostMapping("/approve/{userId}")
    public String approveUser(@PathVariable Long userId, RedirectAttributes redirectAttributes) {
        try {
            userService.approveUser(userId);
            redirectAttributes.addFlashAttribute("success", "User approved successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/reject/{userId}")
    public String rejectUser(@PathVariable Long userId, RedirectAttributes redirectAttributes) {
        try {
            userService.rejectUser(userId);
            redirectAttributes.addFlashAttribute("success", "User rejected and removed");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }
}