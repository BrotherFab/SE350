package src;

public class Patient {
    private String name;
    private VitalSigns latestVitals;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void recordVitals(VitalSigns vitals) {
        this.latestVitals = vitals;
    }

    public VitalSigns getLatestVitals() {
        return latestVitals;
    }

    public String toString() {
        return name;
    }
}
