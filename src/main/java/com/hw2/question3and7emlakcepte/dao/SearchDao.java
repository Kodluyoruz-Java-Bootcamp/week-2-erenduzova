package com.hw2.question3and7emlakcepte.dao;

import com.hw2.question3and7emlakcepte.model.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchDao {

    // Singleton
    private static SearchDao searchDao;
    private List<Search> searches = new ArrayList();

    private SearchDao() {

    }

    public static SearchDao getInstance() {
        if (searchDao == null) {
            searchDao = new SearchDao();
        }
        return searchDao;
    }

    public List<Search> getSearches() {
        return searches;
    }

    public void addSearch(Search search) {
        searches.add(search);
    }
}
