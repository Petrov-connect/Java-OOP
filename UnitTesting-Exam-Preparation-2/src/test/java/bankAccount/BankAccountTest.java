package bankAccount;
//created by J.M.

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {


    private static final BigDecimal testValue = BigDecimal.valueOf(100.1);
    private static final String testName = "testAccount";
    private static String testParameter;
    private static BigDecimal testParam;

    BankAccount bankAccount;

    @Before
    public void setUp(){

       bankAccount = new BankAccount(testName,testValue);
    }

    @Test
    public void testConstructorMustCreateObjectWhitCorrectParameters(){
        Assert.assertEquals(testValue,bankAccount.getBalance());
        Assert.assertEquals(testName,bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameMustFailsWhenParameterIsLessThenLengthThree(){
        testParameter  = "ab";
        bankAccount = new BankAccount(testParameter,testValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameMustFailsWhenParameterIsBiggerThenLength25(){
        testParameter  = "aaaaasssssdddddfffffgggggh";
        bankAccount = new BankAccount(testParameter,testValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBalanceMustFailsWhenParameterIsLessThenZero(){
        testParam = BigDecimal.valueOf(-1.1);
        bankAccount = new BankAccount(testName,testParam);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDepositMustFailsWhenParameterIsLessThenZero(){
        testParam = BigDecimal.valueOf(-1.1);
        bankAccount.deposit(testParam);
    }

    @Test
    public void testDepositMustAddCorrectParameter(){
        testParam = BigDecimal.valueOf(10.1);
        BigDecimal expected = bankAccount.getBalance().add(testParam);
        bankAccount.deposit(testParam);
        Assert.assertEquals(expected,bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testWithdrawMustFailsWhenParameterIsLessOrEqualsZero(){
        testParam = BigDecimal.valueOf(-1.1);
        bankAccount.withdraw(testParam);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testWithdrawMustFailsWhenParameterIsBiggerThenCurrentBalance(){
        testParam = BigDecimal.valueOf(101.1);
        bankAccount.withdraw(testParam);
    }

    @Test
    public void testWithdrawMustSubtractBalanceWhenParameterIsCorrect(){
        testParam = BigDecimal.valueOf(11.1);
        BigDecimal expected = bankAccount.getBalance().subtract(testParam);
        Assert.assertEquals(testParam,bankAccount.withdraw(testParam));
        Assert.assertEquals(expected,bankAccount.getBalance());
    }
}