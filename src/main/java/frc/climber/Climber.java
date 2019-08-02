package frc.climber;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;

public class Climber {

    private final Spark motor;

    public Climber() {
        motor = new Spark(RobotMap.climber);
    }

    public void setSpeed (double n) {
        motor.setSpeed(n);
    }

}