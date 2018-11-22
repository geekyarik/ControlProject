package com.company.TaxiPark;

public class Car implements Comparable {

    private CarType type;
    private Integer cruiserSpeed;
    private Integer price;
    private Double fuelConsumption;
    private static int count = 0;
    private int id = count++;

    public Car(CarType type, Integer cruiserSpeed, Integer price, Double fuelConsumption) {
        this.type = type;
        this.cruiserSpeed = cruiserSpeed;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Integer getCruiserSpeed() {
        return cruiserSpeed;
    }

    public void setCruiserSpeed(Integer cruiserSpeed) {
        this.cruiserSpeed = cruiserSpeed;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public int compareTo(Object other) {
        if (this.fuelConsumption > ((Car) other).fuelConsumption) {
            return 1;
        } else if (this.fuelConsumption < ((Car) other).fuelConsumption) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Car id=" + id +
                ", type=" + type +
                ", cruiserSpeed=" + cruiserSpeed +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption;
    }
}
