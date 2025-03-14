# Stock Manager
---
## Objective
Learn Java Web (Spring Boot), MVC, and database manipulation.
## Description
 **Product Registration System (Spring Boot + REST API)**
- REST API with CRUD for products
- Persistence using Hibernate/JPA
- Testing with Postman

---
## JPA and Hibernate

#### JPA
The **JPA** dependency is a dependency included in one of the Spring Boot modules, the Spring Data module.

This dependency allows the programmer to use annotations that abstract code that was previously written manually, automating it. This code pertains to procedures between the application's **source code** and the **database** used, such as:

- Creation of tables (entities);
- Creation of attributes for these entities;
- Specification of data types for each entity;
- Definition of relationships between entities/tables.

The annotations used **abstract these procedures**, so the programmer **does not need to create classes and code to manage these actions between the application and the database.**

#### Hibernate

**Hibernate** is an implementation of **JPA**. Hibernate is primarily responsible for **managing the communication between the application and the database** through the **JDBC driver**, thereby abstracting classes and code from the programmer, preventing them from performing these configurations manually.

The normal workflow of Hibernate in a Spring Web application that implements the **JPA** framework is as follows:

1. A **query** is made in the application to the database using JPA annotations (such as `@Column`, `@Entity`, etc.);
2. This JPA query is then passed to **Hibernate**, which receives it and **translates it into SQL code.**
3. This query, now translated into database code, is passed by Hibernate to the database through the **JDBC driver**.
4. The database receives this query **and then performs the SQL operation.**

So, in general terms, we can say that **JPA** is an interface that abstracts database procedures from the programmer, while **Hibernate** implements this interface and performs more complex tasks, such as **managing the connection** to the database and **compiling SQL instructions**.

---
## Configuring JPA Dependencies

The first step **before mapping the database entities in the application** is to install the JPA framework dependencies. The JPA dependencies **already include the Hibernate dependencies.**

In the `pom.xml` file (responsible for configuring the project dependencies), in the `<dependencies>` section, install the JPA dependency:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

After adding the JPA dependency to the project, the next step is to **add the JDBC driver**, which will be the connector between the database and the application, managed by Hibernate.
In this project example, the JDBC driver for the MySQL database will be used:
```xml
<dependency>
	<groupId>com.mysql</groupId>
	<artifactId>mysql-connector-j</artifactId>
</dependency>
```

We have added the JDBC driver connector to the application. Our next step is to configure it with the data related to the database that will be used. This will be done in the `application.properties` file:
```java
spring.datasource.url=jdbc:mysql://localhost:3306/schemaName
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```
In the configurations above, the first three instructions relate to the settings of the database schema itself on the server where it is hosted.
For the last three configurations, we have:
- `spring.jpa.hibernate.ddl-auto=update`: Defines the behavior of the database schema, in this case, being automatically updated.
- `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`: It is **optional** for an application with only one JDBC driver and **mandatory** for an application with multiple JDBC drivers. This configuration specifies the name of the JDBC driver.
- `spring.jpa.show-sql=true`: Allows SQL queries to be displayed in the application console, which is useful for debugging.

After making the necessary configurations for the dependencies used or associated with the Java Persistence API (JPA), we can proceed to the next step: Mapping the application entities in the database using the JPA dependencies.

---
## Mapping Entities

#### Owner Side
Before mapping the `Product` and `Category` entities used in our project so far, we need to understand the concept of the **Owner Side** in a relationship between database tables in the context of JPA.

In the context of our application, it is known that the relationship between the `Product` and `Category` tables is one-to-many, where one category can be referenced by many products. In this type of relationship, it is important to understand the concept of the **Owner Side**, which will be the one that **will hold the foreign key** linking the two tables. In this case, the `Product` entity **is the owner side of the relationship**, as this table will contain a column that references the foreign key of the `Category` entity.

#### Mapping Entities Using JPA
###### `Product` Entity
```java
package com.studies.stock_manager.entities;  
import jakarta.persistence.*;  
  
@Entity  
public class Product {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long id;  
  
    @Column(name = "name")  
    private String name;  
  
    @Column(name="description")  
    private String description;  
  
    @Column(name="price")  
    private double price;  
  
    @Column(name="stock_quantity")  
    private int stockQuantity;  
  
    @ManyToOne  
    @JoinColumn(name="category_id", referencedColumnName = "id", nullable=false)  
    private Category category;  
}
```
The `@Entity` annotation belongs to the `import jakarta.persistence.*` package and is used to specify that the `Product` class represents a database entity.  
In the `id` attribute, we use the `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)` annotations to specify that this attribute is the PK (Primary Key) column of the entity in question, and its value should be **automatically generated** by the database. The `GenerationType.IDENTIFY` constant indicates that the `strategy` for generating these keys will depend on the DBMS used. For example, MySQL will generate values based on `AUTO_INCREMENT`.

Moving forward, we use the `@Column` annotations to indicate columns of this entity in the database (and specify their names as arguments).

Finally, the `@ManyToOne` annotation specifies that there is a **many-to-one** relationship between the `Product` and `Category` entities, where one category can be associated with many products. This annotation is strictly important **because it specifies a relationship** between the `Product` entity and the `Category` entity, through the `category` attribute. The `@JoinColumn(name="category_id", referencedColumnName = "id")` instruction specifies that **a column referencing a FK** (foreign key) should be added, where this column will be named `category_id` and will reference the `id` column in the `Category` entity. The `nullable=false` instruction ensures that this column cannot be filled with `null` in the database and must have an initialized FK.

Last but not least, the `@JoinColumn(name="category_id", referencedColumnName = "id")` instruction also defines that the `Product` entity will be the **Owner Side**. In our example, it contains the reference (FK) to the `Category` entity. This same instruction will not be used in the referenced column within the scope of the referenced `Category` entity.

###### `Category` Entity
```java
package com.studies.stock_manager.entities;  
import jakarta.persistence.*;  
import java.util.List;  
  
@Entity  
public class Category {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;  
  
    @Column(name="name")  
    private String name;  
  
    @OneToMany(mappedBy = "category")  
    private List<Product> products;  
}
```
The annotations used in the `Category` entity represent the same as explained earlier for the `Product` entity, except for the `@OneToMany(mappedBy = "category")` annotation. Notice that this annotation is the inverse of the one used in `Product`, which is important to maintain the relationship between these entities and keep the logic cohesive (one category can be in many products). The `mappedBy` instruction indicates which column in the `Product` entity is mapping the `Category` entity, in this case, the `category` column.

Notice that we do not use the `@JoinColumn` annotation, as we are now dealing with the non-owner side of the relationship between these two entities.

Finally, note that the `products` attribute does not represent a column in the `Category` entity, being instead a characteristic of this entity within the application, used to define business rules, but not extending to the database.

###### Constructors, Getters, and Setters for Entities
###### `Product` Entity
```java
package com.studies.stock_manager.entities;  
import jakarta.persistence.*;  
  
@Entity  
public class Product {
	// JPA handling above
	
    public Product() { }  
  
    public Product(String name, String description, double price, int stockQuantity, Category category) {  
        this.name = name;  
        this.description = description;  
        this.price = price;  
        this.stockQuantity = stockQuantity;  
        this.category = category;  
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
  
    public int getStockQuantity() {  
        return stockQuantity;  
    }  
  
    public void setStockQuantity(int stockQuantity) {  
        this.stockQuantity = stockQuantity;  
    }  
  
    public Category getCategory() {  
        return category;  
    }  
  
    public void setCategory(Category category) {  
        this.category = category;  
    }  
}
```

Notice that we have an **explicit empty constructor** in the scope of the entity. It is mandatory because JPA will need it when initializing objects of this entity. JPA uses an empty constructor to initialize objects of this entity and then initializes its attributes using the **setter methods** declared in the scope of the entity, which makes the **setter methods** also mandatory.

The non-empty (parameterized) constructor is not mandatory for JPA to function, as JPA does not use it. However, it is useful for initializing entity objects within the application.

###### `Category` Entity
For the `Category` entity, we follow the same logic for constructing constructors and methods as used in the `Product` entity:
```java
package com.studies.stock_manager.entities;  
import jakarta.persistence.*;  
import java.util.List;  
  
@Entity  
public class Category {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;  
  
    @Column(name="name")  
    private String name;  
  
    @OneToMany(mappedBy = "category")  
    private List<Product> products;  
  
    public Category() { }  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public List<Product> getProducts() {  
        return products;  
    }  
  
    public void setProducts(List<Product> products) {  
        this.products = products;  
    }  
}
```
---
## Building the Layers: `repositories` Layer

