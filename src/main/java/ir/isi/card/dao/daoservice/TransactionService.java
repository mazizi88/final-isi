package ir.isi.card.dao.daoservice;

import ir.isi.card.dao.TransactionDao;
import ir.isi.card.entity.Transactions;
import ir.isi.card.hibernate.ConnectionManage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TransactionService implements TransactionDao {

    ConnectionManage connectionManage;

    public TransactionService(ConnectionManage connectionManage)
    {
        this.connectionManage=connectionManage;

    }
    public Transactions getTransactionByID(int id) {
        Session session=null;
        Transaction transaction=null;
        Transactions transactions=null;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Transactions> query=criteriaBuilder.createQuery(Transactions.class);
            Root<Transactions> roo=query.from(Transactions.class);
            query.where(criteriaBuilder.equal(roo.get("id"),id));
            query.select(roo);
            Query<Transactions> query1=session.createQuery(query);
            transactions=query1.getSingleResult();


            transaction.rollback();

        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            transaction.rollback();
            if(session!=null &&session.isOpen())
                session.close();
        }


        return transactions;
    }

    public List<Transactions> list() {

        List<Transactions> transactionsList=null;
        Transaction transaction=null;
        Session session=null;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Transactions> query=criteriaBuilder.createQuery(Transactions.class);
            Root<Transactions> root=query.from(Transactions.class);
            query.select(root);
            Query<Transactions>query1=session.createQuery(query);
            transactionsList=query1.list();
            transaction.commit();
        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            if(session!=null && session.isOpen())
                session.close();

        }
        return transactionsList;


    }

    public boolean update(Transactions transactions) {

        Transaction transaction=null;
        Session session=null;
        boolean result=false;

        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            session.update(transactions);

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

    public boolean insert(Transactions transactions) {


        Transaction transaction=null;
        Session session=null;
        Boolean result=false;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            session.save(transactions);

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

    public List<Transactions> list(int start, int count) {
        List<Transactions> transactionsList=null;
        Transaction transaction=null;
        Session session=null;
        try
        {
            session=connectionManage.getSession();
            transaction=session.beginTransaction();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<Transactions> query=criteriaBuilder.createQuery(Transactions.class);
            Root<Transactions> root=query.from(Transactions.class);
            query.select(root);
            Query<Transactions>query1=session.createQuery(query);
            query1.setFirstResult(start);
            query1.setMaxResults(count);
            transactionsList=query1.list();
            transaction.commit();
        }catch (Exception ex)
        {
            if(transaction!=null && transaction.isActive())
                transaction.rollback();
            if(session!=null && session.isOpen())
                session.close();

        }
        return transactionsList;

    }
}
