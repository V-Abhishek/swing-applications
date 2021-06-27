/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Abhishek
 */
public class Car {

    private boolean availability;
    private String manufacturer;
    private int yearOFManufacture;
    private int numberOfseats;
    private int serialNumber;
    private int modelNumber;
    private boolean maintenceCerticateValidity;
    private String cityOfOrigin;
    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOFManufacture() {
        return yearOFManufacture;
    }

    public void setYearOFManufacture(int yearOFManufacture) {
        this.yearOFManufacture = yearOFManufacture;
    }

    public int getNumberOfseats() {
        return numberOfseats;
    }

    public void setNumberOfseats(int numberOfseats) {
        this.numberOfseats = numberOfseats;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public boolean getMaintenceCerticateValidity() {
        return maintenceCerticateValidity;
    }

    public void setMaintenceCerticateValidity(boolean maintenceCerticateValidity) {
        this.maintenceCerticateValidity = maintenceCerticateValidity;
    }

    public String getCityOfOrigin() {
        return cityOfOrigin;
    }

    public void setCityOfOrigin(String cityOFOrigin) {
        this.cityOfOrigin = cityOFOrigin;
    }

    @Override
    public String toString() {
        return carName;
    }

}
