package dataprocessing;

import actions.Simulation;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import data.Database;
import data.GiftList;
import data.OutputDatabase;

import java.io.File;
import java.io.IOException;

public class DataManagement {

    public DataManagement() {
        // constructor for json
    }

    public void simulateData(Database db, OutputDatabase odb, GiftList giftList) {
        Simulation sim = new Simulation(db, giftList);
        sim.InitialYear(odb);
    }

    public void readAllData() {
        OutputDatabase odb = new OutputDatabase();
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            Database db = new Database();
            try {
                db = new ObjectMapper().readerFor(Database.class).readValue(
                        new File("tests/test" + i + Constants.FILE_EXTENSION));
                GiftList giftList = new GiftList();
                giftList.populateGiftList(db.getInitialData().getSantaGiftsList());
                simulateData(db, odb, giftList);
                writeAllData(odb, i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeAllData(OutputDatabase odb, Integer testNumber) {
        ObjectMapper om = new ObjectMapper();
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(new File(Constants.OUTPUT_PATH + testNumber), odb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
