package com.pbo2.bakery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pbo2.bakery.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "dashboard";
    }
}