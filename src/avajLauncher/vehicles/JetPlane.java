package avajLauncher.vehicles;

import avajLauncher.weather.Coordinates;
import avajLauncher.weather.WeatherProvider;
import avajLauncher.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String condition;

        WeatherProvider weather = WeatherProvider.getProvider();

        condition = weather.getCurrentWeather(this.coordinates);

        if (condition.equals("SUN")) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLatitude(coordinates.getLatitude() + 10);
            this.coordinates.setHeight(coordinates.getHeight() + 2);
        }

        else if (condition.equals("RAIN")) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLatitude(coordinates.getLatitude() + 5);
        }

        else if (condition.equals("FOG")) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setLatitude(coordinates.getLatitude() + 1);
        }

        else if (condition.equals("SNOW")) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + condition);

            this.coordinates.setHeight(coordinates.getHeight() - 7);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
