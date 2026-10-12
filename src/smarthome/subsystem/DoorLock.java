package smarthome.subsystem;

public class DoorLock {
    private boolean locked = true;

    public void unlock() {
        locked = false;
        System.out.println("Door: unlocked");
    }

    public void lock() {
        locked = true;
        System.out.println("Door: locked");
    }

    public boolean isLocked() {
        return locked;
    }
}
