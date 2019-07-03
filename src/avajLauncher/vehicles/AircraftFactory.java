package avajLauncher.vehicles;

import avajLauncher.weather.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type == "Helicopter") {
            Helicopter aircraft = new Helicopter(name, coordinates);
            return aircraft;
        }
        else if (type == "JetPlane") {
            JetPlane aircraft = new JetPlane(name, coordinates);
            return aircraft;
        }

        else if (type == "Baloon") {
            Baloon aircraft = new Baloon(name, coordinates);
            return aircraft;
        }
        else {
            return null;
        }
    }
}
