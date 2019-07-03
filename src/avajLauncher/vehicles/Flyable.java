package avajLauncher.vehicles;

import avajLauncher.weather.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}