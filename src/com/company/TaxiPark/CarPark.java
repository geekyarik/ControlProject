package com.company.TaxiPark;

import com.company.ConsoleMenu.UnrecogrizedCommandEx;
import com.company.Main;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class CarPark {

    private List<Car> carList;
    private Integer count;

    public Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public CarPark() {
        this.carList = new ArrayList<Car>();
        this.count = 0;
        String log4jConfPath = "D:\\Projects\\RozrProject\\src\\com\\company\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    public void add(Car object) {
        this.carList.add(object);
        count++;
    }

    public void showList() {
        for (Car eachCar : carList) {
            System.out.println(eachCar);
        }
    }

    public void showList(List<Car> carList) {
        for (Car eachCar : carList) {
            System.out.println(eachCar);
        }
    }

    public void remove(int id) throws InvalidIDEx {

        for (Car eachCar : this.carList) {
            if (eachCar.getId() == id) {
                this.carList.remove(eachCar);
                count--;
                return;
            }
        }

        throw new InvalidIDEx("No object with this id");
    }

    public List<Car> find(int fromSpeed, int toSpeed) {
        List<Car> subCarList = new ArrayList<Car>();

        for (Car eachCar : this.carList) {
            if (eachCar.getCruiserSpeed() >= fromSpeed && eachCar.getCruiserSpeed() <= toSpeed) {
                subCarList.add(eachCar);
            }
        }
        if(subCarList.isEmpty()){
            throw new IndexOutOfBoundsException("There are no cars in this range.");
        }
        return subCarList;
    }

    public void findAndShow(int fromSpeed, int toSpeed) {
        for (Car eachCar : this.carList) {
            if (eachCar.getCruiserSpeed() >= fromSpeed && eachCar.getCruiserSpeed() <= toSpeed) {
                System.out.println(eachCar);
            }
        }
    }

    public void showPrice() {
        System.out.println("Price of the car park=" + this.sumPrice());
    }

    public int sumPrice() {
        int sum = 0;
        for (Car eachCar : this.carList) {
            sum += eachCar.getPrice();
        }
        return sum;
    }

    public void sort() {
        Collections.sort(carList);
    }
}
