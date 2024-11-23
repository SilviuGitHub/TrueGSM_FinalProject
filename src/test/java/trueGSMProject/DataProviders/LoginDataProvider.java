package trueGSMProject.DataProviders;

import trueGSMProject.ObjectModels.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBException;
import org.testng.annotations.DataProvider;
import trueGSMProject.utils.CSVUtils;
import trueGSMProject.utils.DatabaseUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    /* ####################################################### JSON DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginJsonDataProvider")
    public Iterator<Object[]> loginJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel[] loginModelList = objectMapper.readValue(jsonFile, LoginModel[].class);

        for (LoginModel lm : loginModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    /* ####################################################### CSV DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginCSVDataProvider")
    public Iterator<Object[]> loginCSVDataProvider() throws JAXBException, IOException, CsvException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        List<String[]> csvData = CSVUtils.readCsv("src/test/resources/testData/testDataInput.csv");

        int usernameIndex = 0, passwordIndex = 1, loginErrIndex = 2;

//        starting from 1 because we have header with legend
        for (int i = 1; i < csvData.size(); i++) {
            String[] line = csvData.get(i);
            LoginModel loginModel = new LoginModel(line[usernameIndex], line[passwordIndex], line[loginErrIndex]);
            dp.add(new Object[]{loginModel});
        }

        return dp.iterator();
    }

    /* ####################################################### SQL DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginSQLDataProvider")
    public Iterator<Object[]> loginSQLDataProvider() throws JAXBException, IOException, CsvException, SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();
//     connect to DB and get data
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login");

        while (resultSet.next()) {
            LoginModel loginModel = new LoginModel(databaseUtils.getElementFromDB(resultSet, "username"),
                    databaseUtils.getElementFromDB(resultSet, "password"),
                    databaseUtils.getElementFromDB(resultSet, "loginError"));
            dp.add(new Object[]{loginModel});
        }

        return dp.iterator();
    }
}

