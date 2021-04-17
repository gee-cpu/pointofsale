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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "customer_order")
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
    @NamedQuery(name = "CustomerOrder.findById", query = "SELECT c FROM CustomerOrder c WHERE c.id = :id"),
    @NamedQuery(name = "CustomerOrder.findByQuantity", query = "SELECT c FROM CustomerOrder c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CustomerOrder.findByPrice", query = "SELECT c FROM CustomerOrder c WHERE c.price = :price"),
    @NamedQuery(name = "CustomerOrder.findByDateAdded", query = "SELECT c FROM CustomerOrder c WHERE c.dateAdded = :dateAdded"),
    @NamedQuery(name = "CustomerOrder.findByStatus", query = "SELECT c FROM CustomerOrder c WHERE c.status = :status"),
    @NamedQuery(name = "CustomerOrder.findByIdProductOrder", query = "SELECT c FROM CustomerOrder c WHERE c.idProductOrder = :idProductOrder")})
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private BigInteger price;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column(name = "status")
    private Boolean status;
    @Basic(optional = false)
    @Column(name = "id_product_order")
    private long idProductOrder;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ProductOrder productOrder;

    public CustomerOrder() {
    }

    public CustomerOrder(Long id) {
        this.id = id;
    }

    public CustomerOrder(Long id, long idProductOrder) {
        this.id = id;
        this.idProductOrder = idProductOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public long getIdProductOrder() {
        return idProductOrder;
    }

    public void setIdProductOrder(long idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
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
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.CustomerOrder[ id=" + id + " ]";
    }
    
}
