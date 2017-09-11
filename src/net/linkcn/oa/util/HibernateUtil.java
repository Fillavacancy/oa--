package net.linkcn.oa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
    private static Configuration              confiGuration;
    private static final SessionFactory       sessionFactory;
    static
    {
        try
        {
            confiGuration = new Configuration().configure();
            sessionFactory = confiGuration.buildSessionFactory();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession()
    {
        Session session = threadlocal.get();
        if (session == null || !session.isOpen())
        {
            session = sessionFactory.openSession();
            threadlocal.set(session);
        }
        return session;
    }

    public static void close()
    {
        Session session = threadlocal.get();
        threadlocal.set(null);
        session.close();
    }
}
