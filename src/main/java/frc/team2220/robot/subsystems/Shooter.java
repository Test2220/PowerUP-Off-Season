package frc.team2220.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2220.robot.RobotMap;

public class Shooter extends Subsystem
{
    //Declares Talons:
    public WPI_TalonSRX topRightTalon;
    public WPI_TalonSRX topLeftTalon;
    public WPI_TalonSRX bottomRightTalon;
    public WPI_TalonSRX bottomLeftTalon;

    //Declares Piston:
    private DoubleSolenoid cubePiston;

    //Constructor:
    public Shooter()
    {
        //Configures Talons:
        topRightTalon = new WPI_TalonSRX(RobotMap.SHOOTER_TOP_RIGHT);
        topLeftTalon = new WPI_TalonSRX(RobotMap.SHOOTER_TOP_LEFT);
        bottomRightTalon = new WPI_TalonSRX(RobotMap.SHOOTER_BOTTOM_RIGHT);
        bottomLeftTalon = new WPI_TalonSRX(RobotMap.SHOOTER_BOTTOM_LEFT);

        //Configures Cube Piston:
        cubePiston = new DoubleSolenoid(RobotMap.CUBE_PISTON_UP, RobotMap.CUBE_PISTON_DOWN);

        //Configures wheel motion direction
        topRightTalon.setInverted(true);
        topLeftTalon.setInverted(false);
        bottomRightTalon.setInverted(true);
        bottomLeftTalon.setInverted(false);
    }

    //Sets the motors based on the Control Mode and the Value:
    public void spinAllMotors(ControlMode controlMode, double value)
    {
        topRightTalon.set(controlMode, value);
        topLeftTalon.set(controlMode, value);
        bottomRightTalon.set(controlMode, value);
        bottomLeftTalon.set(controlMode, value);
    }

    //Configures possible Cube Piston Positions:
    public enum CubePistonPosition
    {
        UP,
        DOWN
    }

    //Sets the Cube Piston Position to UP or DOWN based on parameters entered:
    public void setCubePiston(CubePistonPosition position)
    {
        switch (position)
        {
            case UP:
                cubePiston.set(DoubleSolenoid.Value.kReverse);
                break;
            case DOWN:
                cubePiston.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}