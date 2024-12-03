package trueGSMProject.tests;

import org.testng.annotations.Test;
import trueGSMProject.POJO.SearchModel;
import trueGSMProject.data.SearchDataProvider;
import trueGSMProject.pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "searchCSVDataProvider", dataProviderClass = SearchDataProvider.class)
    public void searchWithCSVAsDataSource(SearchModel searchModel) {
        searchWithSearchModel(searchModel);
    }

    protected void searchWithSearchModel(SearchModel searchModel) {
        setUp();
        driver.navigate().to(baseURL);

        SearchPage searchPage = new SearchPage(driver);
        System.out.println(searchModel);
        searchPage.search(searchModel.getSearchInput());
    }
}
