/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class Road {
    private int startCity;
    private int endCity;
    private int distance;

    public Road(int startCity, int endCity, int distance) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.distance = distance;
    }

    public int getStartCity() {
        return startCity;
    }

    public int getEndCity() {
        return endCity;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Road{" +
                "startCity = " + startCity +
                ", endCity = " + endCity +
                ", distance = " + distance +
                '}';
    }
}
