/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.CustomerDirectory;
import Business.Abstract.User;
import java.util.Date;

/**
 *
 * @author AEDSpring2019
 */
public class Customer extends User implements Comparable<Customer> {

    private CustomerDirectory customerDirectory;
    private String createdOn;

    public Customer(String password, String userName) {
        super(password, userName, "Customer");
        new CustomerDirectory();
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    @Override
    public int compareTo(Customer o) {
        return o.getUserName().compareTo(this.getUserName());
    }

    @Override
    public String toString() {
        return getUserName(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verify(String password) {
        if (password.equals(getPassword())) {
            return true;
        }
        return false;
    }

    public String getDate() {
        return createdOn;
    }

    public void setDate(String createdOn) {
        this.createdOn = createdOn;
    }

}
