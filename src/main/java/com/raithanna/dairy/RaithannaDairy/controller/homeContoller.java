package com.raithanna.dairy.RaithannaDairy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class homeContoller {
    @GetMapping({"/"})
    public String home(Model model, @RequestParam(value = "name", defaultValue = "World",required = false) String name, HttpSession session, HttpServletRequest request){

        List messages = new ArrayList<>();
        model.addAttribute("messages",  messages);

        return "home";
    }
}
