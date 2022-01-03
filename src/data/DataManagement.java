package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;

import java.io.File;
import java.io.IOException;

public class DataManagement {

    public DataManagement() {
        // constructor for json
    }

    public void readAllData() {
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            Database db = new Database();
            try {
                db = new ObjectMapper().readerFor(Database.class).readValue(
                        new File("tests/test" + i + Constants.FILE_EXTENSION));
                System.out.println(db.getInitialData().getChildren().get(0).getAge());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
