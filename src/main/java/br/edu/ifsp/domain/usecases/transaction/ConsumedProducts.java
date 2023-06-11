package br.edu.ifsp.domain.usecases.transaction;

import br.edu.ifsp.domain.entities.product.Product;

public class ConsumedProducts {
    private String name;
    private Integer quantity;
    private Double unitaryPrice;
    private Double productTotalCost;

    public ConsumedProducts() {}

    public ConsumedProducts(Product product) {
        this(product, null);
    }
    public ConsumedProducts(Product product, Integer quantity) {
        this.name = product.getName();
        this.quantity = quantity;
        this.unitaryPrice = product.getPrice();
        this.productTotalCost = totalCost();
    }

    private Double totalCost(){
        Double total = quantity*unitaryPrice;
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(Double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public Double getProductTotalCost() {
        return productTotalCost;
    }

    public void setProductTotalCost(Double productTotalCost) {
        this.productTotalCost = productTotalCost;
    }

    @Override
    public String toString() {
        return "ConsumedProducts{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitaryPrice=" + unitaryPrice +
                ", productTotalCost=" + productTotalCost +
                '}';
    }
}
