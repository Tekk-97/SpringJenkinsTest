package com.example.SpringJenkinsTest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) throws UnknownHostException {
        model.addAttribute("mystat", InetAddress.getLocalHost().getHostName()+"   "+
                InetAddress.getLocalHost().getHostAddress()+"   "+ InetAddress.getLocalHost().getCanonicalHostName() +
                " "+request.getHeader("Host") + "  "+request.getHeader("user-agent")+
                " "+response.getHeader("Server")+" "+response.getHeader("Allow"));
        return "home";
    }
}
