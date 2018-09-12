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


    // Instantiate XboxController Variables
    private final TwilightXBoxController
            driverController,
            manipulatorController;

    private final ControllerTriggerTrigger shootTrigger;
    // Readable Controller Values

    //Dhruv Changed:
    public TwilightXBoxController getDriverController()       { return driverController; }
    public TwilightXBoxController getManipulatorController()  { return manipulatorController; }

    // Constructor Defines Actions
    public OI()
    {

        // Define XboxController Variables
        driverController      = new TwilightXBoxController(RobotMap.XBOX_DRIVER);
        manipulatorController = new TwilightXBoxController(RobotMap.XBOX_MANIPULATOR);
        shootTrigger = new ControllerTriggerTrigger(manipulatorController, GenericHID.Hand.kRight);

        //Configures what button does what
        //Dhruv Changed:

        shootTrigger.whileActive(new ShootCube(0.24));
        shootTrigger.whenInactive(new ShootCube(0));
    }
}