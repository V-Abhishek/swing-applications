/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author aelinadas
 */
public class Ticket {

    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private double flightDuration;
    private String date;
    private String flightTime;
    private String isAvailable;
    private double price;
    private String userName;
    private String ticketNumber;
    private Date bookingDate;
    private String seatNumber;

    public Ticket(String flightNumber, String departureLocation, String arrivalLocation, double flightDuration, String date, String flightTime, String isAvailable, double price, String userName, String ticketNumber, Date bookingDate, String seatNumber) {
        this.flightNumber = flightNumber;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDuration = flightDuration;
        this.date = date;
        this.flightTime = flightTime;
        this.isAvailable = isAvailable;
        this.price = price;
        this.userName = userName;
        this.ticketNumber = ticketNumber;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public String isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return flightNumber + " " + departureLocation + " " + arrivalLocation + " " + date + " " + flightTime + " " + isAvailable + flightDuration + " " + price + " " + userName + " " + ticketNumber + " " + bookingDate;
    }

}
