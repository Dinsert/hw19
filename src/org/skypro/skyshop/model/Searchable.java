package org.skypro.skyshop.model;

public interface Searchable {

    default boolean searchTerm(String term) {
        return getName().contains(term);
    }

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + "-" + getContentType();
    }

}

