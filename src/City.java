/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class City {
    private int number;
    private String acronym;
    private String name;
    private int population;
    private int elevation;

    public City(int number, String acronym, String name, int population, int elevation) {
        this.number = number;
        this.acronym = acronym;
        this.name = name;
        this.population = population;
        this.elevation = elevation;
    }

    public int getNumber() {
        return number;
    }

    public String getAcronym() {
        return acronym;
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
                ", acronym = '" + acronym + '\'' +
                ", name = '" + name + '\'' +
                ", population = " + population +
                ", elevation = " + elevation +
                '}';
    }
}
