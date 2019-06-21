package com.jaravir.tekila.module.accounting;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.module.accounting.entity.Payment;
import com.jaravir.tekila.module.archive.ArchiveEntity;
import com.jaravir.tekila.module.archive.accounting.PaymentArchived;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

import static org.junit.Assert.*;
/**
 * Created by sajabrayilov on 8/5/2015.
 */
public class PaymentArchivedTest {
    @Ignore
    @Test
    public void testPaymentArchived () {
       /* Properties properties = new Properties();
        properties.put(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/persistence.xml");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tekila_test", properties);*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tekila_test");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, 1L);
        assertNotNull(user);

        Payment payment = em.find(Payment.class, 2537862L);
        assertNotNull(payment);

        PaymentArchived paymentArchived = new PaymentArchived(payment, user);
        assertEquals(Double.valueOf(1.0), paymentArchived.getAmount());
        em.persist(paymentArchived);

        PaymentArchived paymentArchived2 = new PaymentArchived(payment, user);
        assertEquals(Double.valueOf(1.0), paymentArchived2.getAmount());
        em.persist(paymentArchived2);

        em.getTransaction().commit();
    }
}
