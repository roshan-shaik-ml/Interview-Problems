/*
  Author: Shaik Faizan Roshan Ali
  Date: 26th May 2022
  Link: https://leetcode.com/problems/string-to-integer-atoi/

*/

class Solution {
    public static int myAtoi(String s) {
        
        boolean start = false;
        int sign = 1;
        int size = s.length();
        int value = 0;
        long temp = 0;
        
        for(int i = 0; i < size; i++) {
            
            int ascii = s.charAt(i); /* get current character ascii value */
            
          
            /* First character conditions open */
          
            /* two conditions to check i.e. 
                first character is either a sign '+' || '-' 
                        OR 
                first character is a number 
            */
            boolean symbolCondition = (ascii == (int)'+' || ascii == (int)'-');
            boolean numberCondition = (ascii >= (int)'0' && ascii <= (int)'9');
            
            /* If the first character itself isn't a symbol or a number */
            if(start == false && numberCondition == false && symbolCondition == false && (char)ascii != ' ') 
                return value;
            
            /* Sequence has number started but we have non-numbers */
            if(start == true && numberCondition == false) {
                
                break;
            }
            
            /* first character is a sign */
            else if(symbolCondition == true) { 
                
                if(ascii == (int)'-')
                    sign = -1;
                start = true;
                continue;
            }
            
            /* first character is a number */
            else if(start == false && numberCondition == true) {
                
                start = true;
            }
          
            /* First character conditions closed */
            
            /* Building the number */
            if(start == true && numberCondition == true) {

                temp = value * 10 + (ascii - (int)'0');
                
                /* Condition to check the integer overflow */
              
                if((int)temp / 10 != value && sign == 1) {

                    return Integer.MAX_VALUE * sign;
                }
                    
                else if((int)temp / 10 != value && sign == -1) {

                    return Integer.MIN_VALUE * sign;
                }
                    
                else {
                    // System.out.print("inside else value statement   ");
                    value = (int)temp;
                }
                    
            }
        }
        
        return value * sign;
    }
    
    public static void main(String[] args) {
        
        String s1 = "+-12";
        String s2 = "-333   asdfasdf ";
        String s3 = "-3.121221";
        String s4 = "9458228912837698";
        
        int v1 = myAtoi(s1);
        int v2 = myAtoi(s2);
        int v3 = myAtoi(s3);
        int v4 = myAtoi(s4);
        
        System.out.println(s1 + " : " + v1);
        System.out.println(s2 + " : " + v2);
        System.out.println(s3 + " : " + v3);
        System.out.println(s4 + " : " + v4);
    }
}
