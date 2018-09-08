package frc.team2220.robot;

/*
The Robot Map Class is here to identify what CAN IDs represent what robot member.
They are usually defined in all capital letters with underscores and the annotation "public static final" as that is the
standard for constants.
Not only robot members have to go here, but anything constant relating to the control of the robot.
 */
public class RobotMap {

    // Drivetrain Talon IDs
    public static final int
            LEFT_DRIVE_MASTER = 1,
            LEFT_DRIVE_SLAVE = 2;

    public static final int
            RIGHT_DRIVE_MASTER = 3,
            RIGHT_DRIVE_SLAVE = 5;

    // Shooter Motor Controllers TODO TBD ID Values
    public static final int
            SHOOTER_TOP_RIGHT = 0,
            SHOOTER_TOP_LEFT = 0,
            SHOOTER_BOTTOM_RIGHT = 0,
            SHOOTER_BOTTOM_LEFT = 0;

    // Pneumatics Controllers TODO TBD ID Values
    public static final int
            CUBE_PISTON_UP = 0,
            CUBE_PISTON_DOWN = 0;

    // Xbox Controller IDs
    public static final int
            XBOX_DRIVER = 0,
            XBOX_MANIPULATOR = 1;
}