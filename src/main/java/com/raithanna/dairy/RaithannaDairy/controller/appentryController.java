package com.raithanna.dairy.RaithannaDairy.controller;

import com.raithanna.dairy.RaithannaDairy.models.userModel;
import com.raithanna.dairy.RaithannaDairy.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class appentryController {

    @Autowired
    private UserModelRepository userModelRepository;

    @GetMapping("/register")
    public String registerHtml(){
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model,@ModelAttribute userModel user, HttpServletRequest request, HttpSession session){
        List<String> messages = new ArrayList<>();


        System.out.println(user);
        try{
        userModelRepository.save(user);}

        catch (Exception handlerException){
            messages.add("Error Creating your account pls retry");
            model.addAttribute("messages",messages);
            return "register";
        }
        model.addAttribute("messages",messages);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginHtml(){ return "login";}

    @PostMapping("/login")
    public String login(@RequestParam String mobile, Model model, @RequestParam String password, HttpServletRequest request, HttpSession session){
        System.out.println(mobile);
        System.out.println(password);

        List<String> messages = new ArrayList<>();

        try{
            userModel user = userModelRepository.findByMobileAndPassword(mobile,password);
            if (user == null ) {
                messages.add("Account not found! retry ");
                model.addAttribute("messages",messages);
                return "login";
            }
            System.out.println(user);}
        catch (Exception handlerException){
            messages.add("Error logging in! retry ");
            model.addAttribute("messages",messages);
            return "login";
        }
        model.addAttribute("messages",messages);
        session.setAttribute("loggedIn", "yes");
        return "redirect:/";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model){
        List<String> messages = new ArrayList<>();
        messages.add("Logged out successfully");
        model.addAttribute("messages", messages);
        session.setAttribute("loggedIn", "no");
        return "home";
    }

}
