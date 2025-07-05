package org.example;

public class Product {
    protected String name ;
    protected int price ; // I gave it as Int my assumption that the price range not need to  be bigger than int
    protected int quantity ;

    public Product() {}
    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
