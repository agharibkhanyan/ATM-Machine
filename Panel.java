package assignment1;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel extends JPanel{
	public static CheckingAccount a2=new CheckingAccount();
	// also having a problem setting up the interface and the buttons
	private JLabel prompt;
	private JRadioButton one, two, three,four,five;
	public Panel (){
		prompt=new JLabel("Choose your input");
		prompt.setFont(new Font("Arial",Font.BOLD,35));
		
		one=new JRadioButton("enter transaction");
		one.setBackground(Color.red);
		two=new JRadioButton("list all transactions");
		two.setBackground(Color.red);
		three=new JRadioButton("list all checks");
		three.setBackground(Color.red);
		four=new JRadioButton("list all deposits");
		four.setBackground(Color.red);
		five=new JRadioButton("list all service charges");
		five.setBackground(Color.red);
		
		ButtonGroup g=new ButtonGroup();
		g.add(one); g.add(two); 
		g.add(three); g.add(four);g.add(five);
		add(prompt);
		add(one);add(two);add(three);add(four);add(five);
		//for some reason the listener is giving me an error so i cant figure
		//out how to get it running
		BankActionListener listener = new BankActionListener();
		one.addActionListener(listener);
		two.addActionListener(listener);
		three.addActionListener(listener);
		four.addActionListener(listener);
		five.addActionListener(listener);
	setBackground(Color.white);
	setPreferredSize(new Dimension(400,200));
	}
private class BankActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			Object source=event.getSource();
			if(source==one)
				Main.getCode();
				
			if (source==two)	
				Main.getTransactions();
			if(source==three)
				Main.getChecks();
			if(source==four)
				Main.getDeposits();
			if(source==five)
				Main.getServiceCharge();
		}
	}
}
