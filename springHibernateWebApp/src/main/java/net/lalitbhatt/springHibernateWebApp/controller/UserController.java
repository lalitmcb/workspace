package net.lalitbhatt.springHibernateWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	 @RequestMapping(value = "/users/list.lmc")
	 public String getUsers(){
		 return "users/list";
	 }

}
