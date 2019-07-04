package avajLauncher.weather;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return "WTF";
    }

    public void changeWeather() {
        conditionsChanged();
    }
}
