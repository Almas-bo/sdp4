package smarthome.subsystem;

public class Lights {
    private int brightness;

    public void setBrightness(int percent) {
        brightness = percent;
        System.out.println("Lights: brightness " + brightness + "%");
    }

    public void turnOff() {
        setBrightness(0);
    }
}
