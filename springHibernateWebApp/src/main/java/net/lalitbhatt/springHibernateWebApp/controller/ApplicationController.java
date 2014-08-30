package net.lalitbhatt.springHibernateWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ApplicationController {
    
    @RequestMapping(value = "/home.lmc")
    public String entryPoint(){
        return "redirect:user/list.lmc";
    }


}
