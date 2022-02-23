/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : IncompleteExpressionException is a child class of
                    RuntimeException. The main purpose of the class is to
                    provide a custom exception for situations when the input to
                    a state is a newline character and the newline character is
                    not a valid input for that state.
*/

public class IncompleteExpressionException extends RuntimeException {
    
    /**
     *
     */
    private static final long serialVersionUID = 875121942557560352L;

    public IncompleteExpressionException() {
        super("Encountered Unexpected End of Expression: Expression must end with an operand");
    }
}
