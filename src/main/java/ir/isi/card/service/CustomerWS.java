package ir.isi.card.service;

import ir.isi.card.dao.CustomerDao;
import ir.isi.card.dao.daoservice.CustomerService;
import ir.isi.card.entity.Customer;
import ir.isi.card.hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class CustomerWS {
    @GET
    @Path("/json/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerByID(@PathParam("id") int id ) {

        CustomerDao customer=new CustomerService(new HibernateUtil());
        return customer.getCustomerByID(id);

    }
    @GET
    @Path("/json/get/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listCustomer(@PathParam("from") int from, @PathParam("to") int to ) {

        CustomerDao customer=new CustomerService(new HibernateUtil());
        return customer.list(from,to);

    }

    @GET
    @Path("/json/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listCustomerQueryString(@QueryParam("from") int from, @QueryParam("to") int to ) {

        CustomerDao customer=new CustomerService(new HibernateUtil());
        return customer.list(from,to);

    }


}
