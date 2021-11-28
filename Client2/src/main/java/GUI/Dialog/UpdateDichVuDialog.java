package GUI.Dialog;

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

import ClientService.DichVuService;
import Rmi.DTO.DichVuDTO;

public class UpdateDichVuDialog extends JDialog implements ActionListener {
	private JTextField txtTenDV;
	private JTextField txtDonGia;
	private JButton btnSua;
	private JButton btnHuy;
	private DichVuDTO selectedDv;
	private JTextField txtDonVi;

	public UpdateDichVuDialog(DichVuDTO dichVuDTO) {
		setModal(true);
		setSize(350, 360);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(10, 10, 316, 60);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sửa Dịch Vụ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 157, 60);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 80, 316, 230);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 60, 100, 30);
		panel_1.add(lblNewLabel_1);

		txtTenDV = new JTextField();
		txtTenDV.setColumns(10);
		txtTenDV.setBounds(120, 60, 180, 30);
		txtTenDV.setText(dichVuDTO.getTenDv());
		panel_1.add(txtTenDV);

		JLabel lblNewLabel_1_1 = new JLabel("Đơn Giá");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 100, 100, 30);
		panel_1.add(lblNewLabel_1_1);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setText(String.valueOf(dichVuDTO.getDonGia()));
		txtDonGia.setBounds(120, 100, 180, 30);
		panel_1.add(txtDonGia);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(210, 186, 90, 30);
		panel_1.add(btnSua);

		btnHuy = new JButton("Hủy");
		btnHuy.setBounds(110, 186, 90, 30);
		panel_1.add(btnHuy);

		selectedDv = dichVuDTO;

		JLabel lblNewLabel_1_1_1 = new JLabel("Đơn Vị");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 140, 100, 30);
		panel_1.add(lblNewLabel_1_1_1);

		txtDonVi = new JTextField();
		txtDonVi.setColumns(10);
		txtDonVi.setBounds(120, 140, 180, 30);
		txtDonVi.setText(dichVuDTO.getDonVi());
		panel_1.add(txtDonVi);

		// === Action ========================
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
			SuaDichVu();
		}

	}

	private void SuaDichVu() {
		String tenDv = txtTenDV.getText().toString().trim();
		String txtDongia = txtDonGia.getText().toString().trim();
		String donVi = txtDonVi.getText().toString().trim();

		if (!ValidateInPut(tenDv, txtDongia))
			return;

		Double dongia = Double.parseDouble(txtDongia);

		selectedDv.setTenDv(tenDv);
		selectedDv.setDonGia(dongia);
		selectedDv.setDonVi(donVi);

		if (DichVuService.getInstance().UpdateDichVu(selectedDv)) {
			JOptionPane.showMessageDialog(null, "Đã cập nhật dịch vụ :" + selectedDv.getTenDv());
		} else {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật dịch vụ :" + selectedDv.getTenDv());
		}

		this.dispose();
	}

	private boolean ValidateInPut(String tenDv, String txtdongia) {
		if (tenDv.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên cho dịch vụ");
			txtTenDV.requestFocus();
			return false;
		}
		if (txtdongia.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập giá cho dịch vụ");
			txtDonGia.requestFocus();
			return false;
		}

		try {
			Double gia = Double.parseDouble(txtdongia);
			if (gia <= 0) {
				JOptionPane.showMessageDialog(null, "Giá dịch vụ phải lớn hơn '0'");
				txtDonGia.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Giá dịch vụ phải là số");
			txtDonGia.requestFocus();
			return false;
		}
		return true;
	}
}
