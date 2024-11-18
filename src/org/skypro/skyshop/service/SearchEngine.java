package org.skypro.skyshop.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import org.skypro.skyshop.model.Searchable;

public class SearchEngine {

    private final List<Searchable> elements;

    public SearchEngine() {
        elements = new ArrayList<>();
    }

    public List<Searchable> search(String string) {
        List<Searchable> searchResult = new ArrayList<>();
        for (Searchable element : elements) {
            if (nonNull(element) && element.searchTerm(string)) {
                searchResult.add(element);
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        if (!elements.contains(searchable)) {
            elements.add(searchable);
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
