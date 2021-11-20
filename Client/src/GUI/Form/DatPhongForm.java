package GUI.Form;

import javax.swing.JPanel;

import GUI.Dialog.ChooseCustomerDialog;
import Rmi.DTO.KhachHangDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DatPhongForm extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public DatPhongForm () {
		setBackground(Color.decode("#d4d5d6"));
		setLayout(null);
		setBounds(0,0,1180,820);
		
		JPanel pKhachHang = new JPanel();
		pKhachHang.setBackground(Color.WHITE);
		pKhachHang.setBounds(10, 10, 429, 800);
		add(pKhachHang);
		pKhachHang.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin kh\u00E1ch h\u00E0ng");
		lblNewLabel.setBounds(10, 10, 123, 24);
		pKhachHang.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ch\u1ECDn kh\u00E1ch h\u00E0ng");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SampleOpenDialog();
			}
		});
		btnNewButton.setBounds(10, 53, 409, 24);
		pKhachHang.add(btnNewButton);
		
		JPanel pThoiGian = new JPanel();
		pThoiGian.setBackground(Color.WHITE);
		pThoiGian.setBounds(449, 10, 721, 217);
		add(pThoiGian);
		pThoiGian.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1ECDn ng\u00E0y \u0111\u1EBFn ng\u00E0y \u0111i");
		lblNewLabel_1.setBounds(10, 10, 123, 23);
		pThoiGian.add(lblNewLabel_1);
		
		JPanel pPhong = new JPanel();
		pPhong.setBackground(Color.WHITE);
		pPhong.setBounds(449, 237, 721, 258);
		add(pPhong);
		pPhong.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ch\u1ECDn lo\u1EA1i ph\u00F2ng, c\u00E1c th\u00F4ng tin k\u00E8m theo");
		lblNewLabel_2.setBounds(10, 10, 197, 25);
		pPhong.add(lblNewLabel_2);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(449, 505, 721, 213);
		add(pThongTin);
		pThongTin.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Th\u00F4ng tin v\u1EC1 gi\u00E1 thu\u00EA.....");
		lblNewLabel_3.setBounds(10, 10, 131, 24);
		pThongTin.add(lblNewLabel_3);
		
		JPanel pControll = new JPanel();
		pControll.setBackground(Color.WHITE);
		pControll.setBounds(449, 728, 721, 82);
		add(pControll);
		pControll.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("C\u00E1c n\u00FAt th\u00EAm. l\u00E0m m\u1EDBi ...");
		lblNewLabel_4.setBounds(10, 10, 141, 13);
		pControll.add(lblNewLabel_4);
		
	}

	private void SampleOpenDialog() {
		ChooseCustomerDialog dialog = new ChooseCustomerDialog();
		
		dialog.setVisible(true);
	
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				KhachHangDTO kh = new KhachHangDTO();
				kh = dialog.getSelectdCustomer();
				setCustomerInfo(kh);
			}
		});
	}

	private void setCustomerInfo(KhachHangDTO kh) {
		JOptionPane.showMessageDialog(null, kh.toString());
	}
}
