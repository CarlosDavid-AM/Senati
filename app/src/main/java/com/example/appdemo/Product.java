package com.example.appdemo;

public class Product {
    private int id;
    private String marca;
    private String name;
    private double price;

    public Product(int id, String marca, String name, double price) {
        this.id = id;
        this.marca = marca;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return marca + " " + name;
    }
}
