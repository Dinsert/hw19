package org.skypro.skyshop.model;

import static java.util.Objects.*;

public abstract class Product implements Searchable {

    private final String nameProduct;

    public Product(String nameProduct) {
        checkNameProduct(nameProduct);
        this.nameProduct = nameProduct;
    }

    private void checkNameProduct(String nameProduct) {
        if (isNull(nameProduct) || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Неверное имя продукта");
        }
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return TypeContent.PRODUCT.getType();
    }

    @Override
    public String getName() {
        return nameProduct;
    }
}
