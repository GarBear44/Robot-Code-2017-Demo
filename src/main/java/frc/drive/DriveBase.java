package frc.drive;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;

public class DriveBase {

    private Spark left;
    private Spark right;

    public DriveBase() {
        left = new Spark(RobotMap.leftMotor);
        right = new Spark(RobotMap.rightMotor);
    }

    public void move(double l, double r) {
        left.set(l);
        right.set(-r);
    }

    public void moveArcade(double y, double x) {
        move(y + x, y-x);
    }

    public void stop() {
        move(0, 0);
    }
}