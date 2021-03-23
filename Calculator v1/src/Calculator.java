import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField jtfValue;
	private JButton jbtnSign;
	JLabel jlblCal;
	boolean isDecimal=false;	//if decimal point has been pressed; to avoid multiple decimals in a number
	boolean isBrackets=false;	//if brackets have been opened or not, to close brackets if opened
	boolean isOperator=false;	//if an operator has already been pressed, to go for val2 if the operator has been pressed.s
	boolean isMulOp=false;		//to check if multiple operators are being pressed, to solve sequentail operations, manage val1 and val2
	boolean isEqual=false;		//to carry sequential operations when equal to sign is pressed multiple times
	char operation='@';		//initial value of operation which can be +, -, * or /
	double val1, val2,result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("CALCULATOR  (v1)");
		frmCalculator.setBounds(100, 100, 385, 538);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		jtfValue = new JTextField();
		jtfValue.setEditable(false);
		jtfValue.setBackground(Color.LIGHT_GRAY);
		jtfValue.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfValue.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtfValue.setBounds(37, 84, 296, 73);
		frmCalculator.getContentPane().add(jtfValue);
		jtfValue.setColumns(10);
		
		jbtnSign = new JButton("+/-");
		jbtnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtfValue.getText().length()>0)
				{
					//System.out.println(jtfValue.getText());
					Double temp=Double.parseDouble(jtfValue.getText());
					temp=temp*-1;
					jlblCal.setText(Double.toString(temp));
					jtfValue.setText(Double.toString(temp));
				}
			}
		});
		jbtnSign.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnSign.setBounds(37, 444, 55, 37);
		frmCalculator.getContentPane().add(jbtnSign);
		
		JButton jbtn0 = new JButton("0");
		jbtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"0");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"0");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"0");				 
			}
		});
		jbtn0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn0.setBounds(118, 444, 55, 37);
		frmCalculator.getContentPane().add(jbtn0);
		
		JButton jbtnDecimal = new JButton(".");
		jbtnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isDecimal==false)
				{
					jtfValue.setText(jtfValue.getText()+".");
					isDecimal=true;
				}
			}
		});
		jbtnDecimal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jbtnDecimal.setBounds(199, 443, 55, 37);
		frmCalculator.getContentPane().add(jbtnDecimal);
		
		JButton jbtn1 = new JButton("1");
		jbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed, val1 is received
				{
					jtfValue.setText(jtfValue.getText()+"1");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"1");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"1");
			}
		});
		jbtn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn1.setBounds(37, 379, 55, 37);
		frmCalculator.getContentPane().add(jbtn1);
		
		JButton jbtn2 = new JButton("2");
		jbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)
				{
					jtfValue.setText(jtfValue.getText()+"2");
				}
				else
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"2");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"2");
			}
		});
		jbtn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn2.setBounds(118, 379, 55, 37);
		frmCalculator.getContentPane().add(jbtn2);
		
		JButton jbtn3 = new JButton("3");
		jbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"3");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"3");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"3");
			}
		});
		jbtn3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn3.setBounds(199, 379, 55, 37);
		frmCalculator.getContentPane().add(jbtn3);
		
		JButton jbtn4 = new JButton("4");
		jbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"4");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"4");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"4");
			}
		});
		jbtn4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn4.setBounds(37, 318, 55, 37);
		frmCalculator.getContentPane().add(jbtn4);
		
		JButton jbtn5 = new JButton("5");
		jbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"5");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"5");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"5");
			}
		});
		jbtn5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn5.setBounds(118, 318, 55, 37);
		frmCalculator.getContentPane().add(jbtn5);
		
		JButton jbtn6 = new JButton("6");
		jbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"6");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"6");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"6");	
			}
		});
		jbtn6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn6.setBounds(199, 318, 55, 37);
		frmCalculator.getContentPane().add(jbtn6);
		
		JButton jbtn7 = new JButton("7");
		jbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"7");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"7");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"7");
			}
		});
		jbtn7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn7.setBounds(37, 254, 55, 37);
		frmCalculator.getContentPane().add(jbtn7);
		
		JButton jbtn8 = new JButton("8");
		jbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"8");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"8");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"8");
			}
		});
		jbtn8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn8.setBounds(118, 254, 55, 37);
		frmCalculator.getContentPane().add(jbtn8);
		
		JButton jbtn9 = new JButton("9");
		jbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOperator)	//operator not pressed
				{
					jtfValue.setText(jtfValue.getText()+"9");					
				}
				else	//operator has pressed, clear text and write for the val2
				{
					isDecimal=false;
					jtfValue.setText("");
					jtfValue.setText(jtfValue.getText()+"9");
					isOperator=false;
				}
				//val1=Double.parseDouble(jtfValue.getText());
				//jlblCal.setText(Double.toString(val1));
				jlblCal.setText(jlblCal.getText()+"9");
			}
		});
		jbtn9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtn9.setBounds(199, 254, 55, 37);
		frmCalculator.getContentPane().add(jbtn9);
		
		JButton jbtnC = new JButton("C");
		jbtnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				jtfValue.setText("");
				jlblCal.setText("");
				val1=val2=result=0;
				isBrackets=isDecimal=isEqual=isOperator=isMulOp=false;
				System.out.println();
			}
		});		
		jbtnC.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbtnC.setBounds(37, 190, 55, 37);
		frmCalculator.getContentPane().add(jbtnC);
		
		JButton jbtnCe = new JButton("CE");
		jbtnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfValue.setText("");
				if(operation=='@')	//operator not pressed, val1 is to be erased
				{
					val1=0.0;
					jlblCal.setText("");
				}
				else	//to work on val2
				{
					val2=0.0;
					jlblCal.setText(Double.toString(val1) + operation);  
				}
			}
		});
		jbtnCe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtnCe.setBounds(118, 190, 55, 37);
		frmCalculator.getContentPane().add(jbtnCe);
		
		JButton jbtnPercentage = new JButton("%");
		jbtnPercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1=Double.parseDouble(jtfValue.getText());
				operation='%';
			}
		});
		jbtnPercentage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jbtnPercentage.setBounds(199, 191, 55, 37);
		frmCalculator.getContentPane().add(jbtnPercentage);
		
		JButton jbtnEquals = new JButton("=");
		jbtnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//val2=Double.parseDouble(jtfValue.getText());
				if(operation=='+')	
				{
					if(isEqual)	//= sign pressed multiple times
					{
						jlblCal.setText(result+"+"+val2);
						result=result+val2;
						jtfValue.setText(Double.toString(result));
					}
					else
					{
						val2=Double.parseDouble(jtfValue.getText());
						jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
						result=val1+val2;
						jtfValue.setText(Double.toString(result));
						isEqual=true;
					}
				}
				
				if(operation=='-')	
				{
					if(isEqual)
					{
						result=result-val2;
						jtfValue.setText(Double.toString(result));
					}
					else
					{
						val2=Double.parseDouble(jtfValue.getText());
						jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
						result=val1-val2;
						jtfValue.setText(Double.toString(result));
						isEqual=true;
					}
				}
				
				if(operation=='*')	
				{
					if(isEqual)
					{
						result=result*val2;
						jtfValue.setText(Double.toString(result));
					}
					else
					{
						val2=Double.parseDouble(jtfValue.getText());
						jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
						result=val1*val2;
						jtfValue.setText(Double.toString(result));
						isEqual=true;
					}
				}
				
				if(operation=='/')	
				{
					if(isEqual)
					{
						result=result/val2;
						jtfValue.setText(Double.toString(result));
					}
					else
					{
						val2=Double.parseDouble(jtfValue.getText());
						jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
						result=val1/val2;
						jtfValue.setText(Double.toString(result));
						isEqual=true;
					}
				}
				
				
			}
		});
		jbtnEquals.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnEquals.setBounds(278, 446, 55, 37);
		frmCalculator.getContentPane().add(jbtnEquals);
		
		JButton jbtnAdd = new JButton("+");
		jbtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOperator=true;		
				//operation='+';
				if(isMulOp==false)	//+ pressed for the first time
				{
					operation='+';
					val1=Double.parseDouble(jtfValue.getText());
					jlblCal.setText(Double.toString(val1) + operation);
					isMulOp=true;
				}
				else if(isMulOp==true)	//sequentioal operations
				{
					getResult();
					val1=result;
					operation='+';
					jlblCal.setText(Double.toString(val1)+operation);
				}
			
			}
		});
		jbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jbtnAdd.setBounds(278, 379, 55, 37);
		frmCalculator.getContentPane().add(jbtnAdd);
		
		JButton jbtnSubtract = new JButton("-");
		jbtnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOperator=true;		
				//operation='-';
				if(isMulOp==false)	//- pressed for the first time
				{
					operation='-';
					val1=Double.parseDouble(jtfValue.getText());
					jlblCal.setText(Double.toString(val1) + operation);
					isMulOp=true;					
				}
				else if(isMulOp==true)	//sequentioal operations
				{
					getResult();
					val1=result;
					operation='-';
					jlblCal.setText(Double.toString(val1)+operation);
				}
			}
		});
		jbtnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jbtnSubtract.setBounds(278, 318, 55, 37);
		frmCalculator.getContentPane().add(jbtnSubtract);
		
		JButton jbtnMultiply = new JButton("*");
		jbtnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOperator=true;		
				//operation='+';
				if(isMulOp==false)	//* pressed for the first time
				{
					operation='*';
					val1=Double.parseDouble(jtfValue.getText());
					jlblCal.setText(Double.toString(val1) + operation);
					isMulOp=true;
				}
				else if(isMulOp==true)	//sequentioal operations
				{
					getResult();
					val1=result;
					operation='*';
					jlblCal.setText(Double.toString(val1)+operation);
				}
			}
		});
		jbtnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jbtnMultiply.setBounds(278, 254, 55, 37);
		frmCalculator.getContentPane().add(jbtnMultiply);
		
		JButton jbtnDivide = new JButton("/");
		jbtnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOperator=true;		
				//operation='+';
				if(isMulOp==false)	/// pressed for the first time
				{
					operation='/';
					val1=Double.parseDouble(jtfValue.getText());
					jlblCal.setText(Double.toString(val1) + operation);
					isMulOp=true;
				}
				else if(isMulOp==true)	//sequentioal operations
				{
					getResult();
					val1=result;
					operation='/';
					jlblCal.setText(Double.toString(val1)+operation);
				}
			}
		});
		jbtnDivide.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jbtnDivide.setBounds(278, 190, 55, 37);
		frmCalculator.getContentPane().add(jbtnDivide);
		
		jlblCal = new JLabel("");
		jlblCal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlblCal.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblCal.setBounds(37, 26, 296, 48);
		frmCalculator.getContentPane().add(jlblCal);
	
}

public void getResult()
{
	if(operation=='+')	
	{
		val2=Double.parseDouble(jtfValue.getText());
		jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
		result=val1+val2;
		jtfValue.setText(Double.toString(result));
		isEqual=true;		
	}
	if(operation=='-')	
	{
		val2=Double.parseDouble(jtfValue.getText());
		jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
		result=val1-val2;
		jtfValue.setText(Double.toString(result));
		isEqual=true;		
	}
	if(operation=='*')	
	{
		val2=Double.parseDouble(jtfValue.getText());
		jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
		result=val1*val2;
		jtfValue.setText(Double.toString(result));
		isEqual=true;		
	}
	if(operation=='/')	
	{
		val2=Double.parseDouble(jtfValue.getText());
		jlblCal.setText(Double.toString(val1) + operation + Double.toString(val2));
		result=val1/val2;
		jtfValue.setText(Double.toString(result));
		isEqual=true;		
	}
}

}

//end of code