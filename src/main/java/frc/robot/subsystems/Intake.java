package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;;

public class Intake extends SubsystemBase {

  public CANSparkMax intakeMotor;
  public CANSparkMax pivotMotor;
  public CANSparkMax pivotMotorFollower;

  public RelativeEncoder pivotEncoder;
  
  public Intake() {
    intakeMotor = new CANSparkMax(IntakeConstants.kIntakePort, CANSparkMaxLowLevel.MotorType.kBrushless);
    pivotMotor = new CANSparkMax(IntakeConstants.kPivotPort, CANSparkMaxLowLevel.MotorType.kBrushless);
    pivotMotorFollower = new CANSparkMax(IntakeConstants.kPivotFollowerPort, CANSparkMaxLowLevel.MotorType.kBrushless);

    pivotMotorFollower.follow(pivotMotor);

    pivotEncoder = pivotMotor.getEncoder();
    pivotEncoder.setPosition(0);
  }

  public void intakeBalls() {
    intakeMotor.set(IntakeConstants.kIntakePower);
  }

  public void extakeBalls() {
    intakeMotor.set(-IntakeConstants.kIntakePower);
  }

  public void stopIntake() {
    intakeMotor.set(0);
  }
 
  public void lowerIntake() {
    int loweredLimit = 10; // Idk what it is.
    if (pivotEncoder.getPosition() > loweredLimit) {
      pivotMotor.set(0.2);
    }
  }

  public void raiseIntake() {
    int raisedLimit = 20; //Idk what this is either. Can get info at meetings
    if (pivotEncoder.getPosition() < raisedLimit ) {
      pivotMotor.set(-0.2);
    }
  }
}
