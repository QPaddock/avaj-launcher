package avajLauncher.weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String weather[];

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return "String";
    }
}
