package week2;

public class City {
    private int id;
    private String name;
    private int population;

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
