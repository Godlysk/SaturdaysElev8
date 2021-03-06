/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class MoveByAngleCommand extends CommandBase {
  
  DriveSubsystem driveSubsystem;
  double setpoint, error;
  
  /**
   * Creates a new MoveByAngleCommand.
   */
  public MoveByAngleCommand(DriveSubsystem driveSubsystem, double setpoint) {
    this.driveSubsystem = driveSubsystem;
    this.setpoint = setpoint;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.navx.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    this.error = this.setpoint - (RobotContainer.navx.getYaw());
    double correction = this.error * 0.1;
    driveSubsystem.moveByAngle(correction);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(this.error) <= (setpoint * 0.02));
  }
}
