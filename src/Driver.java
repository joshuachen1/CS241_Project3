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
        List<City> cityList = initializeCityList();
        List<Road> roadList = initializeRoadList();
        boolean[][] adjacencyMatrix = new boolean[cityList.size()][cityList.size()];
    }

    /**
     * Read in City.dat data.
     * Return a List of City objects.
     * @return
     * @throws FileNotFoundException
     */
    private static List<City> initializeCityList() throws FileNotFoundException {
        List<City> temp = new ArrayList<>();
        Scanner cityFile = new Scanner(new File("src/City.dat"));
        String[] data;

        while(cityFile.hasNextLine()) {
            data = cityFile.nextLine().split("\\s{2,}");

            int cityNum = Integer.parseInt(data[0].trim());
            String cityAcronym = data[1];
            String cityName = data[2];
            int cityPop = Integer.parseInt(data[3].trim());
            int cityElev = Integer.parseInt(data[3].trim());
            temp.add(new City(cityNum, cityAcronym, cityName, cityPop, cityElev));
        }
        return temp;
    }

    /**
     * Read in Road.dat data.
     * Return a List of Road objects.
     * @return
     * @throws FileNotFoundException
     */
    private static List<Road> initializeRoadList() throws FileNotFoundException {
        List<Road> temp = new ArrayList<>();
        Scanner roadFile = new Scanner(new File("src/Road.dat"));
        String[] data;

        while(roadFile.hasNextLine()) {
            data = roadFile.nextLine().split("\\s{2,}");

            int startCity = Integer.parseInt(data[0].trim());
            int endCity = Integer.parseInt(data[1].trim());
            int distance = Integer.parseInt(data[2].trim());
            temp.add(new Road(startCity, endCity, distance));
        }
        return temp;
    }
}
