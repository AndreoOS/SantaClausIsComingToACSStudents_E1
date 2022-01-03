package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;

import java.io.File;
import java.io.IOException;

public class DataManagement {

    public void readAllData() {
        for(int i = 0; i < Constants.TESTS_NUMBER; i++) {
            Database db = new Database();
            try {
                db = new ObjectMapper().readerFor(Database.class).readValue(
                        new File("test" + i + Constants.FILE_EXTENSION));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
