package agh.dp.state;


import agh.dp.state.States.IState;
import agh.dp.state.States.StartState;

public class Main {
    public static void main(String[] args){
        IState start = new StartState();
        FiniteStateMachine FSM = new FiniteStateMachine(start);
        FSM.checkWord("aaaaaa");
    }
}
