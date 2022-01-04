package main;

import dataprocessing.DataManagement;

public class PopulateJSON {
    public static void main(String[] args) {
        DataManagement dm = new DataManagement();
        dm.readAllData();
    }
}
