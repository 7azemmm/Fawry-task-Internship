package org.example;

public class ExpiryProductShippable extends ExpiryProduct implements Shippable{

     protected double Weight;
        public ExpiryProductShippable() {
        }
    public ExpiryProductShippable(String name, int price , int quantity ,String expiryDate , double Weight) {
        super(name , price , quantity , expiryDate);
        this.Weight = Weight;
    }
        @Override
        public double getWeight() {
            return Weight;
        }



}
