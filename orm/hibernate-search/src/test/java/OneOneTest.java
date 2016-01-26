import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.junit.Test;
import org.nirvana.Address;
import org.nirvana.Club;
import org.nirvana.Person;

import java.util.ArrayList;
import java.util.List;

public class OneOneTest {

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

        search();
    }

    private void search() {
        EntityManager em = emf.createEntityManager();
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Person.class).get();

        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onFields("firstName","clubs.name")
                .matching("123")
                .createQuery();

        javax.persistence.Query jpaQuery =
                fullTextEntityManager.createFullTextQuery(luceneQuery, Person.class);

        List result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
    }

}
