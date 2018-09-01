package frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2220.robot.Robot;

public class KillDrive extends InstantCommand {

    public KillDrive() {
        requires(Robot.gaganDrive);
    }

    public void initialize() {
        Robot.gaganDrive.stopMotors();
    }

}