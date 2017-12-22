package assignment1;

public class Deposit extends Transaction
{
	private double cash,check;
	private double total;
	public Deposit(int number, int id, double amount,double ca,double ck) {
		super(number, id, amount);
		total=cash+check;
		cash=ca;
		check=ck;
		
			
		
	

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

