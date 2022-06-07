/*
    Author: Shaik Faizan Roshan Ali
    Date: 7th May 2022
    Link:https://leetcode.com/problems/powx-n/
    Approach: BinaryExponentiation
**/
public class BinaryExponentiation {

    public static double myPow(double x, int n) {
        
        double answer = 0;
        if(x == 1 && n == 0)
            return 1;
        if(n > 0)
            answer = binaryExponentiation(x, n);
        else if(n < 0)
            answer = 1 / (x * binaryExponentiation(x, -(n+1))); /* to avoid overflow use  */
        return answer;
    }
    
    public static double binaryExponentiation(double x, int n) {
        
        if(n == 0)
            return 1;
        
        else if(n % 2 == 0)
            return binaryExponentiation(x*x, n/2);
        
        return x * binaryExponentiation(x*x, (n-1)/2);
    }

    public static void main(String[] args) {
        
        double answer = myPow(23, 123);
        System.out.println(answer);

    }
}
