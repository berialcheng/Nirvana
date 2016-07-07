package org.nirvana;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * Created by zhongch on 6/20/2016.
 */
public class PlayerTest {

    @Test
    public void test(){
        ThreadLocal<Boolean> c = new ThreadLocal();

        if(c.get()){
            System.out.println("ture");
        }
        //Injector injector = Guice.createInjector();
//        Injector injector = Guice.createInjector(new AppModule());
//
//        Player object = injector.getInstance(Player.class);
//        object.diplayInfo();
//
//        Player object2 = injector.getInstance(Player.class);
//        object2.diplayInfo();
    }
}
