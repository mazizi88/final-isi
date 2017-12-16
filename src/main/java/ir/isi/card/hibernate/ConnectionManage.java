package ir.isi.card.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface ConnectionManage {

    public SessionFactory getSessionFactory();
    public Session getSession();
    public Session openSession();
    public void closeSession(Session session);

}
