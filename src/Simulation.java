import avajLauncher.vehicles.Aircraft;
import avajLauncher.vehicles.AircraftFactory;
import avajLauncher.vehicles.Flyable;
import avajLauncher.weather.WeatherTower;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyableList = new ArrayList<>();

    public static void main(String args[]) {
        try {
                BufferedReader reader = new BufferedReader( new FileReader(args[0]));
                String line = reader.readLine();
                if (line != null) {
                    weatherTower = new WeatherTower();
                    int simulations = Integer.parseInt(line.split(" ")[0]);
                    if (simulations < 0) {
                        System.out.println("Invalid simulation count " + simulations);
                        System.exit(1);
                    }
                    while ((line = reader.readLine()) != null) {
                        Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                        flyableList.add(flyable);
                    }

                    System.out.println(weatherTower);

                    for (Flyable flyable : flyableList) {
                        flyable.registerTower(weatherTower);
                    }

                    for (int i = 1; i <= simulations; i++) {
                        weatherTower.changeWeather();
                    }
                }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + args[0]);
        }
    }
}
