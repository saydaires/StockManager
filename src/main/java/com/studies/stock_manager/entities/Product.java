package com.studies.stock_manager.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="stock")
    private int stock;

    @Column(name="price")
    private double price;

    @Version
    private long version;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> items;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_suppliers",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_supplier")
    )
    private Set<Supplier> suppliers;

    public Product() { }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0)
            throw new IllegalArgumentException("Invalid value as price");
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
