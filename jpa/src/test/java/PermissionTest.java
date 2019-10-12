import com.xinchen.orm.jpa.model.permission.Resource;
import com.xinchen.orm.jpa.model.permission.Role;
import com.xinchen.orm.jpa.model.permission.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;

/**
 * @author xinchen
 * @version 1.0
 * @date 12/10/2019 15:00
 */
public class PermissionTest {
    private static final String PERSISTENCE_UNIT_NAME = "permission";
    private EntityManagerFactory factory;

    @Before
    public void setUp(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        final EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("select t from User t");


        if (q.getResultList().size() == 0){

            Resource resource = new Resource();
            resource.setUrl("/admin");

            Role role = new Role();
            role.setRoleName("管理员");
            role.getResources().add(resource);

            User user = new User();
            user.setUserName("admin");
            user.setPassword("admin");
            user.setCreateTime(new Date());
            user.getRoles().add(role);

            em.persist(resource);
            em.persist(role);
            em.persist(user);
        }

        em.getTransaction().commit();
        em.close();

    }

    @Test
    public void test(){

    }
}
