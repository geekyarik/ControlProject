package com.company;

import com.company.ConsoleMenu.Operation;
import com.company.TaxiPark.CarPark;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        String log4jConfPath = "D:\\Projects\\RozrProject\\src\\com\\company\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER.info("Starting of the program");

        CarPark park = new CarPark();

        Operation.scan(new Scanner(System.in), park);

        /*Scanner fileScanner;

        try (FileInputStream fileIn = new FileInputStream(
                new File("D:\\Projects\\RozrProject\\src\\com\\company\\Res\\input.txt"))) {
            fileScanner = new Scanner(fileIn);

            Operation.scan(fileScanner, park);
        } catch (IOException ex) {
            LOGGER.fatal("Can`t open file with input data.");
        }*/
    }
}
