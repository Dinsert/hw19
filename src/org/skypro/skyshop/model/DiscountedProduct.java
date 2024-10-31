package org.skypro.skyshop.model;

public class DiscountedProduct extends Product {

    private final int basePrise;
    private final int wholePercentDiscount;

    public DiscountedProduct(String nameProduct, int basePrise, int wholePercentDiscount) {
        super(nameProduct);
        checkBasePriceAndWholePercentDiscount(basePrise,wholePercentDiscount);
        this.basePrise = basePrise;
        this.wholePercentDiscount = wholePercentDiscount;
    }

    private void checkBasePriceAndWholePercentDiscount(int basePrise, int wholePercentDiscount) {
        if (basePrise <= 0 && wholePercentDiscount < 0 || wholePercentDiscount > 100) {
            throw new IllegalArgumentException("Неверная цена или процент скидки");
        }
    }

    @Override
    public int getPrice() {
        return basePrise - (basePrise * wholePercentDiscount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + basePrise + " (" + wholePercentDiscount + "%)";
    }
}
