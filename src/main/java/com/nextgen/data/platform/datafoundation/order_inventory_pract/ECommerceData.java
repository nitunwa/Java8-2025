package com.nextgen.data.platform.datafoundation.order_inventory_pract;

import java.util.List;

public class ECommerceData {
    private List<InventoryItem> inventory;
    private List<Order> orders;

    public List<InventoryItem> getInventory() { return inventory; }
    public void setInventory(List<InventoryItem> inventory) { this.inventory = inventory; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}

