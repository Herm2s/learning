package com.hermes;

import com.hermes.pojo.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author herm2s
 * @since 2023/2/19 22:10
 */
class JpaTest {

    private EntityManagerFactory factory;


    @BeforeEach
    public void before() {
        this.factory = Persistence.createEntityManagerFactory("hibernateJPA");
    }

    @Test
    void testC() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Customer customer = new Customer();
        customer.setCustName("张三");
        entityManager.persist(customer);

        tx.commit();
    }

    @Test
    void testR() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Customer customer = entityManager.find(Customer.class, 2L);
        System.out.println(customer);
        tx.commit();
    }

    @Test
    void testR_Lazy() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Customer customer = entityManager.getReference(Customer.class, 2L);
        System.out.println(customer);
        tx.commit();
    }

    @Test
    void testU() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setCustName("爱马仕");
        entityManager.merge(customer);

        tx.commit();
    }

    @Test
    void testJpql() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.createQuery("update Customer set custAddress = :address where  id = 2")
                .setParameter("address", "巴黎")
                .executeUpdate();

        tx.commit();
    }
}
