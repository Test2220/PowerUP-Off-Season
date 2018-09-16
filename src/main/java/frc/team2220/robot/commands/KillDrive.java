package frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2220.robot.Robot;

/*
The Kill Drive Command simply does what its name states: kills the drivetrain.
It is a fail safe designed to safely stop the drivetrain in an event the Xbox Drive Command fails or is interrupted.
 */
public class KillDrive extends InstantCommand {

    // Require Gagan Drive Class In Order To Cancel It
    public KillDrive() {
        requires(Robot.twilightDrive);
    }

    // Run Once On Initialization
    public void initialize() {
        Robot.twilightDrive.stopMotors();
    }
}