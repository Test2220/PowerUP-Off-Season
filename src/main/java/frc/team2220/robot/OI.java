package frc.team2220.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.team2220.robot.commands.ShootCube;
import frc.team2220.robot.utils.TwilightXBoxController;


// The OI class specifies what command is ran when an action on the controllers occurs
// TODO assign actions to the controller binds
public class OI
{


    // Instantiate XboxController Variables
    private final TwilightXBoxController
            driverController,
            manipulatorController;

    // Readable Controller Values
    public TwilightXBoxController getDriverController()       { return driverController; }
    public TwilightXBoxController getManipulatorController()  { return manipulatorController; }

    // Constructor Defines Actions
    public OI() {

        // Define XboxController Variables
        driverController      = new TwilightXBoxController(RobotMap.XBOX_DRIVER);
        manipulatorController = new TwilightXBoxController(RobotMap.XBOX_MANIPULATOR);

        //Configures what button does what
        //TODO: Change code so that while right trigger is held, cube is shot.
        manipulatorController.getAButton().whileHeld(new ShootCube());
    }
}