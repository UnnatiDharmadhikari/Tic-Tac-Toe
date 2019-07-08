import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame implements ActionListener {

	JButton back;
	
	Help()
	{
		
		// Frame properties
			super("Tic Tac Toe");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(350,30,950,700);
			setContentPane(new JLabel(new ImageIcon("images/Help.png")));
			setVisible(true);
			setResizable(false);
			setLayout(null);

			back=new JButton("  ");
			back.setBounds(114,579,212,55);
			back.setFocusPainted(false);
			back.setContentAreaFilled(false);
			back.setBorderPainted(false);
			back.setOpaque(false);

			add(back);
			
			// Event handlers
			
			back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {		
		if(ae.getSource()==back)
		{
			this.dispose();
			new Main();			
		}

	}	

}
