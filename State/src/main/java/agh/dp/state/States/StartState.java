package agh.dp.state.States;

import agh.dp.state.FiniteStateMachine;

public class StartState implements IState{
    private FiniteStateMachine Fsm;

    public StartState(FiniteStateMachine fsm) {
        this.Fsm = fsm;
    }

    @Override
    public void GetNext(char letter) {
        IState nextState;
        switch (letter) {
            case 'a' -> {
                nextState = new AState(Fsm);
                this.Fsm.changeState(nextState);
            }
            case 'b' -> {
                nextState = new BState(Fsm);
                this.Fsm.changeState(nextState);
            }
            case 'c' -> {
                nextState = new CState(Fsm);
                this.Fsm.changeState(nextState);
            }
        }
    }
}
