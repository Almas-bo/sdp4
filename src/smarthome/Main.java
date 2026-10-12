package smarthome;

import smarthome.facade.SmartHomeException;
import smarthome.facade.SmartHomeFacade;
import smarthome.subsystem.Curtains;
import smarthome.subsystem.DoorLock;
import smarthome.subsystem.Lights;
import smarthome.subsystem.MusicSystem;
import smarthome.subsystem.SecuritySystem;
import smarthome.subsystem.Thermostat;

public class Main {
    public static void main(String[] args) {
        SmartHomeFacade home = new SmartHomeFacade(
                new Lights(), new Thermostat(), new Curtains(),
                new MusicSystem(), new DoorLock(), new SecuritySystem("1234"));

        try {
            System.out.println("--- Wrong code ---");
            home.arriveHome("0000");
        } catch (SmartHomeException e) {
            System.out.println("Error: " + e.getMessage() + " (" + e.getCause().getMessage() + ")");
        }

        try {
            System.out.println("--- Arrive home ---");
            home.arriveHome("1234");
        } catch (SmartHomeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Movie night ---");
        home.startMovieNight();

        System.out.println("--- Good night ---");
        home.goodNight();

        System.out.println("--- Leave home ---");
        home.leaveHome();
    }
}
