package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import frc.lib.util.CANSparkMaxUtil.Usage;

public final class Constants {
    
    /* Used for Constants Used Once On Initialization of Robot or Subsystems */
    public final static class Setup {

        /* Swerve Module Ids and Constants */
        public static final int[] moduleIDs = new int[] {0, 1, 2, 3};
        public static final int[] driveMotors = new int[] {3, 1, 7, 5};
        public static final int[] angleMotors = new int[] {4, 2, 8, 6};
        public static final int[] moduleCancoders = new int[] {12, 9, 11, 10};
        public static final double[] angleOffsets = new double[] {0, 0, 0, 0};
        public static final double[] xposition = new double[] {45, 45, -45, -45};

        /* Swerve Motor Inverts */
        public static final boolean driveInvert = false;
        public static final boolean angleInvert = false; //Set false for MK4 modules
    
    }

    public final static class Swerve {
        public static final double stickDeadband = 0.1;

        /* Drivetrain Calculation Constants */
        /* Input these units from center of swerve modules */
        public static final double trackWidth = Units.inchesToMeters(14.5);
        public static final double trackLength = Units.inchesToMeters(14.5);

        /* Input Current Wheel Diameter, Can Change Due To Amount Of Wear */
        public static final double wheelDiameter = 101.6 / 1000.0; // mm to m
        public static final double wheelCircimference = wheelDiameter * Math.PI;

        /* Gyro Direction Toggle */
        public static final boolean invertGyro = true; // Always ensure Gyro is CCW+ CW- (Clockwise is increasing rotation values)

        /* Cancoder Invert */
        public static final boolean canCoderInvert = true;

        /* Speed Settings */
        public static final double maxSpeed = 5.00; // meters per second
        public static final double maxAngularVelocity = 2.125; // radians per second

        /* Mk4i Module Gear Ratios */
        public static final double driveGearRatio = (6.75 / 1.0); // 6.75:1
        public static final double angleGearRatio = (150.0 / 7.0 / 1.0); // 150:7
    
        /* Made in Context of a Square Arrangement */
        public static final SwerveDriveKinematics swerveKinematics =
        new SwerveDriveKinematics(
            new Translation2d(trackLength / 2.0, trackWidth / 2.0),
            new Translation2d(trackLength / 2.0, -trackWidth / 2.0),
            new Translation2d(-trackLength / 2.0, trackWidth / 2.0),
            new Translation2d(-trackLength / 2.0, -trackWidth / 2.0));

        /* Drive Motor Characterization Values */
        /* {Static, Velocity, Acceleration} */    
        public static final double[] driveMotorsSVA = new double[] {0.3, 2.55, 0.135};

    }

    public static final class AutoConstants {
        
        public static final double kPXController = 1;
        public static final double kPYController = 1;
        public static final double kPThetaController = 1;
    
    }

    public final static class Electical {

        /* Base 12 Volt System */
        public static final double voltageComp = 12.0;

        /* Swerve Electrical Limits */
        public static final int driveCurrentLim = 80;
        public static final int angleCurrentLim = 20;

    }

    public final static class PID {

        /* Format {P, I, D, FF} */

        /* Swerve PIDs */
        public static final double[] drivePID = new double[] {0.3, 0.0, 0.0, 0.0};
        public static final double[] anglePID = new double[] {0.025, 0.0, 0.0, 0.0};

    }

    public final static class ConversionFactors {
        /* All numbers in 1 output to required input, or one wheel spin to motor spin */

        /* Swerve Drive Conversions */
        public static final double driveConversionPositionFactor = Swerve.wheelCircimference / Swerve.driveGearRatio;
        public static final double driveConversionVelocityFactor = driveConversionPositionFactor / 60 ; //rpm to rps
        
        public static final double angleConversionPositionFactor = 360.0 / Swerve.angleGearRatio;
        public static final double angleConversionVelocityFactor = angleConversionPositionFactor / 60 ; //rpm to rps

    }

    public final static class IdleModes {
        
        /* Swerve Idles */
        public static final IdleMode driveIdle = IdleMode.kBrake;
        public static final IdleMode angleIdle = IdleMode.kBrake;

    }

    public final static class Usages {

        /* Swerve Usages */
        public static final Usage driveUsage = Usage.kAll;
        public static final Usage angleUsage = Usage.kPositionOnly;

    }

}
