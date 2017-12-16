import ir.isi.card.hibernate.HibernateUtil;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {

        HibernateUtil hu=new HibernateUtil();
       Session session= hu.getSession();
        System.out.println("sss");

    }
}
