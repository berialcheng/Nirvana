package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.nirvana.jpa.domain.Person;
import org.nirvana.jpa.domain.Phone;

public class JpaTest
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Local_mysql");

    @Test
    public void OneToMany()
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("Cheng", "Zhong");
        Phone p1 = new Phone("123456", person);
        Phone p2 = new Phone("654321", person);
        List<Phone> list = new ArrayList<Phone>();
        list.add(p1);
        list.add(p2);
        person.setPhones(list);

        em.persist(person);
        em.getTransaction().commit();
        em.close();
        System.out.println(person.getId());

        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();

        Person personToLook = em2.find(Person.class, 1);
        for (Phone phone : person.getPhones())
        {
            System.out.println(phone.getNumber());
        }
        em2.getTransaction().commit();
        em2.close();
    }

    @Test
    public void ManyToOne()
    {
        EntityManager em = emf.createEntityManager();

        Phone p = em.find(Phone.class, "123456");
        System.out.println(p.getPerson().getFirstName());

        em.close();
    }

    //@Test
    public void test()
    {
        EntityManager em = emf.createEntityManager();
    }


}
