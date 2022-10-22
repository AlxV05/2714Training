package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.climber.MoveClimb;
import frc.robot.commands.climber.MoveClimb.ClimberState;
import frc.robot.subsystems.Climber;


public class RobotContainer {

  private final Joystick operatorJoystick = new Joystick(1);

  private final POVButton operatorDpadUp = new POVButton(operatorJoystick, 0);
  private final POVButton operatorDpadDown = new POVButton(operatorJoystick, 180);

  private final Climber climber = new Climber();
  
  public RobotContainer() {
    climber.setDefaultCommand(new MoveClimb(climber, ClimberState.STOP));
    configureButtonBindings();
  }

  
  private void configureButtonBindings() {
    operatorDpadUp.whileHeld(new MoveClimb(climber, ClimberState.UP));
    operatorDpadDown.whileHeld(new MoveClimb(climber, ClimberState.DOWN));
  }


  
  public Command getAutonomousCommand() {
    return null;
  }
}
