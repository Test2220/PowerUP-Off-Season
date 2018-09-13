package frc.team2220.robot;

import edu.wpi.first.wpilibj.GenericHID;
import frc.team2220.robot.utils.TwilightXboxController;
import frc.team2220.robot.commands.ShootCube;
import frc.team2220.robot.triggers.ControllerTriggerTrigger;


// The OI class specifies what command is ran when an action on the controllers occurs
// TODO assign actions to the controller binds
@SuppressWarnings("FieldCanBeLocal")
public class OI {

    //Creates instance of ControllerTriggerTrigger object
    private final ControllerTriggerTrigger shootTrigger;

    // Instantiate (Twilight)XboxController Variables
    private final TwilightXboxController
            driver,
            manipulator;

    // Readable Xbox Controller Values
    public final TwilightXboxController getDriver()       { return driver; }
    public final TwilightXboxController getManipulator()  { return manipulator; }

    // Constructor Defines Actions
    public OI() {

        /* SETUP AND DEFINE OI MEMBERS */

        driver      = new TwilightXboxController(RobotMap.XBOX_DRIVER);
        manipulator = new TwilightXboxController(RobotMap.XBOX_MANIPULATOR);

        /* ASSIGN COMMANDS TO CONTROLLER BINDS */
        // Define XboxController Variables
        driver      = new TwilightXBoxController(RobotMap.XBOX_DRIVER);
        manipulator= new TwilightXBoxController(RobotMap.XBOX_MANIPULATOR);
        shootTrigger = new ControllerTriggerTrigger(manipulator, GenericHID.Hand.kRight);

        /* ASSIGN COMMANDS TO CONTROLLER BINDS */

        //Configures what button does what
        //Dhruv Changed:
        //TODO Get rid of ControlTriggerTrigger, and use an instance of abstract class Trigger and use simple conditional instead(Reece's Idea).

        shootTrigger.whileActive(new ShootCube(0.24));
        shootTrigger.whenInactive(new ShootCube(0));
    }
}