package service;

import model.AddToBasketData;

public class AddToBasketService {
    public void addToBasket(AddToBasketData addToBasket) {
         System.out.println("Adding " + addToBasket.getProductName() + " - " + addToBasket.getProductSize() + " to basket...");
    }
}
