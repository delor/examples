package junit;

import org.junit.*;

public class TimeoutTest {
    @Test(timeout = 3_000)
    public void testTimeout() throws Exception {
        Thread.sleep(2_000);
    }
}
