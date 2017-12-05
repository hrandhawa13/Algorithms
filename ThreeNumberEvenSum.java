/**
 * Problem from https://practice.geeksforgeeks.org/problems/three-number-even-sum/0 
 * @author harman Randhawa
 */

/**
Description of problem 

Given an integer N, find the number of ways we can choose 3 numbers from {1,2,3…,N}
such that their sum is even.

Input
The first line of the test case contains an integer T denoting number of test cases. 
Following T line contains an integer N each.

Output
Print the answer under modulo 10^9+7.

Constraints:
1<=T<=4.5*10^3
3<=N<=10^5

Example
Input
2
3
4

Output
1
2
 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
        int noOfTests = scan.nextInt();
        for (int i = 0; i < noOfTests; i++) {
            int val = scan.nextInt();
            long oddCount = val / 2 + val % 2, evenCount = val / 2;
            long oCount = (oddCount * (oddCount  - 1) * evenCount) / 2;
            long eCount = evenCount * (evenCount - 1) * (evenCount - 2) / 6;
            System.out.println((oCount + eCount) % 1000000007);
        }
        scan.close();
	}
}
