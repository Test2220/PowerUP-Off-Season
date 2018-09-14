package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2220.robot.RobotMap;

public class Shooter extends Subsystem
{
    // Instantiate and Initialize Static Talons
    private static final WPI_TalonSRX topRightTalon     = new WPI_TalonSRX(RobotMap.SHOOTER_TOP_RIGHT);
    private static final WPI_TalonSRX topLeftTalon      = new WPI_TalonSRX(RobotMap.SHOOTER_TOP_LEFT);
    private static final WPI_TalonSRX bottomRightTalon  = new WPI_TalonSRX(RobotMap.SHOOTER_BOTTOM_RIGHT);
    private static final WPI_TalonSRX bottomLeftTalon   = new WPI_TalonSRX(RobotMap.SHOOTER_BOTTOM_LEFT);

    //Declares Piston:
    private static final DoubleSolenoid cubePiston      = new DoubleSolenoid(RobotMap.CUBE_PISTON_UP, RobotMap.CUBE_PISTON_DOWN);

    // Shooter Subsystem Constructor Configures Class Members
    public Shooter() {

        // Configure Proper Motor Output Inversion
        topRightTalon.setInverted(true);
        topLeftTalon.setInverted(false);
        bottomRightTalon.setInverted(true);
        bottomLeftTalon.setInverted(false);
    }

    // Set All Motors To Control Mode And Speed
    public void spinAllMotors(ControlMode controlMode, double speed) {
        topRightTalon.set(controlMode, speed);
        topLeftTalon.set(controlMode, speed);
        bottomRightTalon.set(controlMode, speed);
        bottomLeftTalon.set(controlMode, speed);
    }

    // Enumeration Of Possible Cube Piston Posiions
    public enum CubePistonPosition {
        UP,
        DOWN
    }

    // Sets the Cube Piston Position to UP or DOWN based on parameters entered
    public void setCubePiston(CubePistonPosition position) {
        switch (position) {
            case UP:
                cubePiston.set(DoubleSolenoid.Value.kReverse);
                break;
            case DOWN:
                cubePiston.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }

    @Override
    protected void initDefaultCommand() {
        // No Default Command
    }
}