package algos.khaled;

/**
 * @author khaled abderrahim
 */
public class Karatsuba {

    public static void main(String[] args) {
        System.out.println("Karatsuba algorithm implementation:");
    }
    /**
     * Returns the product of {@code first} multiplied by {@code seconde}
     * @param first the array representation of the first number
     * @param seconde the array representation of the seconde number
     * @return first times seconde by applying <a href="https://en.wikipedia.org/wiki/Karatsuba_algorithm">Karatsuba Algorithm</a>
     * @throws IllegalArgumentException if {@code first} and {@code seconde} are inequal
     */
    public static int multiply(int[] first , int[] seconde){
        if(first.length != seconde.length)
            throw new IllegalArgumentException("Length inequality first: "+first.length+", seconde: "+seconde.length);
        return 0;
    }
}
