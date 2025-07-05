package org.example;

public class NonExpiryProductShippable extends NonExpiryProudct implements Shippable {

    protected double Weight ;
    public NonExpiryProductShippable() {}

    public NonExpiryProductShippable (String name, int price, int quantity , double Weight){
        super(name, price, quantity);
        this.Weight = Weight;
    }

    @Override
    public double getWeight() {
        return Weight;
    }
}
