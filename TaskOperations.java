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
	private static boolean isPal(String s, int i, int j) {
        if ( i >= j ) {
            return true;
        }
        if ( s.charAt(i) != s.charAt(j) ) {
            return false;
        }
        return isPal( s, i + 1, j - 1 );
    }

    // Recursive method to find palindrome substrings and count unique ones
    private static int countPalindromicSubstrings( String s, int start, int end, String[] palindromes, int count ) {
        if ( start >= s.length() ) {
            return count;
        }
        if ( end >= s.length() ) {
            return countPalindromicSubstrings( s, start + 1, start + 1, palindromes, count );
        }

        if ( isPal(s, start, end) ) {
            String substring = s.substring(start, end + 1);
            if (!isAlreadyCounted(palindromes, count, substring)) {
                palindromes[count] = substring;
                count++;
            }
        }
        return countPalindromicSubstrings(s, start, end + 1, palindromes, count);
    }

    // Method to check if a substring is already counted
    private static boolean isAlreadyCounted(String[] palindromes, int count, String substring) {
        for (int i = 0; i < count; i++) {
            if (palindromes[i].equals(substring)) {
                return true;
            }
        }
        return false;
    }
    private static int countPS(String s) {
        // Array to hold all palindromic substrings
        String[] palindromes = new String[s.length() * (s.length() + 1) / 2];
        return countPalindromicSubstrings(s, 0, 0, palindromes, 0);
    }    
    public static void CountPalindrome() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.Task1);
    	String PalindromeString = sc.nextLine();
    	
    	if(PalindromeString.equals("exit")) {
    		System.out.println("Exiting the program");
    		return;
    	}
    	int result = countPS(PalindromeString);
    	System.out.println("Number of palindrome in the string:" + result);
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
            int n = Integer.parseInt(input);
            long[] memo = new long[n + 1];
            System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n, memo));
            }
            catch(Exception e){
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
           if(input.equals("exit")){
        	   System.out.println("Exiting the code...");
        	   return;
           }
            // Convert input to snake_case and then to camelCase
            String snakeCase = toSnakeCase(input, 0);
            String camelCase = toCamelCase(snakeCase, 0, 0);

            System.out.println("CamelCase version: " + camelCase);
            CamelAndSnakeCase();            
        }
     // Convert camelCase to snake_case
        private static String toSnakeCase(String str, int index) {
            if (index >= str.length()) {
                return "";
            }
            char currentChar = str.charAt(index);
            if (Character.isUpperCase(currentChar)) {
                return "_" + Character.toLowerCase(currentChar) + toSnakeCase(str, index + 1);
            } else if (currentChar == ' ') {
                return "_" + toSnakeCase(str, index + 1);
            } else {
                return currentChar + toSnakeCase(str, index + 1);
            }
        }
        // Convert snake_case to camelCase
        private static String toCamelCase(String str, int index, int capitalizeNext) {
            if (index >= str.length()) {
                return "";
            }
            char currentChar = str.charAt(index);
            if (currentChar == '_') {
                return toCamelCase(str, index + 1, 1);
            } else if (capitalizeNext == 1) {
                return Character.toUpperCase(currentChar) + toCamelCase(str, index + 1, 0);
            } else {
                return currentChar + toCamelCase(str, index + 1, 0);
            }
        }
        
        
        
        //Task 4: Count Consonants
        private static final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        private static boolean isVowel(char c, int index) {
            if (index == vowels.length) {
                return false;
            }
            if (c == vowels[index]) {
                return true;
            }
            return isVowel(c, index + 1);
        }
        private static boolean isConsonant(char c) {
            return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') && !isVowel(c, 0);
        }
        private static int countingConsonants(String str, int index) {
            if (index == str.length()) {
                return 0;
            }
            int count = isConsonant(str.charAt(index)) ? 1 : 0;
            return count + countingConsonants(str, index + 1);
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
        public static void Exiting() {
        	
        }
}

