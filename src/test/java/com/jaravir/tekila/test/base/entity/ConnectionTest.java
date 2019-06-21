package com.jaravir.tekila.test.base.entity;

import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.*;
/**
 * Created by sajabrayilov on 6/4/2015.
 */
public class ConnectionTest {
    @Ignore
    @Test
    public void testConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tekila_test");
        EntityManager em = emf.createEntityManager();

        long count = em.createQuery("select count(s) from Subscription s", Long.class).getSingleResult();
        assertTrue(count > 0);
        System.out.println("Count of subscriptions: " + count);
        em.close();
        emf.close();
    }
}
