package GUI.Form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;

public class GoiDichVuForm extends JPanel {
	private JTable tblDsPhong;
	private JTextField txtSoLuong;
	private JTable tblDsDv;
	public GoiDichVuForm() {
		setBackground(Color.decode("#d4d5d6"));
		setBounds(0, 0, 1180, 820);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 20, 1140, 780);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 415, 520);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 395, 385);
		panel_1.add(scrollPane);
		
		tblDsPhong = new JTable();
		scrollPane.setViewportView(tblDsPhong);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 460, 130, 30);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("page");
		lblNewLabel.setBounds(150, 460, 90, 30);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBounds(250, 460, 130, 30);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Chọn Phòng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 10, 286, 30);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(440, 10, 690, 760);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 65, 670, 385);
		panel_2.add(scrollPane_1);
		
		tblDsDv = new JTable();
		scrollPane_1.setViewportView(tblDsDv);
		
		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.setBounds(10, 460, 130, 30);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("page");
		lblNewLabel_1.setBounds(150, 460, 90, 30);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton(">");
		btnNewButton_1_1.setBounds(242, 460, 130, 30);
		panel_2.add(btnNewButton_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 515, 670, 2);
		panel_2.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Tên dịch vụ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 525, 130, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Đơn vị");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(291, 525, 130, 30);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Đơn giá");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(10, 570, 130, 30);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nhập số lượng");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2_1.setBounds(291, 570, 130, 30);
		panel_2.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Tổng tiền");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2_2.setBounds(10, 620, 130, 30);
		panel_2.add(lblNewLabel_2_2_2);
		
		JLabel lblTenDV = new JLabel("............");
		lblTenDV.setBounds(140, 525, 140, 30);
		panel_2.add(lblTenDV);
		
		JLabel lblDonGia = new JLabel("............");
		lblDonGia.setBounds(140, 565, 140, 30);
		panel_2.add(lblDonGia);
		
		JLabel lblDonVi = new JLabel("............");
		lblDonVi.setBounds(431, 527, 140, 30);
		panel_2.add(lblDonVi);
		
		JLabel lblTongTien = new JLabel("............");
		lblTongTien.setBounds(140, 620, 140, 30);
		panel_2.add(lblTongTien);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(431, 570, 130, 30);
		panel_2.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 688, 670, 2);
		panel_2.add(separator_1);
		
		JButton btnThemDV = new JButton("Đặt Dịch Vụ");
		btnThemDV.setBounds(540, 700, 100, 30);
		panel_2.add(btnThemDV);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(430, 700, 100, 30);
		panel_2.add(btnXoaTrang);
		
		JLabel lblNewLabel_3_1 = new JLabel("Chọn Dịch Vụ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(10, 10, 286, 30);
		panel_2.add(lblNewLabel_3_1);
	}
}
