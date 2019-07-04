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
        this.id = nextId();
    }

    private long nextId() {
        idCounter = idCounter + 1;
        return idCounter;
    }
}

