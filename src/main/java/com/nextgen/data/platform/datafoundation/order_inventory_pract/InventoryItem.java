package com.nextgen.data.platform.datafoundation.order_inventory_pract;

public class InventoryItem {
    private String product;
    private int available;
    private String category;

    // Getters and Setters
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = available; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "product='" + product + '\'' +
                ", available=" + available +
                ", category='" + category + '\'' +
                '}';
    }
}

