/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Abhishek
 */
public class FleetOfCars {

    private ArrayList<Car> fleetOfCars;
    private String lastModified;

    public FleetOfCars() {
        this.fleetOfCars = new ArrayList<Car>();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        this.lastModified = dateFormat.format(calendar.getTime());
    }

    public ArrayList<Car> getFleetOfCars() {
        return fleetOfCars;
    }

    public void setFleetOfCars(ArrayList<Car> fleetOfCars) {
        this.fleetOfCars = fleetOfCars;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Car addCar() {
        Car car = new Car();
        fleetOfCars.add(car);
        return car;
    }

    public void removeCar(Car car) {
        fleetOfCars.remove(car);
    }

    public ArrayList searchBySerialNumber(int serialNumber) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getSerialNumber() == serialNumber) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public ArrayList searchByModelNumber(int modelNumber) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getModelNumber() == modelNumber) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public ArrayList searchBySerialModelNumber(int serialNumber, int modelNumber) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getModelNumber() == modelNumber && car.getSerialNumber() == serialNumber) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public ArrayList searchByManufactureYear(int searchYear) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getYearOFManufacture() == searchYear) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public ArrayList searchByManufactureName(String manufactureName) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getManufacturer().equalsIgnoreCase(manufactureName)) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public ArrayList searchByManufactureNameYear(String manufactureName, int searchYear) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getManufacturer().equalsIgnoreCase(manufactureName) && car.getYearOFManufacture() == searchYear) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public ArrayList searchByCity(String cityName) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.getCityOfOrigin().equalsIgnoreCase(cityName)) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

    public HashMap searchFirstAvailable(String cityName) {
        ArrayList<Car> requiredResultList = new ArrayList<Car>();
        ArrayList<Car> suggestionResultList = new ArrayList<Car>();
        HashMap<Integer, ArrayList> finalResultMap = new HashMap<Integer, ArrayList>();
        for (Car car : fleetOfCars) {
            if (car.getCityOfOrigin().equalsIgnoreCase(cityName) && car.isAvailability()) {
                requiredResultList.add(car);
            } else if (car.isAvailability()) {
                suggestionResultList.add(car);
            }
        }
        if (!requiredResultList.isEmpty()) {
            finalResultMap.put(1, requiredResultList);
            return finalResultMap;
        } else if (requiredResultList.isEmpty() && !suggestionResultList.isEmpty()) {
            finalResultMap.put(2, suggestionResultList);
            return finalResultMap;
        }
        return null;
    }

    public ArrayList searchBySeatNumbers(int required, int maximum) {
        ArrayList<Car> resultList = new ArrayList<Car>();
        for (Car car : fleetOfCars) {
            if (car.isAvailability() && car.getNumberOfseats() >= required && car.getNumberOfseats() <= maximum) {
                resultList.add(car);
            }
        }
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return null;
    }

}
