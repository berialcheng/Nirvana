package org.nirvana.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.server.Authentication;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by zhongch on 6/16/2016.
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, User> {

    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        if(basicCredentials.getPassword().equalsIgnoreCase("pwd")){
            return  Optional.of(new User("test user"));
        }
        return Optional.absent();
    }
}
