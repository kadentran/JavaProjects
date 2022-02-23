/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : InvalidCharacterException is a child class of
                    RuntimeException. The main purpose of the class is to
                    provide a custom exception for situations when the input to
                    a state is not a valid input for that state and is not an
                    invalid character which would require a different existing
                    exception.
*/

public class InvalidCharacterException extends RuntimeException{
    
    /**
     *
     */
    private static final long serialVersionUID = -3917054278773664763L;

    public InvalidCharacterException() {
        super("Encountered Invalid Character: Only digits 0-9, +, -, and newline characters are valid inputs");
    }
}
