package com.company;

//Scanner for user input: https://www.programiz.com/java-programming/basic-input-output
import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    // Matt Clark (0598737)
    // This Program will create a fibonacci sequence with a number of terms specified by the user
    // This will be done both through recursion and through iteration to find the pros and cons of each technique
    //Last push to GitHub - Feb 2nd, 2019 @ 3:32pm

    public static void main(String[] args) {
        // Assign Variables
        Integer terms = 0; //Number of terms user would like to calculate
        Integer num1 = 0; // First term to be added
        Integer num2 = 1; // Second term to be added
        Integer result = 1; //sum of num1 and num2

        //Welcome users
        System.out.println("Welcome, this program will create a Fibonacci series based on the number of terms set.");
        System.out.println("A Fibonacci series of numbers is characterized as the following: 0 1 1 2 3, where the sum of the previous two numbers equal the current number.");
        System.out.println();   // Blank Line for Spacing

        //Find amount of terms to calculate
        terms = getTerms(terms);

        //Testing if Iterative works
        fiboSeriesIte(terms, num1, num2);


        //End program
        System.out.println("Series Complete!");

    }// End of Main Method


    //Recursive Function
    //public int fiboSeriesRec(int terms, int num1, int num2){


    //}//End of recursive function


    //Iterative Function
    public static int fiboSeriesIte(int terms, int num1, int num2){
        Integer nextTerm;

            switch (terms) {
                case 1:
                    System.out.println(num1);
                    break;
                case 2:
                    System.out.println(num1);
                    System.out.println(num2);
                    break;
                default:
                    System.out.println(num1);
                    System.out.println(num2);
                    for (int i = 2; i<terms; i++) {
                        //print the next term
                        nextTerm = num1 + num2;
                        System.out.println(nextTerm);

                        //adjust num1 and num2
                        num2 = num1;
                        num1 = nextTerm;
                    }

            }
        return terms;

    }//End of iterative function


    //Integer Validation Method
    public static int getTerms(int terms)
    {
        // Create Scanner
        Scanner input = new Scanner(System.in);
        //Set terms
        terms = 0;

        //test input
        try {
            //ask for input
            System.out.println("How many terms would you like to calculate?");
            terms = input.nextInt();
        }
        //Handle error
        catch (InputMismatchException e) {
            System.out.println("Invalid Input: Please pick a Number of 1 or greater");
            System.out.println(" ");
            getTerms(terms);
        }

        if (terms < 1){
            System.out.println("Invalid Input: Please pick a Number of 1 or greater");
            System.out.println(" ");
            getTerms(terms);
        }

        //Return Value
        return terms;
    }//End of method


}//End of class