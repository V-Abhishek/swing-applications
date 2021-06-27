/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author ketanmalik
 */
public class InitializeData {

    private ArrayList<Aircraft> aircraftDirectory;
    private ArrayList<Flight> flightSchedule;
    Random random = new Random();

    public boolean randomAvailabilityGeneration() {
        return random.nextBoolean();
    }

    public String randomDateGeneration() {
        int max = (int) LocalDate.of(2019, 12, 31).toEpochDay();
        int min = (int) LocalDate.of(2019, 11, 01).toEpochDay();
        long rand = min + random.nextInt(max - min);

        LocalDate d = LocalDate.ofEpochDay(rand);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = d.format(f);
        return date;
    }

    public void initializeAircraftDirectory(String airlinerName, ArrayList<Aircraft> ad) {
        this.aircraftDirectory = ad;
        switch (airlinerName) {
            case "Delta Airlines":
                Aircraft a1 = new Aircraft(100, "Airbus", "A380", true, true);
                Aircraft a2 = new Aircraft(101, "Airbus", "A330", true, true);
                Aircraft a3 = new Aircraft(102, "Airbus", "A310", true, false);
                Aircraft a4 = new Aircraft(103, "Boeing", "787", true, true);
                Aircraft a5 = new Aircraft(104, "Airbus", "737", false, false);

                aircraftDirectory.add(a1);
                aircraftDirectory.add(a2);
                aircraftDirectory.add(a3);
                aircraftDirectory.add(a4);
                aircraftDirectory.add(a5);

                break;

            case "Southwest Airlines":
                Aircraft a6 = new Aircraft(001, "Airbus", "A220", false, false);
                Aircraft a7 = new Aircraft(002, "Airbus", "A300", false, false);
                Aircraft a8 = new Aircraft(003, "Airbus", "A310", true, false);
                Aircraft a9 = new Aircraft(004, "Boeing", "777", true, true);
                Aircraft a10 = new Aircraft(005, "Airbus", "767", true, true);
                aircraftDirectory.add(a6);
                aircraftDirectory.add(a7);
                aircraftDirectory.add(a8);
                aircraftDirectory.add(a9);
                aircraftDirectory.add(a10);

                break;

            case "American Airlines":
                Aircraft a11 = new Aircraft(1120, "Bombardier", "7500", true, true);
                Aircraft a12 = new Aircraft(1121, "Bombardier", "3500", true, true);
                Aircraft a13 = new Aircraft(1122, "Airbus", "A330", true, false);
                Aircraft a14 = new Aircraft(1123, "Boeing", "777", true, true);
                Aircraft a15 = new Aircraft(1124, "Airbus", "787", false, false);
                aircraftDirectory.add(a11);
                aircraftDirectory.add(a12);
                aircraftDirectory.add(a13);
                aircraftDirectory.add(a14);
                aircraftDirectory.add(a15);

                break;

            case "United Airlines":
                Aircraft a16 = new Aircraft(2001, "Tupolev", "ANT-1", false, false);
                Aircraft a17 = new Aircraft(2002, "Tupolev", "ANT-45", true, false);
                Aircraft a18 = new Aircraft(2003, "Airbus", "A310", true, false);
                Aircraft a19 = new Aircraft(2004, "Bombardier", "7500", true, true);
                Aircraft a20 = new Aircraft(2005, "Airbus", "737", false, false);
                aircraftDirectory.add(a16);
                aircraftDirectory.add(a17);
                aircraftDirectory.add(a18);
                aircraftDirectory.add(a19);
                aircraftDirectory.add(a20);

                break;

            case "Alaska Airlines":
                Aircraft a21 = new Aircraft(301, "Embrarer", "450", true, true);
                Aircraft a22 = new Aircraft(302, "Airbus", "A330", true, true);
                Aircraft a23 = new Aircraft(303, "Embrarer", "300", true, false);
                Aircraft a24 = new Aircraft(304, "Boeing", "787", true, true);
                Aircraft a25 = new Aircraft(305, "Embrarer", "195", false, false);
                aircraftDirectory.add(a21);
                aircraftDirectory.add(a22);
                aircraftDirectory.add(a23);
                aircraftDirectory.add(a24);
                aircraftDirectory.add(a25);

                break;

        }
    }

    public void initializeFlightSchedule(int serialNo, ArrayList<Flight> af) {
        this.flightSchedule = af;

        switch (serialNo) {
            case 100:

                Flight f1 = new Flight("DL101", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 450.00);
                Flight f2 = new Flight("DL102", "Boston", "Chicago", 2.5, randomDateGeneration(), "Day time", true, 50.00);
                Flight f3 = new Flight("DL103", "New York", "Dallas", 4, randomDateGeneration(), "Evening", true, 950.00);
                Flight f4 = new Flight("DL104", "Irwin", "Houston", 4.2, randomDateGeneration(), "Day time", true, 550.50);
                Flight f5 = new Flight("DL105", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 600.00);

                flightSchedule.add(f1);
                flightSchedule.add(f2);
                flightSchedule.add(f3);
                flightSchedule.add(f4);
                flightSchedule.add(f5);

                break;

            case 101:

                Flight f6 = new Flight("DL106", "Boston", "Atlanta", 3.5, randomDateGeneration(), "Morning", true, 250.00);
                Flight f7 = new Flight("DL107", "Atlanta", "Chicago", 2.2, randomDateGeneration(), "Evening", true, 450.88);
                Flight f8 = new Flight("DL108", "New York", "Dallas", 4.4, randomDateGeneration(), "Morning", true, 690.00);
                Flight f9 = new Flight("DL109", "Irwin", "Denver", 5, randomDateGeneration(), "Day time", true, 647.98);
                Flight f10 = new Flight("DL110", "Orlando", "San Francisco", 6.5, randomDateGeneration(), "Morning", true, 478.90);

                flightSchedule.add(f6);
                flightSchedule.add(f7);
                flightSchedule.add(f8);
                flightSchedule.add(f9);
                flightSchedule.add(f10);

                break;
            case 102:

                Flight f11 = new Flight("DL111", "Phoenix", "Miami", 2.5, randomDateGeneration(), "Morning", true, 537.30);
                Flight f12 = new Flight("DL112", "Boston", "Detroit", 1.5, randomDateGeneration(), "Evening", true, 567.30);
                Flight f13 = new Flight("DL113", "Boston", "Dallas", 4.9, randomDateGeneration(), "Morning", true, 567.30);
                Flight f14 = new Flight("DL114", "San Diego", "Houston", 4.0, randomDateGeneration(), "Day time", true, 858.00);
                Flight f15 = new Flight("DL115", "Washington", "San Francisco", 3.3, randomDateGeneration(), "Morning", true, 789.00);

                flightSchedule.add(f11);
                flightSchedule.add(f12);
                flightSchedule.add(f13);
                flightSchedule.add(f14);
                flightSchedule.add(f15);

                break;
            case 103:

                Flight f16 = new Flight("DL116", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 678.44);
                Flight f17 = new Flight("DL117", "Boston", "Chicago", 2.5, randomDateGeneration(), "Evening", true, 473.88);
                Flight f18 = new Flight("DL118", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 684.77);
                Flight f19 = new Flight("DL119", "Irwin", "Houston", 4.2, randomDateGeneration(), "Day time", true, 788.74);
                Flight f20 = new Flight("DL120", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 555.75);

                flightSchedule.add(f16);
                flightSchedule.add(f17);
                flightSchedule.add(f18);
                flightSchedule.add(f19);
                flightSchedule.add(f20);

                break;
            case 104:

                Flight f21 = new Flight("DL121", "Boston", "Portland", 3.5, randomDateGeneration(), "Evening", true, 687.77);
                Flight f22 = new Flight("DL122", "Portland", "Chicago", 5, randomDateGeneration(), "Morning", true, 111.11);
                Flight f23 = new Flight("DL123", "New York", "Chicago", 4.3, randomDateGeneration(), "Evening", true, 372.37);
                Flight f24 = new Flight("DL124", "Irwin", "San Diego", 4.2, randomDateGeneration(), "Morning", true, 483.78);
                Flight f25 = new Flight("DL125", "Arizona", "Oakland", 3, randomDateGeneration(), "Day time", true, 782.67);

                flightSchedule.add(f21);
                flightSchedule.add(f22);
                flightSchedule.add(f23);
                flightSchedule.add(f24);
                flightSchedule.add(f25);

                break;

            case 001:

                Flight g1 = new Flight("SW101", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 647.546);
                Flight g2 = new Flight("SW102", "Boston", "Chicago", 2.5, randomDateGeneration(), "Evening", true, 674.33);
                Flight g3 = new Flight("SW103", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 326.37);
                Flight g4 = new Flight("SW104", "Irwin", "Houston", 4.2, randomDateGeneration(), "Day time", true, 777.3);
                Flight g5 = new Flight("SW105", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 788.00);

                flightSchedule.add(g1);
                flightSchedule.add(g2);
                flightSchedule.add(g3);
                flightSchedule.add(g4);
                flightSchedule.add(g5);

                break;

            case 002:

                Flight g6 = new Flight("SW106", "Boston", "Atlanta", 3.5, randomDateGeneration(), "Morning", true, 978.84);
                Flight g7 = new Flight("SW107", "Atlanta", "Chicago", 2.2, randomDateGeneration(), "Evening", true, 775.60);
                Flight g8 = new Flight("SW108", "New York", "Dallas", 4.4, randomDateGeneration(), "Morning", true, 789.99);
                Flight g9 = new Flight("SW109", "Irwin", "Denver", 5, randomDateGeneration(), "Day time", true, 657.900);
                Flight g10 = new Flight("SW110", "Orlando", "San Francisco", 6.5, randomDateGeneration(), "Morning", true, 657.35);

                flightSchedule.add(g6);
                flightSchedule.add(g7);
                flightSchedule.add(g8);
                flightSchedule.add(g9);
                flightSchedule.add(g10);

                break;
            case 003:

                Flight g11 = new Flight("SW111", "Phoenix", "Miami", 2.5, randomDateGeneration(), "Evening", true, 567.30);
                Flight g12 = new Flight("SW112", "Boston", "Detroit", 1.5, randomDateGeneration(), "Morning", true, 567.30);
                Flight g13 = new Flight("SW113", "Boston", "Dallas", 4.9, randomDateGeneration(), "Day time", true, 644.55);
                Flight g14 = new Flight("SW114", "San Diego", "Houston", 4.0, randomDateGeneration(), "Morning", true, 557.30);
                Flight g15 = new Flight("SW115", "Washington", "San Francisco", 3.3, randomDateGeneration(), "Morning", true, 565.00);

                flightSchedule.add(g11);
                flightSchedule.add(g12);
                flightSchedule.add(g13);
                flightSchedule.add(g14);
                flightSchedule.add(g15);

                break;
            case 004:

                Flight g16 = new Flight("SW116", "Boston", "Dallas", 4.5, randomDateGeneration(), "Evening", true, 444.5);
                Flight g17 = new Flight("SW117", "Boston", "Chicago", 2.5, randomDateGeneration(), "Morning", true, 578.78);
                Flight g18 = new Flight("SW118", "New York", "Dallas", 4, randomDateGeneration(), "Day time", true, 6754.00);
                Flight g19 = new Flight("SW119", "Irwin", "Houston", 4.2, randomDateGeneration(), "Morning", true, 895.70);
                Flight g20 = new Flight("SW120", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 677.99);

                flightSchedule.add(g16);
                flightSchedule.add(g17);
                flightSchedule.add(g18);
                flightSchedule.add(g19);
                flightSchedule.add(g20);

                break;
            case 005:

                Flight g21 = new Flight("SW121", "Boston", "Portland", 3.5, randomDateGeneration(), "Morning", true, 980.0);
                Flight g22 = new Flight("SW122", "Portland", "Chicago", 5, randomDateGeneration(), "Evening", true, 647.99);
                Flight g23 = new Flight("SW123", "New York", "Chicago", 4.3, randomDateGeneration(), "Morning", true, 785.00);
                Flight g24 = new Flight("SW124", "Irwin", "San Diego", 4.2, randomDateGeneration(), "Day time", true, 678.44);
                Flight g25 = new Flight("SW125", "Arizona", "Oakland", 3, randomDateGeneration(), "Morning", true, 674.44);

                flightSchedule.add(g21);
                flightSchedule.add(g22);
                flightSchedule.add(g23);
                flightSchedule.add(g24);
                flightSchedule.add(g25);

                break;

            case 1120:

                Flight a1 = new Flight("AL101", "Boston", "Dallas", 4.5, randomDateGeneration(), "Evening", true, 564.45);
                Flight a2 = new Flight("AL102", "Boston", "Chicago", 2.5, randomDateGeneration(), "Morning", true, 684.43);
                Flight a3 = new Flight("AL103", "New York", "Dallas", 4, randomDateGeneration(), "Day time", true, 468.66);
                Flight a4 = new Flight("AL104", "Irwin", "Houston", 4.2, randomDateGeneration(), "Morning", true, 879.00);
                Flight a5 = new Flight("AL105", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 675.00);

                flightSchedule.add(a1);
                flightSchedule.add(a2);
                flightSchedule.add(a3);
                flightSchedule.add(a4);
                flightSchedule.add(a5);

                break;

            case 1121:

                Flight a6 = new Flight("AL106", "Boston", "Atlanta", 3.5, randomDateGeneration(), "Morning", true, 789.00);
                Flight a7 = new Flight("AL107", "Atlanta", "Chicago", 2.2, randomDateGeneration(), "Day time", true, 787.00);
                Flight a8 = new Flight("AL108", "New York", "Dallas", 4.4, randomDateGeneration(), "Evening", true, 893.99);
                Flight a9 = new Flight("AL109", "Irwin", "Denver", 5, randomDateGeneration(), "Evening", true, 976.00);
                Flight a10 = new Flight("AL110", "Orlando", "San Francisco", 6.5, randomDateGeneration(), "Morning", true, 909.00);

                flightSchedule.add(a6);
                flightSchedule.add(a7);
                flightSchedule.add(a8);
                flightSchedule.add(a9);
                flightSchedule.add(a10);

                break;
            case 1122:

                Flight a11 = new Flight("AL111", "Phoenix", "Miami", 2.5, randomDateGeneration(), "Morning", true, 8879.7);
                Flight a12 = new Flight("AL112", "Boston", "Detroit", 1.5, randomDateGeneration(), "Day time", true, 980.00);
                Flight a13 = new Flight("AL113", "Boston", "Dallas", 4.9, randomDateGeneration(), "Morning", true, 980.00);
                Flight a14 = new Flight("AL114", "San Diego", "Houston", 4.0, randomDateGeneration(), "Evening", true, 755.0);
                Flight a15 = new Flight("AL115", "Washington", "San Francisco", 3.3, randomDateGeneration(), "Morning", true, 758.00);

                flightSchedule.add(a11);
                flightSchedule.add(a12);
                flightSchedule.add(a13);
                flightSchedule.add(a14);
                flightSchedule.add(a15);

                break;
            case 1123:

                Flight a16 = new Flight("AL116", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 758.00);
                Flight a17 = new Flight("AL117", "Boston", "Chicago", 2.5, randomDateGeneration(), "Day time", true, 566.00);
                Flight a18 = new Flight("AL118", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 687.090);
                Flight a19 = new Flight("AL119", "Irwin", "Houston", 4.2, randomDateGeneration(), "Evening", true, 780.78);
                Flight a20 = new Flight("AL120", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 666.00);

                flightSchedule.add(a16);
                flightSchedule.add(a17);
                flightSchedule.add(a18);
                flightSchedule.add(a19);
                flightSchedule.add(a20);

                break;
            case 1124:

                Flight a21 = new Flight("AL121", "Boston", "Portland", 3.5, randomDateGeneration(), "Morning", true, 667.99);
                Flight a22 = new Flight("AL122", "Portland", "Chicago", 5, randomDateGeneration(), "Day time", true, 666.00);
                Flight a23 = new Flight("AL123", "New York", "Chicago", 4.3, randomDateGeneration(), "Evening", true, 434.00);
                Flight a24 = new Flight("AL124", "Irwin", "San Diego", 4.2, randomDateGeneration(), "Morning", true, 679.00);
                Flight a25 = new Flight("AL125", "Arizona", "Oakland", 3, randomDateGeneration(), "Evening", true, 788.90);

                flightSchedule.add(a21);
                flightSchedule.add(a22);
                flightSchedule.add(a23);
                flightSchedule.add(a24);
                flightSchedule.add(a25);

                break;

            case 2001:

                Flight u1 = new Flight("UA101", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 789.00);
                Flight u2 = new Flight("UA102", "Boston", "Chicago", 2.5, randomDateGeneration(), "Evening", true, 780.99);
                Flight u3 = new Flight("UA103", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 784.00);
                Flight u4 = new Flight("UA104", "Irwin", "Houston", 4.2, randomDateGeneration(), "Day time", true, 789.00);
                Flight u5 = new Flight("UA105", "Arizona", "San Francisco", 3, randomDateGeneration(), "Morning", true, 987.00);

                flightSchedule.add(u1);
                flightSchedule.add(u2);
                flightSchedule.add(u3);
                flightSchedule.add(u4);
                flightSchedule.add(u5);

                break;

            case 2002:

                Flight u6 = new Flight("UA106", "Boston", "Atlanta", 3.5, randomDateGeneration(), "Morning", true, 890.00);
                Flight u7 = new Flight("UA107", "Atlanta", "Chicago", 2.2, randomDateGeneration(), "Evening", true, 79.00);
                Flight u8 = new Flight("UA108", "New York", "Dallas", 4.4, randomDateGeneration(), "Morning", true, 68.00);
                Flight u9 = new Flight("UA109", "Irwin", "Denver", 5, randomDateGeneration(), "Day time", true, 767.99);
                Flight u10 = new Flight("UA110", "Orlando", "San Francisco", 6.5, randomDateGeneration(), "Morning", true, 87.93);

                flightSchedule.add(u6);
                flightSchedule.add(u7);
                flightSchedule.add(u8);
                flightSchedule.add(u9);
                flightSchedule.add(u10);

                break;
            case 2003:

                Flight u11 = new Flight("UA111", "Phoenix", "Miami", 2.5, randomDateGeneration(), "Morning", true, 689.99);
                Flight u12 = new Flight("UA112", "Boston", "Detroit", 1.5, randomDateGeneration(), "Day time", true, 890.77);
                Flight u13 = new Flight("UA113", "Boston", "Dallas", 4.9, randomDateGeneration(), "Morning", true, 779.66);
                Flight u14 = new Flight("UA114", "San Diego", "Houston", 4.0, randomDateGeneration(), "Evening", true, 870.99);
                Flight u15 = new Flight("UA115", "Washington", "San Francisco", 3.3, randomDateGeneration(), "Morning", true, 776.99);

                flightSchedule.add(u11);
                flightSchedule.add(u12);
                flightSchedule.add(u13);
                flightSchedule.add(u14);
                flightSchedule.add(u15);

                break;
            case 2004:

                Flight u16 = new Flight("UA116", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 908.77);
                Flight u17 = new Flight("UA117", "Boston", "Chicago", 2.5, randomDateGeneration(), "Evening", true, 780.99);
                Flight u18 = new Flight("UA118", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 890.00);
                Flight u19 = new Flight("UA119", "Irwin", "Houston", 4.2, randomDateGeneration(), "Morning", true, 890.88);
                Flight u20 = new Flight("UA120", "Arizona", "San Francisco", 3, randomDateGeneration(), "Day time", true, 878.00);

                flightSchedule.add(u16);
                flightSchedule.add(u17);
                flightSchedule.add(u18);
                flightSchedule.add(u19);
                flightSchedule.add(u20);

                break;
            case 2005:

                Flight u21 = new Flight("UA121", "Boston", "Portland", 3.5, randomDateGeneration(), "Morning", true, 909.89);
                Flight u22 = new Flight("UA122", "Portland", "Chicago", 5, randomDateGeneration(), "Evening", true, 890.78);
                Flight u23 = new Flight("UA123", "New York", "Chicago", 4.3, randomDateGeneration(), "Morning", true, 909.89);
                Flight u24 = new Flight("UA124", "Irwin", "San Diego", 4.2, randomDateGeneration(), "Morning", true, 767.90);
                Flight u25 = new Flight("UA125", "Arizona", "Oakland", 3, randomDateGeneration(), "Day time", true, 6778.00);

                flightSchedule.add(u21);
                flightSchedule.add(u22);
                flightSchedule.add(u23);
                flightSchedule.add(u24);
                flightSchedule.add(u25);

                break;

            case 301:

                Flight al1 = new Flight("ALS101", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 897.00);
                Flight al2 = new Flight("ALS102", "Boston", "Chicago", 2.5, randomDateGeneration(), "Day time", true, 677.90);
                Flight al3 = new Flight("ALS103", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 899.00);
                Flight al4 = new Flight("ALS104", "Irwin", "Houston", 4.2, randomDateGeneration(), "Morning", true, 909.88);
                Flight al5 = new Flight("ALS105", "Arizona", "San Francisco", 3, randomDateGeneration(), "Evening", true, 676.99);

                flightSchedule.add(al1);
                flightSchedule.add(al2);
                flightSchedule.add(al3);
                flightSchedule.add(al4);
                flightSchedule.add(al5);

                break;

            case 302:

                Flight al6 = new Flight("ALS106", "Boston", "Atlanta", 3.5, randomDateGeneration(), "Morning", true, 789.00);
                Flight al7 = new Flight("ALS107", "Atlanta", "Chicago", 2.2, randomDateGeneration(), "Evening", true, 767.99);
                Flight al8 = new Flight("ALS108", "New York", "Dallas", 4.4, randomDateGeneration(), "Morning", true, 876.00);
                Flight al9 = new Flight("ALS109", "Irwin", "Denver", 5, randomDateGeneration(), "Morning", true, 897.66);
                Flight al10 = new Flight("ALS110", "Orlando", "San Francisco", 6.5, randomDateGeneration(), "Day time", true, 678.99);

                flightSchedule.add(al6);
                flightSchedule.add(al7);
                flightSchedule.add(al8);
                flightSchedule.add(al9);
                flightSchedule.add(al10);

                break;
            case 303:

                Flight al11 = new Flight("ALS111", "Phoenix", "Miami", 2.5, randomDateGeneration(), "Morning", true, 677.99);
                Flight al12 = new Flight("ALS112", "Boston", "Detroit", 1.5, randomDateGeneration(), "Evening", true, 687.00);
                Flight al13 = new Flight("ALS113", "Boston", "Dallas", 4.9, randomDateGeneration(), "Morning", true, 356.99);
                Flight al14 = new Flight("ALS114", "San Diego", "Houston", 4.0, randomDateGeneration(), "Morning", true, 678.00);
                Flight al15 = new Flight("ALS115", "Washington", "San Francisco", 3.3, randomDateGeneration(), "Day time", true, 778.90);

                flightSchedule.add(al11);
                flightSchedule.add(al12);
                flightSchedule.add(al13);
                flightSchedule.add(al14);
                flightSchedule.add(al15);

                break;
            case 304:

                Flight al16 = new Flight("ALS116", "Boston", "Dallas", 4.5, randomDateGeneration(), "Morning", true, 678.00);
                Flight al17 = new Flight("ALS117", "Boston", "Chicago", 2.5, randomDateGeneration(), "Evening", true, 789.99);
                Flight al18 = new Flight("ALS118", "New York", "Dallas", 4, randomDateGeneration(), "Morning", true, 786.00);
                Flight al19 = new Flight("ALS119", "Irwin", "Houston", 4.2, randomDateGeneration(), "Morning", true, 6769.00);
                Flight al20 = new Flight("ALS120", "Arizona", "San Francisco", 3, randomDateGeneration(), "Day time", true, 989.99);

                flightSchedule.add(al16);
                flightSchedule.add(al17);
                flightSchedule.add(al18);
                flightSchedule.add(al19);
                flightSchedule.add(al20);

                break;
            case 305:

                Flight al21 = new Flight("ALS121", "Boston", "Portland", 3.5, randomDateGeneration(), "Morning", true, 677.90);
                Flight al22 = new Flight("ALS122", "Portland", "Chicago", 5, randomDateGeneration(), "Evening", true, 555.90);
                Flight al23 = new Flight("ALS123", "New York", "Chicago", 4.3, randomDateGeneration(), "Morning", true, 689.00);
                Flight al24 = new Flight("ALS124", "Irwin", "San Diego", 4.2, randomDateGeneration(), "Day time", true, 778.00);
                Flight al25 = new Flight("ALS125", "Arizona", "Oakland", 3, randomDateGeneration(), "Morning", true, 678.66);

                flightSchedule.add(al21);
                flightSchedule.add(al22);
                flightSchedule.add(al23);
                flightSchedule.add(al24);
                flightSchedule.add(al25);

                break;

        }
    }

    public String[][] initializeSeats(String seats[][]) {
        String seat[][] = seats;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 12; j++) {
                switch (j) {
                    case 0:
                        seat[i][j] = i + 1 + "A";
                        break;
                    case 1:
                        seat[i][j] = String.valueOf(randomAvailabilityGeneration());
                        break;
                    case 2:
                        seat[i][j] = i + 1 + "B";
                        break;
                    case 3:
                        seat[i][j] = String.valueOf(randomAvailabilityGeneration());
                        break;
                    case 4:
                        seat[i][j] = i + 1 + "C";
                        break;
                    case 5:
                        seat[i][j] = String.valueOf(randomAvailabilityGeneration());
                        break;
                    case 6:
                        seat[i][j] = i + 1 + "D";
                        break;
                    case 7:
                        seat[i][j] = String.valueOf(randomAvailabilityGeneration());
                        break;
                    case 8:
                        seat[i][j] = i + 1 + "E";
                        break;
                    case 9:
                        seat[i][j] = String.valueOf(randomAvailabilityGeneration());
                        break;
                    case 10:
                        seat[i][j] = i + 1 + "F";
                        break;
                    case 11:
                        seat[i][j] = String.valueOf(randomAvailabilityGeneration());
                        break;

                }
            }
        }
        return seat;
    }

}
