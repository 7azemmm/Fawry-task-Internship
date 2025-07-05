package org.example;

import java.util.ArrayList;


public class Cart {
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Integer> ProductQuantity = new ArrayList<>();
    public Cart() {}

    public void AddProduct(Product product,  int quantity) {

        if(quantity <= 0 || quantity > product.getQuantity()) {
            System.out.println("Out Of Stock , Here is the list to make a new choice");
            return;
        }else{
            product.quantity -= quantity;
            ProductQuantity.add(quantity);
            products.add(product);

            System.out.println("Added product to Cart , let's back to our list");
        }

    }




}
