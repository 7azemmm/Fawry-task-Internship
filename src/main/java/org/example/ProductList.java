package org.example;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProductList {
    protected List<Product> products = new ArrayList<Product>();

    public ProductList() {}

    public void printProducts() {

        if (products == null) return;

        for (Product product : products) {
            if (product != null) {
                System.out.println("Name :" + product.getName() + "-- Price: " + product.getPrice() + "-- Quantity : " + product.getQuantity() );
            }
        }
    }
    public Product getSpecificProduct(String Name) {

        String LowerCaseName = Name.toLowerCase();
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(LowerCaseName)) {
               return product ;
            }
            if (product.getQuantity() == 0) {
                return null;
            }
        }
        return null;
    }


   public void addProduct(Product product) {
        products.add(product);

   }

    public boolean isExpired(String expiryDateStr) {
        // I fomrat my date pattern as 5/7/2025 , to change it from string to date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        // change str to date
        LocalDate expiryDate = LocalDate.parse(expiryDateStr, formatter);
        LocalDate today = LocalDate.now();
        return expiryDate.isBefore(today);
    }




}
