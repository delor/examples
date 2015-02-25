package junit;

import example.Person;
import org.junit.*;

public class BasicAssertions {

    @Test
    public void basicAssertion() throws Exception {
        assert 1 == 1;
    }

    @Test
    public void testTrue() throws Exception {
        Assert.assertTrue(1 + 1 == 2);
    }

    @Test
    public void testFalse() throws Exception {
        Assert.assertFalse(1 + 1 == 3);
    }

    @Test
    public void testIntegersEquality() throws Exception {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testThatIntegersDiffer() throws Exception {
        Assert.assertNotEquals(1, 2);
    }

    @Test
    public void testEqualityOfDoubles() throws Exception {
        Assert.assertEquals(2.32 * 3, 6.96, 0.0005);
    }

    @Test
    public void testArrayEquality() throws Exception {
        Assert.assertArrayEquals(
                new int[]{1, 2, 3},
                new int[]{1, 2, 3}
        );
    }

    @Test
    public void testThatPassedObjectIsTheSameThatGotReturned() throws Exception {
        Person expected = new Person("Bartek", 18);
        Person actual = returnTheSame(expected);
        Assert.assertSame(expected, actual);
    }

    static public Person returnTheSame(Person person) {
        return person;
    }

    static public Person returnNew(Person person) {
        return new Person(person.name(), person.age());
    }

    @Test
    public void testNull() throws Exception {
        Object object = null;
        Assert.assertNull(object);
    }
}
