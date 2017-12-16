package ir.isi.card.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date issuDate;
    @Column
    private boolean active;

    @Column
    private String payment;

    public void setId(int id) {
        this.id = id;
    }

    public void setIssuDate(Date issuDate) {
        this.issuDate = issuDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public Date getIssuDate() {
        return issuDate;
    }

    public boolean isActive() {
        return active;
    }

    public String getPayment() {
        return payment;
    }

    @ManyToOne
    @JoinColumn(name = "F_customer")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {

        return customer;
    }
/*


   // public virtual string Date { get; set; }
  //  public virtual DateTime? RegistrationDate { get; set; }
    public virtual bool IsActive { get; set; }
    public virtual string Payment { get; set; }
    public virtual string Comment { get; set; }
    public virtual int Id { get; set; }
    public Status Case { get; set; }

    //[ForeignKey("Member")]
    public virtual long NationalId { get; set; }
    public virtual Member Member { get; set; }
    */
}
