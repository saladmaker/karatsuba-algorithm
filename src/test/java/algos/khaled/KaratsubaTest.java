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
    @Test
    void testOneLevelRecursive(){
        int[] first ={1,5};
        int[] seconde ={2,6};
        int expected= 15*26;
        assertEquals(expected, Karatsuba.multiply(first, seconde));

        int[] firstZero ={0,0};
        int[] secondeNonZero ={5,8};
        expected=0;
        assertEquals(expected, Karatsuba.multiply(firstZero, secondeNonZero));
        
        int[] firstNonZero = {7,8};
        int[] secondeZero ={0,0};
        expected = 78*0;
        assertEquals(expected, Karatsuba.multiply(firstNonZero, secondeZero));
        
        int[] firstBig = {7,8};
        int[] secondeBig ={9,9};
        expected = 78*99;
        assertEquals(expected, Karatsuba.multiply(firstBig, secondeBig));
    }
    @Test
    void testBigNumber(){
        int[] first ={2,4,5,6};
        int[] seconde ={5,4,0,2};
        int expected = 2456*5402;
        assertEquals(expected, Karatsuba.multiply(first, seconde));
        
        int[] firstLeadingZero ={0,3,5,9};
        int[] secondeContainsZero ={8,7,0,2};
        expected = 359*8702;
        assertEquals(expected, Karatsuba.multiply(firstLeadingZero, secondeContainsZero));
        
        int[] firstContainsZero ={2,3,5,0};
        int[] secondeLeadingZero ={0,7,4,2};
        expected = 2350*742;
        assertEquals(expected, Karatsuba.multiply(firstContainsZero, secondeLeadingZero));
        
        int[] firstLeadingZeros ={0,0,0,8};
        int[] secondeContainsZeros ={8,1,0,0};
        expected = 8*8100;
        assertEquals(expected, Karatsuba.multiply(firstLeadingZeros, secondeContainsZeros));
        
        int[] firstContainsZeros ={9,0,0,0};
        int[] secondeLeadingZeros ={0,0,0,2};
        expected = 9000*2;
        assertEquals(expected, Karatsuba.multiply(firstContainsZeros, secondeLeadingZeros));        
    }
}
