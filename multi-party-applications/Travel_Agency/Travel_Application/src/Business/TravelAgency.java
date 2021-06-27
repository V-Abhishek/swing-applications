/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ketanmalik
 */
public class TravelAgency {

    private ArrayList<Airliner> airlinerDirectory;
    private ArrayList<Customer> customerDirectory;

    public TravelAgency() {
        airlinerDirectory = new ArrayList<Airliner>();
        customerDirectory = new ArrayList<Customer>();
        initializeAirlinerDirectory();
        initializeCustomerDirectory(airlinerDirectory);
    }

    public ArrayList<Airliner> getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(ArrayList<Airliner> airlinerDirectory) {
        this.airlinerDirectory = airlinerDirectory;
    }

    public Airliner addAirliner(String airlinerName, int noOfAircrafts, String headquarters) {
        Airliner airliner = new Airliner(airlinerName, noOfAircrafts, headquarters);
        airlinerDirectory.add(airliner);
        return airliner;
    }

    public void deleteAirliner(Airliner airliner) {
        airlinerDirectory.remove(airliner);
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(ArrayList<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public Customer addCustomer() {
        Customer customer = new Customer();
        customerDirectory.add(customer);
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        customerDirectory.remove(customer);
    }

    public Airliner searchAirliner(String searchTerm) {
        for (Airliner e : airlinerDirectory) {
            if (e.getAirlinerName().equalsIgnoreCase(searchTerm)) {
                return e;
            }
        }
        return null;
    }

    public void initializeAirlinerDirectory() {
        Airliner a1 = new Airliner("Delta Airlines", 5, "Atlanta");
        Airliner a2 = new Airliner("Southwest Airlines", 5, "Dallas");
        Airliner a3 = new Airliner("American Airlines", 5, "Fort Worth");
        Airliner a4 = new Airliner("United Airlines", 5, "Chicago");
        Airliner a5 = new Airliner("Alaska Airlines", 5, "SeaTac");

        airlinerDirectory.add(a1);
        airlinerDirectory.add(a2);
        airlinerDirectory.add(a3);
        airlinerDirectory.add(a4);
        airlinerDirectory.add(a5);
    }

    public void initializeCustomerDirectory(ArrayList<Airliner> airlinerDirectory) {
        System.out.println(airlinerDirectory);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
        Date bookingDate = new Date();
        String date = simpleDateFormat.format(bookingDate);
        try {
            bookingDate = simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Inavlid date during initialization");
        }
        Customer c1 = new Customer();
        String date1 = "";
        for (Airliner a : airlinerDirectory) {
            for (Aircraft af : a.getAircraftDirectory()) {
                for (Flight f : af.getFlightDirectory()) {
                    if (f.getFlightNumber().equals("DL101")) {
                        date1 = f.getDate();
                        break;
                    }
                }
            }
        }
        c1.setUserName("john_doe@gmail.com");
        c1.setName("John");
        c1.setAge(34);
        c1.setGender("Male");

        c1.setTicket(new Ticket("DL101", "Boston", "Dallas", 4.5, date1, "Morning", "Available", 4500.00, "john_doe@gmail.com", "john_doe1A", bookingDate, "1A"));
        c1.setPassword("John123#");
        customerDirectory.add(c1);

        Customer c2 = new Customer();
        for (Airliner a : airlinerDirectory) {
            for (Aircraft af : a.getAircraftDirectory()) {
                for (Flight f : af.getFlightDirectory()) {
                    if (f.getFlightNumber().equals("DL106")) {
                        date1 = f.getDate();
                        break;
                    }
                }
            }
        }
        c2.setUserName("nikhil_aga@gmail.com");
        c2.setName("Nikhil");
        c2.setAge(22);
        c2.setGender("Male");
        c2.setTicket(new Ticket("DL106", "Boston", "Atlanta", 3.5, date1, "Morning", "Available", 2500.00, "nikhil_aga@gmail.com", "nikhil_aga2F", bookingDate,"2F"));
        c2.setPassword("Nikhil123#");
        customerDirectory.add(c2);

        Customer c3 = new Customer();
        for (Airliner a : airlinerDirectory) {
            for (Aircraft af : a.getAircraftDirectory()) {
                for (Flight f : af.getFlightDirectory()) {
                    if (f.getFlightNumber().equals("DL111")) {
                        date1 = f.getDate();
                        break;
                    }
                }
            }
        }
        c3.setUserName("smith_joe@gmail.com");
        c3.setName("Smith");
        c3.setAge(28);
        c3.setGender("Male");
        c3.setTicket(new Ticket("DL111", "Phoenix", "Miami", 2.5, date1, "Morning", "Available", 56237.30, "smith_joe@gmail.com", "smith_joe3E", bookingDate,"3E"));
        c3.setPassword("Smith123#");
        customerDirectory.add(c3);

        Customer c4 = new Customer();
        for (Airliner a : airlinerDirectory) {
            for (Aircraft af : a.getAircraftDirectory()) {
                for (Flight f : af.getFlightDirectory()) {
                    if (f.getFlightNumber().equals("DL117")) {
                        date1 = f.getDate();
                        break;
                    }
                }
            }
        }
        c4.setUserName("joey_m@gmail.com");
        c4.setName("Joey");
        c4.setAge(22);
        c4.setGender("Male");
        c4.setTicket(new Ticket("DL117", "Boston", "Chicago", 2.5, date1, "Evening", "Available", 4783.88, "joey_m@gmail.com", "joey_m4D", bookingDate,"4D"));
        c4.setPassword("Joey123#");
        customerDirectory.add(c4);

        Customer c5 = new Customer();
        for (Airliner a : airlinerDirectory) {
            for (Aircraft af : a.getAircraftDirectory()) {
                for (Flight f : af.getFlightDirectory()) {
                    if (f.getFlightNumber().equals("DL121")) {
                        date1 = f.getDate();
                        break;
                    }
                }
            }
        }
        c5.setUserName("raechel_g@gmail.com");
        c5.setName("Raechel");
        c5.setAge(25);
        c5.setGender("Female");
        c5.setTicket(new Ticket("DL121", "Boston", "Portland", 3.5, date1, "Evening", "Available", 6872.77, "raechel_g@gmail.com", "raechel_gu1C", bookingDate,"1C"));
        c5.setPassword("Raechel123#");

        customerDirectory.add(c5);

        Customer c6 = new Customer();
        for (Airliner a : airlinerDirectory) {
            for (Aircraft af : a.getAircraftDirectory()) {
                for (Flight f : af.getFlightDirectory()) {
                    if (f.getFlightNumber().equals("SW104")) {
                        date1 = f.getDate();
                        break;
                    }
                }
            }
        }
        c6.setUserName("zayn_m@gmail.com");
        c6.setName("Zayn");
        c6.setAge(26);
        c6.setGender("Male");
        c6.setTicket(new Ticket("SW104", "Irwin", "Houston", 4.2, date1, "Day time", "Available", 777.3, "zayn_m@gmail.com", "zayn_m21D", bookingDate,"21D"));
        c6.setPassword("Zayn123#");
        customerDirectory.add(c6);

        Customer c7 = new Customer();
        c7.setUserName("linda_fa@gmail.com");
        c7.setName("Linda");
        c7.setAge(20);
        c7.setGender("Female");
        c7.setTicket(null);
        c7.setPassword("Linda123#");
        customerDirectory.add(c7);

        Customer c8 = new Customer();
        c8.setUserName("william_s@gmail.com");
        c8.setName("William");
        c8.setAge(11);
        c8.setGender("Male");
        c8.setTicket(null);
        c8.setPassword("William123#");
        customerDirectory.add(c8);

        Customer c9 = new Customer();
        c9.setUserName("phoebi_h@gmail.com");
        c9.setName("Phoebi");
        c9.setAge(16);
        c9.setGender("Female");
        c9.setTicket(null);
        c9.setPassword("Phoebi123#");
        customerDirectory.add(c9);

        Customer c10 = new Customer();
        c10.setUserName("chandler_bing@gmail.com");
        c10.setName("Chandler");
        c10.setAge(30);
        c10.setGender("Male");
        c10.setTicket(null);
        c10.setPassword("Chandler123#");
        customerDirectory.add(c10);
    }

}
