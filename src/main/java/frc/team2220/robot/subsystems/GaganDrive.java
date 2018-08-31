package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2220.robot.RobotMap;
import frc.team2220.robot.commands.XboxDrive;

public class GaganDrive extends Subsystem {

    // Create CAN Talons
    private TalonSRX leftMaster     = new TalonSRX(RobotMap.LEFT_DRIVE_MASTER);
    private TalonSRX rightMaster    = new TalonSRX(RobotMap.RIGHT_DRIVE_MASTER);
    private TalonSRX leftSlave      = new TalonSRX(RobotMap.LEFT_DRIVE_SLAVE);
    private TalonSRX rightSlave     = new TalonSRX(RobotMap.RIGHT_DRIVE_SLAVE);

    // Execute XboxDrive Command During Periodic
    public void initDefaultCommand() { setDefaultCommand(new XboxDrive()); }

    // Constructor On Execution Configure Talons
    public GaganDrive() {

        // Set Slaves To Follow Masters
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);

        // Reverse Right Side Motors TODO Check if right side is the correct side to invert
        rightMaster.setInverted(true);
        rightSlave.setInverted(true);

        // TODO Figure out encoders and set them up here
    }

    // TODO Check controller values to see if add or subtract turn param
    // Custom CurvatureDrive Method To Work Without DifferentialDrive
    public void curvatureDrive(double power, double turn) {
        leftMaster.set(ControlMode.PercentOutput, clip(power - turn, -1, 1));
        rightMaster.set(ControlMode.PercentOutput, clip(power + turn, -1, 1));
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