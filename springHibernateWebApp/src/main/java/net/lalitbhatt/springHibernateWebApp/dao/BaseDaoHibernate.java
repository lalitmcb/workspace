package net.lalitbhatt.springHibernateWebApp.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("dao")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseDaoHibernate {
    protected final Log log = LogFactory.getLog(getClass());

    @Resource
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Object saveOrUpdateObject(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
        return o;
    }

	public Object getObject(Class clazz, Serializable id) {
        Object o = sessionFactory.getCurrentSession().get(clazz, id);
        return o;
    }

	public Object loadObject(Class clazz, Serializable id) {
        Object o = sessionFactory.getCurrentSession().load(clazz, id);
        return o;
    }
	
	public void removeObject(Class clazz, Serializable id) {
        sessionFactory.getCurrentSession().delete(getObject(clazz, id));
    }
}
