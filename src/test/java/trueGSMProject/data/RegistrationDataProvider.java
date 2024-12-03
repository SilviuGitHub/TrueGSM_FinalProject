package trueGSMProject.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import trueGSMProject.POJO.RegistrationModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDataProvider {

    /* ####################################################### JSON DATA PROVIDER ##########################################  */

    @DataProvider(name = "registrationJSONDataProvider")
    public Iterator<Object[]> registrationwithJSONasDataProvider() throws IOException {
        Collection<Object[]> registerdp = new ArrayList<>();
//      here we will map json to RegistrationModel
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        RegistrationModel[] registrationModelList = objectMapper.readValue(jsonFile, RegistrationModel[].class);

        for (RegistrationModel registrationModel : registrationModelList)
            registerdp.add(new Object[]{registrationModel});

        return registerdp.iterator();
    }
}