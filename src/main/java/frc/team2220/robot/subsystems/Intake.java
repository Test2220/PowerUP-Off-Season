package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2220.robot.RobotMap;
import frc.team2220.robot.commands.ActiveIntake;

// TODO Explain Intake Subsystem With Comment Here
public class Intake extends Subsystem
{

    // Instantiate And Initialize Intake Talons
    private static final TalonSRX leftIntake            = new TalonSRX(RobotMap.COLLECTOR_LEFT);
    private static final TalonSRX rightIntake           = new TalonSRX(RobotMap.COLLECTOR_RIGHT);
    private static final TalonSRX leftTransfer          = new TalonSRX(RobotMap.TRANSFER_LEFT);
    private static final TalonSRX rightTransfer         = new TalonSRX(RobotMap.TRANSFER_RIGHT);

    // Instantiate And Initialize Ramp And Intake Pistons
    private static final DoubleSolenoid rampPiston      = new DoubleSolenoid(RobotMap.RAMP_PISTON_EXTENDED, RobotMap.RAMP_PISTON_RETRACTED);
    private static final DoubleSolenoid intakePiston    = new DoubleSolenoid(RobotMap.INTAKE_PISTON_EXTEND, RobotMap.INTAKE_PISTON_RETRACT);

    protected void initDefaultCommand()
    {

    }

    // Constructor Configures Intake Talons
    public Intake()
    {
        // Invert Specificied Intake Talons
        leftIntake.setInverted(true);
        rightIntake.setInverted(false);
        leftTransfer.setInverted(true);
        rightTransfer.setInverted(false);
    }

    /* DEFINE PNEUMATIC POSITION HELPER ENUMS */

    // The Target Group Of Motors To Spin, Used In Conjunction With The Spin Method
    public enum SpinTarget
    {
        INTAKE,
        TRANSFER,
        BOTH
    }

    // Two Possible Positions Of Intake
    public enum IntakePos
    {
        EXTENDED,
        RETRACTED
    }

    // Two Possible Positions Of Ramp
    public enum RampPos
    {
        UP,
        DOWN
    }

    /**
     * The Spin method spins the designated group of motors in the Spin Target
     * @param spinTarget    What group of motors to spin
     * @param controlMode   What control mode to spin the motors with
     * @param value         What control mode coefficient to apply to the motors (usually power)
     */
    public void spin(SpinTarget spinTarget, ControlMode controlMode, double value)
    {
        switch (spinTarget)
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

    public void setIntake(IntakePos intakePos)
    {
        switch (intakePos)
        {
            case EXTENDED:
                intakePiston.set(DoubleSolenoid.Value.kReverse);
                break;
            case RETRACTED:
                intakePiston.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }

    // Raises Or Lowers Ramp
    public void setRamp(RampPos rampPos)
    {
        switch (rampPos)
        {
            case UP:
                rampPiston.set(DoubleSolenoid.Value.kForward);
                break;
            case DOWN:
                rampPiston.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }
}