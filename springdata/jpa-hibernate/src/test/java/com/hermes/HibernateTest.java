package com.hermes;

import com.hermes.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author herm2s
 * @since 2023/2/19 21:32
 */
class HibernateTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("/hibernate.cfg.xml")
                .build();

        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    void testC() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustName("爱马仕");
            session.save(customer);

            transaction.commit();
        }
    }

    @Test
    void testR() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Customer customer = session.find(Customer.class, 1L);
            System.out.println(customer);
            tx.commit();
        }
    }

    @Test
    void testR_Lazy() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Customer customer = session.load(Customer.class, 1L);
            System.out.println(customer);
            tx.commit();
        }
    }

    @Test
    void testU() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            // customer.setId(1L);
            customer.setCustName("香奈儿");
            customer.setCustAddress("外国");

            session.saveOrUpdate(customer);
            tx.commit();
        }
    }

    @Test
    void testD() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setId(1L);

            session.remove(customer);
            tx.commit();
        }
    }

    @Test
    void testHQL() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            String hql = "FROM Customer";

            List<Customer> customers = session.createQuery(hql, Customer.class).getResultList();
            System.out.println(customers);

            tx.commit();
        }
    }
}
