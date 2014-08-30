package net.lalitbhatt.springHibernateWebApp.rest;

import java.util.List;

import javax.annotation.Resource;

import net.lalitbhatt.springHibernateWebApp.model.UserWithoutPassword;
import net.lalitbhatt.springHibernateWebApp.service.UserWithoutPasswordService;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {
	
	static final Logger logger = Logger.getLogger(UsersRestController.class.getName());
	
	@Resource
	UserWithoutPasswordService userService;
	
	@RequestMapping(value = "/rest/users", method = RequestMethod.GET)
    public @ResponseBody List<UserWithoutPassword> getUserList() {
        List<UserWithoutPassword> userWithoutPasswordList = userService.getListOfUsers();
        return userWithoutPasswordList;
    }

}
