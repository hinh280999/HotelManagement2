package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Page1 extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public Page1 () {
		setBackground(Color.GREEN);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PageOne");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(43, 76, 297, 118);
		add(lblNewLabel);
		
	}

}
