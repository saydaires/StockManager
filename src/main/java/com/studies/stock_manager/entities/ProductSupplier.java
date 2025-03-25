package com.studies.stock_manager.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "products_suppliers")
public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private long idProduct;
//    private long idSupplier;


    public ProductSupplier() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
