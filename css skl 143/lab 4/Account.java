/**
 * Account.java
 *
 * This Account class represents bank accounts that stores money for an owner.
 *
 * Author: (put your name here)
 */
class Account
{
// Instance variables
	private double balance;	// invariant: balance >= 0 (should never be negative)
	private String owner;

//Constructor
	public Account(String name) {
		balance = 0;
		owner = name;
	}

// Instance methods
	/** Deposits 'amount' into the account
	 */
	public void deposit(int amount) {
		this.balance += amount;
	}

	/** Withdraws 'amount' from the account.
	 *	This only makes sense if amount <= balance.
	 *	This method should be re-written so that there is not a possibility of
	 *	having a negative balance.
	 */
	public void withdraw(int amount) {
		if (amount <= this.getBalance()) {
			this.balance -= amount;
		} else {
			System.err.println("Cannot withdraw $" + amount + ", account balance is only " + this.getBalance());
			return;
		}
	}

	/* Returns the balance of the Account
	 */
	public double getBalance() {
		return this.balance;
	}

	/* Returns the owner of the Account
	 */
	public String getOwner() {
		return this.owner;
	}
}

/* Question answers
 * 2a. watch window is in the center of the left panel (VS Code)
 * 2b. call stack is below watch on the bottom of the left panel, just above the breakpoints list
 * 3a. step over (F10) steps over a line of code (such as a function call), still running the code but skipping the minutia of running it step-by-step
 * 3bi. step into takes each line of code step by step, doing all the normal functions one at a time at the user's own pace
 * 3bii. step over skips this minutia and just executes a line wholesale, updating variables and things when it's done
 * 3ci. step out exits a call, such as a method, and finishes the original line you stepped into, stopping after that as if you had stepped over
 * 3cii. it's the inverse of stepping into, and different from stepping over as it allows you to effectively step over a line from anywhere inside its call
 * 3di. continues running the program as normal, not stopping for each step anymore
 * 3dii. if you only needed/wanted to analyze a portion of the program in steps, it allows you to resume operation as normal once you're done
 */