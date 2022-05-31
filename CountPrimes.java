/*
  Author: Shaik Faizan Roshan Ali
  Date: 31st May 2022
  Link: https://leetcode.com/problems/count-primes/
**/
import java.util.Arrays;
public class Solution {
    /*
        Seive method for counting primes
    
    **/
    public static boolean[] seive(int limit) {
        
        boolean[] isPrime = new boolean[limit+1];
        Arrays.fill(isPrime, true);
        double bound = Math.sqrt(limit+1);
        
        isPrime[0] = false; isPrime[1] = false;
        
        for(int i = 2; i < bound; i++) {
            
            if(isPrime[i] == true) {
                
                for(int j = i * i; j < limit; j += i) {

                    isPrime[j] = false;
                }
            }
             
        }

        return isPrime;
    } 
    
    public static int countPrimes(int n) {
        
        if(n == 0 || n == 1)  
            return 0;
        
        boolean[] isPrime = seive(n);
        
        int count = 0;
        for(int index = 0; index < n; index++) {
            
            if(isPrime[index] == true) 
                count += 1;
        }
        return count;
    }
    public static void main(String[] args) {
        
        int primes = countPrimes(100);
        System.out.println("Total primes in range the 100 are " + primes);
    }
}
