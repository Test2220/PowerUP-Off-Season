package frc.team2220.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.team2220.robot.utils.TwilightXBoxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ControllerTriggerTrigger extends Trigger
{

    TwilightXBoxController controller;
    Hand hand;

    public ControllerTriggerTrigger(TwilightXBoxController controller, Hand hand)
    {
        this.controller = controller;
        this.hand = hand;
    }

    @Override
    public boolean get()
    {
        return (controller.getTrigger(hand) >= 0.25);
    }
}
