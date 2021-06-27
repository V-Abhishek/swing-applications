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
public class Flight {

    private ArrayList<SeatAssignment> seatAssignmentDirectory = new ArrayList<SeatAssignment>();

    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private double flightDuration;
    private String date;
    private String flightTime;
    private boolean isAvailable;
    private double price;
    
    

    public Flight(String flightNumber, String departureLocation, String arrivalLocation, double flightDuration, String date, String flightTime, boolean isAvailable, double price) {
        seatAssignmentDirectory = new ArrayList<SeatAssignment>();
        this.flightNumber = flightNumber;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDuration = flightDuration;
        this.date = date;
        this.flightTime = flightTime;
        this.isAvailable = isAvailable;
        this.price = price;
        addWindowSeats();
        addAisleSeats();
        addMiddleSeats();
        initializeAssignmentDirectory(flightNumber);

    }

    public Flight() {
        //Do not delete
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public double getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(double flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public ArrayList<SeatAssignment> getSeatAssignmentDirectory() {
        return seatAssignmentDirectory;
    }

    public void setSeatAssignmentDirectory(ArrayList<SeatAssignment> seatAssignmentDirectory) {
        this.seatAssignmentDirectory = seatAssignmentDirectory;
    }

    private void addWindowSeats() {
        for (int i = 1; i <= 25; i++) {
            SeatAssignment seatAssignment = new SeatAssignment();
            seatAssignment.setSeatNumber(i + "A");
            seatAssignment.setIsAvailable(true);
            seatAssignment.setSeatType("Window");
            seatAssignmentDirectory.add(seatAssignment);
        }
        for (int i = 1; i <= 25; i++) {
            SeatAssignment seatAssignment = new SeatAssignment();
            seatAssignment.setSeatNumber(i + "F");
            seatAssignment.setIsAvailable(true);
            seatAssignment.setSeatType("Window");
            seatAssignmentDirectory.add(seatAssignment);
        }
    }

    private void addAisleSeats() {
        for (int i = 1; i <= 25; i++) {
            SeatAssignment seatAssignment = new SeatAssignment();
            seatAssignment.setSeatNumber(i + "C");
            seatAssignment.setIsAvailable(true);
            seatAssignment.setSeatType("Aisle");
            seatAssignmentDirectory.add(seatAssignment);
        }
        for (int i = 1; i <= 25; i++) {
            SeatAssignment seatAssignment = new SeatAssignment();
            seatAssignment.setSeatNumber(i + "D");
            seatAssignment.setIsAvailable(true);
            seatAssignment.setSeatType("Aisle");
            seatAssignmentDirectory.add(seatAssignment);
        }
    }

    private void addMiddleSeats() {
        for (int i = 1; i <= 25; i++) {
            SeatAssignment seatAssignment = new SeatAssignment();
            seatAssignment.setSeatNumber(i + "B");
            seatAssignment.setIsAvailable(true);
            seatAssignment.setSeatType("Middle");
            seatAssignmentDirectory.add(seatAssignment);
        }
        for (int i = 1; i <= 25; i++) {
            SeatAssignment seatAssignment = new SeatAssignment();
            seatAssignment.setSeatNumber(i + "E");
            seatAssignment.setIsAvailable(true);
            seatAssignment.setSeatType("Middle");
            seatAssignmentDirectory.add(seatAssignment);
        }
    }

    public void initializeAssignmentDirectory(String flightNumber){
        if(flightNumber.equals("DL101")){
            for (SeatAssignment seatAssignment :seatAssignmentDirectory) {
                    if (seatAssignment.getSeatNumber().equalsIgnoreCase("1A")) {
                        seatAssignment.setIsAvailable(false);
                        break;
                    }
            }
        }
        
        if(flightNumber.equals("DL106")){
            for (SeatAssignment seatAssignment :seatAssignmentDirectory) {
                    if (seatAssignment.getSeatNumber().equalsIgnoreCase("2F")) {
                        seatAssignment.setIsAvailable(false);
                        break;
                    }
            }
        }
        
        if(flightNumber.equals("DL111")){
            for (SeatAssignment seatAssignment :seatAssignmentDirectory) {
                    if (seatAssignment.getSeatNumber().equalsIgnoreCase("3E")) {
                        seatAssignment.setIsAvailable(false);
                        break;
                    }
            }
        }
        
        if(flightNumber.equals("DL117")){
            for (SeatAssignment seatAssignment :seatAssignmentDirectory) {
                    if (seatAssignment.getSeatNumber().equalsIgnoreCase("4D")) {
                        seatAssignment.setIsAvailable(false);
                        break;
                    }
            }
        }
        
        if(flightNumber.equals("DL121")){
            for (SeatAssignment seatAssignment :seatAssignmentDirectory) {
                    if (seatAssignment.getSeatNumber().equalsIgnoreCase("1C")) {
                        seatAssignment.setIsAvailable(false);
                        break;
                    }
            }
        }
        
        if(flightNumber.equals("SW104")){
            for (SeatAssignment seatAssignment :seatAssignmentDirectory) {
                    if (seatAssignment.getSeatNumber().equalsIgnoreCase("21D")) {
                        seatAssignment.setIsAvailable(false);
                        break;
                    }
            }
        }
        
    }
    
    @Override
    public String toString() {
        return flightNumber + "";
    }
}
