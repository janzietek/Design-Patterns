package agh.dp.state;


import agh.dp.state.States.IState;
import agh.dp.state.States.StartState;

public class Main {
    public static void main(String[] args){
        FiniteStateMachine FSM = new FiniteStateMachine();
        IState start = new StartState(FSM);
        FSM.setInitialState(start);
        boolean result = FSM.checkWord("abaaaa");

        System.out.println(result);
    }
}
