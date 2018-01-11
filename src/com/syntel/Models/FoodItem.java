package com.syntel.Models;

public class FoodItem {

    private String name;

    @Override
    public String toString() {
        return name;
    }

    public FoodItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
