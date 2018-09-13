package frc.team2220.robot;

import frc.team2220.robot.utils.TwilightXboxController;

/*
Short for Operator Interface, the OI class is where you put the controller binds to run commands.
The goal is to keep all things relating to controller binds in this class to stay organized
TODO Assign Commands To Controller Binds
 */
@SuppressWarnings("FieldCanBeLocal")
public class OI {

    // Create Xbox Controller Members
    private final TwilightXboxController
            driver,
            manipulator;

    // Readable Xbox Controller Values
    public final TwilightXboxController getDriver()       { return driver; }
    public final TwilightXboxController getManipulator()  { return manipulator; }

    // Constructor Defines Buttons and Actions
    public OI() {

        /* SETUP AND DEFINE OI MEMBERS */

        driver      = new TwilightXboxController(RobotMap.XBOX_DRIVER);
        manipulator = new TwilightXboxController(RobotMap.XBOX_MANIPULATOR);

        /* ASSIGN COMMANDS TO CONTROLLER BINDS */
    }
}