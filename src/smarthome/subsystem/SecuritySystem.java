package smarthome.subsystem;

public class SecuritySystem {
    private final String secretCode;
    private boolean armed = true;

    public SecuritySystem(String secretCode) {
        this.secretCode = secretCode;
    }

    public void disarm(String code) throws WrongCodeException {
        if (!secretCode.equals(code)) {
            throw new WrongCodeException("Wrong security code");
        }
        armed = false;
        System.out.println("Security: disarmed");
    }

    public void arm() {
        armed = true;
        System.out.println("Security: armed");
    }

    public boolean isArmed() {
        return armed;
    }
}
