package GUI.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ClientService.NhanVienService;
import Rmi.DTO.NhanVienDTO;
import Rmi.DTO.TaiKhoanDTO;

public class UpdateNhanVienDialog extends JDialog implements ActionListener {
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtMail;
	private JTextField txtAccountName;
	private JPasswordField txtAccountPass;
	private JButton btnSua;
	private JButton btnHuy;
	private JRadioButton rdQuanLy;
	private JRadioButton rdNhanVien;
	private JComboBox<String> comboBox;
	private NhanVienDTO selectedNvDTO;

	public UpdateNhanVienDialog(NhanVienDTO nhanVienDTO) {
		setModal(true);
		setSize(570, 475);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 556, 70);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Thêm Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 98, 556, 330);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		selectedNvDTO = nhanVienDTO;

		txtName = new JTextField();
		txtName.setBounds(166, 10, 380, 30);
		txtName.setColumns(10);
		txtName.setText(selectedNvDTO.getTen());
		panel_1.add(txtName);

		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 10, 134, 30);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 50, 134, 30);
		panel_1.add(lblNewLabel_1_1);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(166, 50, 380, 30);
		txtPhone.setText(selectedNvDTO.getSdt());
		panel_1.add(txtPhone);

		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(10, 90, 134, 30);
		panel_1.add(lblNewLabel_1_1_1);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(166, 90, 380, 30);
		txtMail.setText(selectedNvDTO.getEmail());
		panel_1.add(txtMail);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(10, 130, 134, 30);
		panel_1.add(lblNewLabel_1_1_1_1);

		String gioiTinh[] = { "Nam", "Nữ" };
		comboBox = new JComboBox<String>(gioiTinh);
		if (selectedNvDTO.getGioiTinh().equals("Nam")) {
			comboBox.setSelectedItem("Nam");
		} else
			comboBox.setSelectedItem("Nữ");
		comboBox.setBounds(166, 130, 380, 21);
		panel_1.add(comboBox);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1.setBounds(10, 170, 134, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1);

		txtAccountName = new JTextField();
		txtAccountName.setColumns(10);
		txtAccountName.setBounds(166, 161, 380, 30);
		txtAccountName.setText(selectedNvDTO.getTaiKhoan().getTenTK());
		panel_1.add(txtAccountName);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 210, 134, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);

		txtAccountPass = new JPasswordField();
		txtAccountPass.setColumns(10);
		txtAccountPass.setBounds(166, 201, 380, 30);
		txtAccountPass.setText(selectedNvDTO.getTaiKhoan().getMatKhau());
		panel_1.add(txtAccountPass);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Loại tài khoản");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 250, 134, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);

		rdNhanVien = new JRadioButton("Nhân viên");
		rdNhanVien.setBounds(166, 250, 120, 30);
		panel_1.add(rdNhanVien);

		rdQuanLy = new JRadioButton("Quản lý");
		rdQuanLy.setBounds(306, 250, 120, 30);
		panel_1.add(rdQuanLy);

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdNhanVien);
		bgroup.add(rdQuanLy);

		if (selectedNvDTO.getTaiKhoan().isAdmin()) {
			rdQuanLy.setSelected(true);
		} else {
			rdNhanVien.setSelected(true);
		}

		btnSua = new JButton("Sửa");
		btnSua.setBounds(460, 290, 85, 30);
		panel_1.add(btnSua);

		btnHuy = new JButton("Hủy");
		btnHuy.setBounds(366, 290, 85, 30);
		panel_1.add(btnHuy);

		// == Add Action ====
		btnSua.addActionListener(this);
		btnHuy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnHuy)) {
			this.dispose();
		}
		if (o.equals(btnSua)) {
			SuaNhanVien();
		}
	}

	private void SuaNhanVien() {
		String name = txtName.getText().toString();
		String gender = comboBox.getSelectedItem().toString();
		String phone = txtPhone.getText().toString();
		String mail = txtMail.getText().toString();

		String accountName = txtAccountName.getText().toString();
		String accountPass = txtAccountPass.getText().toString();
		
		boolean isAdmin = rdQuanLy.isSelected();

		if (!validateInPut(name, gender, phone, mail, accountName, accountPass))
			return;

		NhanVienDTO UpdateObj = new NhanVienDTO(name, mail, gender, phone);
		TaiKhoanDTO tkDTO = new TaiKhoanDTO(accountName, accountPass, isAdmin);
		UpdateObj.setTaiKhoan(tkDTO);
		UpdateObj.setMaNV(selectedNvDTO.getMaNV());

		if (!NhanVienService.getInstance().updateNhanVien(UpdateObj)) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản đã được sử dụng bởi nhân viên khác");
			txtAccountName.requestFocus();
			return;
		}
		JOptionPane.showMessageDialog(null, "Đã cập nhật thành công nhân viên : " + name);
		this.dispose();
	}

	private boolean validateInPut(String name, String gender, String phone, String mail, String accountName,
			String accountPass) {
		if (name.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên");
			txtName.requestFocus();
			return false;
		}
		if (gender.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính");
			comboBox.requestFocus();
			return false;
		}
		if (phone.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập số điện thoại ");
			txtPhone.requestFocus();
			return false;
		}
		if (mail.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập Email");
			txtMail.requestFocus();
			return false;
		}
		if (accountName.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập Tài khoản cho nhân viên");
			txtAccountName.requestFocus();
			return false;
		}
		if (accountPass.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu của tài khoản");
			txtAccountPass.requestFocus();
			return false;
		}
		return true;
	}
}
