package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.climber.Climber;
import frc.climber.ClimberControl;
import frc.controllers.JoystickController;
import frc.controllers.XBoxController;
import frc.drive.DriveBase;
import frc.drive.DriveControl;
import frc.intake.Intake;
import frc.intake.IntakeControl;
import frc.util.ClockRegulator;
//import frc.vision.Camera;

public class Robot extends TimedRobot {
    
    private DriveControl driveControl;
    private IntakeControl intakeControl;
    private ClimberControl climberControl;

    private DriveBase driveBase;
    private Intake intake;
    private Climber climber;

    private XBoxController xbox;
    private JoystickController joystick;

    //public static Camera camera;

    @Override
    public void robotInit() {

        xbox = new XBoxController(0);
        joystick = new JoystickController(1);

        driveBase = new DriveBase();
        intake = new Intake();
        climber = new Climber();

        driveControl = new DriveControl(driveBase, xbox);
        intakeControl = new IntakeControl(intake, joystick);
        climberControl = new ClimberControl(climber, joystick);

        //camera = new Camera();
    }

    @Override
    public void teleopInit() {
        //camera.start();
    }

    @Override
    public void teleopPeriodic() {
        ClockRegulator cl = new ClockRegulator(50);
        BigLoop bigLoop = new BigLoop(cl);

        bigLoop.add(driveControl);
        bigLoop.add(intakeControl);
        bigLoop.add(climberControl);

        bigLoop.init();
        
        while (isEnabled() && (isOperatorControl() || isAutonomous())) {
            //camera.run();
            bigLoop.update();
        }

        //camera.stop();
        bigLoop.cleanUp();
        
    }

    @Override
    public void autonomousInit() {
        teleopInit();
    }
    //init 1 time inits from here, iterative robot shouldn't be set up like this to avoid loop overruns, just making do

    @Override
    public void autonomousPeriodic() {
        teleopPeriodic();
    }

    @Override
    public void testInit(){
        teleopInit();
    }

    @Override
    public void testPeriodic(){
        ClockRegulator cl = new ClockRegulator(50);
        BigLoop bigLoop = new BigLoop(cl);
        //camera.start();

        bigLoop.add(driveControl);
        // bigLoop.add(intakeControl);
        // bigLoop.add(climberControl);

        bigLoop.init();
        
        while (isEnabled() && (isOperatorControl() || isAutonomous())) {
            //camera.run();
            bigLoop.update();
        }

        bigLoop.cleanUp();
    }
}
