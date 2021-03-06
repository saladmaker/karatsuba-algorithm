package algos.khaled;

import java.util.Arrays;

/**
 * @author khaled abderrahim
 */
public class Karatsuba {

    public static void main(String[] args) {
        System.out.println("Karatsuba algorithm implementation:");
    }

    /**
     * Returns the product of {@code first} multiplied by {@code seconde}
     *
     * @param first the array representation of the first number
     * @param seconde the array representation of the seconde number
     * @return first times seconde by applying
     * <a href="https://en.wikipedia.org/wiki/Karatsuba_algorithm">Karatsuba
     * Algorithm</a>
     * @throws NumberFormatException if {@code first} is null and/or {@code seconde} 
     * is null
     * @throws IllegalArgumentException if {@code first} and {@code seconde} have
     * inequal length
     * @throws NumberFormatException if {@code first}, {@code seconde} are empty
     * @throws NumberFormatException if {@code first}'s, {@code seconde}'s lengths
     * is not <i><em>power of two n= 2^m where m is a natural number</em></i>
     */
    public static int multiply(int[] first, int[] seconde) {
        if(first == null){
            throw new NumberFormatException("first number is null");
        }
        if(seconde == null ){
            throw new NumberFormatException("seconde number is null");
        }
        if (first.length != seconde.length) {
            throw new IllegalArgumentException("Length inequality first: " + first.length + ", seconde: " + seconde.length);
        }
        int n =first.length;
        if (n == 0) {
            throw new NumberFormatException("empty number!");
        }
        
        /*
        * by checking n &(n-1) we can determin if n is power of two, n = 2^m
        * where m is natural number for example 8 = 2^3
        * 8 & 7= 0
        *   1 0 0 0
        * + 0 1 1 1
        *   ========
        *   0 0 0 0
        */
        int checkPowerOfTwo= (n)&(n-1);
        if(checkPowerOfTwo!=0){
            throw new NumberFormatException("numbers's length must 2^m where m is natural number 0,1,2,...etc.");
        }
        if(n == 1){
            return first[0]*seconde[0];
        }
        int halfN = n/2;
        int[] a = Arrays.copyOfRange(first,0,halfN);
        int[] b = Arrays.copyOfRange(first, halfN, n);
        int[] c = Arrays.copyOfRange(seconde, 0, halfN);
        int[] d = Arrays.copyOfRange(seconde, halfN, n);
        return (int)
                (
                 (
                     Math.pow(10, n)
                   * multiply(a, c)
                  )
                +(
                   Math.pow(10, halfN)
                   *( 
                      multiply(a, d) 
                     +
                      multiply(b, c)
                    )
                 )
                +  multiply(b, d)
                );
                
                
    }
}
