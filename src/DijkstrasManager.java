import java.util.List;

/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class DijkstrasManager {
    private List<City> cityList;
    private List<Road> roadList;
    private boolean[][] adjacencyMatrix;

    public DijkstrasManager(List<City> cityList, List<Road> roadList) {
        this.cityList = cityList;
        this.roadList = roadList;
        initializeAdjacencyMatrix(cityList.size());
    }

    public List<City> getCityList() {
        return cityList;
    }

    public List<Road> getRoadList() {
        return roadList;
    }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public String displayCityInfo(String cityCode) {
        for (City c : cityList) {
            if (cityCode.toUpperCase().equals(c.getCityCode())) {
                return c.toString();
            }
        }
        return "Invalid City Code";
    }

    /**
     * Read the List of Roads.
     * Create Adjacency Matrix of size: numCities.
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
