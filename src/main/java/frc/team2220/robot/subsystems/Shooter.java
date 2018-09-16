package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2220.robot.RobotMap;

public class Shooter extends Subsystem
{
    // Instantiate and Initialize Talons
    private static final TalonSRX topRightTalon     = new TalonSRX(RobotMap.SHOOTER_TOP_RIGHT);
    private static final TalonSRX topLeftTalon      = new TalonSRX(RobotMap.SHOOTER_TOP_LEFT);
    private static final TalonSRX bottomRightTalon  = new TalonSRX(RobotMap.SHOOTER_BOTTOM_RIGHT);
    private static final TalonSRX bottomLeftTalon   = new TalonSRX(RobotMap.SHOOTER_BOTTOM_LEFT);

    // Instantiate And Initialize Shooter Pneumatics
    private static final DoubleSolenoid cubePiston  = new DoubleSolenoid(RobotMap.CUBE_PISTON_UP, RobotMap.CUBE_PISTON_DOWN);

    // TODO Set Default Command
    protected void initDefaultCommand() {
        // No Default Command
    }

    // Constructor Configures Shooter Talons
    public Shooter() {

        // Configure Proper Motor Output Inversion
        topRightTalon.setInverted(true);
        topLeftTalon.setInverted(false);
        bottomRightTalon.setInverted(true);
        bottomLeftTalon.setInverted(false);
    }

    // Cube Piston Position Enum
    public enum CubePos {
        UP,
        DOWN
    }

    // Set All Motors To Control Mode And Control Mode Coefficient
    public void spinAllMotors(ControlMode controlMode, double value) {
        topRightTalon.set(controlMode, value);
        topLeftTalon.set(controlMode, value);
        bottomRightTalon.set(controlMode, value);
        bottomLeftTalon.set(controlMode, value);
    }

    // Sets the Cube Piston Position to UP or DOWN based on parameters entered
    public void setCube(CubePos cubePos) {
        switch (cubePos) {
            case UP:
                cubePiston.set(DoubleSolenoid.Value.kReverse);
                break;
            case DOWN:
                cubePiston.set(DoubleSolenoid.Value.kForward);
                break;
        }
    }
}