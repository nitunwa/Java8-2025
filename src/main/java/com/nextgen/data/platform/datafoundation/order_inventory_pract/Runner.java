package com.nextgen.data.platform.datafoundation.order_inventory_pract;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ECommerceData data = mapper.readValue(new File("/Users/snath/Downloads/github-nitun-project/Java8-2025/src/main/java/com/nextgen/data/platform/datafoundation/order_inventory_pract/api_order.json"), ECommerceData.class);

        List<Order> orders = data.getOrders();
        List<InventoryItem> inventory = data.getInventory();
        System.out.println(orders);

        // 1. Find the total number of unique products that were ordered at least once.
            // System.out.println(uniqueProductsCount(orders));

        // 2. Find the customers list IDs who placed more than one order.
            //System.out.println(findCustomers(orders));

       // 3. Total number of orders containing at least one "Electronics" item:
        totalOrdersWithElectronics(orders, inventory);


    }

    static int totalOrdersWithElectronics(List<Order> orders, List<InventoryItem> inventory) {
        // 3. Total number of orders containing at least one "Electronics" item:

        Map<String, String> testMap= inventory.stream().collect(Collectors.toMap(InventoryItem::getProduct, InventoryItem::getCategory));

        Map<String, Integer> demoMap = new HashMap<>();

        for(Order order : orders) {
            for(Item item : order.getItems()) {
                String category = testMap.get(item.getProduct());
                if(category.equalsIgnoreCase("Electronics")) {
                    demoMap.put(order.getOrderId(), demoMap.getOrDefault(order.getOrderId(), 0) + 1);
                }
            }
        }

       int count = (int)demoMap.entrySet().stream().filter(ele -> ele.getValue() > 1).map(Map.Entry::getKey).count();

        System.out.println(count);
        return count;
    }

    static int uniqueProductsCount(List<Order> orders) {
        // Java 8
        Long res = orders.stream().flatMap(order -> order.getItems().stream().filter(item -> item.getQuantity() >= 1)).count();
        System.out.println("-----------");
        System.out.println(res);

        // without Java 8
        int count = 0;
        for(Order order : orders) {
            for(Item item : order.getItems()) {
                if(item.getQuantity() >= 1) {
                    count++;
                }
            }
        }
        return count;
    }

    static List<String> findCustomers(List<Order> orders) {
        // Java 8
        List<String> customers = orders.stream().collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()))
                .entrySet().stream().filter(ele -> ele.getValue() > 1).map(Map.Entry::getKey).toList();
        // break down
        Map<String, Long> mapData = orders.stream().collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));
        List<String> customerList = mapData.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();


        // without Java 8
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(Order order: orders) {
           map.put(order.getCustomerId(), map.getOrDefault(order.getCustomerId(),0) + 1);
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}

/*orders.stream().flatMap(order -> order.getItems().stream()
        .filter(item -> "Electronics".equalsIgnoreCase(testMap.get(item.getProduct()))));*/
