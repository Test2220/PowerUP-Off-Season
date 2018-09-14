package frc.team2220.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team2220.robot.RobotMap;
import frc.team2220.robot.commands.XboxDrive;

/*
The Gagan Drive class is a subsystem that defines and controls the drivetrain CIM motors with Talon Motor Controllers.
On initialization, the subsystem executes the Xbox Drive command in order to actually control the motors.
The subsystem defines the members of the subsystem and a command usually controls those members.
TODO Write Autonomous And Encoders Code
 */
public class GaganDrive extends Subsystem {

    // Instantiate DifferentialDrive
    private final DifferentialDrive diffDrive;

    // Create Talons Specifically For Speed Controller Purposes
    private static final WPI_TalonSRX leftMaster    = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_MASTER);
    private static final WPI_TalonSRX rightMaster   = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_MASTER);
    private static final WPI_TalonSRX leftSlave     = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_SLAVE);
    private static final WPI_TalonSRX rightSlave    = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_SLAVE);

    // Execute XboxDrive Command During Periodic
    public void initDefaultCommand() {
        setDefaultCommand(new XboxDrive());
    }

    // Constructor Configure Talons and Define DifferentialDrive
    public GaganDrive() {

        // Set Slaves To Follow Masters
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);

        // Enable Motor Safety
        leftMaster.setSafetyEnabled(true);
        rightMaster.setSafetyEnabled(true);
        leftSlave.setSafetyEnabled(true);
        rightSlave.setSafetyEnabled(true);

        // Brake Motors
        setNeutralMode(NeutralMode.Brake);

        // Invert Proper Motor Outputs
        rightMaster.setInverted(true);
        rightSlave.setInverted(true);
        leftMaster.setInverted(true);
        leftSlave.setInverted(true);

        // TODO Figure Out How Encoders Work And Write Code For Them Prior To Differential Drive Definition

        // Define DifferentialDrive With Configured Master Talons
        diffDrive = new DifferentialDrive(leftMaster, rightMaster);
    }

    /* DRIVETRAIN TELEOP AND AUTONOMOUS METHODS */

    // Curvature Drive Method To Control Power And Turn Amount With Seperate Axis
    public void curvatureDrive(double power, double turn) {
        diffDrive.curvatureDrive(power, turn, true);
    }

    // Sets Power To Both Drive Motors, Usually For Autonomous Or Testing
    public void setPower(double bothPower) {
        leftMaster.set(bothPower);
        rightMaster.set(bothPower);
    }

    // Set Motor Percent Power To 0% And Brake Motors For Extra Stop Power
    public void stopMotors() {
        setPower(0);
        setNeutralMode(NeutralMode.Brake);
    }

    // Switch Motors To Percent Output
    public void usePercentOutput() {
        leftMaster.set(ControlMode.PercentOutput, 0);
        rightMaster.set(ControlMode.PercentOutput, 0);
    }

    // Set Neutral Mode Of All Motors
    private void setNeutralMode(NeutralMode neutralMode) {
        leftMaster.setNeutralMode(neutralMode);
        rightMaster.setNeutralMode(neutralMode);
        leftSlave.setNeutralMode(neutralMode);
        rightSlave.setNeutralMode(neutralMode);
    }
}