package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team2220.robot.RobotMap;
import frc.team2220.robot.commands.XboxDrive;

public class GaganDrive extends Subsystem {

    // Instantiate DifferentialDrive
    private final DifferentialDrive diffDrive;

    // Create CAN Talons
    private WPI_TalonSRX leftMaster     = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_MASTER);
    private WPI_TalonSRX rightMaster    = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_MASTER);
    private WPI_TalonSRX leftSlave      = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_SLAVE);
    private WPI_TalonSRX rightSlave     = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_SLAVE);

    // Execute XboxDrive Command During Periodic
    public void initDefaultCommand() { setDefaultCommand(new XboxDrive()); }

    // Constructor Configure Talons and Define DifferentialDrive
    public GaganDrive() {

        // Set Slaves To Follow Masters
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);

        // Brake Motors
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);
        leftSlave.setNeutralMode(NeutralMode.Brake);
        rightSlave.setNeutralMode(NeutralMode.Brake);

        // Reverse Right Side Motors TODO Check if right side is the correct side to invert
        rightMaster.setInverted(true);
        rightSlave.setInverted(true);

        // TODO Figure out encoders and set them up here

        // Define DifferentialDrive With Configured Talons
        diffDrive = new DifferentialDrive(leftMaster, rightMaster);
    }

    // TODO Check controller values to see if add or subtract turn param
    // Custom CurvatureDrive Method To Work Without DifferentialDrive
    /*public void curvatureDrive(double power, double turn) {
        leftMaster.set(clip(power - turn, -1, 1));
        rightMaster.set(clip(power + turn, -1, 1));
    }*/

    // TODO See if pre made or custom curvature drive is better

    // Pre-made CurvatureDrive Method
    public void curvatureDrive(double power, double turn) {
        diffDrive.curvatureDrive(power, turn, true);
    }

    // Switch Motors To Percent Output
    public void usePercentOutput() {
        leftMaster.set(ControlMode.PercentOutput, 0);
        rightMaster.set(ControlMode.PercentOutput, 0);
    }

    // Clip Method To Manage Range Of Values
    private double clip(double input, double min, double max) {
        if (input > max)
            return max;
        else if (input < min)
            return min;
        else
            return input;
    }
}