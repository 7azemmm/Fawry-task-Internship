package org.example;

public class ShippingService {
    protected Cart cart;
    public ShippingService(Cart cart) {
        this.cart = cart;

    }

    public double getTotalWeight() {
        double totalWeight = 0;
        int cartSize = cart.products.size();
        for (int i = 0; i < cartSize; i++) {
            Product product = cart.products.get(i);

            if (product instanceof Shippable) {
                double currentWeight = ((Shippable) product).getWeight() * cart.ProductQuantity.get(i);
                totalWeight += currentWeight;
            }
        }
        return totalWeight;
    }

    public void printTotalWeight() {
        System.out.println("Shipment service price breakdown:");

        int cartSize = cart.products.size();
        for (int i = 0; i < cartSize; i++) {
            Product product = cart.products.get(i);

            if (product instanceof Shippable) {
                int quantity = cart.ProductQuantity.get(i);
                double currentWeight = ((Shippable) product).getWeight() * quantity;
                System.out.println(quantity + " * " + product.getName() + "    " + currentWeight);
            }
        }

        System.out.println("Total shipping weight: " + getTotalWeight()/1000 + "KG");
    }

    public double getTotalWeightPrice(double Weight) {
        // my assumption is for each gram for shipping it will cost = 0.10
        double TotalWeightpPrice = Weight*0.10;
        return TotalWeightpPrice;
    }


}



