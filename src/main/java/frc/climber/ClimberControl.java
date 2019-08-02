package frc.climber;

import frc.controllers.JoystickController;
import frc.interfaces.LoopModule;

public class ClimberControl implements LoopModule {

    private final Climber climber;
    private final JoystickController joystick;

    public ClimberControl(Climber climber, JoystickController joystick) {
        this.climber = climber;
        this.joystick = joystick;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(long delta) {
        if(joystick.getButton(5) || joystick.getButton(6)) {
            climber.setSpeed(1);
        } else {
            climber.setSpeed(0);
        }
    }

}