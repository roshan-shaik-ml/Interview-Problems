/**
 * CaesarCipher
 */
public class CaesarCipher {

    public static void main(String[] args) {
        
        int rotateValue = 4;        
        String string = "ROSHAN";
        
        String encryptedString = encryptString(string, rotateValue);
        System.out.println("Encrypted String: " + encryptedString);
    }

    public static char[] getRotatedAlphabets(int rotateValue) {

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String subString1 = alphabets.substring(0, rotateValue);
        String subString2 = alphabets.substring(rotateValue, alphabets.length());
        String rotatedAlphabets = subString2 + subString1;

        return rotatedAlphabets.toCharArray();
    }

    public static String encryptString(String string, int rotateValue) {
        
        char[] rotateAlphabets = getRotatedAlphabets(rotateValue);
        
        
        string = string.toLowerCase();
        char[] stringArray = string.toCharArray();
        int length = stringArray.length;

        String encryptedString = "";
        for(int index = 0; index < length; index++){

            int encryptIndex = stringArray[index] - 'a';
            encryptedString += rotateAlphabets[encryptIndex];
        }

        return encryptedString;
    }
}