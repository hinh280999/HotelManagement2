package GUI.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClientService.KhachHangService;
import Rmi.DTO.KhachHangDTO;

public class AddKhachHangDialog extends JDialog implements ActionListener {
	private JTextField txtName;
	private JButton btnThem;
	private JButton btnHuy;
	private JTextField txtCMT;
	private JTextField txtSDT;
	private JTextField txtMail;
	private JTextField txtDiaChi;

	public AddKhachHangDialog() {
		setModal(true);
		setSize(570, 420);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 556, 70);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Thêm Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 98, 556, 250);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(166, 10, 380, 30);
		panel_1.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tên khách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 10, 134, 30);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 90, 134, 30);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(10, 130, 134, 30);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số CMT");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(10, 50, 134, 30);
		panel_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1.setBounds(10, 170, 134, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(461, 210, 85, 30);
		panel_1.add(btnThem);

		btnHuy = new JButton("Hủy");
		btnHuy.setBounds(366, 210, 85, 30);
		panel_1.add(btnHuy);

		txtCMT = new JTextField();
		txtCMT.setColumns(10);
		txtCMT.setBounds(166, 50, 380, 30);
		panel_1.add(txtCMT);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(166, 90, 380, 30);
		panel_1.add(txtSDT);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(166, 130, 380, 30);
		panel_1.add(txtMail);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(166, 170, 380, 30);
		panel_1.add(txtDiaChi);

		// === add action /// =
		btnHuy.addActionListener(this);
		btnThem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnHuy)) {
			this.dispose();
		}
		if (o.equals(btnThem)) {
			ThemKhachHang();
		}
	}

	private void ThemKhachHang() {
		String name = txtName.getText().toString();
		String soCMT = txtCMT.getText().toString();
		String phone = txtSDT.getText().toString();
		String mail = txtMail.getText().toString();
		String diachi = txtDiaChi.getText().toString();

		if (!validateInPut(name, soCMT, phone, mail, diachi))
			return;

		KhachHangDTO addObj = new KhachHangDTO(name, mail, phone, diachi, soCMT);
		if (!KhachHangService.getInstance().addKhachHang(addObj)) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình thêm khách hàng : " + addObj.getTen());
			return;
		}

		JOptionPane.showMessageDialog(null, "Thêm thành công khách hàng: " + addObj.getTen());
		this.dispose();
	}

	private boolean validateInPut(String name, String soCMT, String phone, String mail, String diaChi) {
		if (name.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên khách hàng");
			txtName.requestFocus();
			return false;
		}
		if (soCMT.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập số CMT khách hàng");
			txtCMT.requestFocus();
			return false;
		}
		if (phone.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập số điện thoại khách hàng");
			txtSDT.requestFocus();
			return false;
		}
		if (mail.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập Email khách hàng");
			txtMail.requestFocus();
			return false;
		}
		if (diaChi.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập địa chỉ");
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}
}
