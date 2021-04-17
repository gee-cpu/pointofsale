package com.gonchaba.shopping.cart.pos.dto;

public class CartDTO<date> {
    private int quantity;
    private long product_id;
    private date date_added;

    public CartDTO(int quantity, long product_id, date date_added) {
        this.quantity = quantity;
        this.product_id = product_id;
        this.date_added = date_added;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public date getDate_added() {
        return date_added;
    }

    public void setDate_added(date date_added) {
        this.date_added = date_added;
    }
}
