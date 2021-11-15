import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener
{
	static JTextField l;
	static JFrame f;
	String s0,s1,s2;
	Calculator()
	{
		s0=s1=s2="";
	}
	
	public static void main(String [] args)
	{
		f=new JFrame("Swing Calculator");
		try{
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		Calculator c = new Calculator();
		
		// calculator main display area
		l=new JTextField(16);
		l.setEditable(false);
		
		//create buttons
		JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bm,bd,CLS,EQUALS,e;
		
		b0=new JButton("0");
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		
		//setting up the operator buttons
		ba=new JButton("+");
		bs=new JButton("-");
		bm=new JButton("*");
		bd=new JButton("/");
		CLS=new JButton("C");
		
		//setting up the equal to button
		EQUALS=new JButton("=");
		
		//for decimal 
		e=new JButton(".");
		
		JPanel p= new JPanel();
		
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
		
		//adding components of caclculator to the panel
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
		
		p.setBackground(Color.blue);
		
		f.add(p);
		f.setSize(200,250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();
	}
		
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		
		if((s.charAt(0) >= '0' && s.charAt(0) <= '9' ) || s.charAt(0) =='.' )
		{
			//if first operand is present then add to second operand
			if(!s1.equals(""))
				s2 = s2 + s;
			else 
				s0 = s0 + s;
			
			l.setText(s0 + s1 + s2);
		
		}
		else if( s.charAt(0) == 'C' )
		{
			s0=s1=s2="";
			l.setText(s0 + s1 + s2);
		}
		
		else if( s.charAt(0) == '=' )
		{
			double te;
			if( s1.equals("+") )
				te=Double.parseDouble(s0) + Double.parseDouble(s2);
			else if(s1.equals("-"))
				te=Double.parseDouble(s0) - Double.parseDouble(s2);
			else if(s1.equals("*"))
				te=Double.parseDouble(s0) * Double.parseDouble(s2);
			else 
				te=Double.parseDouble(s0) / Double.parseDouble(s2);
			
			l.setText(s0 + s1 + s2 + "=" + te);
			
			s0=Double.toString(te);
			s1=s2="";
		}
		
		else
		{
			if(s1.equals("") || s2.equals(""))
				s1=s;
			else{
				  //evaluate
				  double te;
					if( s1.equals("+") )
						te=Double.parseDouble(s0) + Double.parseDouble(s2);
					else if(s1.equals("-"))
						te=Double.parseDouble(s0) - Double.parseDouble(s2);
					else if(s1.equals("*"))
						te=Double.parseDouble(s0) * Double.parseDouble(s2);
					else 
						te=Double.parseDouble(s0) / Double.parseDouble(s2);
					
					s0=Double.toString(te); //convert the result to string 
					s1=s;       //place the operator
					s2="";
			}
			
			l.setText(s0+s1+s2);
		}
	}
}
