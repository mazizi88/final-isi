package ir.isi.card.dao;

import ir.isi.card.entity.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomerByID(int id);
    List<Customer> list();
    boolean update(Customer customer);
    boolean insert(Customer customer);
    public List<Customer> list(int start,int count);
}
