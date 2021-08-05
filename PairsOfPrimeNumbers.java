import java.util.Arrays;

import javax.print.attribute.standard.NumberOfInterveningJobs;

/**
 * PairsOfPrimeNumbers
 */
public class PairsOfPrimeNumbers {

    public static void main(String[] args) {
        
        int max = 400;
        int[] primes = seive(max);

        int number = 30; // input n for for p*q <= n where p, q belongs to primes
        getPrimePairs(primes, number);
    }

    public static void getPrimePairs(int[] primes,int number) {

        int length = primes.length;
        for(int index = 0; primes[index] <= number/2; index++) {

            for(int index2 = 0; index2 < length; index2++) {

                if(primes[index]*primes[index2] <= number)
                    System.out.print(primes[index] + " " + primes[index2] + " ");
                else
                    break;
            }                
        }        
    }
    
    public static int[] seive(int number) {

        int[] primes;
        int count = 0; // counting number of primes discovered
        boolean[] isPrime = new boolean[number+1];
        Arrays.fill(isPrime, true);
        for(int current = 2; current < Math.sqrt(number); current++) {

            for(int num = current*current; num < number+1; num += current) {

                isPrime[num] = false;
            }
        }
        /* Count the number of primes */
        for(int index = 2; index < number+1; index++) {

            if(isPrime[index] == true)
                count += 1;
        }

        primes = new int[count];
        int insertIndex = 0;
        for(int index = 2; index < number; index++) {

            if(isPrime[index] == true) {

                primes[insertIndex] = index;
                insertIndex += 1;
            }
                
        }
        return primes;
    }
}