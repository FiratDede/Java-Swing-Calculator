import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	String applicationName;
	double mainResult;
	char currentSign;
	JPanel topSection;
	JTextField mainScreen;
	JPanel buttonsSection;
	MyButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
	MyButton buttonPlus,buttonMinus,buttonMultiplication,buttonDivision,buttonEqual,buttonC,buttonReset,buttonDot;
	Calculator(){
		// Initialize some application properties
		this.applicationName="Calculator";
		this.setTitle(this.applicationName);
		this.mainResult=0.0;
		this.currentSign=' ';
		this.setBackground(Color.orange);
	
		
		topSection= new JPanel();
		topSection.setLayout(new BorderLayout());
		topSection.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		topSection.setBackground(Color.orange);
		
		
		mainScreen=new JTextField("0");
		mainScreen.setBackground(Color.black);
		mainScreen.setHorizontalAlignment(JTextField.RIGHT);
		mainScreen.disable();
		
		buttonsSection=new JPanel();
		buttonsSection.setLayout(new GridLayout(0,3,3,3));
		buttonsSection.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
		buttonsSection.setBackground(Color.orange);
		
		button0=new MyButton("0");
		button0.addActionListener(createActionListenerForNumberButton("0"));
		
		button1=new MyButton("1");
		button1.addActionListener(createActionListenerForNumberButton("1"));
		
		button2=new MyButton("2");
		button2.addActionListener(createActionListenerForNumberButton("2"));
		
		button3=new MyButton("3");
		button3.addActionListener(createActionListenerForNumberButton("3"));
		
		button4=new MyButton("4");
		button4.addActionListener(createActionListenerForNumberButton("4"));
		
		button5=new MyButton("5");
		button5.addActionListener(createActionListenerForNumberButton("5"));
		
		button6=new MyButton("6");
		button6.addActionListener(createActionListenerForNumberButton("6"));
		
		button7=new MyButton("7");
		button7.addActionListener(createActionListenerForNumberButton("7"));
		
		button8=new MyButton("8");
		button8.addActionListener(createActionListenerForNumberButton("8"));
		
		button9=new MyButton("9");
		button9.addActionListener(createActionListenerForNumberButton("9"));
		
		buttonPlus= new MyButton("+");
		buttonPlus.addActionListener(createActionListenerForPlusButton());
		
		
		buttonMinus= new MyButton("-");
		buttonMinus.addActionListener(createActionListenerForMinusButton());
		
		buttonMultiplication=new MyButton("*");
		buttonMultiplication.addActionListener(createActionListenerForMultiplicationButton());
		
		buttonDivision=new MyButton("/");
		buttonDivision.addActionListener(createActionListenerForDivisionButton());
		
		buttonEqual=new MyButton("=");
		buttonEqual.addActionListener(createActionListenerForEqualButton());
		
		buttonC=new MyButton("C");
		buttonC.addActionListener(createActionListenerForCButton());
		
		buttonReset=new MyButton("Reset");
		buttonReset.addActionListener(createActionListenerForResetButton());
		
		buttonDot=new MyButton(".");
		buttonDot.addActionListener(createActionListenerForDotButton());
		
		topSection.add(mainScreen,BorderLayout.NORTH);
		
		//Add Buttons to Button Section
		buttonsSection.add(button0);
		buttonsSection.add(button1);
		buttonsSection.add(button2);
		buttonsSection.add(button3);
		buttonsSection.add(button4);
		buttonsSection.add(button5);
		buttonsSection.add(button6);
		buttonsSection.add(button7);
		buttonsSection.add(button8);
		buttonsSection.add(button9);
		buttonsSection.add(buttonPlus);
		buttonsSection.add(buttonMinus);
		buttonsSection.add(buttonMultiplication);
		buttonsSection.add(buttonDivision);
		buttonsSection.add(buttonEqual);
		buttonsSection.add(buttonC);
		buttonsSection.add(buttonDot);
		buttonsSection.add(buttonReset);
		
		
		
		this.add(topSection,BorderLayout.NORTH);
		this.add(buttonsSection,BorderLayout.CENTER);
	
	
	}
	void run() {
		this.pack();
		this.setVisible(true);
	}
	ActionListener createActionListenerForNumberButton(String value) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mainScreen.getText().equals("0")) {
					mainScreen.setText(value);
					
				}
				else {
					mainScreen.setText(mainScreen.getText()+value);
				}
				
			}
		};
		
	}
	ActionListener createActionListenerForPlusButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")) {
					doOperation();
					mainScreen.setText("");
					currentSign='+';
				}
				
			}
		};
		
	}
	ActionListener createActionListenerForMinusButton() {
		return new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")&&!mainScreen.getText().equals("-") ) {
					doOperation();
					mainScreen.setText("");
					currentSign='-';
				}
				else if(mainScreen.getText().equals("")) {
					mainScreen.setText("-");
				}
				
			}
		};
		
		
	}
	ActionListener createActionListenerForMultiplicationButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")) {
					doOperation();
					mainScreen.setText("");
					currentSign='*';
				}
			}
		};
		
	}
	ActionListener createActionListenerForDivisionButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")) {
					doOperation();
					mainScreen.setText("");
					currentSign='/';
				}
			}
		};
		
	}
	ActionListener createActionListenerForEqualButton() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")) {
					doOperation();
					mainScreen.setText(""+mainResult);
					currentSign=' ';
				}
				
			}
		};
		
	}
	ActionListener createActionListenerForCButton() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")) {
					mainScreen.setText(mainScreen.getText().substring(0, mainScreen.getText().length()-1));	
				}
			}
		};
	}
	ActionListener createActionListenerForResetButton() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					mainScreen.setText("0");
					currentSign=' ';
			}
		};
		
	}
	ActionListener createActionListenerForDotButton() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainScreen.getText().equals("")&& !mainScreen.getText().contains(".")) {
					mainScreen.setText(mainScreen.getText()+".");
					
				}
				
			}
		};
	}
	
	void doOperation() {
		if(this.currentSign==' ') {
			mainResult=Double.parseDouble(mainScreen.getText());
		}
		else if(this.currentSign=='+'){
			mainResult+=Double.parseDouble(mainScreen.getText());
		}
		else if(this.currentSign=='-') {
			mainResult-=Double.parseDouble(mainScreen.getText());
		}
		else if(this.currentSign=='*') {
			mainResult*=Double.parseDouble(mainScreen.getText());
		}
		else if(this.currentSign=='/') {
			mainResult/=Double.parseDouble(mainScreen.getText());
		}
			
	}
	

}
