package com.Studyopedia;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;
        while (continueProgram) {
        	
            System.out.println("Main Menu:");
            System.out.println("1.Count Palindrome");
            System.out.println("2. Nth Fibonacci Series ");
            System.out.println("3. Snake To Camel");
            System.out.println("4. Count Consonants");
            System.out.println("5. Binary to decimal");
            System.out.println("6. Exit");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                	TaskOperations.CountPalindrome();
                    break;
                case "2":
                	TaskOperations.nthfibonacci();
                    break;
                case "3" :
                	TaskOperations.CamelAndSnakeCase();
                	break;
                case "4" :
                	TaskOperations.countConsonants();
                	break;
                case "5" :                	
                	TaskOperations.convertBinaryToDecimalInput();
                	break;
                case "6":
                	System.out.println("Exiting....");
                	continueProgram = false;
                	break;
                default:
                	System.out.println("Invalid Option.");
                	break;		
            }
        }
	}
}
