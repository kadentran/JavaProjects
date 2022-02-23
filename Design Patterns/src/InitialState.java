/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : InitialState is a singleton child class of abstract class
                    State. The main purpose of this class is to represent the
                    initial state of the expression evaluator fsm which only
                    accepts digits 1-9 and the newline character as valid
                    input.
*/

public class InitialState extends State {
    // private variable of same type as class to store an instance of this singleton class
    private static InitialState iInstance;
    
    // private constructor for instance of this singleton class
    private InitialState() {

    }

    // public method to create an instance of this singleton class
    public synchronized static InitialState instance() {
        if (iInstance == null) {
            iInstance = new InitialState();
        }
        return iInstance;
    }

    // override function for evaluateCharacter to handle state transition
    @Override
    public void evaluateCharacter(Calculator calculator, char c) {
        // if input character is between 0 and 9 (inclusive), then utilize the
        // Context to update operand (N) and result (T) and set current state
        // to an instance of FirstOperandState
        if (c>='1' && c<='9') {
            calculator.updateFirstOperand(Integer.parseInt(String.valueOf(c)));
            calculator.setState(FirstOperandState.instance());
        }
        // if input is newline character, utilize the Context to display the
        // result of the expression and set current state to an instance of
        // FinalSuccessState
        else if (c=='\n') {
            calculator.displayResult();
            calculator.setState(FinalSuccessState.instance());
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
