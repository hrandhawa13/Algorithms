/*
Problem from https://practice.geeksforgeeks.org/problems/find-the-fine/0
Given an array of penalties, an array of car numbers and also the date. The task is to find the total fine which will be collected on the given date. Fine is collected from odd-numbered cars on even dates and vice versa.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains two integers N & Date, second line contains N space separated car numbers and third line contains N space separated penalties.

Output:
For each test case,In new line print the total fine.

Constraints:
1<=T<=100
1<=N<=105
1000<= Car num<=9999
1<=Date<=31
1<=penalty[i]<=103
Example:
Input:
2
4 12
2375 7682 2325 2352
250 500 350 200
3 8
2222 2223 2224
200 300 400
Output:
600
300

*/


import java.util.*;
public class CarFineCalculator{
   public static ArrayList<String> input = new ArrayList<String>();
   public static int numTestCases;
   public static void main(String[] args){
      getInput();
      process();
      
   }
   public static void getInput(  ){
      Scanner in = new Scanner(System.in);
      String temp = "";
      int count = 0;
      numTestCases = Integer.parseInt(in.nextLine());
      do{
         temp = in.nextLine() +" ";//get N and date
         temp += in.nextLine() + " ";//get the n cars
         temp += in.nextLine() + " "; //get the n fines
         input.add(temp);
         count++;
	}while ( count < numTestCases );
      in.close();
   }
   public static void process(){
      String cars = "";
      String fines = "";
      String[] arr;
      for ( int i = 0; i < input.size(); i++ ){
         arr = input.get(i).split(" ");
         calculateFine(arr);
         }
      }
   public static void calculateFine( String[] arr ){
      int numCars = Integer.parseInt(arr[0]);
      int date = Integer.parseInt(arr[1]);
      boolean dateEven = ( date%2 == 0);
      int carNum = 0;
      int fine = 0;
      for ( int i = 2 ; i < 2+numCars; i++){
         carNum = Integer.parseInt(arr[i]);
         if ( carNum %2 == 0 && !dateEven ){//car number and date are even 
            fine += Integer.parseInt(arr[i + numCars ] );
         }
         else if ( carNum %2 == 1 && dateEven ){//car number and date are even 
            fine += Integer.parseInt(arr[i + numCars] );
         }
      }
      System.out.println("Fine for date " + date + "is " + fine);
   }
}
