/*
    Author: Shaik Faizan Roshan Ali
    Date: 4th August 2021
    Email: alsahercoder@gmail.com
    Approach: 
    1. Find the greatest number 'n' that satisfies the condition (n*n <= given_number)
    2. let lowerbound = 0, upperbound = n and result = -1
        mid = lowerbound + upperbound / 2
        loop(lower bound <= upperbound)
        "new condition for this binary search are"
        2.1 mid * mid <= number 
            update result and change the lower bound to find next greatest number
        2.2 decrease the upper bound to find the number satisfy above condition

    3. After the above loop fails => the maximum number is found for n*n <= required_number
    4. print the result 

*/
public class SquareRoot {

    public static void main(String[] args) {
        
        int result = binarySearchSquareRoot(10);

        System.out.print(result);
    }

    public static int binarySearchSquareRoot(int number) {

        int low = 1;
        int high = number;
        int mid = (high + low) / 2;
        int result = -1;
        while(low < high) {

            mid = (high + low) / 2;

            if(mid*mid <= number) {

                result = mid;
                low = mid + 1; 
            }
            else {

                high = mid - 1;
            }

        }
        
        return result;
    }
}
