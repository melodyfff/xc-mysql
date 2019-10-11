package com.xinchen.orm.jpa;


import com.xinchen.orm.jpa.model.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    private static final String PERSISTENCE_UNIT_NAME = "todos";

    /** Interface used to interact with the entity manager factory for the persistence unit. */
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        // 创建persistence unit
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        // 创建EntityManager
        final EntityManager em = factory.createEntityManager();

        // 这里的Todo是@Entity中的name属性指定的
        final Query q = em.createQuery("select t from Todo t");
        final List resultList = q.getResultList();
        System.out.println(resultList);


        // create new todo
        em.getTransaction().begin();
        Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        em.persist(todo);
        em.getTransaction().commit();

        em.close();

    }
}
