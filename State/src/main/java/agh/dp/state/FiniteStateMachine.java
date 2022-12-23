package agh.dp.state;

import agh.dp.state.States.IState;

public class FiniteStateMachine {
    private IState state;

    public FiniteStateMachine(IState initialState) {
        this.state = initialState;
    }

    public void checkWord(String word){
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            System.out.println(letter);
        }
    }

    public void changeState(IState newState){
        this.state = newState;
    }
}
