package calculator;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedCalcTest {
    @Parameterized.Parameter(0) public String args;
    @Parameterized.Parameter(1) public int result;
    Calculator calculator;

    @Parameterized.Parameters(name = "arg = \"{0}\", result = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "", 0 }, { "0", 0 }, { "1", 1 }, { "2", 2 }, { "3", 3 }, { "4", 4 }
        });
    }

    @Before public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testOneNumber() throws Exception {
        assertEquals(result, calculator.add(args));
    }
}
