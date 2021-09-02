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
    @Test
    void testNullArrayNumber(){
        int[] firstNull = null;
        int[] seconde ={1,2,5,4};
        Exception exception = assertThrows(NumberFormatException.class, ()->Karatsuba.multiply(firstNull, seconde));
        String message = exception.getMessage();
        assertEquals("first number is null",message);
        // applying matrix case checking
        int[] first ={1,2,5,4};
        int[] secondeNull = null;
        exception = assertThrows(NumberFormatException.class, ()->Karatsuba.multiply(first, secondeNull));
        message = exception.getMessage();
        assertEquals("seconde number is null",message);
    }
    @Test
    void testBaseCase(){
        int[] first = {2};
        int[] seconde ={6};
        int expected = first[0]*seconde[0];
        assertEquals(expected, Karatsuba.multiply(first, seconde));
        
        int[] firstZero = {0};
        int[] secondeNonZero ={4};
        expected = firstZero[0]*secondeNonZero[0];
        assertEquals(expected, Karatsuba.multiply(firstZero, secondeNonZero));
        
        int[] firstNonZero = {3};
        int[] secondeZero ={0};
        expected = firstNonZero[0]*secondeZero[0];
        assertEquals(expected, Karatsuba.multiply(firstNonZero, secondeZero));       
    }
}
