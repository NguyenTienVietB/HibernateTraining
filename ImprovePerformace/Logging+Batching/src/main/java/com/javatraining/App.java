package com.javatraining;


import com.javatraining.model.User;
import com.javatraining.utils.HibernateUtils;

import lombok.extern.log4j.Log4j2;
import org.hibernate.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;

@Log4j2
public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            log.info("Statistics enabled = " + sessionFactory.getStatistics().isStatisticsEnabled());

            session.beginTransaction();

            final int numberOfRecords = 30;
            final int batchSize = 10; // same as the JDBC batch size
            for (int i = 1; i <= numberOfRecords; i++) {
                User user = new User();
                user.setUsername("User number " + i);
                user.setPassword("password");
                session.persist(user);

                if (i % batchSize == 0 && i != numberOfRecords) {
                    log.info("Flush a batch of INSERT & release memory: {} time(s)", (i / batchSize));
                    session.flush();
                    session.clear();
                }
            }

            log.info("Flush the last time at commit time");

            session.getTransaction().commit();

        }
//        StatelessSession statelessSession = null;
//        Transaction txn = null;
//        ScrollableResults scrollableResults = null;
//        try {
//            SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//            statelessSession = sessionFactory.openStatelessSession();
//
//            txn = statelessSession.getTransaction();
//            txn.begin();
//
//            scrollableResults = statelessSession
//                    .createSelectionQuery("select u from User u")
//                    .scroll(ScrollMode.FORWARD_ONLY);
//
//            while (scrollableResults.next()) {
//                User User = (User) scrollableResults.get();
//                statelessSession.update(User);
//            }
//
//            txn.commit();
//        } catch (RuntimeException e) {
//            if (txn != null && txn.getStatus() == TransactionStatus.ACTIVE) txn.rollback();
//            throw e;
//        } finally {
//            if (scrollableResults != null) {
//                scrollableResults.close();
//            }
//            if (statelessSession != null) {
//                statelessSession.close();
//            }
//        }

    }


    }