package avajLauncher.vehicles;

import avajLauncher.weather.Coordinates;
import avajLauncher.weather.WeatherProvider;
import avajLauncher.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String condition;

        WeatherProvider weather = WeatherProvider.getProvider();

        condition = weather.getCurrentWeather(this.coordinates);

        if (condition.equals("SUN")) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLongitude(coordinates.getLongitude() + 10);
            this.coordinates.setHeight(coordinates.getHeight() + 2);
        }

        else if (condition.equals("RAIN")) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLongitude(coordinates.getLongitude() + 5);
        }

        else if (condition.equals("FOG")) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLongitude(coordinates.getLongitude() + 1);
        }

        else if (condition.equals("SNOW")) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setHeight(coordinates.getHeight() - 12);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(Helicopter.this);
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
