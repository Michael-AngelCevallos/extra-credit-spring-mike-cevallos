package com.codeup.extracreditspringmikecevallos.model;



//Create the Order  model to reflect the changes made in the database. It must have:
//An id  that auto-increments when a new record is being created.
//An email  to keep track of the customer.
//A totalPrice  that is defined as a double.
//A constructor, getters and setters for each property.
//2.  Your application will need an OrderRepository , create the repository in order to utilize
//Spring Boot Extra Credit Assignment
//Setup

import jakarta.persistence.*;

@Entity
@Table(name = "orders") // need to add name here or it won't add to my sql <------------
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;
    @Column
    private double totalPrice;

    public Order() {
    }

    public Order(String email, double totalPrice) {
        this.email = email;
        this.totalPrice = totalPrice;
    }

    public Order(long id, String email, double totalPrice) {
        this.id = id;
        this.email = email;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
