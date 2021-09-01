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
}
