package ATM;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Panel extends JFrameL{
	public static CheckingAccount a2=new CheckingAccount();
	// also having a problem setting up the interface and the buttons
	public static final int WIDTH=400;
	public static final int HEIGHT=200;
	private JMenu fileMenu,accountMenu,transactionMenu;
	private JMenuItem readFromFile,writeToFile,listAllCk,listAllDp,findAnAcct,listAll,addNew,addTrans;
	private JMenuBar bar;
	public Panel (String title){
		super(title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileMenu=new JMenu("File");
		
		BankActionListener ml=new BankActionListener();
		
		readFromFile=new JMenuItem("Read from File");
		readFromFile.addActionListener(ml);
		fileMenu.add(readFromFile);
		
		writeToFile=new JMenuItem("Write to File");
		writeToFile.addActionListener(ml);
		fileMenu.add(writeToFile);
		
		accountMenu=new JMenu("Accounts");
		
		addNew=new JMenuItem("Add new Account");
		addNew.addActionListener(ml);
		accountMenu.add(addNew);
		
		listAll=new JMenuItem("List all Transactions");
		listAll.addActionListener(ml);
		accountMenu.add(listAll);
		
		listAllCk=new JMenuItem("List all Checks");
		listAllCk.addActionListener(ml);
		accountMenu.add(listAllCk);
		
		listAllDp=new JMenuItem("List all Deposits");
		listAllDp.addActionListener(ml);
		accountMenu.add(listAllDp);
		
		findAnAcct=new JMenuItem("Find and Account");
		findAnAcct.addActionListener(ml);
		accountMenu.add(findAnAcct);
		
		transactionMenu=new JMenu("Transactions");
		
		addTrans=new JMenuItem("Add Transaction");
		addTrans.addActionListener(ml);
		transactionMenu.add(addTrans);
		
		bar=new JMenuBar();
		bar.add(fileMenu);
		bar.add(accountMenu);
		bar.add(transactionMenu);
		setJMenuBar(bar);
		
	}
private class BankActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			String source=event.getActionCommand();
			
			if(source.equals("Read from File"))
			Main.readFile();
			
				if(source.equals("Write to File"))
				Main.writeFile();
				
					if(source.equals("Add new Account"))
					Main.getCode();
					
						if(source.equals("List all Transactions"))
						Main.getTransactions();
					
							if(source.equals("List all Checks"))
							Main.getChecks();
						
								if(source.equals("List all Deposits"))
								Main.getDeposits();
								
									if(source.equals("Find and Account"))
									Main.findAccount();
									
										if(source.equals("Add Transaction"))
										Main.start();
				
			
		}
	}
}
