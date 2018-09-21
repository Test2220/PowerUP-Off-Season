package frc.team2220.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.team2220.robot.commands.ActiveIntake;
import frc.team2220.robot.utils.TwilightXboxController;
import frc.team2220.robot.commands.ShootCube;

/*
Short for Operator Interface, the OI class is where you put the controller binds to run commands.
The goal is to keep all things relating to controller binds in this class to stay organized
TODO Assign Commands To Controller Binds
 */
@SuppressWarnings("FieldCanBeLocal")
public class OI
{

    // Define Custom Xbox Controller Instance Variables
    private final TwilightXboxController
            driver,
            manipulator;

    // Xbox Controller Contracts
    public final TwilightXboxController getDriver()       { return driver; }
    public final TwilightXboxController getManipulator()  { return manipulator; }

    // Create Abstract Trigger Method
    private Trigger shootTrigger(TwilightXboxController xb, GenericHID.Hand hand)
    {
        return new Trigger()
        {
            @Override
            public boolean get()
            {
                double triggerValue = hand.equals(GenericHID.Hand.kLeft)
                        ? xb.getAxis(TwilightXboxController.VariableControl.LEFT_TRIGGER)
                        : xb.getAxis(TwilightXboxController.VariableControl.RIGHT_TRIGGER);
                return triggerValue >= 0.25;
            }
        };
    }

    // OI Constructor Initialize And Setup Members
    public OI()
    {

        /* SETUP AND DEFINE OI MEMBERS */

        driver      = new TwilightXboxController(RobotMap.XBOX_DRIVER);
        manipulator = new TwilightXboxController(RobotMap.XBOX_MANIPULATOR);

        /* ASSIGN COMMANDS TO CONTROLLER BINDS */

        //Runs shooter motors while right trigger is held.
        shootTrigger(manipulator, GenericHID.Hand.kRight).whileActive(new ShootCube(0.24));
        shootTrigger(manipulator, GenericHID.Hand.kRight).whenInactive(new ShootCube(0));

        //TODO: Create ActiveIntake command:
        shootTrigger(manipulator, GenericHID.Hand.kLeft).whileActive(new ActiveIntake(-0.75));

    }
}