/*
 * About : check whether there are two numbers present with given product. 
**/
import java.util.*;

public class CheckTwoNumberProduct {
    
    public static void main(String[] args) {
        
        int[] arr = {21, 23, 44, 10, 12, 14};
        int product = 140;

        checkTwoNumberProduct(arr, product);
    }

    public static void checkTwoNumberProduct(int[] arr, int product) {

        int length = arr.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int index = 0; index < length; index++) {

            map.put(arr[index], index);
        }

        for(int index = 0; index < length; index++) {

            int required = product / arr[index];
            if(map.get(required) != null) {

                System.out.println(arr[index] + " " + required);
                break;
            }
        }
    }
}
