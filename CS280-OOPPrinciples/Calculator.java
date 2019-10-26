
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JApplet implements ActionListener{
	
	JTextField result;
	JTextField operand;
	JButton[] numbers = new JButton[10];
	double resultNum = 0.0, num1, num2;
	String OPString = "";
	
	//initialize calculator
	public void init() {
		Font f = new Font("Helvetica", 1, 30);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//create two text fields, one for result and one for operator
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(2,1));
		
		result = new JTextField("Result", 100);
		result.setBackground(Color.WHITE);
		result.setEditable(false);
		result.setFont(f);
		text.add(result);
		
		operand = new JTextField("Operand", 100);
		operand.setBackground(Color.WHITE);
		operand.setEditable(false);
		operand.setFont(f);
		text.add(operand);
		
		
		contentPane.add(text, BorderLayout.NORTH);
		
		//create buttons 0 - 9 and put them in the center of the content pane
		JPanel numberButtons = new JPanel();
		numberButtons.setLayout(new FlowLayout());
		
		Dimension d = new Dimension(100, 100);
		
		//create all 10 buttons in a loop
		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton("" + i);
			numbers[i].addActionListener(this);
			numbers[i].setPreferredSize(d);
			numbers[i].setFont(f);
			numberButtons.add(numbers[i]);
		}
		
		contentPane.add(numberButtons, BorderLayout.CENTER);
		
		//create operators 
		JPanel operators = new JPanel();
		operators.setLayout(new FlowLayout());
		
		JButton add = new JButton("+");
		add.addActionListener(this);
		add.setPreferredSize(d);
		add.setFont(f);
		operators.add(add);
		
		JButton subtract = new JButton("-");
		subtract.addActionListener(this);
		subtract.setPreferredSize(d);
		subtract.setFont(f);
		operators.add(subtract);
		
		JButton multiply = new JButton("*");
		multiply.addActionListener(this);
		multiply.setPreferredSize(d);
		multiply.setFont(f);
		operators.add(multiply);
		
		JButton divide = new JButton("/");
		divide.addActionListener(this);
		divide.setPreferredSize(d);
		divide.setFont(f);
		operators.add(divide);
		
		JButton equals = new JButton("=");
		equals.addActionListener(this);
		equals.setPreferredSize(d);
		equals.setFont(f);
		operators.add(equals);
		
		JButton reset = new JButton("reset");
		reset.addActionListener(this);
		reset.setPreferredSize(d);
		reset.setFont(new Font("Helvetica", 1, 15));
		operators.add(reset);
		
		contentPane.add(operators, BorderLayout.SOUTH);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String buttonString = e.getActionCommand();
		
		if (operand.getText().equals("Operand")){
			operand.setText("");
		}
		
		//loop through all number buttons to see if they were pressed
		for (int i = 0; i < 10; i++) {
			if (buttonString.equals("" + i))
				operand.setText(operand.getText() + e.getActionCommand());
		}
		
		 if (buttonString.equals("+")) {
			OPString = "+";
			//set result pane empty
			if (result.getText().equals("Result"))
				result.setText("");
			//set first number to operand
			num1 = stringToDouble(operand.getText());
			//set number to result
			result.setText(Double.toString(num1));
			//set operand back to blank
			operand.setText("");
			
		}
		else if (buttonString.equals("-")) {
			OPString = "-";
			//set result pane empty
			if (result.getText().equals("Result"))
				result.setText("");
			//set first number to operand
			num1 = stringToDouble(operand.getText());
			//set number to result
			result.setText(Double.toString(resultNum));
			//set operand back to blank
			operand.setText("");
			
		}
		else if (buttonString.equals("*")) {
			OPString = "*";
			//set result pane empty
			if (result.getText().equals("Result"))
				result.setText("");
			//set first number to operand
			num1 = stringToDouble(operand.getText());
			//set number to result
			result.setText(Double.toString(num1));
			//set operand back to blank
			operand.setText("");
		}
		else if (buttonString.equals("/")) {
			OPString = "/";
			//set result pane empty
			if (result.getText().equals("Result"))
				result.setText("");
			//set first number to operand
			num1 = stringToDouble(operand.getText());
			//set number to result
			result.setText(Double.toString(num1));
			//set operand back to blank
			operand.setText("");
		}
		else if (buttonString.equals("=")) {
			num2 = stringToDouble(operand.getText());
			
			if (OPString.equals("+")) {
				resultNum = num1 + num2;
				result.setText(Double.toString(resultNum));
				operand.setText("");
			}
			else if (OPString.equals("-")) {
				resultNum = num1 - num2;
				result.setText(Double.toString(resultNum));
				operand.setText("");
			}
			else if (OPString.equals("*")) {
				resultNum = num1 * num2;
				result.setText(Double.toString(resultNum));
				operand.setText("");
			}
			else if (OPString.equals("/")) {
				try {
					if (num2 > (-1.0 * Math.exp(10)) || num2 < (1.0 * Math.exp(10))) 
						throw new DivideByZeroException();
					
					resultNum = num1 / num2;
					result.setText(Double.toString(resultNum));
					operand.setText("");
					
				} catch (DivideByZeroException err) {result.setText(err.getMessage());}
				
				
			}
			else 
				result.setText("Fatal error. Please reset.");
		}
		else if (buttonString.equals("reset")) {
			if (result.getText().equals("Result"))
				result.setText("");
			result.setText("Result");
			operand.setText("Operand");
			resultNum = 0.0;
		}
		
		
	}
	
	// Throws NumberFormatException.
	private static double stringToDouble(String stringObject) {
		return Double.parseDouble(stringObject.trim());
	}
	
	private class DivideByZeroException extends Exception {
		public DivideByZeroException() {
			super("divide by zero error");
		}
		public DivideByZeroException(String message) {
			super(message);
		}
	}
	
}
