package net.lalitbhatt.springHibernateWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	 @RequestMapping(value = "/user/list")
	 public String getUsers(){
		 return "/page/user/list";
	 }

}
