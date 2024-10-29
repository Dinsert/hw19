package org.skypro.skyshop.model;

import static java.util.Objects.*;

public abstract class Product implements Searchable {

    private final String nameProduct;

    public Product(String nameProduct) {
        if (isNull(nameProduct) || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Неверное имя продукта");
        }
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getContentType() {
        return TypeContent.PRODUCT.getType();
    }

    @Override
    public String getName() {
        return nameProduct;
    }
}

enum TypeContent {
    PRODUCT("PRODUCT"), ARTICLE("ARTICLE");
    private String type;

    TypeContent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
