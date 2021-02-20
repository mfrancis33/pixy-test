package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.PixyCamSPI;

/**
 * A demonstration of various methods of using the PixyCam.
 * 
 * This was mainly created for using the SPI port to get information, however
 * there is another subsystem for using the analog/digital ports instead.
 */
public class Robot extends TimedRobot {

  public String gameData;

  public static PixyCamSPI PixyCamSPI;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit(){
    PixyCamSPI = new PixyCamSPI(0);
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