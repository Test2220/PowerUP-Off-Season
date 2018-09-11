package frc.team2220.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2220.robot.subsystems.GaganDrive;
import frc.team2220.robot.subsystems.Shooter;

public class Robot extends IterativeRobot {

    //Creates a static instance of the subsystem GaganDrive
    public static final GaganDrive  gaganDrive  = new GaganDrive();
    public static       OI          oi          = null;
    public static final Shooter shooter = new Shooter();

    @Override
    public void robotInit() {
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
    public void autonomousPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
}