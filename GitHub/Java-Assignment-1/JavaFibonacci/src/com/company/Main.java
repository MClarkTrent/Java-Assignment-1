package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    // Matt Clark (0598737)
    // This Program will create a fibonacci sequence with a number of terms specified by the user
    // This will be done both through recursion and through iteration to find the pros and cons of each technique

    public static void main(String[] args) {
        // Assign Variables
        Integer terms = 0; //Number of terms user would like to calculate
        Long num1 = 0L; // First term to be added
        Long num2 = 1L; // Second term to be added
        Integer i = 0; //counter for recursive function
        String calcChoice = null; //User chooses calculation method


        //timer variables
        Long startTime = null;
        Long endTime = null;


        //Welcome users
        System.out.println("Welcome, this program will create a Fibonacci series based on the number of terms set.");
        System.out.println("A Fibonacci series of numbers is characterized as the following: 0 1 1 2 3, where the sum of the previous two numbers equal the current number.");
        System.out.println();   // Blank Line for Spacing

        //Find amount of terms to calculate
        terms = getTerms(terms);

        //Choose a calculation method
        calcChoice = getCalc(calcChoice);
        //choose function based off of choice, double check input, time calculation
        switch(calcChoice){
            case "rec":
                startTime = System.nanoTime();
                fiboSeriesRec(terms,num1,num2,i);
                endTime = System.nanoTime();
                break;
            case "ite":
                startTime = System.nanoTime();
                fiboSeriesIte(terms,num1,num2);
                endTime = System.nanoTime();
                break;
            default:
                System.out.println("Error detected: Closing program.");
                System.exit(1);
                break;
        }

        //End program messages
        System.out.println("Series Complete!");
        System.out.println(" ");

        //Method
        System.out.println("Calculation Method: "+calcChoice);
        //number of terms
        System.out.println("Number of Terms: "+terms);
        //Print Timer details
        System.out.println("Total Time: "+(endTime - startTime)+" Nano Seconds");


    }// End of Main Method


    //Recursive Function - only call if terms > 2
    public static int fiboSeriesRec(int terms, long num1, long num2, int i){
         //local variables
        Long nextTerm;

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
    public static int fiboSeriesIte(int terms, long num1, long num2){
        //Set up term to be printed
        Long nextTerm;

        //Print just the first or first 2 if specified
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
        //Local Variables
        terms = 0;//Set terms
        Boolean goodNumber; //check that input is int
        Boolean checkNum; //check that num is valid (avoid double error printing)

        //Input test loop
        do {
            //reset good number check
            goodNumber = true;
            checkNum = true;

            //test input for integer
            try {
                // Create Scanner
                Scanner input = new Scanner(System.in);
                //ask for input
                System.out.println("How many terms would you like to calculate: ");
                terms = input.nextInt();
            }
            //Handle error
            catch (InputMismatchException ex) {
                System.out.println("Invalid Input: Please pick a Number");
                System.out.println(" ");
                goodNumber = false;
                checkNum = false; //retry input
            }
            //Check against negative numbers or 0
            if (terms < 1 & checkNum) {
                System.out.println("Invalid Input: Please pick a Number of 1 or greater");
                System.out.println(" ");
                goodNumber = false; //retry input
            }
        }while(!goodNumber);
        //Return Value
        return terms;
    }//End of method


    //Calculation Choice Validation
    public static String getCalc(String calcChoice){
        //Bool variable for loop check
        Boolean calccheck = false;
       do {
           // Create Scanner
           Scanner input = new Scanner(System.in);
           //Ask for inputs
           System.out.println("What type of calculation method would you like to use?");
           System.out.println("type rec for recursive or ite for iterative: ");
           calcChoice = input.next();

           //Check inputs
           switch (calcChoice) {
               case "ite":
                   calccheck = true;
                   break;
               case "rec":
                   calccheck = true;
                   break;
               //if requirements not met, re-call method
               default:
                   System.out.println("Invalid Input: please choose from the stated options.");
                   System.out.println(" ");
                   break;
           }//end of switch
       }while(!calccheck);

       //return value
       return calcChoice;
    }//End of method

}//End of class