package ru.siestavl.siestavl.entity;

/**
 * Created by dmitry on 10/13/15.
 */
public class Dish {
    private String name;
    private String description;
    private String shortDescription;
    private int price;
    private int dishIndex;


    public int getDishIndex() {
        return dishIndex;
    }

    public void setDishIndex(int dishIndex) {
        this.dishIndex = dishIndex;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
