/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Abhishek
 */
public class VitalSignHistory {

    private ArrayList<VitalSigns> vitalSignHistory;

    public VitalSignHistory() {
        vitalSignHistory = new ArrayList<VitalSigns>();
    }

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSigns> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public VitalSigns addVitals() {
        VitalSigns vitalSigns = new VitalSigns();
        vitalSignHistory.add(vitalSigns);
        return vitalSigns;
    }

    public void deleteVitals(VitalSigns vitalSigns) {
        vitalSignHistory.remove(vitalSigns);
    }

    public ArrayList<VitalSigns> getAbnormalList(double max, double min) {
        ArrayList<VitalSigns> list = new ArrayList<VitalSigns>();
        for (VitalSigns vitalSigns : this.getVitalSignHistory()) {
            if (vitalSigns.getBloodPressure() < min || vitalSigns.getBloodPressure() > max) {
                list.add(vitalSigns);
            }
        }
        return list;
    }
}
