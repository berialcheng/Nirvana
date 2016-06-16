package org.nirvana.auth;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Created by zhongch on 6/16/2016.
 */
public class User implements Principal {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return null;
    }
}
