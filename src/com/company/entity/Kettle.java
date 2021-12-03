package com.company.entity;

import com.company.entity.enums.Color;

/**
 * The type of Kettle
 */
public class Kettle extends Appliance{
    private int powerConsumption;
    private double waterCapacity;
    private Color color;

    public Kettle() {
    }

    public Kettle(String name, double price, int powerConsumption, double waterCapacity, Color color) {
        super(name, price);
        this.powerConsumption = powerConsumption;
        this.waterCapacity = waterCapacity;
        this.color = color;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(double waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", waterCapacity=" + waterCapacity +
                ", color=" + color +
                '}';
    }
}
