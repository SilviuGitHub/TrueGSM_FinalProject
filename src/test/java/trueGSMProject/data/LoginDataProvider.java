package trueGSMProject.data;

import trueGSMProject.POJO.LoginModel;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBException;
import org.testng.annotations.DataProvider;
import trueGSMProject.utils.DatabaseUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataProvider {

    /* ####################################################### SQL DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginSQLDataProvider")
    public Iterator<Object[]> loginSQLDataProvider() throws JAXBException, IOException, CsvException, SQLException {
        Collection<Object[]> logindp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();
//     connect to DB and get data
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login");

        while (resultSet.next()) {
            LoginModel loginModel = new LoginModel(databaseUtils.getElementFromDB(resultSet, "username"),
                    databaseUtils.getElementFromDB(resultSet, "password"),
                    databaseUtils.getElementFromDB(resultSet, "loginMessage"));
            logindp.add(new Object[]{loginModel});
        }

        return logindp.iterator();
    }
}
