package ir.isi.card.dao;

import ir.isi.card.entity.Customer;
import ir.isi.card.entity.Transactions;

import java.util.List;

public interface TransactionDao {

    Transactions getTransactionByID(int id);
    List<Transactions> list();
    boolean update(Transactions transactions);
    boolean insert(Transactions transactions);
    public List<Transactions> list(int start, int count);
}
