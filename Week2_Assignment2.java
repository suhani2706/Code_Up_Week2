/**
 * The following code will run for the below :
 		-> Binary to Decimal conversion		-> Nth Fibonacci series
 		
 	Owner : Suhani Mathur
 	Created : 11 Sep 2024
 */




package com.Studyopedia;
import java.util.Scanner;
public class Week2_Assignment2 {
	
	//Task 5 : Convert Binary To Decimal conversion
	public static int convertBinaryToDecimal(String binary, int index) {
        if (index == binary.length()) {
            return 0; 
        }        
        int digit = binary.charAt(index) - '0';  
        return digit * (int)Math.pow(2, binary.length() - 1 - index) + convertBinaryToDecimal(binary, index + 1);
    }
    public static void convertBinaryToDecimalInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a binary number (e.g., 1010):");
        String binary = sc.next();          

        if (!binary.equals("exit")) {
            int decimalValue = convertBinaryToDecimal(binary, 0);
            System.out.println("The decimal equivalent is: " + decimalValue);
            convertBinaryToDecimalInput();  
        }else{
            System.out.println("Exiting the code.");
        }
    }    
    	//Task 2 : print the nth number in the Fibonacci series.
        public static void nthfibonacci() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the value of n:");
            try{
                int n = scanner.nextInt();
            scanner.close();

            // Create a memoization array to store Fibonacci numbers
            long[] memo = new long[n + 1];
            System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n, memo));
            }
            catch(Exception e){
                System.out.println("Invalid Input :)");
            }
            
        }
        private static long fibonacci(int n, long[] memo) {
            if (n == 0 || n==1) {
                return n; // Base cases: F(0) = 0, F(1) = 1
            }
            if (memo[n] != 0) {
                return memo[n]; // Return cached result if available
            }
            // Compute Fibonacci number recursively and cache it
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            return memo[n];
        }
    }


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Main Menu:");
            System.out.println("1.Binary to decimal");
            System.out.println("2. Nth Fibonacci Series ");
            System.out.println("3. Exit");
            System.out.print("Enter option number: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                	convertBinaryToDecimalInput();
                    break;
                case "2":
                	nthfibonacci();
                    break;
                default:
                	System.out.println("Invalid Option.");
                	break;
		
	}

}
