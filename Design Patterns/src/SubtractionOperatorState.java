/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : SubtractionOperatorState is a singleton child class of
                    abstract class State. The main purpose of this class is to
                    represent a state from the expression evaluator fsm which
                    follows the evaluation of a subtraction symbol (-) and only
                    accepts digits 1-9 as a valid input.
*/

public class SubtractionOperatorState extends State {
    // private variable of same type as class to store an instance of this singleton class
    private static SubtractionOperatorState subInstance;
    
    // private constructor for instance of this singleton class
    private SubtractionOperatorState() {

    }

    // public method to create an instance of this singleton class
    public synchronized static SubtractionOperatorState instance() {
        if (subInstance == null) {
            subInstance = new SubtractionOperatorState();
        }
        return subInstance;
    }

    // override function for evaluateCharacter to handle state transition
    @Override
    public void evaluateCharacter(Calculator calculator, char c) {
        // if input character is between 1 and 9 (inclusive), then utilize
        // the Context to update the opperand (N) and set current
        // state to an instance of SecondAdditionOperandState
        if (c>='1' && c<='9') {
        	calculator.updateSecondOperand(Integer.parseInt(String.valueOf(c)));
            calculator.setState(SecondSubtractionOperandState.instance());
        }
        // if input is newline character, set current state to
        // FinalFailureState and throw IncompleteExpressionException
        else if (c=='\n') {
            calculator.setState(FinalFailureState.instance());
            throw new IncompleteExpressionException();
        }
        // if input character is 0, set current state to FinalFailureState
        // and throw LeadingZeroException
        else if (c=='0') {
            calculator.setState(FinalFailureState.instance());
            throw new LeadingZeroException();
        }
        // if input character is + or -, set current state to FinalFailureState
        // and throw UnexpectedOperatorException
        else if (c=='+' || c=='-') {
            calculator.setState(FinalFailureState.instance());
            throw new UnexpectedOperatorException();
        }
        // if input character is any other character, set current state to
        // FinalFailureState and throw InvalidCharacterException
        else {
            calculator.setState(FinalFailureState.instance());
            throw new InvalidCharacterException();
        }

    }
    
}
