package model;

public class SearchData {
    private String searchQuery;
    private String expectedUrlPart;

    public SearchData(String searchQuery, String expectedUrlPart) {
        this.searchQuery = searchQuery;
        this.expectedUrlPart = expectedUrlPart;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public String getExpectedUrlPart() {
        return expectedUrlPart;
    }
}
