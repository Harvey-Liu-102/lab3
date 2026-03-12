// Name: Harvey Liu
// Lab 3, Problem 1
// Submission date: 03/15/26

package lab3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class L3P1
{
    public static ArrayList<Connection> store(final String fileName)
    {
        ArrayList<Connection> array = new ArrayList<Connection>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                Scanner scanner = new Scanner(line);
                array.add(new Connection(scanner.next(), scanner.next()));
                scanner.close();
            }
        }
        catch(final FileNotFoundException fileNotFoundException)
        {
            System.out.println(fileNotFoundException);
        }
        catch(final IOException ioException)
        {
            System.out.println(ioException);
        }
        return array;
    }

    public static void printAllConnections(final ArrayList<Connection> array)
    {
        System.out.println("All connections: ");
        for (int i = 0; i < array.size(); ++i)
        {
            System.out.println(array.get(i).start + " -> " + array.get(i).end);
        }
    }

    public static boolean possibleStartingCity(final ArrayList<Connection> array, final String city)
    {
        for (int i = 0; i < array.size(); ++i)
        {
            if (array.get(i).start.equals(city))
            {
                return true;
            }
        }
        return false;
    }

    public static void printPossibleConnections(final ArrayList<Connection> array, final String city) //prints possible next cities you can visit from current city
    {
        System.out.println("\nFrom [" + city + "], you can travel to:");
        for (int i = 0; i < array.size(); ++i)
        {
            if (array.get(i).start.equals(city))
            {
                System.out.println(" - " + array.get(i).end);
            }
        }
    }

    public static ArrayList<String> possibleConnections(final ArrayList<Connection> array, final String city) //arraylist of possible next cities you can visit from current city
    {
        ArrayList<String> array2 = new ArrayList<String>();
        for (int i = 0; i < array.size(); ++i)
        {
            if (array.get(i).start.equals(city))
            {
                array2.add(array.get(i).end);
            }
        }
        return array2;
    }

    public static String getNextCity(final ArrayList<Connection> array, final String city, Scanner scanner)
    {
        ArrayList<String> array2 = possibleConnections(array, city);
        System.out.print("Enter the next city to visit: ");
        String city2 = scanner.next();
        while (!array2.contains(city2)) //ensures the next city can be visited from the current city
        {
            System.out.print("You can't visit " + city2 + ". Enter the next city to visit: ");
            city2 = scanner.next();
        }
        return city2;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        final String fileName = scanner.next();
        ArrayList<Connection> array = store(fileName); //all connections
        ArrayList<String> path = new ArrayList<String>(); //travel path
        printAllConnections(array);
        System.out.print("\nEnter your starting city: ");
        String city = scanner.next();
        while (!possibleStartingCity(array, city))
        {
            System.out.print(city + " is not a starting city. Enter your starting city: ");
            city = scanner.next();
        }
        final String startingCity = city;
        path.add(city); //add starting city to travel path
        do
        { 
            printPossibleConnections(array, city);
            city = getNextCity(array, city, scanner);
            path.add(city); //add all cities visited after the starting city, to travel path
        }
        while (!city.equals(startingCity)); //repeat until a city visited after the starting city, is the same as the starting city
        System.out.println("\n*** Returned to the starting city. Trip completed! ***\n");
        System.out.println("Your travel path:");
        for (int i = 0; i < path.size(); ++i) //print travel path
        {
            System.out.print(path.get(i));
            if (i < path.size() - 1)
            {
                System.out.print(" -> ");
            }
        }
    }
}