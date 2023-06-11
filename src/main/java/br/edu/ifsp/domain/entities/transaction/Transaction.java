package br.edu.ifsp.domain.entities.transaction;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.usecases.transaction.ConsumedProducts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Integer id;
    private Double booking;
    private List<ConsumedProducts> consumedProducts;

    private Double totalCost;

    public Transaction() {
    }

    public Transaction(Double booking) {
        this(null, booking, null, null);
    }


    public Transaction(Integer id, Double booking, List<ConsumedProducts> consumedProducts, Double totalCost) {
        this.id = id;
        this.booking = booking;
        this.consumedProducts = consumedProducts;
        this.totalCost = totalCost;

        if (this.consumedProducts == null) {
            this.consumedProducts = new ArrayList<>();
        }
    }

    public void addProducts(ConsumedProducts product) {
        if (this.consumedProducts == null) {
            this.consumedProducts = new ArrayList<>();
        }
        this.consumedProducts.add(product);
    }

    public Double calculateTotalCost() {
        var sum = booking;
        for(ConsumedProducts product : consumedProducts){
            sum += product.getProductTotalCost();
        }
        return sum;
    }

    public String calculateDuration(Booking booking){
        Duration duration = Duration.between(booking.getStartDateBooking(), booking.getFinishDateBooking());
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

        return hours + "h" + minutes + "m";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBooking() {
        return booking;
    }

    public void setBooking(Double booking) {
        this.booking = booking;
    }

    public List<ConsumedProducts> getConsumedProducts() {
        return consumedProducts;
    }

    public void setConsumedProducts(List<ConsumedProducts> consumedProducts) {
        this.consumedProducts = consumedProducts;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", booking=" + booking +
                ", products=" + consumedProducts +
                ", totalCost=" + totalCost +
                '}';
    }
}
