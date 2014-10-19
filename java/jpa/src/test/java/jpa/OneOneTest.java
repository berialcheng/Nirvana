package jpa;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.nirvana.jpa.domain.Address;
import org.nirvana.jpa.domain.Person;

public class OneOneTest {
	
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Local_mysql");

	@Test
	public void test() {
		
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
		Person person = new Person("Cheng", "Zhong");
		person.setAddress(new Address("Street","City"));
		
		em.persist(person);
		
		em.getTransaction().commit();
		em.close();
	}

}
