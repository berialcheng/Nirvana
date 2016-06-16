package org.nirvana.auth;

/**
 * Created by zhongch on 6/16/2016.
 */
public class BasicAuthorizer implements io.dropwizard.auth.Authorizer<User> {
    public boolean authorize(User user, String s) {
        return true;
    }
}
