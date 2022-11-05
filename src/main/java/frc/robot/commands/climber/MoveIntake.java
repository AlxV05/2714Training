// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

  private Intake intake;
  private IntakeState intakeState;
  private Index index;
  
  public MoveIntake(Intake intake, IntakeState intakeState, Index index) {
    this.intake = intake;
    this.intakeState = intakeState;
    this.index = index;
  }

  
  public enum IntakeState {
    INTAKE,
    EXTAKE,
    LOWER,
    RAISE,
    STOP;
  }

  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    switch(intakeState) {
      case INTAKE:
        intake.intakeBalls();
        //index.moveAll(0.75);
        break;
      case EXTAKE:
        intake.extakeBalls();
        //index.moveAll(-0.75);
        break;
      case STOP:
        //intake.raiseIntake();
        intake.stopIntake();
        //index.stopAll();
        break;
      case LOWER:
        intake.lowerIntake();
        break;
      case RAISE:
        intake.raiseIntake();
        break;
    }
  }

  
  @Override
  public void end(boolean interrupted) {
    //intake.raiseIntake();
    intake.stopIntake();
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
