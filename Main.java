import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{

 JButton start,quit,help,about;	
 
 	Main()
	{
 		super("Tic Tac Toe");
		// Frame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(1300,650);
		setBounds(350,30,950,700);
		setContentPane(new JLabel(new ImageIcon("images/Home.png")));
		setVisible(true);
		setResizable(false);
		setLayout(null);
						
		// Button details
		start=new JButton("  ");
		quit=new JButton("  ");
		help=new JButton("  ");
		about=new JButton("  ");
	

		start.setBounds(726,224,212,55);
		start.setFocusPainted(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setOpaque(false);
		
		help.setBounds(690,355,210,55);
		help.setFocusPainted(false);
		help.setContentAreaFilled(false);
		help.setBorderPainted(false);
		help.setOpaque(false);
		
		about.setBounds(610,463,210,55);
		about.setFocusPainted(false);
		about.setContentAreaFilled(false);
		about.setBorderPainted(false);
		about.setOpaque(false);
		
		quit.setBounds(418,533,210,55);
		quit.setFocusPainted(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		quit.setOpaque(false);
		
		add(start);
		add(quit);
		add(help);
		add(about);
		
		// Event handlers
		start.addActionListener(this);
		help.addActionListener(this);
		about.addActionListener(this);
		quit.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main();
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==start)
		{
			this.dispose();
			new game();			
		}
		
	int states;
		if(ae.getSource()==quit)
		{
			states=JOptionPane.showConfirmDialog(this,"Do you want to really quit the game?","Quit Confirmation",JOptionPane.YES_NO_OPTION);
			if(states==0)
				System.exit(0);
		}
		
		if(ae.getSource()==about)
		{
			this.dispose();
			new About();			
		}
		
		if(ae.getSource()==help)
		{
			this.dispose();
			new Help();			
		}
	}
}
