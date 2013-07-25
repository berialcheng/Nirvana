package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.nirvana.jpa.domain.Person;

public class JpaTest {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Local_mysql");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Person person = new Person("Cheng","Zhong","12345678");
		em.persist(person);
		em.getTransaction().commit();
		
		System.out.println(person.getId());
	}

}
