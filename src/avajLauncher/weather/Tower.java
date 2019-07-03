package avajLauncher.weather;

import avajLauncher.vehicles.Flyable;
import avajLauncher.vehicles.Helicopter;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {}

    protected void conditionsChanged() {}
}

