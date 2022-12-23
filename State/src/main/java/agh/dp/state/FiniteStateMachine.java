package agh.dp.state;

import agh.dp.state.States.AcceptState;
import agh.dp.state.States.IState;
import agh.dp.state.States.RejectState;

public class FiniteStateMachine {
    private IState state;

    public boolean checkWord(String word){
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        builder.append(Character.MIN_VALUE);
        word = builder.toString();
        System.out.println(word);

        for (int i = 0; i < word.length(); i++) {
            state.GetNext(word.charAt(i));
        }

        if (state.getClass() == RejectState.class)
            return false;
        else if (state.getClass() == AcceptState.class)
            return true;
        else {
            System.out.println("Sth messed up");
            return true;
        }
    }

    public void changeState(IState newState){
        this.state = newState;
    }

    public void setInitialState(IState start) {
        this.state = start;
    }
}
