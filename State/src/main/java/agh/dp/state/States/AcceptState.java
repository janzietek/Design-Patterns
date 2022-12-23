package agh.dp.state.States;

import agh.dp.state.FiniteStateMachine;

public class AcceptState implements IState{
    private final FiniteStateMachine Fsm;

    public AcceptState(FiniteStateMachine fsm) {
        this.Fsm = fsm;
    }

    @Override
    public void GetNext(char letter) {
        Fsm.changeState(new RejectState(this.Fsm));
    }
}
