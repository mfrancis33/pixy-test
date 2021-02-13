package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.PixyCam;

/**
 * PIXY SPI EXAMPLE A few notes 1.) Two things need to be added to the
 * build.gradle file. See the attached tutorial document 2.) This code is for
 * using Chip Select 0 (CS0) and the onboard SPI Port 3.) If you are using SPI
 * mode, go into PixyMon and set the control mode to SPI
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  public String gameData;

  public static PixyCam PixyCam;

  @Override
  public void robotInit(){
    PixyCam = new PixyCam(0);
  }

  @Override
  public void robotPeriodic(){
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    CommandScheduler.getInstance().run();
    SmartDashboard.putString("Game Data", gameData);
  }

  @Override
  public void autonomousInit(){
    //
  }

  @Override
  public void autonomousPeriodic(){
    //
  }

  @Override
  public void teleopInit(){
    //
  }

  @Override
  public void teleopPeriodic(){
    //
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    //
  }
}