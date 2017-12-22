package assignment1;
import java.util.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.text.DecimalFormat;
public class Main {
	// create a callback for the checkings account and set variable = to the checkings account
	public static CheckingAccount a1=new CheckingAccount();
	public static double account=a1.getBalance();
	//do the same for Panel so you can use variable p1 for callback purposes
	public static Panel p1=new Panel();	
	public static String choice,choice1,choice2,line;
	public static int fr=1,g=2,c=1,m;
	public static double start,code,ck,ca;
	public static String str,m1,word,cash,check,name;
	public static String d3="Deposit";
	public static DecimalFormat df = new DecimalFormat("$#,##0.00;($#,##0.00)");
	public static Check c1=new Check(25,26,89.5,27);

	//initialize t by itself because constructor has paramiters
	public static Transaction t;
	public static JFrame frame;
	public static Deposit d =(Deposit)t;
	public static void main(String[]args){
		//set frame message for the output panel
	frame=new JFrame("Checking Account Actions");
	//exit to close the output
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(p1);
	frame.pack();
	frame.setVisible(true);
}
	//class to get transactions
public static void getTransactions(){
line=String.format("\tList of Transactions for \n"+"Name"+name+"\n"+
			"\nID\t\tType\t\tAmount\n");
	// set for loop to run trough transaction count
	for(int i = 0;i<a1.gettransCount();i++){
		t=a1.getTrans(i);
		switch (t.getTransId()){
		case 1:word="Check";
		line+=String.format("%-3d  %15s   %15s",t.getTransNumber(),"Check",df.format(t.getTransAmt()))+"\n";

		break;
		case 2:word="Deposit";
		line+=String.format("%-3d  %15s   %15s",t.getTransNumber(),"Deposit",df.format(t.getTransAmt()))+"\n";

		break;
		case 3:word="Service Charge";
		line+=String.format("%-3d  %15s   %15s",t.getTransNumber(),"Srv. Charge",df.format(t.getTransAmt()))+"\n";
		break;
	}	
	}
	JTextArea text=new JTextArea(line);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced",Font.PLAIN,16));
	JOptionPane.showMessageDialog(null, text);

}// class to get the total checks
public static void getChecks(){
	line=String.format("Checks for "+name+"\n"+
	"\nID\tCheck\tAmount\n");
	for(int i = 0;i<a1.gettransCount();i++){
		t=a1.getTrans(i);
		if(t.getTransId()==1){
			line+=String.format("\n%-3d %7d %10s",t.getTransNumber(),m,df.format(t.getTransAmt()));
			
		
	}}
	JTextArea text=new JTextArea(line);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced",Font.PLAIN,16));
	JOptionPane.showMessageDialog(null, text);
}//class for deposit
public static void getDeposits(){
	line=String.format("Deposit for "+name+"\n"
	+"\nID\tType\tCheck\tCash\tAmount\n");
	for(int i = 0;i<a1.gettransCount();i++){
		t=a1.getTrans(i);  
		if(t.getTransId()==2){
			line+=String.format("\n%-4d %8s %8s %6s %9s",t.getTransNumber(),"Deposit",df.format(ck),df.format(ca),df.format(t.getTransAmt()));
	
	}}
	JTextArea text=new JTextArea(line);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced",Font.PLAIN,16));
	JOptionPane.showMessageDialog(null, text);
}
public static void getServiceCharge(){
	line=String.format("Service Charges\n"
+"\nID         Amount\n");
	for(int i = 0;i<a1.gettransCount();i++){
		t=a1.getTrans(i); 
		if(t.getTransId()==3)
		line+=String.format("\n%-3d %10s",t.getTransNumber(),df.format(t.getTransAmt()));

	}
	JTextArea text=new JTextArea(line);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced",Font.PLAIN,16));
	JOptionPane.showMessageDialog(null, text);
}
// class to ask bank startup questions and get the initial input
	public static void getCode(){
		// if loop for first question then convert from string 
		if(c==1){
			str=JOptionPane.showInputDialog("Hello Welcome to Bank of Atula how much money would you like to start with?");
			start=Double.parseDouble(str);
			name=JOptionPane.showInputDialog("Enter the account name");
			// send the balance to checkings set balance method
			a1.setBalance(start,g,0,0.1,0.1);
			//add the initial variable that indicates the loop can never occur 
			c++;
		}
		
		DecimalFormat df = new DecimalFormat("$#,##0.00;($#,##0.00)");
		//set variable to then use to only run loop once
		int am=3;
		//set a while statnment to ask menu options which will be killed in case of a 0
		while (am!=0){
		choice1=JOptionPane.showInputDialog("What would you like to do today?\n"
				+ "1.Write a check in the amount of:\n"
				+ "2.Deposit a check in the amount of:\n"
				+ "0.Exit!");
		//convert answer
		am=Integer.parseInt(choice1);
	//put if statnments that calls a method 
		if (am==1){
		transAmount(am);
		}
		if(am==2){
		transAmount(am);
		frame.setVisible(true);
		}
		if(am==0){
			//if 0 kill the program and display message 
				a1.setF(a1.getBalance(),a1.getServiceCharge());
				choice="Transaction End:\n"+
				"Current Balance: "+df.format(a1.getBalance())+"!\n"+
				"Total Service Charges: "+df.format(a1.getServiceCharge())+"!\n"+
					"Final balance: "+df.format(a1.getF());
				JOptionPane.showMessageDialog(null, choice);
		}
		}
	}
	// i am having problems calling the transaction class in order
	//to send the numbers to the constructor so it records the transactions
	public static void transAmount(int a){
		double amt;
		
	if (a==1){
		// reset choice
		choice="";
		choice1=JOptionPane.showInputDialog("Enter the check amount you want to write!");
		amt=Double.parseDouble(choice1);
		choice2=JOptionPane.showInputDialog("Enter the check Number");
		m=Integer.parseInt(choice2);
			a1.setBalance(amt, a,m,0.1,0.1);
			//set new balance
			// set the service charge for the transaction
			a1.setServiceCharge(.15);
			// create message for transaction amount and current balance 
			choice+=name+" Account\n"+
					"Transaction Check # "+m+"in the amount: "+df.format(amt)+"!\n"+
					"Current Balance: "+df.format(a1.getBalance())+"!\n";
			choice+="Service charge check__.15$\n"; 
			// if loop for first check
			if (a1.getBalance()<500&&fr==1){
			// set service charge for check
			a1.setServiceCharge(5);
			choice+="Service Charge Below 500:Charge__5$\n";
			fr++;
			}
			if (a1.getBalance()<50){
				choice+="Warning Balance below 50:\n";
			}
			if(a1.getBalance()<0){
				a1.setServiceCharge(10);
				choice+="Service Charge balance below 0:__$10\n";
			}
			choice+="Total Service Charge:"+df.format(a1.getServiceCharge());
			JOptionPane.showMessageDialog(null, choice);	
				}
		if(a==2){
			
			choice="";
				inputElements();
			amt=ca+ck;
			
			a1.setBalance(amt, a,0,ca,ck);
			a1.setServiceCharge(.10);
		  
			choice+=name+" Account\n"+
					"Transaction in the amount: "+df.format(amt)+"!\n"+
					"Current Balance: "+df.format(a1.getBalance())+"!\n";
			choice+="Service charge deposit__.10$\n";
			choice+="Total Service Charge:"+df.format(a1.getServiceCharge());
			JOptionPane.showMessageDialog(null, choice);	
	}
		
	
	}
	public static void inputElements()
	   {  
	      // String cash="", check="";
	       frame.setVisible(false);

	 
	    
	    JTextField field1 = new JTextField("");
	    JTextField field2 = new JTextField("");

	    JPanel panel = new JPanel(new GridLayout(0, 1));

	    panel.add(new JLabel("Cash"));
	    panel.add(field1);
	    panel.add(new JLabel("Check"));
	    panel.add(field2);
	    field1.addAncestorListener(new SetFocus());
	   field1.requestFocusInWindow();
	   panel.setCursor(panel.getCursor());
	   panel.setVisible(true);
	    int result = JOptionPane.showConfirmDialog(null, panel, "Test",
	        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    if (result == JOptionPane.OK_OPTION) {
	           cash=field1.getText();
	           ca=Double.parseDouble(cash);
	           
	           check= field2.getText();
	           ck=Double.parseDouble(check);
	        
	    } else {
	        System.out.println("Cancelled");
	       System.exit(0);
	    }
	    
	    }
	private static class SetFocus implements AncestorListener {



	  public void ancestorAdded(AncestorEvent e) {
	    JComponent component = e.getComponent();
	    component.requestFocusInWindow();

	   
	  }

	  public void ancestorMoved(AncestorEvent e) {
	  }

	  public void ancestorRemoved(AncestorEvent e) {
	  }
	}

	

	}


	
