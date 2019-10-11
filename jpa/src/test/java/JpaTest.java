import com.xinchen.orm.jpa.model.relationship.Family;
import com.xinchen.orm.jpa.model.relationship.Person;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author xinchen
 * @version 1.0
 * @date 11/10/2019 17:08
 */
public class JpaTest {

    private static final String PERSISTENCE_UNIT_NAME = "people";
    private EntityManagerFactory factory;

    @Before
    public void setUp(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        final EntityManager em = factory.createEntityManager();


        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        Query q = em.createQuery("select m from Person m");
        // Persons should be empty

        boolean createNewEntrites = (q.getResultList().size() == 0);

        // No, so lets create new entries
        if (createNewEntrites){
            TestCase.assertEquals(0, q.getResultList().size());
            Family family = new Family();
            family.setDescription("Family for the test");

            // 托管状态
            em.persist(family);

            for (int i = 0;i<40;i++){
                Person person = new Person();
                person.setFirstName("Jim_"+i);
                person.setLastName("Test_"+i);

                // 托管状态
                em.persist(person);

                family.getMembers().add(person);
                em.persist(person);
                em.persist(family);
            }

        }

        // Commit the transaction, which will cause the entity to be stored in the database
        em.getTransaction().commit();

        // It is always good practice to close the EntityManager so that resources are conserved.
        em.close();
    }


    @Test
    public void checkAvailablePeople() {

        // now lets check the database and see if the created entries are there
        // create a fresh, new EntityManager
        EntityManager em = factory.createEntityManager();

        // Perform a simple query for all the Message entities
        Query q = em.createQuery("select m from Person m");

        // We should have 40 Persons in the database
        Assert.assertEquals(40, q.getResultList().size());

        em.close();
    }


    @Test
    public void checkFamily(){
        // Go through each of the entities and print out each of their
        // messages, as well as the date on which it was created
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select f from Family f");


        final List resultList = q.getResultList();
        System.out.println(resultList);

        Assert.assertEquals(1, resultList.size());
        Assert.assertEquals(40,((Family)(q.getSingleResult())).getMembers().size());
        em.close();
    }

}
