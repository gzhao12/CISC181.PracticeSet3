package pkgMain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pkgMain.Account;
import exceptions.InsufficientFundsException;

public class AccountTest {
	private Account testAccount;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testAccount = new Account(1122, 20000, 4.5);
	}

	@After
	public void tearDown() throws Exception {
		System.out.printf("The balance is: $%.2f \n", testAccount.getBalance());
		System.out.println("The monthly interest is " + testAccount.getMonthlyInterestRate() + "%");
		System.out.println("The account was created on " + testAccount.getDateCreated() + "\n");
	}

	@Test
	public void testGetDateCreated() {
		assertTrue(testAccount.getDateCreated() == null);
	}

	@Test
	public void testGetMonthlyInterestRate() {
		double monthlyInterestRate = testAccount.getAnnualInterestRate() / 12;
		assertTrue(testAccount.getMonthlyInterestRate() == monthlyInterestRate);
	}

	@Test
	public void testDeposit() {
		double depositAmount = 3000;
		double expectedBalance = testAccount.getBalance() + depositAmount;
		testAccount.deposit(depositAmount);
		assertTrue(testAccount.getBalance() == expectedBalance);
	}

	@Test
	public void testWithdraw() throws InsufficientFundsException {
		double withdrawAmount = 2500;
		double expectedBalance = testAccount.getBalance() - withdrawAmount;
		testAccount.withdraw(withdrawAmount);
		assertTrue(testAccount.getBalance() == expectedBalance);
	}

	@Test(expected = InsufficientFundsException.class)
	public void testWithdrawWithException() throws InsufficientFundsException {
		double originalBalance = testAccount.getBalance();
		testAccount.withdraw(999999);
		assertTrue(testAccount.getBalance() == originalBalance);
	}
}