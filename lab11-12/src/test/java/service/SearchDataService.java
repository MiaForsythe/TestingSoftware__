package service;

import model.SearchData;

public class SearchDataService {
    public static SearchData getSearchData() {
        return new SearchData("Green Tea", "?s=Green+Tea");
    }
}
