package GUI.Dialog;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPhongDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txttenPhong;

	public AddPhongDialog() {
		setModal(true);
		setSize(800, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 766, 60);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 756, 50);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 96, 766, 357);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ten phong");
		lblNewLabel_1.setBounds(10, 61, 81, 13);
		panel_1.add(lblNewLabel_1);
		
		txttenPhong = new JTextField();
		txttenPhong.setBounds(118, 58, 96, 19);
		panel_1.add(txttenPhong);
		txttenPhong.setColumns(10);
	}
}
