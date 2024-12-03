package trueGSMProject.POJO;

public class SearchModel {
    private String searchInput;

    public SearchModel() {
    }

    public SearchModel(String searchInput) {
        this.searchInput = searchInput;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    @Override
    public String toString() {
        return "SearchModel: {"+ "searchInput='" + getSearchInput() + '\'' +
                '}';

    }
}
