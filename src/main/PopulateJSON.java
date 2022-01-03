package main;

import data.DataManagement;

public class PopulateJSON {
    public static void main(String[] args) {
        DataManagement dm = new DataManagement();
        dm.readAllData();
    }
}
