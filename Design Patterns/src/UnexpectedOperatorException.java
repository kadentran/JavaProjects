/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : UnexpectedOperatorException is a child class of
                    RuntimeException. The main purpose of the class is to
                    provide a custom exception for situations when the input to
                    a state is an addition symbol (+) or a subtraction symbol
                    (-) and that symbol is not a valid input for that state.
*/

public class UnexpectedOperatorException extends RuntimeException{
    
    /**
     *
     */
    private static final long serialVersionUID = -8205214810708974244L;

    public UnexpectedOperatorException() {
        super("Encountered Unexpected Operator: Operators are only allowed after an operand");
    }
}
