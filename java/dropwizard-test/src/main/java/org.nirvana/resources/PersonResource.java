package org.nirvana.resources;

import io.dropwizard.auth.Auth;
import org.nirvana.auth.User;
import org.nirvana.core.Person;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhongch on 6/16/2016.
 */
@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public List<Person> get(){
        Person p = new Person(1, "Dummy Name");
        List<Person> pl = new ArrayList<Person>();
        pl.add(p);
        return pl;
    }

    @PUT
    public Person put(@Auth User user , Person person){
        return person;
    }

    @GET
    @Path("async")
    public void getPerson(@Suspended AsyncResponse asyncResponse){
        asyncResponse.register(new CompletionCallback() {
            @Override
            public void onComplete(Throwable throwable) {
                if (throwable == null) {
                    // no throwable - the processing ended successfully
                    // (response already written to the client)
                    System.out.println("onComplete no throwable");
                } else {
                    System.out.println(String.format("onComplete throwable %s", throwable));
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10000);
                    Person p = new Person(1, "Dummy Name");
                    List<Person> pl = new ArrayList<Person>();
                    pl.add(p);
                    asyncResponse.resume(p);
                } catch (InterruptedException e) {
                    asyncResponse.cancel();
                }
            }
        }).start();
    }
}
