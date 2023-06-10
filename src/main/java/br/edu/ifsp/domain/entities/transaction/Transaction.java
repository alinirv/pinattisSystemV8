package br.edu.ifsp.domain.entities.transaction;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.product.Product;

import java.util.List;

public class Transaction {
    private Integer id;
    private Booking booking;
    private List<Product> products;

    public Transaction() {
    }

    public Transaction(Integer id, Booking booking, List<Product> products) {
        this.id = id;
        this.booking = booking;
        this.products = products;
    }

    public Transaction(Booking booking, List<Product> products) {
        this.booking = booking;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", booking=" + booking +
                ", products=" + products +
                '}';
    }
}
