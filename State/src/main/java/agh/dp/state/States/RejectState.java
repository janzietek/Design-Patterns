package agh.dp.state.States;

import agh.dp.state.FiniteStateMachine;

public class RejectState implements IState{
    private final FiniteStateMachine Fsm;

    public RejectState(FiniteStateMachine fsm) {
        this.Fsm = fsm;
    }

    @Override
    public void GetNext(char letter) {
        Fsm.changeState(this);
    }
}
