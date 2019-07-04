package avajLauncher.vehicles;

import avajLauncher.weather.Coordinates;
import avajLauncher.weather.WeatherProvider;
import avajLauncher.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String condition;

        WeatherProvider weather = WeatherProvider.getProvider();

        condition = weather.getCurrentWeather(this.coordinates);

        if (condition.equals("SUN")) {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLongitude(coordinates.getLongitude() + 2);
            this.coordinates.setHeight(coordinates.getHeight() + 4);
        }

        else if (condition.equals("RAIN")) {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setHeight(coordinates.getHeight() - 5);
        }

        else if (condition.equals("FOG")) {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setHeight(coordinates.getHeight() - 3);
        }

        else if (condition.equals("SNOW")) {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setHeight(coordinates.getHeight() - 15);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(Baloon.this);
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
