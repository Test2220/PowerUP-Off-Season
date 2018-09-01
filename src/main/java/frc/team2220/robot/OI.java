package frc.team2220.robot;

import edu.wpi.first.wpilibj.XboxController;

// The OI class specifies what command is ran when an action on the controllers occurs
// TODO assign actions to the controller binds
public class OI {

    // Instantiate XboxController Variables
    private final XboxController
            driver,
            manipulator;

    // Readable Controller Values
    public XboxController getDriver()       { return driver; }
    public XboxController getManipulator()  { return manipulator; }

    // Constructor Defines Actions
    public OI() {

        // Define XboxController Variables
        driver      = new XboxController(RobotMap.XBOX_DRIVER);
        manipulator = new XboxController(RobotMap.XBOX_MANIPULATOR);
    }
}