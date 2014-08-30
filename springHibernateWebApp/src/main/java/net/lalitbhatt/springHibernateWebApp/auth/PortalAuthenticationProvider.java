package net.lalitbhatt.springHibernateWebApp.auth;

import javax.annotation.Resource;

import net.lalitbhatt.springHibernateWebApp.dao.UserDao;
import net.lalitbhatt.springHibernateWebApp.model.User;
import net.lalitbhatt.springHibernateWebApp.types.Status;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PortalAuthenticationProvider implements AuthenticationProvider {

    @Resource
    BCryptPasswordEncoder encoder;

    @Resource
    UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userDao.getUserByEmail(authentication.getName());
        Authentication authenticated = null;

        if (user != null) {

            if (user.getStatus() == Status.Inactive) {
                throw new DisabledException("Account is inactive");
            }
            
            if(!encoder.matches(authentication.getCredentials().toString(), user.getPassword())){
                throw new BadCredentialsException("Password is not correct");
            }

            PortalAuthenticatedUser authenticatedUser = new PortalAuthenticatedUser(user);
            authenticated = new UsernamePasswordAuthenticationToken(authenticatedUser, null,
                    authenticatedUser.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticated);
        } else {
            throw new AuthenticationCredentialsNotFoundException("User not Found");
        }
        return authenticated;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
