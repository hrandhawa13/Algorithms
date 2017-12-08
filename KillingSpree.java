/**
Problem from https://practice.geeksforgeeks.org/problems/killing-spree/0

There are Infinite People Standing in a row, indexed from 1.
A person having index 'i' has strength of (i*i).
You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.
You can only Kill a person with strength 'X' if P >= 'X'  and after killing him, Your Strength decreases by 'X'. 
Input:
First line contains an integer 'T' - the number of testcases,
Each of the next 'T' lines contains an integer 'P'- Your Power.
 

Output:
For each testcase Output The maximum Number of People You can kill.

Constraints:
1<=T<=10000
1<=P<=1000000000000000

Example:
Input:
1
14
Output:
3

Explanation:
The strengths of people is 1,4,9,16,.... and so on.
WE can kill the first 3 person , after which our Power becomes 0 and we cant kill anyone else.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class KillingSpree {
    public static ArrayList<String> input = new ArrayList<String>();
    public static long power;
    public static int kills ;
	  
    public static void main (String[] args) {
		getInput();
		startProcessing();
	  }
	public static void getInput(  ){
      Scanner in = new Scanner(System.in);
      String temp = "";
      int count = 0, kills = 0;
      int numTestCases = Integer.parseInt(in.nextLine());
		  do{
         temp = in.nextLine();//get string 
         input.add(temp);
         count++;
		  }while ( count < numTestCases );
      in.close();
   }
   public static void startProcessing(){
       for ( String s : input ){
            power = Long.parseLong(s);
            calculateKills(1);
            System.out.println(kills);
            kills = 0;
       }
    }
    public static void calculateKills( int i ){
        if ( power >= (i*i)){
            power = power - (i*i);
            kills++;
            calculateKills(++i);
        }
        return;
    }
}
