package org.nirvana;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.DropwizardTestSupport;
import io.dropwizard.testing.ResourceHelpers;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nirvana.core.Person;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * Created by zhongch on 6/16/2016.
 */
public class PersonTest {

    public static final DropwizardTestSupport<ServiceConfiguration> SUPPORT =
            new DropwizardTestSupport<>(Application.class, ResourceHelpers.resourceFilePath("test.yml"));

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @BeforeClass
    public static void beforeClass() {
        SUPPORT.before();
    }

    @AfterClass
    public static void afterClass() {
        SUPPORT.after();
    }

    @Test
    public void test() throws IOException {
        Client client = new JerseyClientBuilder().build();
        List<Person> pl = client.target(
                String.format("http://localhost:9000/person" ))
                .request().get(new GenericType<List<Person>>() {});

        MAPPER.writeValue(System.out, pl);
    }

    @Test
    public void test2() throws IOException {
        Person person = new Person(2, "Fake");

        Client client = new JerseyClientBuilder().build();
        Person retval = client.target(
                String.format("http://localhost:9000/person"))
                .register(HttpAuthenticationFeature.basicBuilder().credentials("homer", "pwd").build())
                .request().put(Entity.entity(person, MediaType.APPLICATION_JSON), new GenericType<Person>() {});

        MAPPER.writeValue(System.out, retval);
    }
}
