/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Organization.AdminOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabAssitantOganization;
import Business.UserAccount.UserAccount;

/**
 *
 * @author ran
 */
public class ConfigureABusiness {

    public static Business configure() {
        // Three roles: LabAssistant, Doctor, Admin

        Business business = Business.getInstance();
        AdminOrganization adminOrganization = new AdminOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);

        Employee employee = new Employee();
        employee.setName("Admin");

        UserAccount account = new UserAccount();
        account.setUsername("admin");
        account.setPassword("admin");
        account.setRole("Admin");
        account.setEmployee(employee);

        adminOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account);

        DoctorOrganization doctorOrganization = new DoctorOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(doctorOrganization);

        Employee doctor = new Employee();
        doctor.setName("Jackie");

        UserAccount doctorAccount = new UserAccount();
        doctorAccount.setUsername("doctor");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole("Doctor");
        doctorAccount.setEmployee(doctor);

        doctorOrganization.getEmployeeDirectory().getEmployeeList().add(doctor);
        doctorOrganization.getUserAccountDirectory().getUserAccountList().add(doctorAccount);

        LabAssitantOganization labAssitantOganization = new LabAssitantOganization();
        business.getOrganizationDirectory().getOrganizationList().add(labAssitantOganization);

        Employee labAssitant = new Employee();
        labAssitant.setName("Ben");

        UserAccount labAssitantAccount = new UserAccount();
        labAssitantAccount.setUsername("lab");
        labAssitantAccount.setPassword("lab");
        labAssitantAccount.setRole("Lab Assitant");
        labAssitantAccount.setEmployee(labAssitant);

        labAssitantOganization.getEmployeeDirectory().getEmployeeList().add(labAssitant);
        labAssitantOganization.getUserAccountDirectory().getUserAccountList().add(labAssitantAccount);

        return business;
    }

}
