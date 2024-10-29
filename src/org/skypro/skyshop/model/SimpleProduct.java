package org.skypro.skyshop.model;

public class SimpleProduct extends Product {

    private final int simplePrice;

    public SimpleProduct(String nameProduct, int simplePrice) {
        super(nameProduct);
        if (simplePrice <= 0) {
            throw new IllegalArgumentException("Неверная цена");
        }
        this.simplePrice = simplePrice;
    }

    @Override
    public int getPrice() {
        return simplePrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + simplePrice;
    }
}
