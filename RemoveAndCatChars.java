# Amazon
/*
Problem from https://practice.geeksforgeeks.org/problems/remove-common-characters-and-concatenate/0

Description:
Two strings are given. Modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.

Note: If the modified string is empty then print '-1'.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case consists of an string s1.The next line consists of an string s2. 

Output:
Print the required output.

Constraints: 
1<=T<=100
1<=|Length of Strings|<=100

Example:
Input:
2
aacdb
gafd
abcs
cxzca

Output:
cbgf
bsxz
*/


import java.util.*;
public class RemoveAndCatChars{
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
         temp = in.nextLine() +" ";//get string 1
         temp += in.nextLine() + " ";//get string 2
         input.add(temp);
         count++;
		}while ( count < numTestCases );
      in.close();
   }
   public static void processStrings(){
      String[] arr;
      for ( int i = 0; i < input.size(); i++ ){
         arr = input.get(i).split(" ");
         removeAndCatChars(arr);
         }
      }
   /**
   *This method will remove the characters common in both the strings of array 
   *and add uncommon strings to string 1
   * @param arr : This is the string array which contains 2 string elements only 
   */
   public static void removeAndCatChars(String[] arr){//the string only has 2 elements s1 and s2
      for ( int i = 0 ; i < arr[1].length(); i++){
         char s2 = arr[1].charAt(i);
         if ( arr[0].indexOf(s2) != -1  ){//that means string contains the character
            arr[1] = removeDuplicate(arr[1] , s2);
            arr[0] = removeDuplicate( arr[0] , s2);
            i=-1;
         }
      }
      if ( arr[0].length() == 0 && arr[1].length() == 0){//both the strings are empty 
         System.out.println( "-1" );
         }
      else {
         System.out.println( arr[0]+ arr[1] );
         }
   }
   /**
   *This methor removes all the instances of character from a string( works like sed c command of linux)
   * @param word String from where all the instances of character is to be removed
   * @param c Character that is to be removed 
   */
   private static String removeDuplicate(String word , char c ) {
    String result = "";
    for (int i = 0; i < word.length(); i++) {
        if ( c != word.charAt(i) ) {
            result += "" + word.charAt(i);
        }
    }

    return result;
  }
}
