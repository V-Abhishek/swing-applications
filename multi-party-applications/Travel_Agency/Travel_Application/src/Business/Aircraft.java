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
public class Aircraft {

    private ArrayList<Flight> flightDirectory = new ArrayList<Flight>();
    private int serialNo;
    private String name;
    private String model;
    private boolean hasEntertainment;
    private boolean hasWifi;
    InitializeData initializeData = new InitializeData();

    public Aircraft(int serialNo, String name, String model, boolean hasEntertainment, boolean hasWifi) {
        flightDirectory = new ArrayList<Flight>();
        this.serialNo = serialNo;
        this.name = name;
        this.model = model;
        this.hasEntertainment = hasEntertainment;
        this.hasWifi = hasWifi;
        initializeData.initializeFlightSchedule(serialNo, flightDirectory);
//        initializeFlightSchedule(serialNo);
    }

    public ArrayList<Flight> getFlightDirectory() {
        return flightDirectory;
    }

    public void setFlightDirectory(ArrayList<Flight> flightDirectory) {
        this.flightDirectory = flightDirectory;
    }

    public Flight addFlight(Aircraft aircraft) {
        System.out.println(aircraft);
        Flight flight = new Flight();
        flightDirectory.add(flight);
        return flight;
    }

    public void deleteFlight(Flight flight) {
        flightDirectory.remove(flight);
    }

    public Flight searchFlight(String searchTerm) {
        for (Flight e : flightDirectory) {
            if (e.getFlightNumber().equalsIgnoreCase(searchTerm)) {
                return e;
            }
        }
        return null;
    }

    public Aircraft() {
        //Do not delete
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getModel() {
        return model;
    }

    public void setModelNo(String model) {
        this.model = model;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isHasEntertainment() {
        return hasEntertainment;
    }

    public void setHasEntertainment(boolean hasEntertainment) {
        this.hasEntertainment = hasEntertainment;
    }

//    public void initializeFlightSchedule(int serialNo){
//        
//    }
    @Override
    public String toString() {
        return serialNo + "";
    }

}
