package avajLauncher.weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String weather[] = {"RAIN", "FOG", "SNOW", "SUN"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int result = (coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4;

        return (weather[result]);
    }
}
