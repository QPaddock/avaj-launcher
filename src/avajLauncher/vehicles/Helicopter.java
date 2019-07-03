package avajLauncher.vehicles;

import avajLauncher.weather.Coordinates;
import avajLauncher.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){}

    public void registerTower(WeatherTower weatherTower){}
}
