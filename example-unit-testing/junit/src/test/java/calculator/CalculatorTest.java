package calculator;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void emptyStringAddsToZero() throws Exception {
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void testOneNumber() throws Exception {
        int resultZero = calculator.add("0");
        int resultNegative = calculator.add("-5");
        int resultPositive = calculator.add("7");
        assertEquals(0, resultZero);
        assertEquals(-5, resultNegative);
        assertEquals(7, resultPositive);
    }

    @Test
    public void testManyNumbers() throws Exception {
        int resultZero = calculator.add("0,0");
        int resultDoubleNegative = calculator.add("-1,-1");
        int resultPositive = calculator.add("0,1");
        int resultNegative = calculator.add("-1,0");
        assertEquals(0, resultZero);
        assertEquals(-2, resultDoubleNegative);
        assertEquals(1, resultPositive);
        assertEquals(-1, resultNegative);
    }

    @Test
    public void testSeparators() throws Exception {
        int resultThree = calculator.add("1\n2");
        int resultSix = calculator.add("1\n2,3");
        assertEquals(3, resultThree);
        assertThat(resultThree, is(3));
        assertEquals(6, resultSix);
    }

    @Test
    public void testChangeSeparator() throws Exception {
        int result = calculator.add("//[;]\n1;2");
        int otherSeparatorRes = calculator.add("//[!]\n1!3");
        assertEquals(3, result);
        assertEquals(4, otherSeparatorRes);
    }

    @Test
    public void testRegExSpecialSymbolSeparator() throws Exception {
        int result = calculator.add("//[.]\n1.2");
        assertEquals(3, result);
    }

    @Test
    public void testMultiCharSeparator() throws Exception {
        int result = calculator.add("//[,,]\n2,,3");
        assertEquals(5,result);
        int result2 = calculator.add("//[...]\n2...3");
        assertEquals(5,result2);
        int result3 = calculator.add("//[***]\n2***3");
        assertEquals(5,result3);
    }

    @Test
    public void testManySeparator() throws Exception {
        int result = calculator.add("//[,,][ii][..][//]\n2//3,,1ii2..2");
        assertEquals(10,result);
    }
}
