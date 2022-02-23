/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : SecondAdditionOperandState is a singleton child class of
                    abstract class State. The main purpose of this class is to
                    represent a state from the expression evaluator fsm which
                    follows the evaluation of the first digit of an operand
                    which appears after an addition symbol (+).
                    SecondAdditionOperandState only accepts digits 0-9, an
                    addition symbol (+), a subtraction symbol (-), and the
                    newline character as valid input.
*/

public class SecondAdditionOperandState extends State {
    // private variable of same type as class to store an instance of this singleton class
    private static SecondAdditionOperandState secondAddInstance;
    
    // private constructor for instance of this singleton class
    private SecondAdditionOperandState() {

    }

    // public method to create an instance of this singleton class
    public synchronized static SecondAdditionOperandState instance() {
        if (secondAddInstance == null) {
            secondAddInstance = new SecondAdditionOperandState();
        }
        return secondAddInstance;
    }
    
    // override function for evaluateCharacter to handle state transition
    @Override
    public void evaluateCharacter(Calculator calculator, char c) {
        // if input character is between 0 and 9 (inclusive), then utilize the
        // Context to update operand (N). The current state is not updated
        // since the expected behavior of the fsm for this input in this state
        // is to remain in the same state.
        if (c>='0' && c<='9') {
            calculator.updateSecondOperand(Integer.parseInt(String.valueOf(c)));                    	
        }
        // if input is newline character, utilize the Context to add operand
        // (N) to result (T) and display the result of the expression and set
        // current state to an instance of FinalSuccessState
        else if (c=='\n') {
        	calculator.addOperands();
            calculator.displayResult();
            calculator.setState(FinalSuccessState.instance());
        }
        // if input charcter is an addition symbol (+), utilize the Context to
        // add operand (N) to result (T), reset the operand (N) to 0, and set
        // current state to AdditionOperatorState
        else if (c=='+') {
        	calculator.addOperands();
        	calculator.clearOperand();
            calculator.setState(AdditionOperatorState.instance());            
        }
        // if input charcter is an subtraction symbol (-), utilize the Context
        // to add operand (N) to result (T), reset the operand (N) to 0, and
        // set current state to SubtractionOperatorState
        else if (c=='-') {
        	calculator.addOperands();
        	calculator.clearOperand();
            calculator.setState(SubtractionOperatorState.instance());            
        }
        // if input character is any other character, set current state to
        // FinalFailureState and throw InvalidCharacterException
        else {
            calculator.setState(FinalFailureState.instance());
            throw new InvalidCharacterException();
        }

    }
    
}
