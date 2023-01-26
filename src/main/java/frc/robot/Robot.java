// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private Joystick controller = new Joystick(0);

  private TalonSRX frontLeft = new TalonSRX(1);
  private TalonSRX backLeft = new TalonSRX(3);
  private TalonSRX frontRight = new TalonSRX(0);
  private TalonSRX backRight = new TalonSRX(2);

  private double speedL = 0;
  private double speedR = 0;

  @Override
  public void robotInit() {
    frontLeft.set(ControlMode.PercentOutput, 0);
    backLeft.set(ControlMode.PercentOutput, 0);
    frontRight.set(ControlMode.PercentOutput, 0);
    backRight.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    frontLeft.set(ControlMode.PercentOutput, 0);
    backLeft.set(ControlMode.PercentOutput, 0);
    frontRight.set(ControlMode.PercentOutput, 0);
    backRight.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void teleopPeriodic() {
    double rawSpeedL = -controller.getRawAxis(1);
    double rawSpeedR = -controller.getRawAxis(5);

    if(speedL > rawSpeedL) {
      speedL -= (speedL - rawSpeedL)/50;
    } else if(speedL <= rawSpeedL) {
      speedL += (rawSpeedL - speedL)/50;
    }

    
    if(speedR > rawSpeedR) {
      speedR -= (speedR - rawSpeedR)/50;
    } else if(speedR <= rawSpeedR) {
      speedR += (rawSpeedR - speedR)/50;
    }

    frontLeft.set(ControlMode.PercentOutput, speedL);
    backLeft.set(ControlMode.PercentOutput, speedL);
    frontRight.set(ControlMode.PercentOutput, -speedR);
    backRight.set(ControlMode.PercentOutput, -speedR);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
