package avajLauncher.vehicles;

import avajLauncher.weather.*;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    Aircraft(){}

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        idCounter = idCounter++;
        return idCounter;
    }
}

