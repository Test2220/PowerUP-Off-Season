package frc.team2220.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.team2220.robot.commands.ShootCube;
import frc.team2220.robot.triggers.ControllerTriggerTrigger;
import frc.team2220.robot.utils.TwilightXBoxController;


// The OI class specifies what command is ran when an action on the controllers occurs
// TODO assign actions to the controller binds
public class OI
{

    //Creates instance of ControllerTriggerTrigger object
    private final ControllerTriggerTrigger shootTrigger;

    // Instantiate (Twilight)XboxController Variables
    private final TwilightXBoxController
            driver,
            manipulator;


    // Readable Controller Values

    //Dhruv Changed:
    public TwilightXBoxController getDriver()       { return driver; }
    public TwilightXBoxController getManipulator()  { return manipulator; }

    // Constructor Defines Actions
    public OI()
    {


        // Define XboxController Variables
        driver      = new TwilightXBoxController(RobotMap.XBOX_DRIVER);
        manipulator= new TwilightXBoxController(RobotMap.XBOX_MANIPULATOR);
        shootTrigger = new ControllerTriggerTrigger(manipulator, GenericHID.Hand.kRight);


        //Configures what button does what
        //Dhruv Changed:
        //TODO: Get rid of ControlTriggerTrigger, and use an instance of abstract class Trigger and use simple conditional instead(Reece's Idea).



        shootTrigger.whileActive(new ShootCube(0.24));
        shootTrigger.whenInactive(new ShootCube(0));
    }
}