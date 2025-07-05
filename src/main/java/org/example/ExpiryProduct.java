package org.example;

public class ExpiryProduct extends Product {

    protected String expiryDate;

    public ExpiryProduct() {}
    public ExpiryProduct(String name, int price , int quantity ,String expiryDate) {
        super(name , price , quantity);
        this.expiryDate = expiryDate;
    }


    public String getExpiryDate() {
        return expiryDate;
    }
}
