package com.cheng.lt4.entity;

/**
 * @program: lt4
 * @description:
 * @class; Menu
 * @author: SanCheng
 * @create: 2018-09-22 11:13
 **/
public class Menu {
    private int id;
    private String food;
    private int price;

    public Menu(int id, String food, int price) {
        this.id = id;
        this.food = food;
        this.price = price;
    }

    public Menu(String food, int price) {
        this.food = food;
        this.price = price;
    }


    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
