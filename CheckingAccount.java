package assignment1;
import java.util.*;
public class CheckingAccount extends Accounts {

	private double ServiceCharge;
	private double f;
	private String c;
	public int transCount;
	private ArrayList<Transaction>transList;
	public CheckingAccount(){
		super();
		transList=new ArrayList<Transaction>();
        transCount=0;
		ServiceCharge=getServiceCharge();
	}

	public CheckingAccount(String s, int e){
		super();
		transList=new ArrayList<Transaction>();
        transCount=0;
		ServiceCharge=getServiceCharge();
	}

	public void setBalance(double b,int c,int cn,double dca,double dchk) {
		

		if (c==1){
		balance-=b;
		Check ch=new Check(gettransCount(),c,b,cn);
		addTrans(ch);

		}
		else if(c==2){

		balance+=b;
		Deposit de=new Deposit(gettransCount(),c,b,dca,dchk);
		addTrans(de);
		}
		}
	public double getServiceCharge() {
		return ServiceCharge;
	}
	public void setServiceCharge(double s) {
		Transaction t=new Transaction(gettransCount(), 3, s);
		  
		ServiceCharge=ServiceCharge+s;
		
		 addTrans(t);
		
		
	}
	public void setF(double b,double c){
		f=b-c;
		}
	public double getF(){
		return f;
	}
	public void addTrans(Transaction newTrans){
		transList.add(newTrans);
		transCount++;

	}
	public int gettransCount(){
		return transCount;
	}
	public Transaction getTrans(int i){
		return transList.get(i);
		
	}
	public String getC(){
	return c;
}}
