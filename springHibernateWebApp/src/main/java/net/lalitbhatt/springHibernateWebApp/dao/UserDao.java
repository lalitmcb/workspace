package net.lalitbhatt.springHibernateWebApp.dao;

import java.util.List;

import net.lalitbhatt.springHibernateWebApp.model.User;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
public class UserDao extends BaseDaoHibernate{
    
    @Transactional(propagation = Propagation.REQUIRED,readOnly=false)
    public User getUserByEmail(String userName) {
        User user = null;
        Criteria criteria = this.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", userName));
        user = (User)criteria.uniqueResult();
        return user;
    }

	public List<User> getListOfUsers() {
		List<User> userList = null;
        Criteria criteria = this.getCurrentSession().createCriteria(User.class);
        userList = criteria.list();
        return userList;
	}

}
