/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author ketanmalik
 */
public class Airliner {

    private ArrayList<Aircraft> aircraftDirectory;
    private String airlinerName;
    private int noOfAircrafts;
    private String headquarters;

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Airliner(String airLinerName, int noOfAircrafts, String headquarters) {
        aircraftDirectory = new ArrayList<Aircraft>();
        this.airlinerName = airLinerName;
        this.noOfAircrafts = noOfAircrafts;
        this.headquarters = headquarters;
        InitializeData initializeData = new InitializeData();
        initializeData.initializeAircraftDirectory(airlinerName, aircraftDirectory);
//        initializeAircraftDirectory(airLinerName);
    }

    public ArrayList<Aircraft> getAircraftDirectory() {
        return aircraftDirectory;
    }

    public void setAircraftDirectory(ArrayList<Aircraft> aircraftDirectory) {
        this.aircraftDirectory = aircraftDirectory;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public int getNoOfAircrafts() {
        return noOfAircrafts;
    }

    public void setNoOfAircrafts(int noOfAircrafts) {
        this.noOfAircrafts = noOfAircrafts;
    }

    public void deleteAircraft(Aircraft aircraft) {
        aircraftDirectory.remove(aircraft);
    }

    public Aircraft addAircraft() {
        Aircraft aircraft = new Aircraft();
        aircraftDirectory.add(aircraft);
        return aircraft;
    }

    @Override
    public String toString() {
        return airlinerName;
    }

//    public void initializeAircraftDirectory(String airlinerName) {
//
//        switch (airlinerName) {
//            case "Delta Airlines":
//                Aircraft a1 = new Aircraft(100, "Airbus", "A380", true, true);
//                Aircraft a2 = new Aircraft(101, "Airbus", "A330", true, true);
//                Aircraft a3 = new Aircraft(102, "Airbus", "A310", true, false);
//                Aircraft a4 = new Aircraft(103, "Boeing", "787", true, true);
//                Aircraft a5 = new Aircraft(104, "Airbus", "737", false, false);
//
//                aircraftDirectory.add(a1);
//                aircraftDirectory.add(a2);
//                aircraftDirectory.add(a3);
//                aircraftDirectory.add(a4);
//                aircraftDirectory.add(a5);
//
//                break;
//
//            case "Southwest Airlines":
//                Aircraft a6 = new Aircraft(001, "Airbus", "A220", false, false);
//                Aircraft a7 = new Aircraft(002, "Airbus", "A300", false, false);
//                Aircraft a8 = new Aircraft(003, "Airbus", "A310", true, false);
//                Aircraft a9 = new Aircraft(004, "Boeing", "777", true, true);
//                Aircraft a10 = new Aircraft(005, "Airbus", "767", true, true);
//                aircraftDirectory.add(a6);
//                aircraftDirectory.add(a7);
//                aircraftDirectory.add(a8);
//                aircraftDirectory.add(a9);
//                aircraftDirectory.add(a10);
//
//                break;
//
//            case "American Airlines":
//                Aircraft a11 = new Aircraft(1120, "Bombardier", "7500", true, true);
//                Aircraft a12 = new Aircraft(1121, "Bombardier", "3500", true, true);
//                Aircraft a13 = new Aircraft(1122, "Airbus", "A330", true, false);
//                Aircraft a14 = new Aircraft(1123, "Boeing", "777", true, true);
//                Aircraft a15 = new Aircraft(1124, "Airbus", "787", false, false);
//                aircraftDirectory.add(a11);
//                aircraftDirectory.add(a12);
//                aircraftDirectory.add(a13);
//                aircraftDirectory.add(a14);
//                aircraftDirectory.add(a15);
//
//                break;
//
//            case "United Airlines":
//                Aircraft a16 = new Aircraft(2001, "Tupolev", "ANT-1", false, false);
//                Aircraft a17 = new Aircraft(2002, "Tupolev", "ANT-45", true, false);
//                Aircraft a18 = new Aircraft(2003, "Airbus", "A310", true, false);
//                Aircraft a19 = new Aircraft(2004, "Bombardier", "7500", true, true);
//                Aircraft a20 = new Aircraft(2005, "Airbus", "737", false, false);
//                aircraftDirectory.add(a16);
//                aircraftDirectory.add(a17);
//                aircraftDirectory.add(a18);
//                aircraftDirectory.add(a19);
//                aircraftDirectory.add(a20);
//
//                break;
//
//            case "Alaska Airlines":
//                Aircraft a21 = new Aircraft(301, "Embrarer", "450", true, true);
//                Aircraft a22 = new Aircraft(302, "Airbus", "A330", true, true);
//                Aircraft a23 = new Aircraft(303, "Embrarer", "300", true, false);
//                Aircraft a24 = new Aircraft(304, "Boeing", "787", true, true);
//                Aircraft a25 = new Aircraft(305, "Embrarer", "195", false, false);
//                aircraftDirectory.add(a21);
//                aircraftDirectory.add(a22);
//                aircraftDirectory.add(a23);
//                aircraftDirectory.add(a24);
//                aircraftDirectory.add(a25);
//
//                break;
//
//        }
//    }
    public ArrayList<Aircraft> searchAircraft(String searchTerm) {
        int flag = 0;
        ArrayList<Aircraft> temp = new ArrayList<>();
        for (Aircraft e : aircraftDirectory) {
            if (e.getName().equalsIgnoreCase(searchTerm)) {
                temp.add(e);
                flag = 1;
            }
        }
        if (flag == 0) {
            return null;
        }
        return temp;
    }
}
