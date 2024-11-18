package org.skypro.skyshop.service;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.skypro.skyshop.model.Product;

public class ProductBasket {

    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
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
            if (nonNull(product) && product.getNameProduct().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> removeProductByBasket(String productName) {
        List<Product> result = new ArrayList<>(products);
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            if (productIterator.next().getNameProduct().equals(productName)) {
                productIterator.remove();
            }
        }
        result.removeAll(products);
        if (result.isEmpty()) {
            System.out.println("Список пуст");
        }
        return result;
    }

    public void clearBasket() {
        products.clear();
    }

}
