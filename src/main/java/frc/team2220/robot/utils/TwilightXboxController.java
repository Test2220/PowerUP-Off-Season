package frc.team2220.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// TODO Explain Class
public class TwilightXboxController {

    // Private Class Members
    private final XboxController xb;
    private final int port;

    /* CONSTRUCTOR INITIALIZE CLASS MEMBERS*/
    public TwilightXboxController(int port) {
        this.port = port;
        xb = new XboxController(port);
    }

    // Enum With Functions To Grab Boolean Buttons
    public enum ButtonControl {
        A(1), B(2), X(3), Y(4),
        LEFT_BUMPER(5), RIGHT_BUMPER(6),
        BACK(7), START(8),
        LEFT_STICK(9), RIGHT_STICK(10);

        private int rawAxis;

        ButtonControl(int rawAxis) {
            this.rawAxis = rawAxis;
        }

        private Button getButton(XboxController xb) {
            return new JoystickButton(xb, rawAxis);
        }

        private boolean getButtonPressed(XboxController xb) {
            return xb.getRawButton(rawAxis);
        }
    }

    // Enum With Functions TO Grab Variable Axes
    public enum VariableControl {
        LEFT_STICK_X(true, true, GenericHID.Hand.kLeft), LEFT_STICK_Y(true, false, GenericHID.Hand.kLeft), LEFT_TRIGGER(false, false, GenericHID.Hand.kLeft),
        RIGHT_STICK_X(true, true, GenericHID.Hand.kRight), RIGHT_STICK_Y(true, false, GenericHID.Hand.kRight), RIGHT_TRIGGER(false, false, GenericHID.Hand.kRight);

        private boolean isStick;
        private boolean isX;
        private GenericHID.Hand hand;

        VariableControl(boolean isStick, boolean isX, GenericHID.Hand hand) {
            this.isStick = isStick;
            this.isX = isX;
            this.hand = hand;
        }

        private double getAxis(XboxController xb) {
            return isStick ? isX ? xb.getX(hand) : xb.getY(hand) : xb.getTriggerAxis(hand);
        }
    }

    // Set Controller Rumble
    public void setRumble(double rumbleLeft, double rumbleRight) {
        xb.setRumble(GenericHID.RumbleType.kLeftRumble, rumbleLeft);
        xb.setRumble(GenericHID.RumbleType.kRightRumble, rumbleRight);
    }

    // Get Value Of Selected Variable Axis
    public double getAxis(VariableControl variableControl) {
        return variableControl.getAxis(xb);
    }

    // Get Value Of Selected Boolean Axis
    public boolean getButtonPressed(ButtonControl buttonControl) {
        return buttonControl.getButtonPressed(xb);
    }

    // Get Button For Boolean Axis
    public Button getButton(ButtonControl buttonControl) {
        return buttonControl.getButton(xb);
    }

    // Check If Variable Axis Is At Rest
    public Button getAtRest(VariableControl variableControl) {
        return new Button() {
            @Override
            public boolean get() {
                return variableControl.getAxis(xb) == 0;
            }
        };
    }

    /* GET PRIVATE CLASS MEMBERS */
    public XboxController getXbMember() {
        return xb;
    }

    public int getPort() {
        return port;
    }
}