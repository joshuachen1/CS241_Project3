import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;

/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class UnitTests extends junit.framework.TestCase {

    // Test City Size
    public void test1() throws FileNotFoundException {
        assertEquals(20, initializeCityList().size());
    }

    // Test Num Roads
    public void test2() throws FileNotFoundException {
        assertEquals(77, initializeRoadList().size());
    }

    // Test Adjacency Matrix Size
    public void test3() throws FileNotFoundException {
        DijkstrasManager dm = new DijkstrasManager(initializeCityList(), initializeRoadList());

        assertEquals(20, dm.getAdjacencyMatrix().length);
        assertEquals(20, dm.getAdjacencyMatrix()[0].length);
    }

    // Test City Query Method
    public void test4() throws FileNotFoundException {
        DijkstrasManager dm = new DijkstrasManager(initializeCityList(), initializeRoadList());
        String cityInfo;

        cityInfo = "City{number = 1, cityCode = 'AN', name = 'ANAHEIM', population = 1273000, elevation = 1273000}";
        assertEquals(cityInfo, dm.displayCityInfo("an"));

        cityInfo = "City{number = 2, cityCode = 'BK', name = 'BAKERSFIELD', population = 31100, elevation = 31100}";
        assertEquals(cityInfo, dm.displayCityInfo("Bk"));

        cityInfo = "City{number = 3, cityCode = 'BO', name = 'BOSSTOWN', population = 790, elevation = 790}";
        assertEquals(cityInfo, dm.displayCityInfo("BO"));

        cityInfo = "City{number = 4, cityCode = 'BR', name = 'BREA CANYON', population = 529000, elevation = 529000}";
        assertEquals(cityInfo, dm.displayCityInfo("br"));

        cityInfo = "City{number = 5, cityCode = 'CH', name = 'CHINO HILLS', population = 52200, elevation = 52200}";
        assertEquals(cityInfo, dm.displayCityInfo("ch"));

        cityInfo = "City{number = 6, cityCode = 'ED', name = 'EDWIN DOM', population = 12, elevation = 12}";
        assertEquals(cityInfo, dm.displayCityInfo("ED"));

        cityInfo = "City{number = 7, cityCode = 'FI', name = 'FORT IRWIN', population = 4120, elevation = 4120}";
        assertEquals(cityInfo, dm.displayCityInfo("fi"));

        cityInfo = "City{number = 8, cityCode = 'GD', name = 'GARDENA', population = 653210, elevation = 653210}";
        assertEquals(cityInfo, dm.displayCityInfo("GD"));

        assertEquals("Invalid City Code", dm.displayCityInfo("Hello World"));
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
