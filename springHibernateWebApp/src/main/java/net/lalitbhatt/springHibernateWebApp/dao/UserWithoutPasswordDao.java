package net.lalitbhatt.springHibernateWebApp.dao;

import java.util.List;

import net.lalitbhatt.springHibernateWebApp.model.User;
import net.lalitbhatt.springHibernateWebApp.model.UserWithoutPassword;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository("userWithoutPasswordDao")
@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
public class UserWithoutPasswordDao extends BaseDaoHibernate{
	
	public List<UserWithoutPassword> getListOfUsersWithoutPassword() {
		List<UserWithoutPassword> userWithoutPasswordrList = null;
        Criteria criteria = this.getCurrentSession().createCriteria(User.class);
        userWithoutPasswordrList = criteria.list();
        return userWithoutPasswordrList;
	}

}
