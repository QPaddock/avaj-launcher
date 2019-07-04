package avajLauncher.weather;

import avajLauncher.vehicles.Aircraft;
import avajLauncher.vehicles.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {

        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
    }

    protected void conditionsChanged() {
        for (int i = 0; observers.size() > i ; i++) {
            Flyable craft = observers.get(i);
            craft.updateConditions();
        }

    }
}

