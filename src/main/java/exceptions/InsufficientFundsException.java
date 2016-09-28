package exceptions;

@SuppressWarnings("serial")

public class InsufficientFundsException extends Exception {
	private double amount;
	
	public InsufficientFundsException(){
		
	}
	
	public InsufficientFundsException(double amount) {
		super();
		this.setAmount(amount);
		System.out.println("You have insufficient funds.");
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}