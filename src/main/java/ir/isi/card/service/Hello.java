package ir.isi.card.service;



import ir.isi.card.hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Hello {


    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;


        HibernateUtil hu=new HibernateUtil();
        Session session= hu.getSession();
        if(session!=null)
            System.out.println("session is open");

        return Response.status(200).entity(output).build();

    }
}
