package net.lalitbhatt.springHibernateWebApp.rest;

import java.util.List;

import javax.annotation.Resource;

import net.lalitbhatt.springHibernateWebApp.model.User;
import net.lalitbhatt.springHibernateWebApp.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {
	
	static final Logger logger = Logger.getLogger(UsersRestController.class.getName());
	
	@Resource
	UserService userService;
	
	@RequestMapping(value = "/rest/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUserList() {
        List<User> userList = userService.getListOfUsers();
        return userList;
    }

}
