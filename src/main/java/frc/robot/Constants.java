package frc.robot;

public final class Constants {
    public static final class ClimbConstants {
        public static final int kLeftPivotMotorPort = 16;
        public static final int kLeftClimbMotorPort = 18;
        public static final int kRightPivotMotorPort = 19;
        public static final int kRightClimbMotorPort = 17;

        public static final double kPivotSpeed = 0.1;
        public static final double kClimbSpeed = 1;
    }

    public static final class IntakeConstants {
        public static final int kIntakePort = 12;
        public static final int kPivotPort = 14;
        public static final int kPivotFollowerPort = 20;

        public static final int kIntakePower = 1;
    }

    public static final class IndexConstants {
        public static final int kIndexMotorPort = 15;
        public static final int kRollerMotorPort = 13;
    }
}
