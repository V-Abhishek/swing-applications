/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import static com.assignment5.analytics.AnalysisHelper.sortAndPrint;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesAnalysis;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.SalesPerson;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Abhishek
 */
public class AnalysisHelper {

    private static DataStore dataStore = DataStore.getInstance();
    private static Set<Map.Entry<Integer, Product>> entries1;
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static Set<Map.Entry<Integer, Order>> entries2;
    private static Map<Integer, Order> orderMap = new HashMap<>();
    private static Set<Map.Entry<Integer, Product>> productMapEntries;
    private static Set<Map.Entry<Integer, Order>> orderMapEntries;
    private static Map<Integer, SalesAnalysis> salesAnalysisMap;
    private static Map<Integer, SalesAnalysis> salesAnalysisModifiedMap;
    private static Iterator productMapItr;
    private static int[] avgSalesPrice = {0};
    private static int difference = 0;
    private static int totalProductsSold = 0;
    HashMap<Integer, Integer> revenueMap = null;
    private static int totalProductsInOrder = 0;

    public void determinePricing() {
        createMaps();
        productMapEntries = productMap.entrySet();
        orderMapEntries = orderMap.entrySet();
        productMapItr = productMapEntries.iterator();

        while (productMapItr.hasNext()) {
            avgSalesPrice[0] = 0;
            totalProductsSold = 0;
            difference = 0;
            Map.Entry<Integer, Product> productElement = (Map.Entry<Integer, Product>) productMapItr.next();
            orderMapEntries.stream()
                    .filter(e -> e.getValue().getItem().getProductId() == productElement.getValue().getProductId())
                    .forEach(e -> {
                        setAvgSalesPrice(e.getValue().getItem().getSalesPrice(), e.getValue().getItem().getQuantity());
                    });

            avgSalesPrice[0] = avgSalesPrice[0] / totalProductsSold;
            difference = avgSalesPrice[0] - productElement.getValue().getTargetPrice();
            salesAnalysisMap.put(productElement.getValue().getProductId(), new SalesAnalysis(productElement.getValue().getProductId(), avgSalesPrice[0], productElement.getValue().getTargetPrice(), difference, totalProductsSold, 0.00f));
        }

        printSalesTable();
        modifyOriginalTable();
        printModifiedSalesTable();
        System.out.println();
    }

    public void createMaps() {
        entries1 = dataStore.getProductCatalog().entrySet();
        productMap = (HashMap<Integer, Product>) entries1.stream()
                .limit(15)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        entries2 = dataStore.getSalesData().entrySet();
        orderMap = (HashMap<Integer, Order>) entries2.stream()
                .filter(e -> e.getValue().getItem().getProductId() == matchProduct(e.getValue().getItem().getProductId()))
                .limit(1000)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        salesAnalysisMap = new HashMap<>();
        salesAnalysisModifiedMap = new HashMap<>();
    }

    public int matchProduct(int e) {
        productMapEntries = productMap.entrySet();
        productMapItr = productMapEntries.iterator();
        while (productMapItr.hasNext()) {
            Map.Entry<Integer, Product> prodEntry = (Map.Entry<Integer, Product>) productMapItr.next();
            if (e == prodEntry.getValue().getProductId()) {
                return e;
            }
        }
        return -1;
    }

    public void setAvgSalesPrice(int a, int b) {
        int c = a * b;
        totalProductsInOrder += b;
        avgSalesPrice[0] = avgSalesPrice[0] + c;
        totalProductsSold += b;
    }

    public void printSalesTable() {
        System.out.println();
        System.out.println("Original Data for Products sold above Target Price: ");
        System.out.print("\t  Product ID | Avg Sale Price | Target Price | Above Target | Total Products Sold ");
        System.out.println();
        System.out.println("\t ---------------------------------------------------------------------------------");
        salesAnalysisMap.entrySet().stream()
                .filter(e -> e.getValue().getPriceDifference() >= 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getPriceDifference(), e1.getValue().getPriceDifference()))
                .forEach(e -> {
                    System.out.println("\t     " + e.getKey() + "\t     |\t    " + e.getValue().getSalePrice() + "\t      |\t    " + e.getValue().getTargetPrice() + "\t     |\t    " + e.getValue().getPriceDifference() + "\t    |\t    " + e.getValue().getTotalProductsSold());
                });
        System.out.println();
        System.out.println("Original Data for Products sold below Target Price");
        System.out.print("\t  Product ID | Avg Sale Price | Target Price | Below Target | Total Products Sold ");
        System.out.println();
        System.out.println("\t ----------------------------------------------------------------------------------");
        salesAnalysisMap.entrySet().stream()
                .filter(e -> e.getValue().getPriceDifference() < 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getPriceDifference(), e1.getValue().getPriceDifference()))
                .forEach(e -> {
                    System.out.println("\t     " + e.getKey() + "\t     |\t    " + e.getValue().getSalePrice() + "\t      |\t    " + e.getValue().getTargetPrice() + "\t     |\t    " + e.getValue().getPriceDifference() + "\t    |\t    " + e.getValue().getTotalProductsSold());
                });
    }

    public void printModifiedSalesTable() {
        System.out.println();
        System.out.println("Modified Data for Products sold above Target Price: ");
        System.out.print("\t  Product ID | Avg Sale Price | Modified Target Price | Above Target | Total Products Sold | Error %");
        System.out.println();
        System.out.println("\t ----------------------------------------------------------------------------------------------------");
        salesAnalysisModifiedMap.entrySet().stream()
                .filter(e -> e.getValue().getPriceDifference() >= 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getPriceDifference(), e1.getValue().getPriceDifference()))
                .forEach(e -> {
                    System.out.println("\t     " + e.getKey() + "\t     |\t    " + e.getValue().getSalePrice() + "\t      |\t\t  " + e.getValue().getTargetPrice() + "\t      |\t    " + e.getValue().getPriceDifference() + "\t     |\t    " + e.getValue().getTotalProductsSold() + " \t   |  " + e.getValue().getError() + "%");
                });
        System.out.println();
        System.out.println("Modified Data for Products sold below Target Price");
        System.out.print("\t  Product ID | Avg Sale Price | Modified Target Price | Below Target | Total Products Sold | Error %");
        System.out.println();
        System.out.println("\t -----------------------------------------------------------------------------------------------------");
        salesAnalysisModifiedMap.entrySet().stream()
                .filter(e -> e.getValue().getPriceDifference() < 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getPriceDifference(), e1.getValue().getPriceDifference()))
                .forEach(e -> {
                    System.out.println("\t     " + e.getKey() + "\t     |\t    " + e.getValue().getSalePrice() + "\t      |\t\t  " + e.getValue().getTargetPrice() + "\t      |\t    " + e.getValue().getPriceDifference() + "\t     |\t    " + e.getValue().getTotalProductsSold() + " \t   |  " + e.getValue().getError() + "%");
                });
    }

    public void modifyOriginalTable() {
        float error = 0.00f;
        Iterator itr = salesAnalysisMap.entrySet().iterator();
//        Random random = new Random();
//        double randomNum = 0;
        double checkSalePrice1 = 0;
        double checkSalePrice2 = 0;
        int modifiedTargetPrice = 0;

        while (itr.hasNext()) {
            modifiedTargetPrice = 0;
            Map.Entry<Integer, SalesAnalysis> entry = (Map.Entry<Integer, SalesAnalysis>) itr.next();
//            randomNum = (random.nextInt(5) + 1) * 0.01;
            checkSalePrice1 = (double) entry.getValue().getSalePrice() + (entry.getValue().getSalePrice() * 0.05);
            checkSalePrice2 = (double) entry.getValue().getSalePrice() - (entry.getValue().getSalePrice() * 0.05);
            if (entry.getValue().getTargetPrice() > checkSalePrice1) {
                modifiedTargetPrice = entry.getValue().getSalePrice() + (int) (entry.getValue().getSalePrice() * 0.05);
                entry.getValue().setTargetPrice(modifiedTargetPrice);
                error = ((float) (modifiedTargetPrice - entry.getValue().getSalePrice()) / entry.getValue().getSalePrice()) * 100;
                entry.getValue().setError(error);
            } else if (entry.getValue().getTargetPrice() < checkSalePrice2) {
                modifiedTargetPrice = entry.getValue().getTargetPrice() - (int) (entry.getValue().getSalePrice() * 0.05);
                entry.getValue().setTargetPrice(modifiedTargetPrice);
                error = ((float) (modifiedTargetPrice - entry.getValue().getSalePrice()) / entry.getValue().getSalePrice()) * 100;
                entry.getValue().setError(error);
            } else {
                int avgOfProducts = totalProductsInOrder / 15;
                System.out.println("avg:" + avgOfProducts);

                if (entry.getValue().getTotalProductsSold() > avgOfProducts) {
                    if (entry.getValue().getPriceDifference() >= 5 && entry.getValue().getPriceDifference() <= 7) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() + 5;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() >= 2 && entry.getValue().getPriceDifference() <= 4) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() + 3;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() == 0 || entry.getValue().getPriceDifference() == 1) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() + 1;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() <= -5 && entry.getValue().getPriceDifference() >= -7) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() - 5;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() <= -2 && entry.getValue().getPriceDifference() >= -4) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() - 3;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() == 0 || entry.getValue().getPriceDifference() == -1) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() - 1;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    }
                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts) {
                    if (entry.getValue().getPriceDifference() <= -5 && entry.getValue().getPriceDifference() >= -7) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() - 5;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() <= -2 && entry.getValue().getPriceDifference() >= -4) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() - 3;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() == 0 || entry.getValue().getPriceDifference() == -1) {
                        modifiedTargetPrice = entry.getValue().getTargetPrice() - 1;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() >= 5 && entry.getValue().getPriceDifference() <= 7) {
                        System.out.println("ID:" + entry.getValue().getProductId());
                        modifiedTargetPrice = entry.getValue().getTargetPrice() + 5;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() >= 2 && entry.getValue().getPriceDifference() <= 4) {
                        System.out.println("ID:" + entry.getValue().getProductId());
                        modifiedTargetPrice = entry.getValue().getTargetPrice() + 3;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    } else if (entry.getValue().getPriceDifference() == 0 || entry.getValue().getPriceDifference() == 1) {
                        System.out.println("ID:" + entry.getValue().getProductId());
                        modifiedTargetPrice = entry.getValue().getTargetPrice() + 1;
                        error = ((float) (modifiedTargetPrice - entry.getValue().getTargetPrice()) / entry.getValue().getTargetPrice()) * 100;
                        entry.getValue().setError(error);
                        entry.getValue().setTargetPrice(modifiedTargetPrice);
                    }
                }
            }
            entry.getValue().setPriceDifference(entry.getValue().getSalePrice() - entry.getValue().getTargetPrice());
        }
        salesAnalysisModifiedMap.putAll(salesAnalysisMap);
    }
//    public void modifyOriginalTable() {
//        float error = 0.00f;
//        int avgOfProducts = totalProductsInOrder / 15;
//        Map<Integer, SalesAnalysis> tempMap = new HashMap<>();
//
//        tempMap = salesAnalysisMap.entrySet().stream()
//                .filter(e -> e.getValue().getPriceDifference() > 0)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        Iterator itr1 = tempMap.entrySet().iterator();
//        while (itr1.hasNext()) {
//            Map.Entry<Integer, SalesAnalysis> entry = (Map.Entry<Integer, SalesAnalysis>) itr1.next();
//            int change = modifyTargetPrice(entry, avgOfProducts, "positive");
//            int modifiedTargetPrice = entry.getValue().getTargetPrice() + change;
//            entry.getValue().setTargetPrice(modifiedTargetPrice);
//            entry.getValue().setPriceDifference(entry.getValue().getSalePrice() - entry.getValue().getTargetPrice());
//            error = ((float) (modifiedTargetPrice - entry.getValue().getSalePrice()) / entry.getValue().getSalePrice()) * 100;
//            entry.getValue().setError(error);
//        }
//        salesAnalysisModifiedMap.putAll(tempMap);
//        tempMap.clear();
//
//        tempMap = salesAnalysisMap.entrySet().stream()
//                .filter(e -> e.getValue().getPriceDifference() < 0)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        Iterator itr2 = tempMap.entrySet().iterator();
//        while (itr2.hasNext()) {
//            Map.Entry<Integer, SalesAnalysis> entry = (Map.Entry<Integer, SalesAnalysis>) itr2.next();
//            int change = modifyTargetPrice(entry, avgOfProducts, "negative");
//            int modifiedTargetPrice = entry.getValue().getTargetPrice() + change;
//            entry.getValue().setTargetPrice(modifiedTargetPrice);
//            entry.getValue().setPriceDifference(entry.getValue().getSalePrice() - entry.getValue().getTargetPrice());
//            error = ((float) (modifiedTargetPrice - entry.getValue().getSalePrice()) / entry.getValue().getSalePrice()) * 100;
//            entry.getValue().setError(error);
//        }
//        salesAnalysisModifiedMap.putAll(tempMap);
//        tempMap.clear();
//
//        tempMap = salesAnalysisMap.entrySet().stream()
//                .filter(e -> e.getValue().getPriceDifference() == 0)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        Iterator itr3 = tempMap.entrySet().iterator();
//        while (itr3.hasNext()) {
//            Map.Entry<Integer, SalesAnalysis> entry = (Map.Entry<Integer, SalesAnalysis>) itr3.next();
//            int change = modifyTargetPrice(entry, avgOfProducts, "zero");
//            int modifiedTargetPrice = entry.getValue().getTargetPrice() + change;
//            entry.getValue().setTargetPrice(modifiedTargetPrice);
//            entry.getValue().setPriceDifference(entry.getValue().getSalePrice() - entry.getValue().getTargetPrice());
//            error = ((float) (modifiedTargetPrice - entry.getValue().getSalePrice()) / entry.getValue().getSalePrice()) * 100;
//            entry.getValue().setError(error);
//        }
//        salesAnalysisModifiedMap.putAll(tempMap);
//        tempMap.clear();
//
//        System.out.println();
//    }

//    public int modifyTargetPrice(Map.Entry<Integer, SalesAnalysis> entry, int avgOfProducts, String mode) {
//        if (mode == "positive") {
//            if (entry.getValue().getPriceDifference() >= 5) {
//                if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                    return 5;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 50 && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                    return 4;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 49) {
//                    return 3;
//                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                    return -3;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                    return -4;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                    return -5;
//                }
//            } else if (entry.getValue().getPriceDifference() == 3 || entry.getValue().getPriceDifference() == 4) {
//                if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                    return 3;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 50 && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                    return 2;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 49) {
//                    return 1;
//                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                    return -1;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                    return -2;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                    return -3;
//                }
//            } else if (entry.getValue().getPriceDifference() == 1 || entry.getValue().getPriceDifference() == 2) {
//                if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                    return -2;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 50 && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                    return -1;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 49) {
//                    return 1;
//                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                    return -1;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                    return -2;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                    return -3;
//                }
//            }
//        }
//
//        if (mode == "negative") {
//            if (entry.getValue().getPriceDifference() <= -5) {
//                if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                    return -5;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 50 && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                    return -4;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 49) {
//                    return -3;
//                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                    return 3;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                    return 4;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                    return 5;
//                }
//            } else if (entry.getValue().getPriceDifference() == -3 || entry.getValue().getPriceDifference() == -4) {
//                if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                    return -3;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 50 && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                    return -2;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 49) {
//                    return -1;
//                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                    return 1;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                    return 2;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                    return 3;
//                }
//            } else if (entry.getValue().getPriceDifference() == -1 || entry.getValue().getPriceDifference() == -2) {
//                if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                    return -2;
//                } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                    return -1;
//                } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                    return 1;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                    return 2;
//                } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                    return -3;
//                }
//            }
//        }
//        if (mode == "zero") {
//            if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 100) {
//                return 3;
//            } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts + 50 && entry.getValue().getTotalProductsSold() <= avgOfProducts + 99) {
//                return 2;
//            } else if (entry.getValue().getTotalProductsSold() >= avgOfProducts && entry.getValue().getTotalProductsSold() <= avgOfProducts + 49) {
//                return 1;
//            } else if (entry.getValue().getTotalProductsSold() < avgOfProducts && entry.getValue().getTotalProductsSold() >= avgOfProducts - 49) {
//                return -1;
//            } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 50 && entry.getValue().getTotalProductsSold() >= avgOfProducts - 99) {
//                return -2;
//            } else if (entry.getValue().getTotalProductsSold() <= avgOfProducts - 100) {
//                return -3;
//            }
//        }
//        System.out.println("else");
//        System.out.println(entry.getKey());
//
//        return 0;
//    }
    // Sort Map in Ascending/Descending and Print Results
    public static void sortAndPrint(HashMap<Integer, Integer> toBeSortedMap, String orderType, int numberOfResults) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(toBeSortedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                if (orderType.equalsIgnoreCase("Descending")) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        --numberOfResults;
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        int previousValue = (int) sortedMap.entrySet().iterator().next().getValue();
        for (Iterator<Map.Entry<Integer, Integer>> iterator = sortedMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry mapElement = (Map.Entry) iterator.next();
            if (numberOfResults != 0) {
                System.out.println(mapElement.getKey() + "              " + mapElement.getValue());
                if (previousValue != Integer.parseInt(mapElement.getValue().toString())) {
                    previousValue = Integer.parseInt(mapElement.getValue().toString());
                    --numberOfResults;
                }
            } else {
                if (numberOfResults == 0 && previousValue == Integer.parseInt(mapElement.getValue().toString())) {
                    System.out.println(mapElement.getKey() + "              " + mapElement.getValue());
                } else {
                    break;
                }
            }

        }

    }

    // Top 3 best customers
    public void bestThreeCustomers() {
        Map<Integer, Customer> customerMap = dataStore.getCustomerDirectory();
        Map<Integer, Product> productMap = dataStore.getProductCatalog();
        HashMap<Integer, Integer> preResultMap = new HashMap<>();
        for (Customer customer : customerMap.values()) {
            int total = 0;
            List<Order> orders = customer.getOrderList();
            for (Order order : orders) {
                int salePrice = order.getItem().getSalesPrice();
                int productId = order.getItem().getProductId();
                for (Product product : productMap.values()) {
                    if (product.getProductId() == productId) {
                        int difference = Math.abs(salePrice - product.getTargetPrice());
                        total += difference;
                        break;
                    }
                }
            }
            preResultMap.put(customer.getCustomerId(), total);
        }
        if (!preResultMap.isEmpty()) {
            System.out.println("Customer Id" + "   " + "Sum of difference");
            sortAndPrint(preResultMap, "Descending", 3);
        }
    }

    // Top 3 best negotiated products
    public void bestThreeNegotiatedProducts() {
        Map<Integer, SalesPerson> salesPersonMap = dataStore.getSalesPersonDirectory();
        Map<Integer, Product> productMap = dataStore.getProductCatalog();
        HashMap<Integer, Integer> preResultMap = new HashMap<>();
        for (SalesPerson salesPerson : salesPersonMap.values()) {
            for (Order order : salesPerson.getOrderList()) {
                int salePrice = order.getItem().getSalesPrice();
                int productId = order.getItem().getProductId();
                for (Product product : productMap.values()) {
                    if ((product.getProductId() == productId) && (product.getTargetPrice() < salePrice)) {
                        //int difference = salePrice - product.getTargetPrice();
                        if (preResultMap.containsKey(productId)) {
                            Iterator productIterator = preResultMap.entrySet().iterator();
                            while (productIterator.hasNext()) {
                                Map.Entry mapElement = (Map.Entry) productIterator.next();
                                if (Integer.parseInt(mapElement.getKey() + "") == productId) {
                                    int resultProductId = (int) mapElement.getKey();
                                    int oldSum = preResultMap.get(mapElement.getKey());
                                    int newQuantity = oldSum + order.getItem().getQuantity();
                                    preResultMap.put(resultProductId, newQuantity);
                                }
                            }
                            //preResultMap.put(productId, difference);
                        } else {
                            // preResultMap.put(productId, difference);
                            preResultMap.put(productId, order.getItem().getQuantity());
                        }
                    }
                }
            }
        }
        if (!preResultMap.isEmpty()) {
            System.out.println("Product Id" + "   " + "Sales Quantity");
            sortAndPrint(preResultMap, "Descending", 3);
        }
    }

    //Top 3 sales person
    public void topThreeSalesPerson() {
        HashMap<Integer, SalesPerson> salesDirectory = (HashMap<Integer, SalesPerson>) dataStore.getSalesPersonDirectory();
        HashMap<Integer, Product> productDirectory = (HashMap<Integer, Product>) dataStore.getProductCatalog();
        HashMap<Integer, Integer> preResultMap = new HashMap<>();

        for (SalesPerson salesPerson : salesDirectory.values()) {
            List<Order> orderList = salesPerson.getOrderList();
            int totalProfit = 0;
            for (Order order : orderList) {
                Item item = order.getItem();
                int salesPrice = item.getSalesPrice();
                int productId = item.getProductId();
                int quantity = item.getQuantity();
                for (Product product : productDirectory.values()) {
                    if (product.getProductId() == productId) {
                        int targetPrice = product.getTargetPrice();
                        if (salesPrice > targetPrice) {
                            int profit = (salesPrice - targetPrice) * quantity;
                            totalProfit = totalProfit + profit;
                        }
                    }
                }

            }
            preResultMap.put(salesPerson.getSalesPersonId(), totalProfit);
        }
        if (!preResultMap.isEmpty()) {
            revenueMap = preResultMap;
            System.out.println("Salesperson Id" + "   " + "Profit");
            sortAndPrint(preResultMap, "Descending", 3);
        }
    }

    //Total Revenue
    public void totalRevenue() {
        Integer totalRevenue = 0;
        if (revenueMap != null) {
            for (Integer next : revenueMap.values()) {
                totalRevenue = totalRevenue + next;
            }
            System.out.println("Total Revenue: " + totalRevenue);
        }
    }

}
