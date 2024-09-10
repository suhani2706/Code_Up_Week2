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

public class Operations {

    // Task 1: Valid Parentheses Combination Generator 
    public static void generateCombinations() {
        Scanner scanner = new Scanner(System.in);
        boolean continueGenerating = true;

        while (continueGenerating) {
            System.out.print("Enter a string: ");
            String InputString = scanner.nextLine();
            char[] inputArray = InputString.toCharArray();
            int length = inputArray.length;

            System.out.println("Combinations and Permutations:");

            for (int i = 1; i < (1 << length); i++) {
                char[] subset = new char[length];
                int subsetLength = 0;

                for (int j = 0; j < length; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset[subsetLength++] = inputArray[j];
                    }
                }

                generatePermutations(subset, 0, subsetLength);
            }

            System.out.println("Choose an option:");
            System.out.println("1. Perform again with a new string");
            System.out.println("2. Return to main menu");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    continueGenerating = false;
                    break;
                default:
                    System.out.println("Invalid option! Returning to main menu.");
                    continueGenerating = false;
                    break;
            }
        }
    }

    private static void generatePermutations(char[] array, int left, int right) {
        if (left == right) {
            for (int i = 0; i < right; i++) {
                System.out.print(array[i]);
            }
            System.out.println();
        } else {
            for (int i = left; i < right; i++) {
                char temp = array[left];
                array[left] = array[i];
                array[i] = temp;

                generatePermutations(array, left + 1, right);

                temp = array[left];
                array[left] = array[i];
                array[i] = temp;
            }
        }
    }

    // Task 2: Digit Sum Loop(String)
    public static void digitSumLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean continueSumming = true;

        while (continueSumming) {
            System.out.print("Enter a number: ");
            String userInputNumber = scanner.nextLine();

            boolean isValidNumber = true;
            for (int i = 0; i < userInputNumber.length(); i++) {
                if (userInputNumber.charAt(i) < '0' || userInputNumber.charAt(i) > '9') {
                    isValidNumber = false;
                    break;
                }
            }

            if (!isValidNumber) {
                System.out.println("Invalid input! Please enter a valid positive integer.");
                continue;
            }

            int number = Integer.parseInt(userInputNumber);

            while (number >= 10) {
                int sum = 0;
                while (number > 0) {
                    sum += number % 10;
                    number /= 10;
                }
                number = sum;
            }
            System.out.println("Final single digit sum: " + number);

            System.out.println("Choose an option:");
            System.out.println("1. Perform again with a new number");
            System.out.println("2. Return to main menu");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    continueSumming = false;
                    break;
                default:
                    System.out.println("Invalid option! Returning to main menu.");
                    continueSumming = false;
                    break;
            }
        }
    }

    // Task 3: Consecutive Number Summer 
    public static void findConsecutiveSums() {
        Scanner scanner = new Scanner(System.in);
        boolean continuePrinting = true;

        while (continuePrinting) {
            System.out.print("Enter a positive integer: ");
            int number = scanner.nextInt();
            boolean found = false;

            for (int n = 2; n < number; n++) {
                int sum = (n * (n - 1)) / 2;
                if ((number - sum) % n == 0) {
                    int x = (number - sum) / n;
                    if (x > 0) {
                        found = true;
                        printConsecutiveSequence(x, n);
                    }
                }
            }

            if (!found) {
                System.out.println("No consecutive number sum found for " + number);
            }

            System.out.println("Choose an option:");
            System.out.println("1. Perform same task");
            System.out.println("2. Return to main menu");
            System.out.print("Enter option number: ");
            scanner.nextLine(); 
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    continuePrinting = false;
                    break;
                default:
                    System.out.println("Invalid option! Returning to main menu.");
                    continuePrinting = false;
                    break;
            }
        }
    }

    // Helper method for Task 3 to print consecutive numbers
    private static void printConsecutiveSequence(int start, int n) {
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" + ");
            }
            System.out.print(start + i);
        }
        System.out.println();
}
    //Task 5 : sEncoding Challenge with ASCII Conversion 
    public static void Encoding() {
    	Scanner scanner = new Scanner(System.in);

        boolean continueEncoding = true;

        while (continueEncoding) {
            String inputArray = "";
            boolean validArray = false;

            while (!validArray) {
                System.out.print("Enter the array of characters (e.g., 2a3b1C): ");
                inputArray = scanner.nextLine();

               
                if (inputArray.matches("[a-zA-Z0-9]+")) {
                    validArray = true;
                } else {
                    System.out.println("Invalid input! Please enter only alphanumeric characters.");
                }
            }

            char[] chars = inputArray.toCharArray(); 

            
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] < chars[j]) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                }
            }

            String inputSeries = "";
            boolean validSeries = false;

            while (!validSeries) {
                System.out.print("Enter the series of integers (e.g., 123): ");
                inputSeries = scanner.nextLine();

                if (inputSeries.matches("\\d+")) {
                    validSeries = true;
                } else {
                    System.out.println("Invalid input! Please enter only digits.");
                }
            }

            StringBuilder encodedString = new StringBuilder();
            int seriesLength = inputSeries.length();
            for (int i = 0; i < seriesLength; i++) {
               
                char highestChar = i < chars.length ? chars[i] : '0'; 
                int asciiValue = (int) highestChar;
                encodedString.append(asciiValue);   
            }

            System.out.println("Encoded Output (ASCII values): " + encodedString.toString());
            System.out.println("Choose an option:");
            System.out.println("1. Perform same task");
            System.out.println("2. Return to main menu");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    continueEncoding = false;
                    break;
                default:
                    System.out.println("Invalid option! Returning to main menu.");
                    continueEncoding = false;
                    break;
            }
        }
    }
    //Task 4: Caesar Cipher with Shift Variability     
    public static void caesarCipher() {
    	Scanner scanner = new Scanner(System.in);
        boolean continueShifting = true;
        
        while (continueShifting) {
            System.out.println("Enter string:");
            String text = scanner.nextLine();
            
            System.out.println("Enter the shifting pattern (space-separated integers):");
            String[] patternStrings = scanner.nextLine().split(" ");
            int[] shiftPattern = new int[patternStrings.length];
            
           
            for (int i = 0; i < patternStrings.length; i++) {
                shiftPattern[i] = Integer.parseInt(patternStrings[i]);
            }

            StringBuilder result = new StringBuilder();
            int shiftIndex = 0;

            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);

                if (character == ' ') {
                    result.append(character);  
                } else if (Character.isLetter(character)) {
                    int shift = shiftPattern[shiftIndex];

                    if (Character.isLowerCase(character)) {
                        char shiftedChar = (char) ('a' + (character - 'a' + shift) % 26);
                        result.append(shiftedChar);
                    } else if (Character.isUpperCase(character)) {
                        char shiftedChar = (char) ('A' + (character - 'A' + shift) % 26);
                        result.append(shiftedChar);
                    }

                    shiftIndex = (shiftIndex + 1) % shiftPattern.length; 
                } else {
                    result.append(character);  
                }
            }

            System.out.println("Encoded result: " + result.toString());  

            System.out.println("Choose an option:");
            System.out.println("1. Perform same task");
            System.out.println("2. Return to main menu");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    continueShifting = false;
                    break;
                default:
                    System.out.println("Invalid option! Returning to main menu.");
                    continueShifting = false;
                    break;
        }
    }
       
}
}
    

    
    
    
    