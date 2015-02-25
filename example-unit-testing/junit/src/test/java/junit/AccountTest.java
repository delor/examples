package junit;

import example.Account;
import org.junit.*;
import org.junit.rules.*;

public class AccountTest {

    static final int INITIAL_BALANCE = 0;
    static final int AMOUNT_TO_BE_WITHDRAWN = 1;

    Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(INITIAL_BALANCE);
    }

    @Test(expected = Account.InsufficientFunds.class)
    public void throwsWhenWithdrawingTooMuch1() throws Exception {
        account.withdraw(AMOUNT_TO_BE_WITHDRAWN);
    }

    @Test
    public void throwsWhenWithdrawingTooMuch2() throws Exception {
        try {
            account.withdraw(AMOUNT_TO_BE_WITHDRAWN);
            Assert.fail();
        } catch (Account.InsufficientFunds expected) {
            Assert.assertEquals(expected.getMessage(), "Not enough funds in account");
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionRule() {
        thrown.expect(Account.InsufficientFunds.class);
        thrown.expectMessage("Not enough funds in account");

        account.withdraw(AMOUNT_TO_BE_WITHDRAWN);
    }

}
