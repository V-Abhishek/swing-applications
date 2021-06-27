/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ketanmalik
 */
public class DataStore {

    private static DataStore dataStore;

    private Map<Integer, Order> salesData;
    private Map<Integer, Product> productCatalog;
    private Map<Integer, Item> itemCatalog;
    private Map<Integer, Customer> customerDirectory;
    private Map<Integer, SalesPerson> salesPersonDirectory;

    private DataStore() {
        salesData = new HashMap<>();
        productCatalog = new HashMap<>();
        itemCatalog = new HashMap<>();
        customerDirectory = new HashMap<>();
        salesPersonDirectory = new HashMap<>();
    }

    public static DataStore getInstance() {
        if (dataStore == null) {
            return dataStore = new DataStore();
        }
        return dataStore;
    }

    public static DataStore getDataStore() {
        return dataStore;
    }

    public static void setDataStore(DataStore dataStore) {
        DataStore.dataStore = dataStore;
    }

    public Map<Integer, Order> getSalesData() {
        return salesData;
    }

    public void setSalesData(Map<Integer, Order> salesData) {
        this.salesData = salesData;
    }

    public Map<Integer, Product> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(Map<Integer, Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public Map<Integer, Item> getItemCatalog() {
        return itemCatalog;
    }

    public void setItemCatalog(Map<Integer, Item> itemCatalog) {
        this.itemCatalog = itemCatalog;
    }

    public Map<Integer, Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(Map<Integer, Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public Map<Integer, SalesPerson> getSalesPersonDirectory() {
        return salesPersonDirectory;
    }

    public void setSalesPersonDirectory(Map<Integer, SalesPerson> salesPersonDirectory) {
        this.salesPersonDirectory = salesPersonDirectory;
    }

}
