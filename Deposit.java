package assignment1;

public class Deposit extends Transaction
{
	private double cash,check;
	private double total;
	public Deposit(int number, int id, double amount,double cash,double check) {
		super(number, id, amount);
		total=cash+check;
	
		
			
		
	

	}
	public double getTotal(){
		return total;
	}	
	public double getCash(){
		return cash;
	}
	public double getCheck(){
		return check;
	}
}

