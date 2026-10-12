package smarthome.facade;

import smarthome.subsystem.Curtains;
import smarthome.subsystem.DoorLock;
import smarthome.subsystem.Lights;
import smarthome.subsystem.MusicSystem;
import smarthome.subsystem.SecuritySystem;
import smarthome.subsystem.Thermostat;
import smarthome.subsystem.WrongCodeException;

public class SmartHomeFacade {
    private final Lights lights;
    private final Thermostat thermostat;
    private final Curtains curtains;
    private final MusicSystem music;
    private final DoorLock doorLock;
    private final SecuritySystem security;

    public SmartHomeFacade(Lights lights, Thermostat thermostat, Curtains curtains,
                           MusicSystem music, DoorLock doorLock, SecuritySystem security) {
        this.lights = lights;
        this.thermostat = thermostat;
        this.curtains = curtains;
        this.music = music;
        this.doorLock = doorLock;
        this.security = security;
    }

    public void arriveHome(String securityCode) throws SmartHomeException {
        try {
            security.disarm(securityCode);
        } catch (WrongCodeException e) {
            throw new SmartHomeException("Cannot arrive home: security was not disarmed", e);
        }
        doorLock.unlock();
        lights.setBrightness(80);
        curtains.open();
        thermostat.setTargetTemperature(22);
        music.play("Welcome Home");
    }

    public void leaveHome() {
        music.stop();
        lights.turnOff();
        curtains.close();
        thermostat.enableEcoMode();
        doorLock.lock();
        security.arm();
    }

    public void startMovieNight() {
        curtains.close();
        lights.setBrightness(10);
        thermostat.setTargetTemperature(21);
        music.stop();
    }

    public void goodNight() {
        music.stop();
        lights.turnOff();
        curtains.close();
        thermostat.setTargetTemperature(18);
        doorLock.lock();
        security.arm();
    }
}
