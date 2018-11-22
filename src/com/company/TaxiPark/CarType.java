package com.company.TaxiPark;

public enum CarType {
    HATCHBACK("hatchback"),
    SEDAN("sedan"),
    MPV("mpv"),
    SUV("suv"),
    CROSSOVER("crossover"),
    ROADSTER("roadster");

    final String type;

    CarType(String comText) {
        this.type = comText;
    }

    final String getTypeStr() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
