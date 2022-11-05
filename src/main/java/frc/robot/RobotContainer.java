package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
// import frc.robot.commands.climber.MoveClimb;
import frc.robot.commands.climber.MoveIntake;
// import frc.robot.commands.climber.MoveClimb.ClimberState;
import frc.robot.commands.climber.MoveIntake.IntakeState;
// import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;


public class RobotContainer {

  private final Joystick operatorJoystick = new Joystick(0);  

  private final POVButton operatorDpadUp = new POVButton(operatorJoystick, 0);
  private final POVButton operatorDpadDown = new POVButton(operatorJoystick, 180);

  private JoystickButton operatorAButton = new JoystickButton(operatorJoystick, 1);
  private JoystickButton operatorBButton = new JoystickButton(operatorJoystick, 2);
  private JoystickButton operatorXButton = new JoystickButton(operatorJoystick, 3);
  private JoystickButton operatorYButton = new JoystickButton(operatorJoystick, 4);

  // private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final Index index = new Index();
  
  public RobotContainer() {
    setDefaultCommands();
    configureButtonBindings();
  }

  public void setDefaultCommands() {
  }

  
  private void configureButtonBindings() {
    // operatorDpadUp.whileHeld(new MoveClimb(climber, ClimberState.UP));
    // operatorDpadDown.whileHeld(new MoveClimb(climber, ClimberState.DOWN));
    operatorAButton.whileHeld(new MoveIntake(intake, IntakeState.LOWER, index));
    operatorBButton.whileHeld(new MoveIntake(intake, IntakeState.RAISE, index));
    operatorXButton.whileHeld(new MoveIntake(intake, IntakeState.INTAKE, index));
    operatorYButton.whileHeld(new MoveIntake(intake, IntakeState.EXTAKE, index));
  }


  
  public Command getAutonomousCommand() {
    return null;
  }
}
