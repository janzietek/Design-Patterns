package agh.dp.state.States;

import agh.dp.state.FiniteStateMachine;

public class BState implements IState{
    private FiniteStateMachine Fsm;

    public BState(FiniteStateMachine fsm) {
        this.Fsm = fsm;
    }

    @Override
    public void GetNext(char letter) {
        IState nextState;
        switch (letter) {
            case 'a', Character.MIN_VALUE -> {
                nextState = new AcceptState(Fsm);
                this.Fsm.changeState(nextState);
            }
            case 'b' -> {
                nextState = new BState(Fsm);
                this.Fsm.changeState(nextState);
            }
            case 'c' -> {
                nextState = new RejectState(Fsm);
                this.Fsm.changeState(nextState);
            }
            default -> {
                nextState = new RejectState(Fsm);
                this.Fsm.changeState(nextState);
            }
        }
    }
}
