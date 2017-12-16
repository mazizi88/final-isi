package ir.isi.card.entity;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer",indexes = {@Index(columnList = "fullname"),@Index(columnList = "nationalID")})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column
    private long nationalID;

    @Column
    private String fullname;

    @Column
    private String fatherName;
    @Column
    private Date birthDate;
    @Column
    private String comment;
    @Column
    private  String imageUrl;

    @Column
    private boolean active;


    public int getId() {
        return id;
    }



    public String getFullname() {
        return fullname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getComment() {
        return comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNationalID() {
        return nationalID;
    }

    public void setNationalID(long nationalID) {
        this.nationalID = nationalID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    @OneToMany(mappedBy = "customer")
    Set<Transactions> transactions=new HashSet<Transactions>();

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

    @JsonIgnore
    public Set<Transactions> getTransactions() {

        return transactions;
    }
}
