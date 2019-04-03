import java.util.ArrayList;
import java.util.List;

/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class DijkstrasManager {
    private List<City> cityList;
    private List<Road> roadList;
    private boolean[][] adjacencyMatrix;

    private List<Integer> remainingCities;
    private MinHeap heap;
    private int[] distances;
    private int[] precedingCities;

    public DijkstrasManager(List<City> cityList, List<Road> roadList) {
        this.cityList = cityList;
        this.roadList = roadList;
        initializeAdjacencyMatrix(cityList.size());
        reset();
    }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * Returns City Object toString with Corresponding City Code.
     *
     * @param cityCode
     * @return
     */
    public String displayCityInfo(String cityCode) {
        City city = getCityFromList(cityCode.toUpperCase());
        if (city != null) {
            return city.toString();
        }
        return "Invalid City Code";
    }

    /**
     * Returns the Shortest Path From City 1 to City 2.
     *
     * @param cityCode1
     * @param cityCode2
     * @return
     */
    public String displayShortestPath(String cityCode1, String cityCode2) {
        City startCity = getCityFromList(cityCode1.toUpperCase());
        City endCity = getCityFromList(cityCode2.toUpperCase());

        if (startCity != null && endCity != null) {
            getShortestPath(startCity);

            String shortestPath = "The min distance between " + cityList.get(startCity.getNumber() - 1).getName()
                    + " and " + cityList.get(endCity.getNumber() - 1).getName() + " is "
                    + distances[endCity.getNumber() - 1] + " through the path: ";
            List<String> cityCodes = new ArrayList<>();
            int currCity = endCity.getNumber() - 1;

            while (currCity >= 0) {
                cityCodes.add(cityList.get(currCity).getCityCode());
                currCity = precedingCities[currCity];
            }
            for (int i = cityCodes.size() - 1; i > 0; i--) {
                shortestPath += cityCodes.get(i) + ", ";
            }
            shortestPath += cityCodes.get(0);
            return shortestPath;
        }
        return "Invalid City Codes";

    }

    /**
     * Returns City Object with Corresponding City Code.
     *
     * @param cityCode
     * @return
     */
    private City getCityFromList(String cityCode) {
        for (City c : cityList) {
            if (cityCode.equals(c.getCityCode())) {
                return c;
            }
        }
        return null;
    }

    /**
     * Set Values from Starting City.
     * Predetermines Shortest Path to All Possible Connecting Cities.
     *
     * @param startCity
     */
    private void getShortestPath(City startCity) {
        reset();

        distances[startCity.getNumber() - 1] = 0;
        heap.insert(startCity.getNumber(), 0);

        while (remainingCities.size() > 0) {
            // u: city with smallest distance
            int u = heap.remove().getCityNum();
            if (remainingCities.indexOf(u) != -1) {
                remainingCities.remove(u);
            }

            List<Road> roadsFromU = new ArrayList<>();
            for (Road r : roadList) {
                if (r.getStartCity() == u) {
                    roadsFromU.add(r);
                }
            }

            for (Road v : roadsFromU) {
                int weight = distances[u - 1] + v.getDistance();

                if (weight < distances[v.getEndCity() - 1]) {
                    distances[v.getEndCity() - 1] = weight;
                    precedingCities[v.getEndCity() - 1] = u - 1;
                }
                if (remainingCities.indexOf(v.getEndCity()) != -1) {
                    heap.insert(v.getEndCity(), weight);
                }
            }
        }
    }

    /**
     * Reset Values for Determining Shortest Path.
     */
    private void reset() {
        this.remainingCities = new ArrayList<>();
        this.heap = new MinHeap();
        this.distances = new int[cityList.size()];
        this.precedingCities = new int[cityList.size()];

        // Each Vertex has
        // Set Distance to Infinity
        // Set Preceding City to Undefined
        for (int i = 1; i < cityList.size() + 1; i++) {
            remainingCities.add(i);
            distances[i - 1] = Integer.MAX_VALUE;
            precedingCities[i - 1] = Integer.MIN_VALUE;
        }
    }

    /**
     * Read the List of Roads.
     * Create Adjacency Matrix of size: numCities.
     *
     * @param numCities
     * @return Adjacency Matrix representing the connecting roads.
     */
    private void initializeAdjacencyMatrix(int numCities) {
        adjacencyMatrix = new boolean[numCities][numCities];

        for (Road r : roadList) {
            adjacencyMatrix[r.getStartCity() - 1][r.getEndCity() - 1] = true;
        }
    }
}
