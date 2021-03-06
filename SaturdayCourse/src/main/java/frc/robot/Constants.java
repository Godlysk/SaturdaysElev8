/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int FR_port = 1;
    public static final int FL_port = 2;
    public static final int BR_port = 3; 
    public static final int BL_port = 4;

    public static final int SF_port = 0;
    public static final int SR_port = 1;

    public static final int brakeButtonNumber = 2;
    public static final int boostButtonNumber = 3;
    public static final int solenoidButtonNumber = 6;

    public static double maxSpeed = 0.5;
    public static final double deadband = 0.05;
    public static final double turnThreshold = 0.2;
    public static final double integralResetBound = 0.2;

    public static final double kPEncoder = 0.001;
    public static final double kIEncoder = 0.001;
    public static final double kDEncoder = 0.001;

    public static final double kPNavX = 0.001;
    public static final double kINavX = 0.001;
    public static final double kDNavX = 0.001;


}
