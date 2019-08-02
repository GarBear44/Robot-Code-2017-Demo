package frc.turret;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.RobotMap;
import frc.sensors.Sensors;

public class Turret {

    private final Talon turnMotor;
    private final Talon flyWheelMotor;
    private final Encoder encoder;

    private double offset = 0;
    private double encoderToDegrees = 45d / 35087.5d;

    public Turret(Sensors sensors) {
        turnMotor = new Talon(RobotMap.turret);
        flyWheelMotor = new Talon(RobotMap.shooter);
        encoder = sensors.getFlywheelEncoder();
    }

    public void setTurret(double n){
        turnMotor.set(n);
    }

    private double getTurretPosition() {
        return turnMotor.getPosition() - offset;
    }

    public double getTurretAngle() {
        return getTurretPosition() * encoderToDegrees;
    }

    public void setFlyWheel(double n) {
        flyWheelMotor.set(n);
    }

    public double getFlywheelPosition() {
        return encoder.getDistance();
    }

    public double getFlyWheelRPS() {
        return encoder.getRate();
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public void zeroTurret() {
        offset = turnMotor.getPosition();
    }

}