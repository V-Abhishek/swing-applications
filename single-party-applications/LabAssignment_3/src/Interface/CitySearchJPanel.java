/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Car;
import Business.FleetOfCars;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abhishek
 */
public class CitySearchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CitySearchJPanel
     */
    private JPanel userProcessContainer;
    private FleetOfCars fleetOfCars;
    private ArrayList<Car> tempList;

    CitySearchJPanel(JPanel userProcessContainer, FleetOfCars fleetOfCars) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.fleetOfCars = fleetOfCars;
    }

    public void populate(ArrayList<Car> populateList) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) viewJTable.getModel();
        defaultTableModel.setRowCount(0);
        for (Car car : populateList) {
            Object[] row = new Object[6];
            row[0] = car;
            row[1] = car.getCityOfOrigin();
            if (car.getMaintenceCerticateValidity()) {
                row[2] = "Valid";
            } else {
                row[2] = "Not Valid";
            }
            row[3] = car.getYearOFManufacture();
            row[4] = car.getSerialNumber();
            if (car.isAvailability()) {
                row[5] = "Available";
            } else {
                row[5] = "Not Available";
            }
            defaultTableModel.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        viewCarDetailsBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        citySearchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        availabilityCheckBox = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SEARCH BY CITY");

        viewCarDetailsBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        viewCarDetailsBtn.setText("View Car Details");
        viewCarDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCarDetailsBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(0, 0, 0));
        backBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("<< BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        viewJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car Name", "City", "Maintenance Certificate", "Year Of Manufacture", "Serial Number", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewJTable);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setText("City :");

        citySearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                citySearchTextFieldKeyTyped(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("Show Only Availabile:");

        availabilityCheckBox.setText("Yes");
        availabilityCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availabilityCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(citySearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(availabilityCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(viewCarDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(backBtn)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(citySearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(availabilityCheckBox)
                    .addComponent(viewCarDetailsBtn))
                .addGap(226, 226, 226))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewCarDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCarDetailsBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = viewJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select A Row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Car car = (Car) viewJTable.getValueAt(selectedRow, 0);
            SearchViewJPanel searchViewJPanel = new SearchViewJPanel(userProcessContainer, car);
            userProcessContainer.add("SearchViewJPanel", searchViewJPanel);
            CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewCarDetailsBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void citySearchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_citySearchTextFieldKeyTyped
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && code != KeyEvent.VK_BACK_SPACE && !Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_citySearchTextFieldKeyTyped

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String cityName = "";
        if (!citySearchTextField.getText().equals("")) {
            cityName = citySearchTextField.getText().trim();
            tempList = fleetOfCars.searchByCity(cityName);
            if (tempList != null && !tempList.isEmpty()) {
                populate(tempList);
            } else {
                JOptionPane.showMessageDialog(null, "No Car Exist in " + cityName + " City.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter a City Name");
        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void availabilityCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availabilityCheckBoxActionPerformed
        // TODO add your handling code here:
        if (availabilityCheckBox.isSelected()) {
            if (tempList != null && !tempList.isEmpty()) {
                ArrayList<Car> secondaryList = new ArrayList<Car>();
                for (Car car : tempList) {
                    if (car.isAvailability()) {
                        secondaryList.add(car);
                    }
                }
                if (secondaryList != null && !secondaryList.isEmpty()) {
                    populate(secondaryList);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry!! There are no cars available under this category.");
                    availabilityCheckBox.setSelected(false);
                }
            }

        } else {
            searchButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_availabilityCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox availabilityCheckBox;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField citySearchTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton viewCarDetailsBtn;
    private javax.swing.JTable viewJTable;
    // End of variables declaration//GEN-END:variables
}
