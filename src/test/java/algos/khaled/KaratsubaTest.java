package algos.khaled;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
/**
 * test class for Karatsuba
 */
public class KaratsubaTest {
    
    @Test
    void testCheckEqualLength() {
        int[] first = {1, 2};
        int[] seconde = {2};
        Exception exception = assertThrows(IllegalArgumentException.class, ()->Karatsuba.multiply(first, seconde));
        String message = exception.getMessage();
        assertEquals("Length inequality first: "+first.length+", seconde: "+seconde.length, message);
    }
    @Test
    void testZeroLengthNumber(){
        int[] emptyNubmer={};
        Exception exception = assertThrows(NumberFormatException.class, ()->Karatsuba.multiply(emptyNubmer, emptyNubmer));
        String message = exception.getMessage();
        assertEquals("empty number!", message);
    }
    @Test
    void testLengthIsPowerOfTwo(){
        int[] first ={1,2,3};
        int[] seconde ={1,0,4};
        Exception exception = assertThrows(NumberFormatException.class, ()->Karatsuba.multiply(first, seconde));
        String message = exception.getMessage();
        assertEquals("numbers's length must 2^m where m is natural number 0,1,2,...etc.",message);
        // make sure this also apply to even length number
        int[] evenLengthFirst ={1,2,3,4,3,2};
        int[] evenLengthSeconde ={1,0,4,3,3,8};
        exception = assertThrows(NumberFormatException.class, ()->Karatsuba.multiply(evenLengthFirst, evenLengthSeconde));
        message = exception.getMessage();
        assertEquals("numbers's length must 2^m where m is natural number 0,1,2,...etc.",message);
    }
}
