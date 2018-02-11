import java.util.*;
public class PossibleSubstring{
   /*
   This program will decide whether a given word is a possible substring of another string or not.
   It returns true if it is a substring else returns false
   */
   public static void main(String[] args){
      System.out.println(possibleSubstring("ale", "abpclea")); 
      System.out.println(possibleSubstring("geeks", "geksforgeeks")); 
   }  

   public static boolean possibleSubstring( String input, String biggerWord){
      String str ="";
      String temp = biggerWord;
      try{   
         for( int i = 0;i< input.length(); i++ ){
            char x = input.charAt(i);
            for( int j = 0; j< temp.length(); j++){
               if( x == temp.charAt(j) ){
                  str += x;
                  if( j == 0 ) 
                     temp = temp.substring( j+1, temp.length());
                  else if( j == input.length() - 1)
                     temp = temp.substring( 0, j-1 );
                  else
                     temp = temp.substring( 0, j ) + temp.substring( j+1, temp.length() );
                  j = temp.length();
                  }
               }
            }
         }
         catch(ArrayIndexOutOfBoundsException e){}
         finally{
            System.out.println(input + "---" + biggerWord);
            return input.equals(str);
            }
      }
}
