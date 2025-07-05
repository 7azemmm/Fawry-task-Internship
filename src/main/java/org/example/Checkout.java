package org.example;

public  class Checkout {
    protected Customer customer;
    protected Cart cart;
    private int subTotal;
    public Checkout() {}
    public Checkout(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }


    public void PrintorderCost(){
        if(cart.products.size() == 0){
            System.out.println("No items in your cart.");
        }
        System.out.println("      Checkout Reciept     ");
        for(int i=0 ;i<cart.products.size();i++) {
            int productquantity = cart.ProductQuantity.get(i);
            System.out.println(productquantity+ " *" +cart.products.get(i).getName() + "      " + cart.products.get(i).getPrice()*productquantity);
            subTotal += (cart.products.get(i).getPrice() * productquantity);
        }

    }

    public int getSubTotal() {
        return subTotal;
    }

    public Boolean CheckCustomerBalance(double WeightCost){
        double totalCost = subTotal + WeightCost;
        if(customer.balance < totalCost){
            return false;
        }
        return true;

    }
}
