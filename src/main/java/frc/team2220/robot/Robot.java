package frc.team2220.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team2220.robot.subsystems.GaganDrive;

public class Robot extends IterativeRobot {

    public static final GaganDrive  gaganDrive  = new GaganDrive();
    public static final OI          oi          = new OI();

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
    public void autonomousPeriodic() { }

    @Override
    public void teleopPeriodic() { }

    @Override
    public void testPeriodic() { }
}