package net.lalitbhatt.springHibernateWebApp.auth;

import java.util.Collection;
import java.util.HashSet;

import net.lalitbhatt.springHibernateWebApp.model.User;
import net.lalitbhatt.springHibernateWebApp.types.Status;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class PortalAuthenticatedUser implements UserDetails{
    
    private User user;
    
    public PortalAuthenticatedUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Authenticated User needs a valid user");
        }
        this.user = user;
    }

    public User getUser(){
        return user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new GrantedAuthorityImpl(user.getRole().toString()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
         return true;
    }

    @Override
    public boolean isEnabled() {
        boolean enabled = false;
        Status status = user.getStatus();

        switch (status) {
        case Active: {
            enabled = true;
            break;
        }
        }
        return enabled;
    }

}
