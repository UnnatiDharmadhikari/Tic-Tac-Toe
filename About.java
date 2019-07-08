import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener {

	JButton back;
	About()
	{
		// Frame properties
		super("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("images/About.png")));
		setBounds(350,30,950,700);
		setVisible(true);
		setResizable(false);
		setLayout(null);

		// Button details
		back = new JButton("  ");
		back.setBounds(110,560,195,55);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setOpaque(false);
		add(back);
		
		// Event handlers
		
		back.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==back)
		{
			this.dispose();
			new Main();			
		}


	}
}
