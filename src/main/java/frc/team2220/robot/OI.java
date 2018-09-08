package frc.team2220.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
Short for Operator Interface, the OI class is where you put the controller binds to run commands.
The goal is to keep all things relating to controller binds in this class to stay organized
TODO Assign Commands To Controller Binds
 */
@SuppressWarnings("FieldCanBeLocal")
public class OI {

    // Create Xbox Controller Members
    private final XboxController
            driver,
            manipulator;

    // Readable Xbox Controller Values
    public final XboxController getDriver()       { return driver; }
    public final XboxController getManipulator()  { return manipulator; }

    // Make Buttons For Driver Controller
    private final Button
            driverA,
            driverB,
            driverX,
            driverY,
            driverLB,
            driverRB,
            driverBack,
            driverStart,
            driverLSB,
            driverRSB;

    // Make Buttons For Manipulator Controller
    private final Button
            manipulatorA,
            manipulatorB,
            manipulatorX,
            manipulatorY,
            manipulatorLB,
            manipulatorRB,
            manipulatorBack,
            manipulatorStart,
            manipulatorLSB,
            manipulatorRSB;

    // Make Buttons For Special Circumstances
    private final Button
            leftYTest;

    // Constructor Defines Buttons and Actions
    public OI() {

        /* SETUP AND DEFINE COMMAND RUNNABLE BUTTONS */

        // Define XboxController Variables
        driver      = new XboxController(RobotMap.XBOX_DRIVER);
        manipulator = new XboxController(RobotMap.XBOX_MANIPULATOR);

        // Define Driver Controller Buttons With Raw Axis Number
        driverA     = new JoystickButton(driver, 1);
        driverB     = new JoystickButton(driver, 2);
        driverX     = new JoystickButton(driver, 3);
        driverY     = new JoystickButton(driver, 4);
        driverLB    = new JoystickButton(driver, 5);
        driverRB    = new JoystickButton(driver, 6);
        driverBack  = new JoystickButton(driver, 7);
        driverStart = new JoystickButton(driver, 8);
        driverLSB   = new JoystickButton(driver, 9);
        driverRSB   = new JoystickButton(driver, 10);

        // Define Manipulator Controller Buttons With Raw Axis Number
        manipulatorA        = new JoystickButton(manipulator, 1);
        manipulatorB        = new JoystickButton(manipulator, 2);
        manipulatorX        = new JoystickButton(manipulator, 3);
        manipulatorY        = new JoystickButton(manipulator, 4);
        manipulatorLB       = new JoystickButton(manipulator, 5);
        manipulatorRB       = new JoystickButton(manipulator, 6);
        manipulatorBack     = new JoystickButton(manipulator, 7);
        manipulatorStart    = new JoystickButton(manipulator, 8);
        manipulatorLSB      = new JoystickButton(manipulator, 9);
        manipulatorRSB      = new JoystickButton(manipulator, 10);

        // Define Special Buttons Without Raw Axis Number
        // This Example Shows How To Create A Button Object With A Simple Conditional
        leftYTest = new Button() {
            public boolean get() {
                return driver.getY(GenericHID.Hand.kLeft) > 0.5;
            }
        };

        /* ASSIGN COMMANDS TO CONTROLLER BINDS */
    }
}