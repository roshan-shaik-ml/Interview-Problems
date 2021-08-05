/*
*   Given an unsorted array find the pairs with minimum difference
**/
import java.util.Arrays;
public class MinimumDifferencePairs {
    
    public static void main(String[] args) {
        
        int[] arr = {14, 5, 12, 44, 22, 17, 28};

        int minimumDifference = getMinimumDifference(arr);
        System.out.print(minimumDifference);
    }

    public static int getMinimumDifference(int[] arr) {

        int difference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int length = arr.length;
        for(int index = 1; index < length; index++) {

            if(arr[index] - arr[index-1] < difference)
                difference = arr[index] - arr[index-1];
        }
        return difference;
    }
}
