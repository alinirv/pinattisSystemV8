package br.edu.ifsp.domain.entities.product;

public class Product {
    private Integer id;
    private String name;
    private double price;

    private ProductStatus productStatus;

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public Product() {
    }

    public Product(String name, double price, ProductStatus productStatus) {

        this(null, name, price, productStatus);
    }

    public Product(Integer id, String name, double price, ProductStatus productStatus) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productStatus = productStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
