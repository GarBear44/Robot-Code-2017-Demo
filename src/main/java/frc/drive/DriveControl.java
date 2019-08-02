package frc.drive;
import frc.drive.DriveBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.controllers.XBoxController;
import frc.interfaces.LoopModule;

public class DriveControl implements LoopModule {

    private final DriveBase base;
    private final XBoxController controller;
    private final double kSpeed = .66;
    private final double rSpeed = .5;
    private DriveMode driveMode;
    private double speed;

    public DriveControl(DriveBase base, XBoxController controller) {
        this.base = base;
        this.controller = controller;
        speed = kSpeed;
        driveMode = DriveMode.ARCADE;
    }

    public void init(){
        SmartDashboard.putString("Drive Mode", "" + driveMode);
    }

    @Override
    public void update(long delta){
        selectDriveMode();

        switch (driveMode){
            case TANK:
                tankControl();
            case ARCADE:
                arcadeControl();
        }
    }

    public void selectDriveMode(){
        if(controller.getButton(1)) {
            driveMode = DriveMode.ARCADE;
        } else if(controller.getButton(2)) {
            driveMode = DriveMode.TANK;
        }
    }

    public void tankControl() {
        double speedMultiplier = speed;
		double right = controller.getStickRY();
		double left = controller.getStickLY();

		// Right trigger boost
		speedMultiplier += (1 - speed) * controller.getRTrigger();
		right *= speedMultiplier;
        left *= speedMultiplier;

		// Left trigger straighten
		double avg = (right + left) / 2;
		double lTrigger = controller.getLTrigger();
		double notLTrigger = 1 - lTrigger;
		right = notLTrigger * right + avg * lTrigger;
		left = notLTrigger * left + avg * lTrigger;

		base.move(right, left);
    }

    public void arcadeControl() {
        double targetSpeed = controller.getStickRX() * rSpeed;
		double turnSpeed = targetSpeed * .01;
        base.move((controller.getStickLY()*(speed)) + turnSpeed, (controller.getStickLY()*(speed)) - turnSpeed);

    }

    public DriveBase getBase() {
        return base;
    }

    public enum DriveMode {
        TANK, ARCADE;
    }

}