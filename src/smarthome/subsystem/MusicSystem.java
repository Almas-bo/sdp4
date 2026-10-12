package smarthome.subsystem;

public class MusicSystem {
    public void play(String playlist) {
        System.out.println("Music: playing " + playlist);
    }

    public void stop() {
        System.out.println("Music: stopped");
    }
}
