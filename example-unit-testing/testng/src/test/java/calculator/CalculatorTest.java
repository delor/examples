package calculator;

import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void emptyStringAddsToZero() throws Exception {
        int result = calculator.add("");
        Assert.assertEquals(0, result);
    }

    @DataProvider(name = "test1")
    public static Object[][] test1() {
        return new Object[][] {{"0", 0}, {"-5", -5}, {"7", 7}};
    }

    @Test(dataProvider = "test1")
    public void testOneNumber(String arg, int result) throws Exception {
        Assert.assertEquals(result, calculator.add(arg));
    }

    @Test
    public void testManyNumbers() throws Exception {
        int resultZero = calculator.add("0,0");
        int resultDoubleNegative = calculator.add("-1,-1");
        int resultPositive = calculator.add("0,1");
        int resultNegative = calculator.add("-1,0");
        Assert.assertEquals(0, resultZero);
        Assert.assertEquals(-2, resultDoubleNegative);
        Assert.assertEquals(1, resultPositive);
        Assert.assertEquals(-1, resultNegative);
    }

    @Test
    public void testSeparators() throws Exception {
        int resultThree = calculator.add("1\n2");
        int resultSix = calculator.add("1\n2,3");
        Assert.assertEquals(3, resultThree);
        Assert.assertEquals(6, resultSix);
    }

    @Test
    public void testChangeSeparator() throws Exception {
        int result = calculator.add("//[;]\n1;2");
        int otherSeparatorRes = calculator.add("//[!]\n1!3");
        Assert.assertEquals(3, result);
        Assert.assertEquals(4, otherSeparatorRes);
    }

    @Test
    public void testRegExSpecialSymbolSeparator() throws Exception {
        int result = calculator.add("//[.]\n1.2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void testMultiCharSeparator() throws Exception {
        int result = calculator.add("//[,,]\n2,,3");
        Assert.assertEquals(5, result);
        int result2 = calculator.add("//[...]\n2...3");
        Assert.assertEquals(5, result2);
        int result3 = calculator.add("//[***]\n2***3");
        Assert.assertEquals(5, result3);
    }

    @Test
    public void testManySeparator() throws Exception {
        int result = calculator.add("//[,,][ii][..][//]\n2//3,,1ii2..2");
        Assert.assertEquals(10, result);
    }
}
