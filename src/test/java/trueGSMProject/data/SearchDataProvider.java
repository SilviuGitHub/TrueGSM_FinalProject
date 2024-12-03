package trueGSMProject.data;

import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBException;
import org.testng.annotations.DataProvider;
import trueGSMProject.POJO.SearchModel;
import trueGSMProject.utils.CSVUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SearchDataProvider {

    /* ####################################################### CSV DATA PROVIDER ##########################################  */

    @DataProvider(name = "searchCSVDataProvider")
    public Iterator<Object[]> searchCSVDataProvider() throws JAXBException, IOException, CsvException {
        Collection<Object[]> searchdp = new ArrayList<>();
//      here we will map csv to SearchModel
        List<String[]> csvData = CSVUtils.readCsv("src/test/resources/testData/testDataInput.csv");

        int searchInputIndex = 0;

//        starting from 1 because we have header with legend
        for (int index = 1; index < csvData.size(); index++) {
            String[] line = csvData.get(index);
            SearchModel searchModel = new SearchModel(line[searchInputIndex]);
            searchdp.add(new Object[]{searchModel});
        }

        return searchdp.iterator();
    }
}
