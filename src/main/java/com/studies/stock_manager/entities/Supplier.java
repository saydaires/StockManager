package com.studies.stock_manager.entities;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    @Column(name= "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products;

    public Supplier() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
