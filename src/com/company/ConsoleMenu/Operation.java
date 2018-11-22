package com.company.ConsoleMenu;

import com.company.TaxiPark.Car;
import com.company.TaxiPark.CarPark;
import com.company.TaxiPark.CarType;
import com.company.TaxiPark.InvalidIDEx;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    public static Logger LOGGER = Logger.getLogger(Operation.class.getSimpleName());

    static {
        String log4jConfPath = "D:\\Projects\\RozrProject\\src\\com\\company\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    public static void scan (Scanner scanner, CarPark park){    //(InputStream stream, CarPark park) {

        /*String comText; //= new Scanner(stream).nextLine();
        try(DataInputStream d= new DataInputStream(new BufferedInputStream(stream))){
            comText = d.readUTF();
            execute(comText, stream, park);

        }catch (IOException ex){

        }*/
        showCommands();
        LOGGER.info("Scanning new command.");
        String comText = scanner.nextLine();
        LOGGER.info("Recognizing the command.");
        execute(comText, scanner, park);
    }

    public static void execute(String comText, Scanner scanner, CarPark park) {//InputStream stream
        String token = comText.split(" ")[0]; //this.wordsList.get(0);
        try {
            switch (Command.valueOf(token.toUpperCase())) {
                case COMMANDS:
                    showCommands();
                    break;
                case ADD:
                    park.add(createCar(comText));
                    break;
                case REMOVE:
                    park.remove(getID(comText));
                    break;
                case CHANGE:
                    break;
                case SEARCH:
                    park.showList(park.find(beginRange(comText),endRange(comText)));//park.findAndShow(beginRange(comText), endRange(comText));
                    break;
                case PRICE:
                    park.showPrice();
                    break;
                case LIST:
                    park.showList();
                    break;
                case SORT:
                    park.sort();
                    break;
                case CONSOLE:
                    scanner = new Scanner(System.in);
                    break;
                case EXIT:
                    LOGGER.info("Exit");
                    return;
                default:
                    throw new UnrecogrizedCommandEx("Command is not recognized.");
            }
        } catch (UnrecogrizedCommandEx | IllegalArgumentException | InvalidIDEx ex) {
            System.out.println(ex.getMessage());
            System.out.println("Try to enter your command one more time:");
            LOGGER.warn(ex.getMessage());
        }
        LOGGER.info("Command is operated.");
        scan(scanner, park);
    }

    public static void showCommands() {
        LOGGER.info("Displaying commands");
        System.out.println("Available commands:");
        for (Command com : Command.values()) {
            System.out.println(com.getComText());
        }
    }

    public static Car createCar(String comText) throws UnrecogrizedCommandEx {
        LOGGER.info("Creating new car.");

        Car currentCar = new Car();
        Pattern pattern = Pattern.compile("speed=\\d+");
        Matcher matcher = pattern.matcher(comText);       //add speed=100 type=sedan price=5000 fuel=6.5

        if (!matcher.find()) {
            throw new UnrecogrizedCommandEx("No speed definition");
        }
        currentCar.setCruiserSpeed(Integer.parseInt(matcher.group(0).substring(6)));

        pattern = Pattern.compile("type=\\w+");
        matcher = pattern.matcher(comText);
        if (!matcher.find()) {
            throw new UnrecogrizedCommandEx("No type definition");
        }
        currentCar.setType(CarType.valueOf(matcher.group(0).substring(5).toUpperCase()));

        pattern = Pattern.compile("price=\\d+");
        matcher = pattern.matcher(comText);
        if (!matcher.find()) {
            throw new UnrecogrizedCommandEx("No price definition");
        }
        currentCar.setPrice(Integer.parseInt(matcher.group(0).substring(6)));

        pattern = Pattern.compile("fuel=\\d+.?\\d*");
        matcher = pattern.matcher(comText);
        if (!matcher.find()) {
            throw new UnrecogrizedCommandEx("No fuel definition");
        }
        currentCar.setFuelConsumption(Double.parseDouble(matcher.group(0).substring(5)));

        return currentCar;
    }

    public static int getID(String comText) throws UnrecogrizedCommandEx {
        Pattern pattern = Pattern.compile("id=\\d+");
        Matcher matcher = pattern.matcher(comText);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0).substring(3));
        } else {
            throw new UnrecogrizedCommandEx("No id definition");
        }
    }

    public static int beginRange(String comText) throws UnrecogrizedCommandEx {
        Pattern pattern = Pattern.compile("from=\\d+");
        Matcher matcher = pattern.matcher(comText);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0).substring(5));
        } else {
            throw new UnrecogrizedCommandEx("No value of begin of the range");
        }
    }

    public static int endRange(String comText) throws UnrecogrizedCommandEx {
        Pattern pattern = Pattern.compile("to=\\d+");
        Matcher matcher = pattern.matcher(comText);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0).substring(3));
        } else {
            throw new UnrecogrizedCommandEx("No value of end of the range");
        }
    }
}