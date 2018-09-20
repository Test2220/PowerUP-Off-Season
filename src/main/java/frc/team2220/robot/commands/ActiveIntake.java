package frc.team2220.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2220.robot.Robot;
import frc.team2220.robot.subsystems.Intake;

// TODO Write Active Intake command
public class ActiveIntake extends InstantCommand
{
    public double speed;

    public ActiveIntake(double speed)
    {
        requires(Robot.shooter);
        this.speed = speed;
    }

    public void execute()
    {
        Robot.intake.spin(Intake.WhatToSpin.BOTH, ControlMode.PercentOutput, speed);
    }

}
