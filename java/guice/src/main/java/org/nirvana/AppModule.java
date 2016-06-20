package org.nirvana;

import com.google.inject.AbstractModule;

/**
 * Created by zhongch on 6/20/2016.
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Contact.class).to(Mobile.class).asEagerSingleton();
        bind(Player.class);//.asEagerSingleton();
    }
}
