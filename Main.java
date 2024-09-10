/**
 * The program should run automatically once executed, and the user should
 * have the option to switch between tasks and execute them as needed.
 * The program below will run the following operations:
 		-> Valid Parentheses Combination Generator 		-> Digit Sum Loop(String) 
 		-> Consecutive Number Summer 					-> Caesar Cipher with Shift Variability 
 						-> Encoding Challenge with ASCII Conversion 
 * Owner: Suhani Mathur
 * Date of creation: 10 Sep 2024
 */
package com.Studyopedia;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Main Menu:");
            System.out.println("1. Generate combinations");
            System.out.println("2. Digit sum loop");
            System.out.println("3. Find Consecutive Sums");            
            System.out.println("4. Caesar Cipher");
            System.out.println("5. Encoding in ASCII Code.");
            System.out.println("6. Exit");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                   Operations.generateCombinations();
                    break;
                case "2":
                	Operations.digitSumLoop();
                    break;
                case "3":
                	Operations.findConsecutiveSums();
                	break;
                case "4" :
                	Operations.caesarCipher();
                	break;
                case "5":                	
                	Operations.Encoding();
                	break;
                case "6":
                    continueProgram = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option! Please choose a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}



