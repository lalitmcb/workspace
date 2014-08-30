package net.lalitbhatt.springHibernateWebApp.auth;

import net.lalitbhatt.springHibernateWebApp.model.User;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("portalAuthenticationContext")
public class PortalAuthenticationContext {
    
    public User getUser() {
        PortalAuthenticatedUser authUser = (PortalAuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
        return authUser.getUser();
    }

}
