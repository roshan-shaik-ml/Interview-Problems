/**
 * Sort0nd1
 */
public class Sort0nd1 {

    public static void main(String[] args) {
        
        int[] arr = {0, 1, 0, 1, 0, 0, 0, 1};

        arr = sortBinarySequence(arr);
        for(int digit : arr) {

            System.out.print(digit + " ");
        }
    }

    public static int[] sortBinarySequence(int[] arr) {
        
        int zeros = 0;
        int ones = 0;
        int length = arr.length;

        for(int index = 0; index < length; index++) {

            if(arr[index] == 0) 
                zeros += 1;
            else
                ones += 1;
        }

        for(int index = 0; index < length; index++) {

            if(zeros != 0) {

                arr[index] = 0;
                zeros -= 1;
            }
            else {

                arr[index] = 1;
                ones -= 1;
            }
        }
        return arr;
    }
}