/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : LeadingZeroException is a child class of RuntimeException.
                    The main purpose of the class is to provide a custom
                    exception for situations when the input to a state is a
                    zero (0) and zero is not a valid input for that state.
*/

public class LeadingZeroException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8802568314331434207L;

    public LeadingZeroException() {
        super("Encountered Leading Zero: Leading zeros are not permitted in expressions");
    }

}