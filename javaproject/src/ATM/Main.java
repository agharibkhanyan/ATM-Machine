package ATM;
import java.util.*;
import java.io.*;
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
	public static JFrameL p1=new JFrameL("Araz's Bank");	
	public static String choice,choice1,choice2,line;
	public static int fr=1,g=2,c=1;
	public static double start,code,ck,ca;
	public static String str,m1,word,name;
	public static String d3="Deposit";
	public static DecimalFormat df = new DecimalFormat("$#,##0.00;($#,##0.00)");
	public static Check c1;
	public static boolean saved;
	public static JTextArea ta;
	public static ArrayList <CheckingAccount> bank;
	public static JFrameL j1=new JFrameL(null);

	
	public static Deposit d1;
	public static String fileName="C;\\student\\Account.dat";

	//initialize t by itself because constructor has paramiters
	public static Transaction t;
	public static Panel frame;
	public static Deposit d =(Deposit)t;
	
	public static void main(String[] args) {
		//set frame message for the output panel
	frame=new Panel("Checking Account Operations");
	bank = new ArrayList<CheckingAccount>();
	
	//exit to close the output
	ta=new JTextArea(10,50);
    ta.setFont(new Font("Monospaced",Font.PLAIN, 12));
	
	frame.getContentPane().add(ta);
	frame.pack();
	frame.setVisible(true);
}
	//class to get transactions
public static void getTransactions(){
line=String.format("\tList of Transactions for \n"+"Name:"+a1.getName()+"\n"+
"Balance:"+df.format(a1.getBalance())+"\n"+"Total Service Charges:"+df.format(a1.getServiceCharge())+"\n"+
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
	ta.setText(line);

}// class to get the total checks
public static void getChecks(){
	line=String.format("Checks for "+a1.getName()+"\n"+
	"\nID\tCheck\tAmount\n");
	for(int i = 0;i<a1.gettransCount();i++){
		t=a1.getTrans(i);
		if(t.getTransId()==1){
			c1=(Check)t;
			line+=String.format("\n%-3d %7d %10s",t.getTransNumber(),c1.getCheckNumber(),df.format(t.getTransAmt()));
			
		
	}}
	JTextArea text=new JTextArea(line);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced",Font.PLAIN,16));
	ta.setText(line);
}//class for deposit

public static void getDeposits(){
	line=String.format("Deposit for "+a1.getName()+"\n"
	+"\nID\tType\tCheck\tCash\tAmount\n");
	for(int i = 0;i<a1.gettransCount();i++){
		t=a1.getTrans(i);  
		if(t.getTransId()==2){
			d1=(Deposit)t;
			line+=String.format("\n%-4d %8s %8s %6s %9s",t.getTransNumber(),"Deposit",df.format(d1.getCheck()),df.format(d1.getCash()),df.format(t.getTransAmt()));
	
	}}
	JTextArea text=new JTextArea(line);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced",Font.PLAIN,16));
	ta.setText(line);
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
	ta.setText(line);
}


// class to ask bank startup questions and get the initial input
	public static void getCode(){
		// if loop for first question then convert from string 
			name="";
			saved=false;
			name=JOptionPane.showInputDialog("Enter the account name");
			str=JOptionPane.showInputDialog("How much initial balance would you like to start with?");
			start=Double.parseDouble(str);
			a1=new CheckingAccount();
			// send the balance to checkings set balance method
			a1.setName(name);
			a1.setBalance(start,g,0,0.1,0.1);
			bank.add(a1);
			//add the initial variable that indicates the loop can never occur 
			
		
		}
	public static void findAccount(){
		name=JOptionPane.showInputDialog("Enter the search name ");
		for(int i = 0;i<bank.size();i++){
			if( name.equals(bank.get(i).getName())){
				a1=bank.get(i);
			line=name+" account was found " ;
			ta.setText(line);
			return;
		}
	line=name+ " account not in the list";
	ta.setText(line);}
	}
	public static void start(){
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
		}}
	}
	// i am having problems calling the transaction class in order
	//to send the numbers to the constructor so it records the transactions
	public static void transAmount(int a){
		double amt;
		int m;
	if (a==1){
		saved=false;
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
			choice+=a1.getName()+" Account\n"+
					"Transaction Check # "+m+"in the amount: "+df.format(amt)+"!\n"+
					"Current Balance: "+df.format(a1.getBalance())+"!\n";
			choice+="Service charge check__.15$\n"; 
			// if loop for first check
			if (a1.getBalance()<500&&a1.getSv()==1){
			// set service charge for check
			a1.setServiceCharge(5);
			choice+="Service Charge Below 500:Charge__5$\n";
			a1.setSv();
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
			saved=false;
			choice="";
				inputElements();
			amt=ca+ck;
			
			a1.setBalance(amt, a,0,ca,ck);
			a1.setServiceCharge(.10);
		  
			choice+=a1.getName()+" Account\n"+
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
	    if (result == JOptionPane.OK_OPTION)
	    {String cash,check;
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

	public static void readFile(){
		chooseFile(1);
		
		saved=true;
		try
		{
			FileInputStream fis=new
					FileInputStream(fileName);
				ObjectInputStream in=new
						ObjectInputStream(fis);
				
					bank=(ArrayList<CheckingAccount>)in.readObject();
				c=5;
				in.close();
					
		}
		catch(ClassNotFoundException e){
		    System.out.println(e);
        }

       catch (IOException e) 
        { 
            System.out.println(e);
        }
		}
		
	
	public static void chooseFile(int ioOption){
		  int status, confirm;       
       
	      String  message = "Would you like to use the current default file: \n" +fileName;
	      confirm = JOptionPane.showConfirmDialog (null, message);
	      if (confirm == JOptionPane.YES_OPTION)
	          return;
	      JFileChooser chooser = new JFileChooser();
	      if (ioOption == 1)
	          status = chooser.showOpenDialog (null);
	      else
	          status = chooser.showSaveDialog (null);
	      if (status == JFileChooser.APPROVE_OPTION)
	      {
	          File file = chooser.getSelectedFile();
	          fileName = file.getPath();
	      }
	}

	public static void writeFile(){
		 chooseFile(2);
		 
		 saved=true;
	      	try
			{
				FileOutputStream fos = new
				    FileOutputStream(fileName);
				ObjectOutputStream out = new
					       ObjectOutputStream(fos);
	            
	                         
					out.writeObject(bank);
	                        
	                        out.close();
			
			}	
		catch(IOException e)	
	                { 
	                     JOptionPane.showConfirmDialog(null, e);
	                }
	 
	}
	}


	
