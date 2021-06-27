/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.swing.JOptionPane;

/**
 *
 * @author Abhishek
 */
public class DefaultList {
    private FleetOfCars fleetOfCars;
    
    public DefaultList(FleetOfCars fleetOfCars) {
        this.fleetOfCars=fleetOfCars;
        addDefaultCar();
        JOptionPane.showMessageDialog(null, "Added Multiple Cars Successfully");
    }
   
    public void addDefaultCar(){
        Car car1=fleetOfCars.addCar();
        car1.setCarName("Mustang");
        car1.setAvailability(true);
        car1.setCityOfOrigin("Boston");
        car1.setMaintenceCerticateValidity(true);
        car1.setManufacturer("Ford");
        car1.setModelNumber(550);
        car1.setSerialNumber(123);
        car1.setNumberOfseats(2);
        car1.setYearOFManufacture(2000);
        
        Car car2=fleetOfCars.addCar();
        car2.setCarName("Mustang GTR");
        car2.setAvailability(true);
        car2.setCityOfOrigin("Cambridge");
        car2.setMaintenceCerticateValidity(true);
        car2.setManufacturer("Ford");
        car2.setModelNumber(551);
        car2.setSerialNumber(321);
        car2.setNumberOfseats(2);
        car2.setYearOFManufacture(2003);
        
        Car car3=fleetOfCars.addCar();
        car3.setCarName("BMW M1");
        car3.setAvailability(true);
        car3.setCityOfOrigin("Boston");
        car3.setMaintenceCerticateValidity(false);
        car3.setManufacturer("BMW");
        car3.setModelNumber(552);
        car3.setSerialNumber(231);
        car3.setNumberOfseats(4);
        car3.setYearOFManufacture(2003);
        
        Car car4=fleetOfCars.addCar();
        car4.setCarName("BMW M2");
        car4.setAvailability(false);
        car4.setCityOfOrigin("Cambridge");
        car4.setMaintenceCerticateValidity(true);
        car4.setManufacturer("BMW");
        car4.setModelNumber(553);
        car4.setSerialNumber(111);
        car4.setNumberOfseats(2);
        car4.setYearOFManufacture(2004);
        
        Car car5=fleetOfCars.addCar();
        car5.setCarName("BMW M3");
        car5.setAvailability(true);
        car5.setCityOfOrigin("Cambridge");
        car5.setMaintenceCerticateValidity(true);
        car5.setManufacturer("BMW");
        car5.setModelNumber(222);
        car5.setSerialNumber(222);
        car5.setNumberOfseats(2);
        car5.setYearOFManufacture(2006);
        
        Car car6=fleetOfCars.addCar();
        car6.setCarName("Mercedes G3");
        car6.setAvailability(true);
        car6.setCityOfOrigin("Salem");
        car6.setMaintenceCerticateValidity(true);
        car6.setManufacturer("Mercedes");
        car6.setModelNumber(554);
        car6.setSerialNumber(333);
        car6.setNumberOfseats(6);
        car6.setYearOFManufacture(2005);
        
        Car car7=fleetOfCars.addCar();
        car7.setCarName("Audi A1");
        car7.setAvailability(false);
        car7.setCityOfOrigin("Boston");
        car7.setMaintenceCerticateValidity(false);
        car7.setManufacturer("Audi");
        car7.setModelNumber(556);
        car7.setSerialNumber(444);
        car7.setNumberOfseats(4);
        car7.setYearOFManufacture(2002);
        
        Car car8=fleetOfCars.addCar();
        car8.setCarName("Audi A3");
        car8.setAvailability(true);
        car8.setCityOfOrigin("Salem");
        car8.setMaintenceCerticateValidity(false);
        car8.setManufacturer("Audi");
        car8.setModelNumber(557);
        car8.setSerialNumber(777);
        car8.setNumberOfseats(4);
        car8.setYearOFManufacture(2010);
        
        Car car9=fleetOfCars.addCar();
        car9.setCarName("Polo GT");
        car9.setAvailability(true);
        car9.setCityOfOrigin("Worcester");
        car9.setMaintenceCerticateValidity(true);
        car9.setManufacturer("VolksWagen");
        car9.setModelNumber(558);
        car9.setSerialNumber(558);
        car9.setNumberOfseats(4);
        car9.setYearOFManufacture(2011);
        
        Car car10=fleetOfCars.addCar();
        car10.setCarName("Audi Q7");
        car10.setAvailability(true);
        car10.setCityOfOrigin("Worcester");
        car10.setMaintenceCerticateValidity(true);
        car10.setManufacturer("Audi");
        car10.setModelNumber(559);
        car10.setSerialNumber(888);
        car10.setNumberOfseats(4);
        car10.setYearOFManufacture(2013);
        
        Car car11=fleetOfCars.addCar();
        car11.setCarName("BMW 320");
        car11.setAvailability(false);
        car11.setCityOfOrigin("Somerville");
        car11.setMaintenceCerticateValidity(true);
        car11.setManufacturer("BMW");
        car11.setModelNumber(559);
        car11.setSerialNumber(999);
        car11.setNumberOfseats(4);
        car11.setYearOFManufacture(2003);
        
        Car car12=fleetOfCars.addCar();
        car12.setCarName("Audi Q7");
        car12.setAvailability(true);
        car12.setCityOfOrigin("Cambridge");
        car12.setMaintenceCerticateValidity(false);
        car12.setManufacturer("Audi");
        car12.setModelNumber(559);
        car12.setSerialNumber(8880);
        car12.setNumberOfseats(4);
        car12.setYearOFManufacture(2013);

        
    }
}
