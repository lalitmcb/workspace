package net.lalitbhatt.springHibernateWebApp.service;

import java.util.List;

import javax.annotation.Resource;

import net.lalitbhatt.springHibernateWebApp.dao.UserWithoutPasswordDao;
import net.lalitbhatt.springHibernateWebApp.model.UserWithoutPassword;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserWithoutPasswordService {
	
	static final Logger logger = Logger.getLogger(UserWithoutPasswordService.class.getName());

	@Resource
	UserWithoutPasswordDao userWithoutPasswordDao;

	public List<UserWithoutPassword> getListOfUsers() {
		return userWithoutPasswordDao.getListOfUsersWithoutPassword();
	}
}
