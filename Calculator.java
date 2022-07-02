// Importing the required packages 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {

	// Inputs are of "String" datatype
	//JFrame is from java swing package

	static JTextField l;
	static JFrame f;
	String s0, s1, s2;

	/*
	 * Calculator() is a constructor to initialize the string inputs
	 * Creating empty strings here
	 */
	Calculator() 
	{
		s0 = s1 = s2 = "";
	}

	public static void main(String[] args) {
		f = new JFrame("Swing Calculator");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		Calculator c = new Calculator();

		// Calculator main Display Area
		l = new JTextField(16);
		l.setEditable(false);

		// Buttons to give input as digits in the range 0-9
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bm, bd, CLS, EQUALS, e;

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// Different Operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bm = new JButton("*");
		bd = new JButton("/");
		CLS = new JButton("C");

		// Equal to button
		EQUALS = new JButton("=");

		// Decimal input
		e = new JButton(".");

		//  JPanel/panel is a lightweight and fluid container which can contain other panels/containers also
		// Present in java swing package

		JPanel p = new JPanel();

		// Adding the Event Listeners function to every button

		bm.addActionListener(c);
		bd.addActionListener(c);
		ba.addActionListener(c);
		bs.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		e.addActionListener(c);
		CLS.addActionListener(c);
		EQUALS.addActionListener(c);

		// Adding each button created to the JPanel
		p.add(l);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(ba);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bs);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bm);
		p.add(b0);
		p.add(CLS);
		p.add(e);
		p.add(bd);
		p.add(EQUALS);

		// Giving a blue background to the JPanel here
		p.setBackground(Color.blue);

		f.add(p);
		f.setSize(200, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//Function actionPerformed() which has parameter of Event type


	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		// s is the string currently entered in the textfield area

		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if first operand is present then add to second operand
			if (!s1.equals(""))
				s2 = s2 + s;
			else
			// else add to the first operand 
				s0 = s0 + s;

			l.setText(s0 + s1 + s2);    
		} else if (s.charAt(0) == 'C') {
			// Clearing the data stored in string inputs if "Clear button" is pressed
			s0 = s1 = s2 = "";
			l.setText(s0 + s1 + s2);   
		}

		else if (s.charAt(0) == '=') {

			// Checking the operator selected when "=" is pressed 
			// Calculating and storing the result in "te"
			double te;
			if (s1.equals("+"))
				te = Double.parseDouble(s0) + Double.parseDouble(s2);
			else if (s1.equals("-"))
				te = Double.parseDouble(s0) - Double.parseDouble(s2);
			else if (s1.equals("*"))
				te = Double.parseDouble(s0) * Double.parseDouble(s2);
			else
				te = Double.parseDouble(s0) / Double.parseDouble(s2);

			l.setText(s0 + s1 + s2 + "=" + te);

			s0 = Double.toString(te);
			s1 = s2 = "";
		}

		else {
			if (s1.equals("") || s2.equals(""))
				s1 = s;  // placing the operator in string 
			else {
				// 
				double te;
				if (s1.equals("+"))
					te = Double.parseDouble(s0) + Double.parseDouble(s2);
				else if (s1.equals("-"))
					te = Double.parseDouble(s0) - Double.parseDouble(s2);
				else if (s1.equals("*"))
					te = Double.parseDouble(s0) * Double.parseDouble(s2);
				else
					te = Double.parseDouble(s0) / Double.parseDouble(s2);

				s0 = Double.toString(te); // convert the result to string
				s1 = s; // placing the selected operator for next operation
				s2 = ""; // creating space for entering the next operand
			}

			l.setText(s0 + s1 + s2);  // displaying the end result 
		}
	}
}