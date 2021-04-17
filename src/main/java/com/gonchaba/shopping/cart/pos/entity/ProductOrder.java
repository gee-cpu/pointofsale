/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonchaba.shopping.cart.pos.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fridahpatrick
 */
@Entity
@Table(name = "product_order")
@NamedQueries({
    @NamedQuery(name = "ProductOrder.findAll", query = "SELECT p FROM ProductOrder p"),
    @NamedQuery(name = "ProductOrder.findById", query = "SELECT p FROM ProductOrder p WHERE p.id = :id"),
    @NamedQuery(name = "ProductOrder.findByDateOrdered", query = "SELECT p FROM ProductOrder p WHERE p.dateOrdered = :dateOrdered"),
    @NamedQuery(name = "ProductOrder.findByAddress", query = "SELECT p FROM ProductOrder p WHERE p.address = :address"),
    @NamedQuery(name = "ProductOrder.findByName", query = "SELECT p FROM ProductOrder p WHERE p.name = :name"),
    @NamedQuery(name = "ProductOrder.findByCity", query = "SELECT p FROM ProductOrder p WHERE p.city = :city"),
    @NamedQuery(name = "ProductOrder.findByPostalCode", query = "SELECT p FROM ProductOrder p WHERE p.postalCode = :postalCode"),
    @NamedQuery(name = "ProductOrder.findByPhoneNumber", query = "SELECT p FROM ProductOrder p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "ProductOrder.findByEmail", query = "SELECT p FROM ProductOrder p WHERE p.email = :email"),
    @NamedQuery(name = "ProductOrder.findByShippingCost", query = "SELECT p FROM ProductOrder p WHERE p.shippingCost = :shippingCost"),
    @NamedQuery(name = "ProductOrder.findByStatus", query = "SELECT p FROM ProductOrder p WHERE p.status = :status")})
public class ProductOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_ordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrdered;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "shipping_cost")
    private BigInteger shippingCost;
    @Column(name = "status")
    private Boolean status;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productOrder", fetch = FetchType.LAZY)
    private CustomerOrder customerOrder;

    public ProductOrder() {
    }

    public ProductOrder(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigInteger shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductOrder)) {
            return false;
        }
        ProductOrder other = (ProductOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.ProductOrder[ id=" + id + " ]";
    }
    
}
