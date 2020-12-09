public class Capital
{
    private String name;
    private int population;
    private double squareMiles;

    public Capital(String nameIs, int popIs, double sqMiAre)
    {
        name = nameIs;
        population = popIs;
        squareMiles = sqMiAre;
    }

    public String getName()
    {
        return name;
    }

    public int getPopulation()
    {
        return population;
    }

    public double getSquareMiles()
    {
        return squareMiles;
    }
}
