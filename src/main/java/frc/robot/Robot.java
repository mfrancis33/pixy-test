package frc.robot;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import io.github.pseudoresonance.pixy2api.*;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

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
  private Pixy2 pixycam;
  boolean isCamera = false ;
  // private SPILink spi;
  int state = -1;
  private int iter = 0;

  @Override
  public void robotInit(){
    //
  }

  @Override
  public void teleopInit(){
    pixycam = Pixy2.createInstance(Pixy2.LinkType.SPI);
  }

  @Override
  public void teleopPeriodic(){
    state = pixycam.init(1); // if no camera present, try to initialize
    isCamera = (state >= 0);
    SmartDashboard.putBoolean("Camera", isCamera); //publish if we areconnected
    pixycam.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1 , 48); //run getBlocks with arguments to have the camera
    //acquire target data
    ArrayList<Block> blocks = pixycam.getCCC().getBlockCache(); //assign the data to an ArrayList for convinience
    if (blocks.size() > 0) {
      double xcoord = blocks.get(0).getX(); // x position of the largest target
      double ycoord = blocks.get(0).getY(); // y position of the largest target
      String data = blocks.get(0).toString(); // string containing target info
      SmartDashboard.putBoolean("present", true); // show there is a target present
      SmartDashboard.putNumber("Xccord", xcoord);
      SmartDashboard.putNumber("Ycoord", ycoord);
      SmartDashboard.putString("Data", data);
    } else {
      SmartDashboard.putBoolean("present", false);
    }
    SmartDashboard.putNumber("size", blocks.size()); //push to dashboard how many targets are detected
    SmartDashboard.putNumber("iter", iter);
    iter++;
  }
}