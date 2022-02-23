/*
Name            : Kaden Tran (stt032000)
Group           : Group 3 - Kaden Tran, Stanley Varghese, and Michael Perdue
Assignment      : SE6329.MS1 Homework 03
Date            : September 26, 2020
Class Summary   : Class containing main method to test/use expression evaluator
*/

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        // Create new Calculator object which will serve as the context for FSM
        Calculator calculator = new Calculator();
        
        // Ask user for expression and store user input (plus newline) as expression.
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter expression: ");
        String expression = scanner.nextLine() + "\n";
        scanner.close();
        
        // Iterate through each character in expression and evaluate it via the the Calculator context
        for (int i = 0; i < expression.length(); i++) {
            calculator.evaluateCharacter(expression.charAt(i));
        }
    }
}
