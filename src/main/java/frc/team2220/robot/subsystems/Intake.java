package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2220.robot.RobotMap;

public class Intake extends Subsystem
{
    //Defines Intake and transfer talons
    WPI_TalonSRX leftIntake;
    WPI_TalonSRX rightIntake;
    WPI_TalonSRX leftTransfer;
    WPI_TalonSRX rightTransfer;

    //Defines ramp and intake pistons
    private DoubleSolenoid rampPiston;
    private DoubleSolenoid intakePistons;

    //Constructor
    public Intake()
    {
        //Instantiates Intakes and transfers
        leftIntake = new WPI_TalonSRX(RobotMap.COLLECTOR_LEFT);
        rightIntake = new WPI_TalonSRX(RobotMap.COLLECTOR_RIGHT);
        leftTransfer = new WPI_TalonSRX(RobotMap.TRANSFER_LEFT);
        rightTransfer = new WPI_TalonSRX(RobotMap.TRANSFER_RIGHT);

        //Instantiates ramp and intake pistons
        rampPiston = new DoubleSolenoid(RobotMap.RAMP_PISTON_EXTENDED, RobotMap.RAMP_PISTON_RETRACTED);
        intakePistons = new DoubleSolenoid(RobotMap.INTAKE_PISTON_EXTEND, RobotMap.INTAKE_PISTON_RETRACT);

        //Configures direction of motors
        leftIntake.setInverted(true);
        rightIntake.setInverted(false);
        leftTransfer.setInverted(true);
        rightTransfer.setInverted(false);
    }

    public enum WhatToSpin
    {
        INTAKE,
        TRANSFER,
        BOTH
    }

    public enum IntakePistonPosition
    {
        EXTENDED,
        RETRACTED
    }

    public enum rampPistonPosition
    {
        UP,
        DOWN
    }

    public void spin(WhatToSpin thingToSpin, ControlMode controlMode, double value)
    {
        switch (thingToSpin)
        {
            case INTAKE:
                leftIntake.set(controlMode, value);
                rightIntake.set(controlMode, value);
            break;

            case TRANSFER:
                leftTransfer.set(controlMode, value);
                rightTransfer.set(controlMode, value);
                break;

            case BOTH:
                leftIntake.set(controlMode, value);
                rightIntake.set(controlMode, value);
                leftTransfer.set(controlMode, value);
                rightTransfer.set(controlMode, value);
                break;
        }
    }

    public void setIntakePiston(IntakePistonPosition position)
    {
        switch (position)
        {
            case EXTENDED:
                intakePistons.set(DoubleSolenoid.Value.kReverse);
                break;

            case RETRACTED:
                intakePistons.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }

    public void setRamp(rampPistonPosition position)
    {
        switch (position)
        {
            case UP:
                rampPiston.set(DoubleSolenoid.Value.kForward);
                break;
            case DOWN:
                rampPiston.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }

    @Override
    protected void initDefaultCommand() { /* setDefaultCommand(new ControlIntake()); */ }
}