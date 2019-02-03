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
        Integer i = 0; //counter for recursive function


        //Welcome users
        System.out.println("Welcome, this program will create a Fibonacci series based on the number of terms set.");
        System.out.println("A Fibonacci series of numbers is characterized as the following: 0 1 1 2 3, where the sum of the previous two numbers equal the current number.");
        System.out.println();   // Blank Line for Spacing

        //Find amount of terms to calculate
        terms = getTerms(terms);

        //Testing if Iterative works
        fiboSeriesRec(terms, num1, num2, i);


        //End program
        System.out.println("Series Complete!");

    }// End of Main Method


    //Recursive Function - only call if terms > 2
    public static int fiboSeriesRec(int terms, int num1, int num2, int i){
        Integer nextTerm;

        //print only num1
        if(terms == 1) {
            System.out.println(num1);
            //increment counter far enough to stop recursion
            i = i+5;
        }

        if (i < 3) {
            //print first and second term
            System.out.println(num1);
            System.out.println(num2);
            //add 2 to the counter
            i = i+2;
        }

        //Begin recursion at terms > 3
        //Check to see if series is done
        if( i < terms) {
            //find and print next term
            nextTerm = num1 + num2;
            System.out.println(nextTerm);

            //Adjust num1 and num2
            num1 = num2;
            num2 = nextTerm;

            //Add 1 to the counter variable
            i++;

            //Call the function again (recursion)
            fiboSeriesRec(terms,num1,num2, i);
        }
        //useless return
        return i;
    }//End of recursive function


    //Iterative Function
    public static int fiboSeriesIte(int terms, int num1, int num2){
        //Set up term to be printed
        Integer nextTerm;

        //Print just the first or firstt 2 if specified
            switch (terms) {
                case 1:
                    System.out.println(num2);
                    break;
                case 2:
                    System.out.println(num2);
                    System.out.println(num1);
                    break;
                default:
                    //print first 2 terms
                    System.out.println(num2);
                    System.out.println(num1);
                    //loop to calculate the others
                    for (int i = 2; i<terms; i++) {
                        //print the next term
                        nextTerm = num1 + num2;
                        System.out.println(nextTerm);

                        //adjust num1 and num2
                        num1 = num2;
                        num2 = nextTerm;
                    }//end of loop
            }//end of switch
        //Useless return
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