package agh.dp.state.States;

import agh.dp.state.FiniteStateMachine;

public class AcceptState implements IState {
    private final FiniteStateMachine Fsm;

    public AcceptState(FiniteStateMachine fsm) {
        this.Fsm = fsm;
    }

    @Override
    public void GetNext(char letter) {
        IState nextState;
        switch (letter) {
            case Character.MIN_VALUE -> {
                this.Fsm.changeState(this);
            }
            default -> {
                nextState = new RejectState(Fsm);
                this.Fsm.changeState(nextState);
            }
        }
    }
}
