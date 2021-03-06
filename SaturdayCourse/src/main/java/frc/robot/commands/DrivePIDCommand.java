/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DrivePIDCommand extends CommandBase {
  /**
   * Creates a new DrivePIDCommand.
   */

  DriveSubsystem driveSubsystem;
  
  public DrivePIDCommand(DriveSubsystem driveSubsystem) {

    this.driveSubsystem = driveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double yaxis = RobotContainer.getY(RobotContainer.joy1, Constants.deadband); // Adjusted Y
    double zaxis = RobotContainer.getZ(RobotContainer.joy1, Constants.deadband); // Adjusted Z
    
    if (Math.abs(zaxis) > Constants.turnThreshold) {
      driveSubsystem.arcadeInbuilt(yaxis, zaxis);
    } else {
      if (yaxis != 0) driveSubsystem.drivePIDNavX(yaxis); // driveSubsystem.drivePIDEncoder(yaxis);
      else driveSubsystem.drive(0, 0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
