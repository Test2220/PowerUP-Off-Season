package frc.team2220.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2220.robot.subsystems.GaganDrive;
import frc.team2220.robot.subsystems.Shooter;

/*
The Robot class is the main class. It is ran by the roborio and therefore needs to include the various subsystems.
Usually this is accomplished by running them with the scheduler.
 */
public class Robot extends TimedRobot {

    // Instantiate Subsystems
    public static GaganDrive    gaganDrive;
    public static Shooter       shooter;

    // Instantiate OI For Controls
    public static OI          oi;

    @Override
    public void robotInit() {
        gaganDrive = new GaganDrive();
        oi = new OI();
    }

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
        gaganDrive.setPower(0.2);
    }
}