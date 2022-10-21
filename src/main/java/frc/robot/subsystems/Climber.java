package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class Climber extends SubsystemBase{
    private CANSparkMax LeftPivotMotor;
    private CANSparkMax LeftClimbMotor;
    private CANSparkMax RightPivotMotor;
    private CANSparkMax RightClimbMotor;

    private RelativeEncoder LeftPivotEncoder;
    private RelativeEncoder LeftClimbEncoder;
    private RelativeEncoder RightPivotEncoder;
    private RelativeEncoder RightClimbEncoder;

    public Climber() {
        this.LeftPivotMotor = new CANSparkMax(ClimbConstants.kLeftPivotMotorPort, MotorType.kBrushless);
        this.LeftClimbMotor = new CANSparkMax(ClimbConstants.kLeftClimbMotorPort, MotorType.kBrushless);
        this.RightPivotMotor = new CANSparkMax(ClimbConstants.kLeftPivotMotorPort, MotorType.kBrushless);
        this.RightClimbMotor = new CANSparkMax(ClimbConstants.kLeftClimbMotorPort, MotorType.kBrushless);

        this.LeftPivotEncoder = LeftPivotMotor.getEncoder();
        this.LeftClimbEncoder = LeftClimbMotor.getEncoder();
        this.RightPivotEncoder = RightPivotMotor.getEncoder();
        this.RightClimbEncoder = RightClimbMotor.getEncoder();
    }

    public void climbUp() {
        LeftClimbMotor.set(-ClimbConstants.kClimbSpeed);
        RightClimbMotor.set(ClimbConstants.kClimbSpeed);
    }

    public void climbDown() {
        LeftClimbMotor.set(ClimbConstants.kClimbSpeed);
        RightClimbMotor.set(-ClimbConstants.kClimbSpeed);
    }

    public void climbStop() {
        LeftClimbMotor.set(0);
        RightClimbMotor.set(0);
    }

    public void pivotOut() {
        LeftPivotMotor.set(-ClimbConstants.kPivotSpeed);
        RightPivotMotor.set(ClimbConstants.kPivotSpeed);
    }

    public void pivotIn() {
        LeftPivotMotor.set(ClimbConstants.kPivotSpeed);
        RightPivotMotor.set(-ClimbConstants.kPivotSpeed);
    }

    public void pivotStop() {
        LeftPivotMotor.set(0);
        RightPivotMotor.set(0);
    }

}
