package smarthome.subsystem;

public class Thermostat {
    private int targetTemperature;

    public void setTargetTemperature(int celsius) {
        targetTemperature = celsius;
        System.out.println("Thermostat: target " + targetTemperature + "C");
    }

    public void enableEcoMode() {
        setTargetTemperature(16);
        System.out.println("Thermostat: eco mode on");
    }
}
