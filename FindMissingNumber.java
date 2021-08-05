/**
 * FindMissingNumber
 * Given an array of size n-1 with number from 1 to N
 * find the missing number from the sequence.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int missingNumber = findMissingNumber(arr);
        System.out.println(missingNumber);
    }

    public static int findMissingNumber(int[] arr) {

        int n = arr.length + 1; // n digits
        int sum1 = n * (n+1) / 2; // sum of n digits
        int sum2 = 0;

        int length = arr.length;
        for(int i = 0; i < length; i++) {

            sum2 += arr[i];
        }
        
        return sum1 - sum2;
    }
}