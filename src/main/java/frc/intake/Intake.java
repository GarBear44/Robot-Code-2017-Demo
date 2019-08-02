package frc.intake;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;

public class Intake {

    private final Spark motor;

    public Intake () {
        motor = new Spark(RobotMap.intake);
    }

    public void setSpeed(double n){
        motor.setSpeed(n);
    }

}