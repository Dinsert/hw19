package org.skypro.skyshop.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import org.skypro.skyshop.model.Product;

public class ProductBasket {

    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        boolean isBasketFull = true;
        for (int i = 0; i < products.length; i++) {
            if (isNull(products[i])) {
                products[i] = product;
                isBasketFull = false;
                break;
            }
        }
        if (isBasketFull) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalBasketValue() {
        int result = 0;
        for (Product product : products) {
            if (nonNull(product)) {
                result += product.getPrice();
            }
        }
        return result;
    }

    public void printBasketContents() {
        int count = 0;
        boolean isEmptyBasket = true;
        for (Product product : products) {
            if (nonNull(product)) {
                isEmptyBasket = false;
                System.out.println(product);
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        if (!isEmptyBasket) {
            System.out.println("Итого: " + getTotalBasketValue());
            System.out.println("Специальных товаров: " + count);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkProductContainsInBasket(String productName) {
        for (Product product : products) {
            if (nonNull(product) && productName.equals(product.getNameProduct())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            if (nonNull(products[i])) {
                products[i] = null;
            }
        }
    }

}
