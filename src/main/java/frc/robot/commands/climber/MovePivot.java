package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class MovePivot extends CommandBase{
    public Climber climber;
    private PivotState pivotState;
    
    public MovePivot(Climber climber, PivotState pivotState) {
        this.climber = climber;
        this.pivotState = pivotState;
    }

    public enum PivotState {
        OUT,
        IN,
        STOP
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        switch(pivotState) {
            case OUT:
                climber.pivotOut();
                break;
            case IN:
                climber.pivotIn();
                break;
            case STOP:
                climber.pivotStop();
                break;
        }
    }

    @Override
    public void end(boolean interrupted) {
        climber.pivotStop();
    }

    @Override 
    public boolean isFinished() {
        return false;
    }
}
