public class IntegerPalindrome {
    
    public static void main(String[] args) {
        
        int number = 10001;
        boolean result = checkIntegerPalindrome(number);
        System.out.print(result);
    }

    public static boolean checkIntegerPalindrome(int number) {

        /* Reverse the number */

        int numberCopy = number;
        int reverseNumber = 0;

        while(numberCopy != 0) {

            reverseNumber = (reverseNumber * 10) + (numberCopy%10);
            numberCopy = numberCopy/10;

        }
        
        if(reverseNumber == number)
            return true;
        return false;
    }
}
