package net.lalitbhatt.springHibernateWebApp.service;

import java.util.List;

import javax.annotation.Resource;

import net.lalitbhatt.springHibernateWebApp.dao.UserDao;
import net.lalitbhatt.springHibernateWebApp.model.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	
	static final Logger logger = Logger.getLogger(UserService.class.getName());

	@Resource
	UserDao userDao;

	public List<User> getListOfUsers() {
		return userDao.getListOfUsers();
	}
}
