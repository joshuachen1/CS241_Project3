/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class City {
    private int number;
    private String cityCode;
    private String name;
    private int population;
    private int elevation;

    public City(int number, String cityCode, String name, int population, int elevation) {
        this.number = number;
        this.cityCode = cityCode;
        this.name = name;
        this.population = population;
        this.elevation = elevation;
    }

    public int getNumber() {
        return number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getElevation() {
        return elevation;
    }

    @Override
    public String toString() {
        return "City{" +
                "number = " + number +
                ", cityCode = '" + cityCode + '\'' +
                ", name = '" + name + '\'' +
                ", population = " + population +
                ", elevation = " + elevation +
                '}';
    }
}
