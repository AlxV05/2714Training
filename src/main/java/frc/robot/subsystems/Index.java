package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexConstants;

public class Index extends SubsystemBase {

  private CANSparkMax indexMotor;
  private CANSparkMax rollerMotor;

  
  public Index() {
    indexMotor = new CANSparkMax(IndexConstants.kIndexMotorPort, CANSparkMaxLowLevel.MotorType.kBrushless);
    rollerMotor = new CANSparkMax(IndexConstants.kRollerMotorPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  public void moveIndex(double power) {
    indexMotor.set(power);
  }

  public void moveRoller(double power) {
    rollerMotor.set(-power);
  }

  public void moveAll(double power) {
    moveIndex(power);
    moveRoller(power);
  }
        
  public void stopAll() {
    moveAll(0);
  }
}
