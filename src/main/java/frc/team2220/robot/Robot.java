package frc.team2220.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.sun.media.jfxmedia.logging.Logger;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2220.robot.subsystems.GaganDrive;

import javax.naming.ldap.Control;

public class Robot extends TimedRobot {

    public static GaganDrive  gaganDrive  = null;
    public static OI          oi          = null;

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