package org.wildstang.sample.robot;

import java.util.Map;

/**
 * CAN Constants are stored here.
 * We primarily use CAN to communicate with Talon motor controllers.
 * These constants must correlate with the IDs set in Phoenix Tuner.
 * Official documentation can be found here:
 * https://phoenix-documentation.readthedocs.io/en/latest/ch08_BringUpCAN.html
 */
public final class CANConstants {

    // Replace these examples.
    // While not independently dangerous if implemented these could have unintended effects.
    //public static final int[] EXAMPLE_PAIRED_CONTROLLERS    = {1,2};
    //public static final int   EXAMPLE_MOTOR_CONTROLLER      = 3;

    public static final int DRIVE_LEFT_FRONT      =  1;
    public static final int DRIVE_LEFT_REAR       =  2;
    public static final int DRIVE_RIGHT_FRONT     =  3;
    public static final int DRIVE_RIGHT_REAR      =  4;
    public static final int TURRET_FLYWHEEL_LEFT  =  5;
    public static final int TURRET_FLYWHEEL_RIGHT =  6;
    public static final int CLIMB_LEFT            =  7; // removed
    public static final int CLIMB_RIGHT           =  8; // removed
    public static final int TURRET_HOOD           =  9;
    public static final int TURRET_ANGLE          = 11;
    public static final int INTAKE                = 10;
    public static final int HOPPER_1              = 12;
    public static final int HOPPER_2_3            = 14;
    public static final int TURRET_KICKER         = 13;
}