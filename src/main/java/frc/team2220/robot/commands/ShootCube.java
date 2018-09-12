package frc.team2220.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2220.robot.Robot;
import frc.team2220.robot.subsystems.Shooter;

public class ShootCube extends InstantCommand
{

    //Variables
    double speed;

    public ShootCube(double speed)
    {
        requires(Robot.shooter);
        this.speed = speed;
    }
    public void execute()
    {
        //Robot.oi.getDriver();
        Robot.shooter.spinAllMotors(ControlMode.PercentOutput, speed);
    }
}
