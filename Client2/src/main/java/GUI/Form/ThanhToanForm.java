package GUI.Form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class ThanhToanForm extends JPanel {
	private JTable tblDsPhieuThue;
	private JTable tblDsDichVu;

	public ThanhToanForm() {
		setBackground(Color.decode("#d4d5d6"));
		setBounds(0, 0, 1180, 820);
		setLayout(null);
		
		JPanel pTable = new JPanel();
		pTable.setBackground(Color.WHITE);
		pTable.setBounds(20, 20, 1160, 790);
		add(pTable);
		pTable.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 650, 400);
		pTable.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 630, 310);
		panel.add(scrollPane);
		
		tblDsPhieuThue = new JTable();
		scrollPane.setViewportView(tblDsPhieuThue);
		
		JButton btnPrev = new JButton("<");
		btnPrev.setBounds(160, 365, 85, 25);
		panel.add(btnPrev);
		
		JLabel lblPage = new JLabel("New label");
		lblPage.setBounds(272, 365, 45, 25);
		panel.add(lblPage);
		
		JButton btnNext = new JButton(">");
		btnNext.setBounds(359, 365, 85, 25);
		panel.add(btnNext);
		
		JLabel lblNewLabel_1 = new JLabel("Chọn Phiếu Thuê");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 10, 307, 25);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(670, 10, 480, 770);
		pTable.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách dịch vụ đã đặt");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 10, 307, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 50, 460, 302);
		panel_1.add(scrollPane_1);
		
		tblDsDichVu = new JTable();
		scrollPane_1.setViewportView(tblDsDichVu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 380, 460, 2);
		panel_1.add(separator);
		
		JLabel lblNewLabel = new JLabel("Tên khách");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 420, 91, 40);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Phòng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 470, 91, 40);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày nhận");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 520, 91, 40);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Ngày trả");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(240, 520, 91, 40);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số ngày");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2.setBounds(10, 570, 91, 40);
		panel_1.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Tiền phòng");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2_1.setBounds(240, 570, 91, 40);
		panel_1.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Tiền Dịch Vụ");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2_1_1.setBounds(10, 620, 91, 40);
		panel_1.add(lblNewLabel_2_1_2_1_1);
		
		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2_1_1_1.setBounds(10, 670, 91, 40);
		panel_1.add(lblNewLabel_2_1_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("......................................");
		lblNewLabel_3.setBounds(111, 420, 242, 40);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("......................................");
		lblNewLabel_3_1.setBounds(111, 470, 242, 40);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("......................................");
		lblNewLabel_3_1_1.setBounds(111, 520, 119, 40);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("......................................");
		lblNewLabel_3_1_1_1.setBounds(344, 520, 105, 40);
		panel_1.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("......................................");
		lblNewLabel_3_1_1_2.setBounds(111, 570, 119, 40);
		panel_1.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("......................................");
		lblNewLabel_3_1_1_2_1.setBounds(341, 570, 108, 40);
		panel_1.add(lblNewLabel_3_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("......................................");
		lblNewLabel_3_1_1_2_1_1.setBounds(111, 620, 338, 40);
		panel_1.add(lblNewLabel_3_1_1_2_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1_1 = new JLabel("......................................");
		lblNewLabel_3_1_1_2_1_1_1.setBounds(111, 670, 338, 40);
		panel_1.add(lblNewLabel_3_1_1_2_1_1_1);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(343, 720, 106, 30);
		panel_1.add(btnThanhToan);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(246, 720, 85, 30);
		panel_1.add(btnXoaTrang);
	}
}
