package model;

public class AddToBasketData {
    private String productName;
    private String productSize;

    public AddToBasketData(String productName, String productSize) {
        this.productName = productName;
        this.productSize = productSize;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSize() {
        return productSize;
    }
}
