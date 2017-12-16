package ir.isi.card.dao.daoservice;

import ir.isi.card.dao.CustomerDao;
import ir.isi.card.entity.Customer;
import ir.isi.card.hibernate.ConnectionManage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerService implements CustomerDao {


    ConnectionManage connectionManage;

    public  CustomerService(ConnectionManage connectionManage)
    {
        this.connectionManage=connectionManage;
    }
    public Customer getCustomerByID(int id) {

        Session session=null;
        Transaction transaction=null;
        Customer customer=null;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Customer> query=criteriaBuilder.createQuery(Customer.class);
            Root<Customer> roo=query.from(Customer.class);
            query.where(criteriaBuilder.equal(roo.get("id"),id));
            query.select(roo);
            Query<Customer> query1=session.createQuery(query);
            customer=query1.getSingleResult();


            transaction.rollback();

        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            transaction.rollback();
            if(session!=null &&session.isOpen())
                session.close();
        }


        return customer;


    }

    public List<Customer> list() {
        List<Customer> customers=null;
        Transaction transaction=null;
        Session session=null;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Customer> query=criteriaBuilder.createQuery(Customer.class);
            Root<Customer> root=query.from(Customer.class);
            query.select(root);
            Query<Customer>query1=session.createQuery(query);
            customers=query1.list();

            transaction.commit();
        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            if(session!=null && session.isOpen())
                session.close();

        }
        return customers;



    }


    public List<Customer> list(int start,int count) {
        List<Customer> customers=null;
        Transaction transaction=null;
        Session session=null;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Customer> query=criteriaBuilder.createQuery(Customer.class);
            Root<Customer> root=query.from(Customer.class);
            query.select(root);
            Query<Customer>query1=session.createQuery(query);
            query1.setFirstResult(start);
            query1.setMaxResults(count);
            customers=query1.list();

            transaction.commit();
        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            if(session!=null && session.isOpen())
                session.close();

        }
        return customers;



    }
    public boolean update(Customer customer) {


        Transaction transaction=null;
        Session session=null;
        Boolean result=false;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            session.update(customer);

            transaction.commit();
            result=true;

        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            if(session!=null && session.isOpen())
                session.close();


        }

        return result;


    }

    public boolean insert(Customer customer) {

        Transaction transaction=null;
        Session session=null;
        Boolean result=false;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            session.save(customer);

            transaction.commit();
            result=true;

        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            if(session!=null && session.isOpen())
                session.close();


        }

        return result;


    }
}
