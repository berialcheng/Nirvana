package jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.nirvana.jpa.domain.Club;
import org.nirvana.jpa.domain.Person;

public class ManyManyTest {
	
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Local_mysql");

	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Person person = new Person("Cheng", "Zhong");
        //Person person2 = new Person("Cheng", "Cheng");
        
        Club b1 = new Club("123456");
        List<Person> persons = new ArrayList<Person>(); 
        persons.add(person);
        //persons.add(person2);
        b1.setPerson(persons);
        
        List<Club> list = new ArrayList<Club>();
        person.setClubs(list);
        //person2.setClubs(list);
        
        em.persist(person);
        //em.persist(person2);
        em.persist(b1);

        em.getTransaction().commit();
        em.close();
	}

}
