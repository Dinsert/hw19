package org.skypro.skyshop.model;

public class SimpleProduct extends Product {

    private final int simplePrice;

    public SimpleProduct(String nameProduct, int simplePrice) {
        super(nameProduct);
        checkSimplePrice(simplePrice);
        this.simplePrice = simplePrice;
    }

    private void checkSimplePrice(int simplePrice) {
        if (simplePrice <= 0) {
            throw new IllegalArgumentException("Неверная цена");
        }
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
