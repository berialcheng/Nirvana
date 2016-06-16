package org.nirvana;

import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.nirvana.auth.BasicAuthenticator;
import org.nirvana.auth.BasicAuthorizer;
import org.nirvana.auth.User;
import org.nirvana.resources.PersonResource;

/**
 * Created by zhongch on 6/16/2016.
 */
public class Application extends io.dropwizard.Application<ServiceConfiguration>{

    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
    }

    @Override
    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {

        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new BasicAuthenticator())
                        .setAuthorizer(new BasicAuthorizer())
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));

        environment.jersey().register(new PersonResource());
    }
}
