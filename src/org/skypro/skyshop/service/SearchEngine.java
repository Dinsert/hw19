package org.skypro.skyshop.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import org.skypro.skyshop.model.Searchable;

public class SearchEngine {

    private static final int MAX_SEARCH_RESULTS = 5;

    private final Searchable[] elements;

    public SearchEngine(int size) {
        elements = new Searchable[size];
    }

    public Searchable[] search(String string) {
        int count = 0;
        Searchable[] searchResult = new Searchable[MAX_SEARCH_RESULTS];
        for (Searchable element : elements) {
            if (nonNull(element) && element.searchTerm(string)) {
                searchResult[count++] = element;
                if (count >= MAX_SEARCH_RESULTS) {
                    break;
                }
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < elements.length; i++) {
            if (isNull(elements[i])) {
                elements[i] = searchable;
                break;
            }
        }
    }

    public Searchable findMostSuitableBySearchString(String search) throws BestResultNotFound {
        Searchable searchable = null;
        for (Searchable element : elements) {
            if (nonNull(element) && element.searchTerm(search)) {
                searchable = element;
                break;
            }
        }
        if (isNull(searchable)) {
            throw new BestResultNotFound("Не удалось найти по запросу " + search + " наиболее подходящего результата");
        }
        return searchable;
    }

    private int getSearchTerm(String string, String substring) {
        int count = 0;
        int index = 0;
        int indexSubstring = string.indexOf(substring, index);
        while (indexSubstring != -1) {
            count++;
            index += substring.length();
            indexSubstring = string.indexOf(substring, index);
        }
        return count;
    }
}
