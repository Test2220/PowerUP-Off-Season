package frc.team2220.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.team2220.robot.Robot;
import frc.team2220.robot.utils.TwilightXboxController;

/*
The Xbox Drive class requires the Gagan Drive subsystem in order to work.
Very simply, what it does is utilize the curvature drive method from the differential drive class to control the robot
using the right joystick Y axis for motor power and the left joystick X axis for turn power.
 */
public class XboxDrive extends Command {

    // Interrupt Cancel Boolean
    private boolean interrupted;

    // Constructor Stops Use Without GaganDrive
    public XboxDrive() { requires(Robot.gaganDrive); }

    // On XboxDrive Switch Control Mode To Percent Output
    public void initialize() {
        Robot.gaganDrive.usePercentOutput();
    }

    // Executes Drive Code Periodically
    public void execute() {

        // Define Variables From Driver Controller
        double leftY    = Robot.oi.getDriver().getAxes(TwilightXboxController.VariableControl.LEFT_STICK_Y);
        double rightX   = -Robot.oi.getDriver().getAxes(TwilightXboxController.VariableControl.RIGHT_STICK_X);

        // Execute CurvatureDrive With Controller Values Specified
        Robot.gaganDrive.curvatureDrive(leftY, rightX);
    }

    // Never Finish Command
    public boolean isFinished() { return interrupted; }

    // If Interrupted Kill Drivetrain
    @Override
    public void interrupted() {

        // Run Kill Drive Train Command
        new KillDrive();

        // Set Value After Safely Shutting Down Drivetrain
        interrupted = true;
    }
}