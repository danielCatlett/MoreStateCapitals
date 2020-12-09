import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StateCapitalsApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("C:\\Users\\danie\\Documents\\SoftwareGuild\\JavaBasics\\MoreStateCapitals\\src\\CapitalInfo.txt");
        Scanner fileScan = new Scanner(file);

        Map<String, Capital> capitals = new HashMap<String, Capital>();

        while(fileScan.hasNextLine())
        {
            String line = fileScan.nextLine();
            String stateName = "";
            String capitalName = "";
            String popString = "";
            int population = 0;
            String areaString = "";
            double area = 0;

            int dataTypeReading = 0;
            boolean lastCharWasColon = false;
            for(int i = 0; i < line.length(); i++)
            {
                if(line.charAt(i) == ':')
                {
                    if(lastCharWasColon)
                    {
                        dataTypeReading++;
                    }
                    lastCharWasColon = true;
                }
                else
                {
                    switch (dataTypeReading)
                    {
                        case 0:
                            stateName += line.charAt(i);
                            break;
                        case 1:
                            capitalName += line.charAt(i);
                            break;
                        case 2:
                            popString += line.charAt(i);
                            break;
                        case 3:
                            areaString += line.charAt(i);
                            break;
                    }
                    lastCharWasColon = false;
                }
            }

            population = Integer.parseInt(popString);
            area = Double.parseDouble(areaString);

            capitals.put(stateName, new Capital(capitalName, population, area));
        }
        fileScan.close();

        Set<String> stateNames = capitals.keySet();

        System.out.println(capitals.size() + " State/Capital pairs loaded\n");

        for(String i : stateNames)
        {
            String output = i + " - ";
            output += capitals.get(i).getName() + " | Pop: ";
            output += capitals.get(i).getPopulation() + " | Area: ";
            output += capitals.get(i).getSquareMiles() + " sq mi";
            System.out.println(output);
        }

        System.out.println("\nEnter the lower limit for capital city population:");
        Scanner in = new Scanner(System.in);
        int populationIn = in.nextInt();
        System.out.println("\nListing capitals with populations greater than " + populationIn + "\n");

        for(String i : stateNames)
        {
            if(capitals.get(i).getPopulation() > populationIn)
            {
                String output = i + " - ";
                output += capitals.get(i).getName() + " | Pop: ";
                output += capitals.get(i).getPopulation() + " | Area: ";
                output += capitals.get(i).getSquareMiles() + " sq mi";
                System.out.println(output);
            }
        }

        System.out.println("\nEnter upper limit for capital city sq mileage");
        double areaIn = in.nextDouble();
        System.out.println("\nListing capitals with areas less than " + areaIn + "\n");

        for(String i : stateNames)
        {
            if(capitals.get(i).getSquareMiles() < areaIn)
            {
                String output = i + " - ";
                output += capitals.get(i).getName() + " | Pop: ";
                output += capitals.get(i).getPopulation() + " | Area: ";
                output += capitals.get(i).getSquareMiles() + " sq mi";
                System.out.println(output);
            }
        }
    }
}
