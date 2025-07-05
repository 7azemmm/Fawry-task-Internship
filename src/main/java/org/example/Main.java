package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Product Cheese = new ExpiryProductShippable("Cheese" , 30 , 20 , "7/4/2026" , 300);
        Product TV = new NonExpiryProductShippable("TV" , 30 , 3,750 );
        Product Biscuit = new ExpiryProduct("Biscuit" ,10 , 22 , "8/10/2023");
        Product MobileScratch = new NonExpiryProudct("MobileScratch" , 30 , 20 );


        Customer customer = new Customer("hazem" , 22 , "cairo" , 100);
        ProductList list = new ProductList();
        list.addProduct(Cheese);
        list.addProduct(TV);
        list.addProduct(Biscuit);
        list.addProduct(MobileScratch);

        Cart cart = new Cart();
        Checkout checkout = new Checkout( customer , cart);
        System.out.println("welcome to our Ecommerce application");
        System.out.println("Hello Dear ," + " " + customer.name);
        System.out.println("your Balance is" + " " + customer.balance);
        System.out.println("please choose one of the following options:");

        while(true){
            System.out.println("1. Display product");
            System.out.println("2. Add product to cart");
            System.out.println("3. checkout");
            System.out.println("for Exit please enter 0 to exit");

            System.out.println("enter your choice");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            switch(choice){
                case 0: System.out.println("Exiting application.");
                    return;
                case 1:   list.printProducts();
                break;
                case 2:
                    System.out.println("which product would you like to add to the cart , please enter his name");
                    String ProductName = sc.nextLine();
                    System.out.println("enter your need from this product");
                    int quantity = Integer.parseInt(sc.nextLine());
                    if(list.getSpecificProduct(ProductName) instanceof ExpiryProduct) {
                        ExpiryProduct p = (ExpiryProduct) list.getSpecificProduct(ProductName);
                        if (list.isExpired(p.getExpiryDate())) {
                            System.out.println("proudct is expired");
                            break;
                        }
                    }
                    if(list.getSpecificProduct(ProductName)!=null){
                        cart.AddProduct(list.getSpecificProduct(ProductName) , quantity);
                    }else{
                        System.out.println("That product out of stock");
                    }
                    break;
                case 3:

                    checkout.PrintorderCost();
                    int SubTotalCost = checkout.getSubTotal();
                    if(SubTotalCost ==0){
                        break;
                    }

                    System.out.println(" subtotal is" + " " + SubTotalCost);

                    System.out.println("----------------------------------------------");
                    ShippingService shippingService = new ShippingService(cart);
                    shippingService.printTotalWeight();
                    double totalWeight= shippingService.getTotalWeight();
                    double totalWeightPrice = shippingService.getTotalWeightPrice(totalWeight);
                    System.out.println("--------------------------------------------------------");
                    System.out.println("subTotal:  " + SubTotalCost);
                    System.out.println("ShippingCost:  " + totalWeightPrice);
                    System.out.println("Total Order Cost: " + (totalWeightPrice + SubTotalCost));
                    Boolean BalanceCheck = checkout.CheckCustomerBalance(totalWeightPrice);
                    if(BalanceCheck){
                        customer.balance -= (totalWeightPrice + SubTotalCost);
                        System.out.println("Congrats , you order done");
                        System.out.println("you balance now is = " + customer.balance);
                    }else{
                        System.out.println("Sorry, you have not enough money");
                        cart.products.clear();
                        customer.balance += SubTotalCost;
                        System.out.println("the money is back to you balace = " + customer.balance);
                    }



            }
        }
        }
    }
