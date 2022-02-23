/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : FinalSuccessState is a singleton child class of abstract
                    class State. The main purpose of this class is to represent
                    a state from the expression evaluator fsm which follows the
                    evaluation of a newline character in a state which accepts
                    the newline character as valid input. FinalSuccessState is
                    one of two final states of the fsm.
*/

public class FinalSuccessState extends State{
    // private variable of same type as class to store an instance of this singleton class
    private static FinalSuccessState finalSuccessInstance;
    // private constructor for instance of this singleton class
    private FinalSuccessState() {

    }

    // public method to create an instance of this singleton class
    public synchronized static FinalSuccessState instance() {
        if (finalSuccessInstance == null) {
            finalSuccessInstance = new FinalSuccessState();
        }
        return finalSuccessInstance;
    }

    // override function for evaluateCharacter to handle state transition
    @Override
    public void evaluateCharacter(Calculator calculator, char c) {
        // evaluateCharacter should never be reached while the fsm is in this
        // state. The message below is output to help identify if an exception
        // is not thrown immediately after the fsm moves to this state.
        System.out.println("Unexpected evaluation in FinalSuccessState");

    }
    
}
