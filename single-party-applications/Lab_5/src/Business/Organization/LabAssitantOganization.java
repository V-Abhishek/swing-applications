/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Abhishek
 */
public class LabAssitantOganization extends Organization {

    public LabAssitantOganization() {
        super(Type.Lab.getValue());
    }

    @Override
    public ArrayList<String> getSupportedRole() {
        ArrayList<String> roles = new ArrayList();
        roles.add("Lab Assitant");
        return roles;
    }

}
