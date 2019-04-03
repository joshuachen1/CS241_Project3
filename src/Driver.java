import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        DijkstrasManager dm = new DijkstrasManager(initializeCityList(), initializeRoadList());

        Scanner inputScanner = new Scanner(System.in);
        String menuCommand, userInput;
        String[] multipleInputs;

        do {
            displayMenu();
            menuCommand = inputScanner.nextLine();

            switch (menuCommand.toUpperCase().charAt(0)) {
                case 'Q':
                    // Input 1 City Code
                    System.out.print("City Code: ");
                    userInput = inputScanner.nextLine();
                    System.out.println("\n" + dm.displayCityInfo(userInput) + "\n");
                    break;
                case 'D':
                    // Input 2 City Codes
                    System.out.print("City Codes: ");
                    multipleInputs = inputScanner.nextLine().split("\\s+");
                    System.out.println("\n" + dm.displayShortestPath(multipleInputs[0].trim(), multipleInputs[1].trim()) + "\n");
            }
        } while (!menuCommand.equals("E"));
    }

    private static void displayMenu() {
        System.out.println("(Q) Query the city information by entering the city code.");
        System.out.println("(D) Find the minimum distance between two cities.");
        System.out.println("(I) Insert a road by entering two city codes and distance.");
        System.out.println("(R) Remove an existing road by entering two city codes.");
        System.out.println("(H) Display this message.");
        System.out.println("(E) Exit.");
        System.out.print("Command: ");
    }

    /**
     * Read in City.dat data.
     *
     * @return a List of City objects.
     * @throws FileNotFoundException
     */
    private static List<City> initializeCityList() throws FileNotFoundException {
        List<City> temp = new ArrayList<>();
        Scanner cityFile = new Scanner(new File("src/City.dat"));
        String[] data;

        while (cityFile.hasNextLine()) {
            data = cityFile.nextLine().split("\\s{2,}");

            int cityNum = Integer.parseInt(data[0].trim());
            String cityCode = data[1];
            String cityName = data[2];
            int cityPop = Integer.parseInt(data[3].trim());
            int cityElev = Integer.parseInt(data[3].trim());
            temp.add(new City(cityNum, cityCode, cityName, cityPop, cityElev));
        }
        return temp;
    }

    /**
     * Read in Road.dat data.
     *
     * @return a List of Road objects.
     * @throws FileNotFoundException
     */
    private static List<Road> initializeRoadList() throws FileNotFoundException {
        List<Road> temp = new ArrayList<>();
        Scanner roadFile = new Scanner(new File("src/Road.dat"));
        String[] data;

        while (roadFile.hasNextLine()) {
            data = roadFile.nextLine().split("\\s{2,}");

            int startCity = Integer.parseInt(data[0].trim());
            int endCity = Integer.parseInt(data[1].trim());
            int distance = Integer.parseInt(data[2].trim());
            temp.add(new Road(startCity, endCity, distance));
        }
        return temp;
    }
}
