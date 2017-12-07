/*
#Microsoft Problem

Problem from https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number/0
Given two non-negative numbers X and Y. The task is calculate the sum of X and Y.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two numbers X and Y.

Output:
For each test case, if the number of digits in sum (X+Y) are equal to the number of digits in X, then print sum, else print X.

Constraints:
1<=T<=500
1<=|Number length |<=100

Example:
Input:
2
25 23
3 5

Output:
48
8

*/



import java.util.*;
public class Sum{
   public static ArrayList<String> input = new ArrayList<String>();
   public static int numTestCases;
   public static void main(String[] args){
      getInput();
      processStrings();
      
   }
   public static void getInput(  ){
      Scanner in = new Scanner(System.in);
      String temp = "";
      int count = 0;
      numTestCases = Integer.parseInt(in.nextLine());
		do{
         temp = in.nextLine();//get string 1
         input.add(temp);
         count++;
		}while ( count < numTestCases );
      in.close();
   }
   public static void processStrings(){
      String[] arr;
      for ( int i = 0; i < input.size(); i++ ){
         arr = input.get(i).split(" ");
         findSum(arr);
         }
      }
   public static void findSum(String[] arr){//the string only has 2 elements s1 and s2
       if ( arr[1].length() > arr[0].length() ){//that is number 2 is more than number 1 
         System.out.println(arr[0] );
          
         return;
      }
      char[] arr1 = arr[0].toCharArray();
      int lengthDiff = arr[0].length() - arr[1].length();
      String temp = "";
      for ( int i = 0; i< lengthDiff; i++ ){
         temp += "0";
         }
      temp += arr[1];
      char[] arr2 = temp.toCharArray();
      char[] result = new char[arr[0].length() +1];
      for ( int i = 0; i< result.length; i++)
         result[i] = '0';
     
      for ( int i = arr1.length-1; i>=0; i--){
         result[i+1] += (arr1[i] - '0') + (arr2[i] - '0') ;
         int tmp = result[i+1] - '0';
         if (   tmp >= 10  ) {//sum of 2 numbers is more than 10
            result[i] =  '1' ;
            result[i+1] = (char)(tmp - 10 + '0');
            }
      }
      if ( result[0] == '0' ) {
         for ( int i = 1; i< result.length; i++)
            System.out.print( result[i] -'0');
         System.out.println();
         }
      else 
         System.out.println( arr[0] );
      
   }
  
}
