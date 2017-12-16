package ir.isi.card.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;





public class HibernateUtil implements ConnectionManage {


    private static final SessionFactory sessionFactory;

    private static ServiceRegistry serviceRegistry;

    static {
        try {



            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {

            System.err.println("Enitial SessionFactory creation failed" + th);

            throw new ExceptionInInitializerError(th);

        }
    }

    public SessionFactory getSessionFactory() {

        return HibernateUtil.sessionFactory;

    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }

    public void closeSession(Session session) {
        if (session != null && session.isOpen())
            session.close();
    }

}
