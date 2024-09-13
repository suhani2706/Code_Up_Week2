/**
 * The following code will run for the below :
 		-> Binary to Decimal conversion		-> Nth Fibonacci series
 		-> Count Consonants					-> Count Palindrome
 		-> Snake To Camel Case
 		
 	Owner : Suhani Mathur
 	Created : 11 Sep 2024
 */
package com.Studyopedia;
import java.util.Scanner;
public class TaskOperations {
	
	//Task 1 :Count Palindrome
	 private static boolean isPal(String string, int i, int j) {
	        if (i >= j) {
	            return true;
	        }
	        if (string.charAt(i) != string.charAt(j)) {
	            return false;
	        }
	        return isPal(string, i + 1, j - 1);
	    }

	    private static int countPalindromicSubstrings(String inputString, int start, int end, int count) {
	        if (start >= inputString.length()) {
	            return count;
	        }
	        if (end >= inputString.length()) {
	            return countPalindromicSubstrings(inputString, start + 1, start + 1, count);
	        }

	        if (isPal(inputString, start, end)) {
	            String substring = inputString.substring(start, end + 1);
	            if (!isAlreadyCounted(inputString, start, end)) {
	                count++;
	            }
	        }
	        return countPalindromicSubstrings(inputString, start, end + 1, count);
	    }

	    private static boolean isAlreadyCounted(String inputString, int start, int end) {
	        for (int i = 0; i < start; i++) {
	            for (int j = i; j < end; j++) {
	                if (isPal(inputString, i, j) && inputString.substring(i, j + 1).equals(inputString.substring(start, end + 1))) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private static int countPS(String s) {
	        return countPalindromicSubstrings(s, 0, 0, 0);
	    }

	    public static void CountPalindrome() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a string (max 80 characters) or type 'exit' to quit:");

	        String PalindromeString = sc.nextLine();

	        if (PalindromeString.equalsIgnoreCase("exit")) {
	            System.out.println("Exiting the program");
	            return;
	        }

	        if (PalindromeString.length() > 80) {
	            System.out.println("Input string exceeds 80 characters.");
	            CountPalindrome();
	            
	        }

	        long result = countPS(PalindromeString);
	        System.out.println("Number of palindromic substrings in the string: " + result);
	        CountPalindrome();
	    }
    
    
    
	//Task 5 : Convert Binary To Decimal conversion
		private static int convertBinaryToDecimal(String binary, int index) {
	        if (index == binary.length()) {
	            return 0; 
	        }        
	        int digit = binary.charAt(index) - '0';  
	        return digit * (int)Math.pow(2, binary.length() - 1 - index) + convertBinaryToDecimal(binary, index + 1);
	    }
	    public static void convertBinaryToDecimalInput(){
	        Scanner sc = new Scanner(System.in);
	        System.out.println(Constants.Task5);
	        String binary = sc.next();       
	        
	        if (binary.equals("exit")) {
	        	System.out.println("Exiting the code.");
	        	return;
	        }	 
	        if(!isValidBinary(binary,0)) {
	        	System.out.println(Constants.Task5_Invalid);	
	        	convertBinaryToDecimalInput();
	        }
	        else {
	            int decimalValue = convertBinaryToDecimal(binary, 0);
	            System.out.println("The decimal equivalent is: " + decimalValue);
	            convertBinaryToDecimalInput();  
	        }
	    } 
	    private static boolean isValidBinary(String binary, int index) {
	        if (index == binary.length()) {
	            return true; 
	        }
	        char c = binary.charAt(index);
	        if (c != '0' && c != '1') {
	            return false; 
	        }
	        return isValidBinary(binary, index + 1); 
	    }
    
    
    
    	//Task 2 : print the nth number in the Fibonacci series.
        public static void nthfibonacci() {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Constants.Task2);
            String input = scanner.nextLine();   
            
           if(input.equals("exit")) {
            System.out.println("Exiting the program..");
            return;
           }
            try{
            int number = Integer.parseInt(input);
            long[] memo = new long[number + 1];
            System.out.println("The " + number + "th Fibonacci number is: " + fibonacci(number, memo));
            }
            catch(Exception ex){
                System.out.println(Constants.Task2_invalid);
            }
            nthfibonacci();
           }     
        //Fibonacci series helper function
        private static long fibonacci(int n, long[] memo) {
            if (n == 0 || n==1) {
                return n; 
            }
            if (memo[n] != 0) {
                return memo[n]; 
            }
    
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            return memo[n];
        }
        
        
        
        
        // Task 3 : Snake To Camel Case
        public static void CamelAndSnakeCase() {
            Scanner scanner = new Scanner(System.in);
        
            System.out.println(Constants.Task3);
        
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("Exiting the code...");
                return;
            }
            String camelCase;
            if (input.contains("_")) {
                camelCase = toCamelCase(input, 0, 0, true);  
            } else {
                String snakeCase = toSnakeCase(input, 0);
                camelCase = toCamelCase(snakeCase, 0, 0, true); 
            }
        
            System.out.println("CamelCase version: " + camelCase);
            CamelAndSnakeCase();
        }
        
        // Convert camelCase to snake_case
        private static String toSnakeCase(String str, int index) {
            if (index >= str.length()) {
                return "";
            }
            char currentChar = str.charAt(index);
            if (!Character.isLetter(currentChar)) {
                return toSnakeCase(str, index + 1);  
            }
         
            if (Character.isUpperCase(currentChar)) {
                return "_" + Character.toLowerCase(currentChar) + toSnakeCase(str, index + 1);
            } else if (currentChar == ' ') {
                return "_" + toSnakeCase(str, index + 1);
            } else {
                return currentChar + toSnakeCase(str, index + 1);
            }
        }
        
        // Convert snake_case to camelCase
        private static String toCamelCase(String str, int index, int capitalizeNext, boolean isFirstWord) {
            if (index >= str.length()) {
                return "";
            }
            char currentChar = str.charAt(index);
            
            if (currentChar == '_') {
                return toCamelCase(str, index + 1, 1, isFirstWord);
            }
           
            if (isFirstWord) {
                return Character.toLowerCase(currentChar) + toCamelCase(str, index + 1, 0, false);
            }
            
            if (capitalizeNext == 1) {
                return Character.toUpperCase(currentChar) + toCamelCase(str, index + 1, 0, false);
            }
            
            if (!Character.isLetter(currentChar) && currentChar != '_') {
                return toCamelCase(str, index + 1, capitalizeNext, isFirstWord);  
            }
            
            return currentChar + toCamelCase(str, index + 1, 0, false);
        }
        
        
        
        
        
        
        //Task 4: Count Consonants
        private static final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        

        private static boolean isVowel(char character, int index) {
            if (index == vowels.length) {
                return false;
            }
            if (character == vowels[index]) {
                return true;
            }
            return isVowel(character, index + 1);
        }
        private static boolean isConsonant(char character) {
            return (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z') && !isVowel(character, 0);
        }
        private static int countingConsonants(String string, int index) {
            if (index == string.length()) {
                return 0;
            }
            int count = isConsonant(string.charAt(index)) ? 1 : 0;
            return count + countingConsonants(string, index + 1);
        }
        public static void countConsonants() {
            Scanner sc = new Scanner(System.in);
            System.out.println(Constants.Task4);
            String inputString = sc.nextLine();
            
            if (inputString.equals("exit")) {
                System.out.println("Exiting the program.");                
                return;
            }            
            int result = countingConsonants(inputString, 0);
            System.out.println("Number of consonants: " + result);            
            countConsonants();  
        } 
        
}

