package frc.team2220.robot.commands;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team2220.robot.Robot;

// TODO Finish xbox drive class
public class XboxDrive extends Command {

    // Interrupt Cancel Boolean
    private boolean interrupted;

    // Constructor Stops Use Without GaganDrive
    public XboxDrive() { requires(Robot.gaganDrive); }

    // On XboxDrive Switch Control Mode To Percent Output
    public void initialize() { Robot.gaganDrive.usePercentOutput(); }

    // Executes Drive Code Periodically
    public void execute() {

        // Define Variables From Driver Controller
        //Dhruv Changed:
        double leftY    = Robot.oi.getDriverController().getYAxis(GenericHID.Hand.kLeft);
        double rightX   = Robot.oi.getDriverController().getXAxis(GenericHID.Hand.kRight);

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