package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class MoveClimb extends CommandBase{
    public Climber climber;
    private ClimberState climberState;
    
    public MoveClimb(Climber climber, ClimberState climberState) {
        this.climber = climber;
        this.climberState = climberState;
    }

    public enum ClimberState {
        UP,
        DOWN,
        STOP
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        switch(climberState) {
            case UP:
                climber.climbUp();
            case DOWN:
                climber.climbDown();
            case STOP:
                climber.climbStop();
        }
    }

    @Override
    public void end(boolean interrupted) {
        climber.climbStop();
    }

    @Override 
    public boolean isFinished() {
        return false;
    }
}
