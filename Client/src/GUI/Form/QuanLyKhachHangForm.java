package GUI.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import CustomControll.ColorButton2;

public class QuanLyKhachHangForm extends JPanel implements ActionListener {
	private ColorButton2 btnThemKH;
	private ColorButton2 btnSuaKhachHang;
	private ColorButton2 btnXoaKhachHang;
	private JTextField txtSearchText;
	private JButton btnSearch;
	private JTable tblDsKhachHang;
	private JButton btnPrev;
	private JLabel lblPage;
	private JButton btnNext;

	public QuanLyKhachHangForm() {
		setBackground(Color.decode("#d4d5d6"));
		setBounds(0, 0, 1180, 820);
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		pSearch.setBounds(10, 10, 1160, 120);
		add(pSearch);
		pSearch.setLayout(null);

		btnThemKH = new ColorButton2(Color.decode("#34e039"), Color.decode("#38f53e"), Color.decode("#32cf37"),
				Color.decode("#34e039"));
		btnThemKH.setText("Thêm Khách Hàng");
		btnThemKH.setBounds(10, 80, 100, 30);
		pSearch.add(btnThemKH);

		btnSuaKhachHang = new ColorButton2(Color.decode("#f0f03a"), Color.decode("#fafa3c"), Color.decode("#e0e034"),
				Color.decode("#f0f03a"));
		btnSuaKhachHang.setBounds(120, 80, 150, 30);
		btnSuaKhachHang.setText("Sửa Thông Khách Hàng");
		pSearch.add(btnSuaKhachHang);

		btnXoaKhachHang = new ColorButton2(Color.decode("#ed3752"), Color.decode("#ff425e"), Color.decode("#e63c55"),
				Color.decode("#ed3752"));
		btnXoaKhachHang.setBounds(280, 80, 150, 30);
		btnXoaKhachHang.setText("Xóa Khách Hàng");
		pSearch.add(btnXoaKhachHang);

		txtSearchText = new JTextField();
		txtSearchText.setBounds(10, 10, 310, 30);
		pSearch.add(txtSearchText);
		txtSearchText.setColumns(10);

		btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setBounds(330, 10, 110, 30);
		pSearch.add(btnSearch);

		JPanel pTable = new JPanel();
		pTable.setBackground(Color.WHITE);
		pTable.setBounds(10, 170, 1160, 640);
		add(pTable);
		pTable.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 1140, 508);
		pTable.add(scrollPane);

		tblDsKhachHang = new JTable();
		tblDsKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tblDsKhachHang.getSelectedRow();
//				selectedPhong = lstPhong.getListData().get(selectedRow);
			}
		});
		scrollPane.setViewportView(tblDsKhachHang);

		JLabel lblNewLabel = new JLabel("Danh khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 10, 150, 30);
		pTable.add(lblNewLabel);

		btnPrev = new JButton("<");
		btnPrev.setBounds(359, 589, 85, 21);
		pTable.add(btnPrev);

		lblPage = new JLabel("paging");
		lblPage.setBounds(450, 593, 45, 13);
		pTable.add(lblPage);

		btnNext = new JButton(">");
		btnNext.setBounds(500, 589, 85, 21);
		pTable.add(btnNext);

		// == action ============
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		btnThemKH.addActionListener(this);
		btnSuaKhachHang.addActionListener(this);
		btnXoaKhachHang.addActionListener(this);
		btnSearch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
