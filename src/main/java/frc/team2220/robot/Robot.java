package frc.team2220.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2220.robot.subsystems.*;
import frc.team2220.robot.subsystems.TwilightDrive;
import frc.team2220.robot.subsystems.Intake;

/*
The Robot class is the main class. It is ran by the roborio and therefore needs to include the various subsystems.
Usually this is accomplished by running them with the scheduler.
 */
public class Robot extends TimedRobot {

    // Instantiate Subsystems
    public static final TwilightDrive twilightDrive  = new TwilightDrive();
    public static final Shooter     shooter     = new Shooter();
    public static final Intake      intake      = new Intake();
    //public static final TwilightDrive   twilightDrive   = new TwilightDrive();
    //public static final Intake          intake          = new Intake();
    //public static final Limelight       limelight       = new Limelight();

    // Instantiate OI For Controls
    public static final OI          oi          =  new OI();

    @Override
    public void robotInit() { }

    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() { }

    @Override
    public void teleopInit() { }

    @Override
    public void testInit() { }

    @Override
    public void disabledPeriodic() { }
    
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
        //Scheduler.getInstance().run();
        twilightDrive.setPower(0.2);
    }
}