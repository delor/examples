package junit;

import example.*;
import org.junit.*;

import java.math.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AllAssertions {

    @Test
    @Ignore
    public void junitExamples() throws Exception {
        // Fails a test with no message.
        Assert.fail();

        // Fails a test with the given message.
        Assert.fail("message");

        // Asserts that two int arrays are equal.
        Assert.assertArrayEquals(new int[]{0}, new int[]{0});

        // Asserts that two objects are equal.
        Assert.assertEquals("Ala", "Ala");

        // Asserts that two objects are not equals.
        Assert.assertNotEquals("Ala", "kot");

        // Asserts that a condition is true.
        Assert.assertTrue(1 == 1);

        // Asserts that a condition is false.
        Assert.assertFalse(1 == 2);

        // Asserts that an object is null.
        Assert.assertNull(null);

        // Asserts that an object isn't null.
        Assert.assertNotNull(new Object());

        Object o1 = new Object();
        Object o2 = new Object();

        // Asserts that two objects refer to the same object.
        Assert.assertSame(o1, o1);

        // Asserts that two objects do not refer to the same object.
        Assert.assertNotSame(o1, o2);
    }

    @Test
    @Ignore
    public void hamcrestExamples() throws Exception {
        assertThat(new int[]{0, 1, 2, 3}, is(equalTo(new int[]{0, 1, 2, 3})));
        assertThat("Ala", equalTo("Ala"));
        assertThat("Ala", is("Ala"));
        assertThat("Ala", is(equalTo("Ala")));
        assertThat("Ala", is(not(equalTo("kot"))));
        assertThat("Ala ma kota", allOf(startsWith("Ala"), containsString(" ma "), endsWith("kota")));
        assertThat("Bartek Piech", both(startsWith("Bartek")).and(endsWith("Piech")));

        BigDecimal actual = new BigDecimal("1.2");
        BigDecimal expected = new BigDecimal("1.2");
        assertThat(actual, describedAs("a big decimal equal to %0", equalTo(expected), expected.toPlainString()));

        List<String> people = Arrays.asList("Bartek Piech", "Bartek Cebryk", "Bartek Mikulski");;
        assertThat(people, everyItem(startsWith("Bartek")));
        assertThat(people, hasItem(startsWith("Bartek")));
        assertThat(people, hasItems(startsWith("Bartek"), endsWith("i")));

        Cheese cheese = new Cheddar();
        assertThat(cheese, is(notNullValue()));
        assertThat(cheese, isA(Cheese.class));
        assertThat(cheese, is(instanceOf(Cheddar.class)));
    }
}
