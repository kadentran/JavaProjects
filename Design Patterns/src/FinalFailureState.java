/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : FinalFailureState is a singleton child class of abstract
                    class State. The main purpose of this class is to represent
                    a state from the expression evaluator fsm which follows the
                    evaluation of a character which is not allowed in the
                    the current state and is one of two final states of the fsm. 
*/

public class FinalFailureState extends State{
    // private variable of same type as class to store an instance of this singleton class
    private static FinalFailureState finalFailInstance;
    
    // private constructor for instance of this singleton class
    private FinalFailureState() {

    }

    // public method to create an instance of this singleton class
    public synchronized static FinalFailureState instance() {
        if (finalFailInstance == null) {
            finalFailInstance = new FinalFailureState();
        }
        return finalFailInstance;
    }

    // override function for evaluateCharacter to handle state transition
    @Override
    public void evaluateCharacter(Calculator calculator, char c) {
        // evaluateCharacter should never be reached while the fsm is in this
        // state. The message below is output to help identify if an exception
        // is not thrown immediately after the fsm moves to this state.
        System.out.println("Unexpected evaluation in FinalFailureState");

    }
    
}
