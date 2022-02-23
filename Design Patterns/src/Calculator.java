/*
Name            : See Controller.java for submitter's name
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : Calculator is a class that serves as context for the
                    expression evaluator.
*/

public class Calculator {
    
    // public variables to be used by states
    public int operand;         // represented in FSM as N
    public int result;          // represented in FSM as T
    public State currentState;  // represents current state in FSM

    // constructor initializes both N and T to 0, moves context to initial state
    public Calculator() {
        operand = 0;
        result = 0;
        currentState = InitialState.instance();
    }

    // getter for operand
    public int getOperand() {
        return operand;
    }

    // getter for result
    public int getResult() {
        return result;
    }
    
    // getter for currentState
    public State getState() {
        return currentState;
    }

    // method to be used by states to move context to the next state in FSM
    public void setState(State s) {
        currentState = s;
    }

    // method to evaluate character in current state
    public void evaluateCharacter(char c) {
        currentState.evaluateCharacter(this, c);
    }

    // method to display result of the expression
	public void displayResult() {
        System.out.println("Result: " + result);
    }

    // method to update the operand (N) as digits are added if no operator has
    // been entered into the expression yet
    public void updateFirstOperand(int i){
        operand = (operand * 10) + i;
        result = operand;
    }

    // method to update the operand (N) as digits are added if an operator has
    // already been entered into the expression
    public void updateSecondOperand(int i){
        operand = (operand * 10) + i;
    }

    // method to add current operand (N) and result (T)
    public void addOperands(){
        result = result + operand;
    }

    // method to subtract current operand (N) from result (T)
    public void subtractOperands() {
        result = result - operand;
    }

    // method to reset the operand
    public void clearOperand() {
        operand = 0;
    }

}
