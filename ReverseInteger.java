/*
  Author: Shaik Faizan Roshan Ali
  Date: 31st May 2022
  Link: https://leetcode.com/problems/reverse-integer/
**/
class Solution {
    
    public int reverse(int x) {
        
        long rev = 0;
        int rem  = 0;

        while(x != 0) {
            
            rem = x % 10;
            x = x / 10;
            rev = rev * 10 + rem;
            
            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }  

        return (int)rev;
    }
}   
