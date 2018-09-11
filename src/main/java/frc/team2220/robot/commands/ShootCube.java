package frc.team2220.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2220.robot.Robot;
import frc.team2220.robot.subsystems.Shooter;

public class ShootCube extends InstantCommand
{
    public ShootCube() {
        requires(Robot.shooter);
    }
    public void execute()
    {
        //Robot.oi.getDriver();
        Robot.shooter.spinAllMotors(ControlMode.PercentOutput, 0.24);
    }
}
