package com.company;

//Scanner for user input: https://www.programiz.com/java-programming/basic-input-output
import java.util.Scanner;

public class Main {
    // Matt Clark (0598737)
    // This Program will create a fibonacci sequence with a number of terms specified by the user
    // This will be done both through recursion and through iteration to find the pros and cons of each technique
    //Last commit to GitHub - Feb 2nd, 2019 @

    public static void main(String[] args) {
        // Assign Variables
        Integer terms = 0; //Number of terms user would like to calculate
        Integer firstNumber = 0; // First term to be added
        Integer secondNumber = 1; // Second term to be added

        // Create Scanner
        Scanner input = new Scanner(System.in);

        //Welcome users
        System.out.println("Welcome, this program will create a Fibonacci series based on the number of terms set.");
        System.out.println("A Fibonacci series of numbers is characterized as the following: 0 1 1 2 3, where the sum of the previous two numbers equal the current number.");
        System.out.println();   // Blank Line for Spacing

        //Ask for user input
        System.out.println("How long would you like the series?");
        //Read input
        terms = input.nextInt();

        System.out.println(terms);

    }
}