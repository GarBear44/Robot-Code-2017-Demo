package frc.intake;

import frc.controllers.JoystickController;
import frc.interfaces.LoopModule;

public class IntakeControl implements LoopModule {

    private final Intake intake;
    private final JoystickController joystick;
    private final double intakeSpeed = -1;

    public IntakeControl(Intake intake, JoystickController joystick) {
        this.intake = intake;
        this.joystick = joystick;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(long delta) {
        if(joystick.getButton(1)){
            intake.setSpeed(intakeSpeed);
        } else {
            intake.setSpeed(0);
        }
    }



}