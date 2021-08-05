/**
 * About: Find two numbers whose product is maximum in array. arr[i] > 0
 */
public class MaximumProduct {

    public static void main(String[] args) {
        
        int[] arr = {1, 100, 42, 4, 23};

        int result = findMaximumProduct(arr); // find maximum product of 2 numbers in array
        System.out.println(result);
    }

    public static int findMaximumProduct(int[] arr) {

        
        int length = arr.length;
        // checking edge case 
        if(length == 1)

            return 0;
        if(length == 2)
            return arr[0]*arr[1];

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int index = 0; index < length; index++) {

            if(arr[index] > firstMax) 
                firstMax = arr[index];

            else if(arr[index] < firstMax && arr[index] > secondMax)
                secondMax = arr[index];
        }

        int product = firstMax*secondMax;
        return product;
    }
}