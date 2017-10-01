package com.twistezo.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -5499172417961772372L;

    public Customer() {
        super();
    }

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "login", length = 50)
    private String login;

    @Size(min = 5, max = 60)
    @Column(name = "password", length = 60)
    private String password;

    @Size(min = 2, max = 50)
    @Column(name = "fullName", length = 50)
    private String fullName;

    @Size(min = 5, max = 50)
    @Column(name = "role", length = 50)
    private String role;

    @Digits(integer = 10, fraction = 2)
    @Column(name = "total_price")
    private BigDecimal totalPrice = new BigDecimal(0);

    @Digits(integer = 16, fraction = 0)
    @Column(name = "card_number")
    private BigDecimal cardNumber;

    @Digits(integer = 3, fraction = 0)
    @Column(name = "cvv")
    private BigDecimal cvv;

    @Column(name = "is_paid")
    private boolean isPaid = false;

    @Column(name = "borrowed_cars")
    private int borrowedCars;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getBorrowedCars() {
        return borrowedCars;
    }

    public void setBorrowedCars(int borrowedCars) {
        this.borrowedCars = borrowedCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getCvv() {
        return cvv;
    }

    public void setCvv(BigDecimal cvv) {
        this.cvv = cvv;
    }
}