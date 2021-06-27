/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analytics.AnalysisHelper;
import com.assignment5.analytics.DataStore;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author kasai
 */
public class GateWay {

    private static DataStore dataStore = DataStore.getInstance();
    private static AnalysisHelper analysisHelper;

    public static void main(String args[]) throws IOException {

        DataGenerator generator = DataGenerator.getInstance();
        analysisHelper = new AnalysisHelper();

        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        DataReader orderReader = new DataReader(generator.getOrderFilePath());
        String[] orderRow;
        while ((orderRow = orderReader.getNextRow()) != null) {
            generateOrder(orderRow);
        }

        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        String[] prodRow;
        while ((prodRow = productReader.getNextRow()) != null) {
            generateProduct(prodRow);
        }
        analysisHelper.determinePricing();
		runAnalysis();
    }

    public static void generateOrder(String[] row) {
        int orderId = Integer.parseInt(row[0]);
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int salePrice = Integer.parseInt(row[6]);
        Item item = new Item(productId, salePrice, quantity);
        Order order = new Order(orderId, salesId, customerId, item);

        dataStore.getSalesData().put(orderId, order);
        dataStore.getItemCatalog().put(itemId, item);

        // Add order to the Customer
        boolean isCustomerPresent = false;
        Iterator customerIterator = dataStore.getCustomerDirectory().entrySet().iterator();
        while (customerIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) customerIterator.next();
            Customer customer = (Customer) mapElement.getValue();
            if (customer.getCustomerId() == customerId) {
                customer.getOrderList().add(order);
                isCustomerPresent = true;
            }
        }
        if (dataStore.getCustomerDirectory().isEmpty() || !isCustomerPresent) {
            Customer customer = new Customer(customerId);
            customer.getOrderList().add(order);
            dataStore.getCustomerDirectory().put(customerId, customer);
        }

        //Add order to the Salesperson
        boolean isSalesPersonPresent = false;
        Iterator salesPersonIterator = dataStore.getSalesPersonDirectory().entrySet().iterator();
        while (salesPersonIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) salesPersonIterator.next();
            SalesPerson salesPerson = (SalesPerson) mapElement.getValue();
            if (salesPerson.getSalesPersonId() == salesId) {
                salesPerson.getOrderList().add(order);
                isSalesPersonPresent = true;
            }
        }
        if (dataStore.getCustomerDirectory().isEmpty() || !isSalesPersonPresent) {
            SalesPerson salesPerson = new SalesPerson(salesId);
            salesPerson.getOrderList().add(order);
            dataStore.getSalesPersonDirectory().put(salesId, salesPerson);
        }
    }

    public static void generateProduct(String[] row) {
        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Product product = new Product(productId, minPrice, maxPrice, targetPrice);
        dataStore.getProductCatalog().put(productId, product);
    }
	
	private static void runAnalysis() {
        System.out.println("******************Top 3 Customers*************************************");
        analysisHelper.bestThreeCustomers();
        System.out.println("******************Top 3 Negotiated Product****************************");
        analysisHelper.bestThreeNegotiatedProducts();
        System.out.println("******************Top 3 Sales Person**********************************");
        analysisHelper.topThreeSalesPerson();
        System.out.println("******************Total Revenue of the year***************************");
        analysisHelper.totalRevenue();
    }
}
