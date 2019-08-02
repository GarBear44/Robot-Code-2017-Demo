package frc.sensors;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

public class Sensors {
	private static Encoder flywheelEncoder;
	private final Encoder wheelsLeft;
	private final Encoder wheelsRight;
	
	public Sensors() {
		// init flywheel encoder
		flywheelEncoder = new Encoder(RobotMap.encoderShooterDIOA, RobotMap.encoderShooterDIOB, false,
				Encoder.EncodingType.k4X);
		flywheelEncoder.reset();
		flywheelEncoder.setDistancePerPulse(RobotMap.rotationsPerStepShooter);

		// init wheel encoders
		wheelsRight = new Encoder(RobotMap.encoderRightDIOA, RobotMap.encoderRightDIOB, false,
				Encoder.EncodingType.k4X);
		wheelsRight.reset();
		wheelsRight.setDistancePerPulse(-RobotMap.inchesPerPulse);
		
		wheelsLeft = new Encoder(RobotMap.encoderLeftDIOA, RobotMap.encoderLeftDIOB, false, Encoder.EncodingType.k4X);
		wheelsLeft.reset();
		wheelsLeft.setDistancePerPulse(RobotMap.inchesPerPulse);
	}

	public Encoder getFlywheelEncoder() {
		return flywheelEncoder;
	}

	public Encoder getLeftWheelEncoder() {
		return wheelsLeft;
	}

	public Encoder getRightWheelEncoder() {
		return wheelsRight;
	}
}
