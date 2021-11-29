package GUI.Form;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class GoiDichVuForm extends JPanel implements ActionListener {
	private JTable tblDsPhong, tblDsDv;
	private JTextField txtSoLuong;
	private JButton btnPhongPrev, btnPhongNext;
	private JButton btnDvPrev, btnDvNext;

	private List<Component> lstComponent = new ArrayList<>();
	private JLabel lblTenDV;
	private JLabel lblDonGia;
	private JLabel lblDonVi;
	private JLabel lblTongTien;
	private JButton btnThemDV;
	private JButton btnXoaTrang;

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

		btnPhongPrev = new JButton("<");
		btnPhongPrev.setBounds(10, 460, 130, 30);
		panel_1.add(btnPhongPrev);

		JLabel lblNewLabel = new JLabel("page");
		lblNewLabel.setBounds(150, 460, 90, 30);
		panel_1.add(lblNewLabel);

		btnPhongNext = new JButton(">");
		btnPhongNext.setBounds(250, 460, 130, 30);
		panel_1.add(btnPhongNext);

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

		btnDvPrev = new JButton("<");
		btnDvPrev.setBounds(10, 460, 130, 30);
		panel_2.add(btnDvPrev);

		JLabel lblNewLabel_1 = new JLabel("page");
		lblNewLabel_1.setBounds(150, 460, 90, 30);
		panel_2.add(lblNewLabel_1);

		btnDvNext = new JButton(">");
		btnDvNext.setBounds(242, 460, 130, 30);
		panel_2.add(btnDvNext);

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

		lblTenDV = new JLabel("............");
		lblTenDV.setBounds(140, 525, 140, 30);
		lstComponent.add(lblTenDV);
		panel_2.add(lblTenDV);

		lblDonGia = new JLabel("............");
		lblDonGia.setBounds(140, 565, 140, 30);
		lstComponent.add(lblDonGia);
		panel_2.add(lblDonGia);

		lblDonVi = new JLabel("............");
		lblDonVi.setBounds(431, 527, 140, 30);
		lstComponent.add(lblDonVi);
		panel_2.add(lblDonVi);

		lblTongTien = new JLabel("............");
		lblTongTien.setBounds(140, 620, 140, 30);
		lstComponent.add(lblTongTien);
		panel_2.add(lblTongTien);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(431, 570, 130, 30);
		txtSoLuong.setColumns(10);
		lstComponent.add(txtSoLuong);
		panel_2.add(txtSoLuong);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 688, 670, 2);
		panel_2.add(separator_1);

		btnThemDV = new JButton("Đặt Dịch Vụ");
		btnThemDV.setBounds(540, 700, 100, 30);
		panel_2.add(btnThemDV);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(430, 700, 100, 30);
		panel_2.add(btnXoaTrang);

		JLabel lblNewLabel_3_1 = new JLabel("Chọn Dịch Vụ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(10, 10, 286, 30);
		panel_2.add(lblNewLabel_3_1);

		// == add action =================
		btnDvNext.addActionListener(this);
		btnDvPrev.addActionListener(this);
		btnPhongNext.addActionListener(this);
		btnPhongPrev.addActionListener(this);
		btnThemDV.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDvNext)) {
			DichVuPrevPage();
		}
		if (o.equals(btnDvPrev)) {
			DichVuNextPage();
		}
		if (o.equals(btnPhongNext)) {
			PhongPrevPage();
		}
		if (o.equals(btnPhongPrev)) {
			PhongPrevPage();
		}
		if (o.equals(btnThemDV)) {
			DatDichVu();
		}
		if (o.equals(btnXoaTrang)) {
			XoaTrang();
		}

	}

	private void DichVuPrevPage() {
		// TODO Auto-generated method stub
		
	}

	private void DichVuNextPage() {
		// TODO Auto-generated method stub

	}

	private void PhongPrevPage() {
		// TODO Auto-generated method stub

	}

	private void DatDichVu() {
		// TODO Auto-generated method stub

	}

	private void XoaTrang() {
		// TODO Auto-generated method stub

	}
}
