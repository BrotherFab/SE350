package src;

public class VitalSigns {
    private double temperature;
    private int heartRate;

    public VitalSigns(double temperature, int heartRate) {
        this.temperature = temperature;
        this.heartRate = heartRate;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHeartRate() {
        return heartRate;
    }
}
