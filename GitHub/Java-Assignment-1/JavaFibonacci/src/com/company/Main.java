package com.company;

//Scanner for user input: https://www.programiz.com/java-programming/basic-input-output
import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Matt Clark (0598737)
    // This Program will create a fibonacci sequence with a number of terms specified by the user
    // This will be done both through recursion and through iteration to find the pros and cons of each technique
    //Last push to GitHub - Feb 2nd, 2019 @ 3:32pm

    public static void main(String[] args) {
        // Assign Variables
        Integer terms = 0; //Number of terms user would like to calculate
        Integer firstNumber = 0; // First term to be added
        Integer secondNumber = 1; // Second term to be added

        //Welcome users
        System.out.println("Welcome, this program will create a Fibonacci series based on the number of terms set.");
        System.out.println("A Fibonacci series of numbers is characterized as the following: 0 1 1 2 3, where the sum of the previous two numbers equal the current number.");
        System.out.println();   // Blank Line for Spacing


        //Retrieve and test user input from getTerms
        terms = getTerms(terms);

        //Ask for which Calculation method to use
        


        //Recursive Function


        //Iterative Function


    }

    //Integer Validation Method
    public static int getTerms(int terms){
        // Create Scanner
        Scanner input = new Scanner(System.in);
        //Set terms
        terms = 0;

        //test input
        try {
            //ask for input
            System.out.println("How many terms would you like?");
            terms = input.nextInt();
        }
        //Handle error
        catch (InputMismatchException e) {
            System.out.println("Invalid Input: Please pick a Number of 1 or greater");
            getTerms(terms);
        }

        if (terms < 1){
            System.out.println("Invalid Input: Please pick a Number of 1 or greater");
            getTerms(terms);
        }
        //Return Value
        return terms;
    }//End of method

}//End of class