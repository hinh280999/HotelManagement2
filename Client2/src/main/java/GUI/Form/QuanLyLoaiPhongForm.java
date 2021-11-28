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
import Model.PageList;
import Rmi.DTO.KhachHangDTO;
import Rmi.DTO.LoaiPhongDTO;

public class QuanLyLoaiPhongForm extends JPanel implements ActionListener {

	private ColorButton2 btnThem;
	private ColorButton2 btnSua;
	private ColorButton2 btnXoa;
	private JTextField txtSearchText;
	private JButton btnSearch;
	private JTable tblDsKhachHang;
	private JButton btnPrev;
	private JLabel lblPage;
	private JButton btnNext;
	private PageList<LoaiPhongDTO> lstLoaiPhong;
	private LoaiPhongDTO selectedLoaiPhong = null;
	private int currentPage, maxPage;
	private static int maxRow = 15;

	public QuanLyLoaiPhongForm() {
		setBackground(Color.decode("#d4d5d6"));
		setBounds(0, 0, 1180, 820);
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		pSearch.setBounds(10, 10, 1160, 120);
		add(pSearch);
		pSearch.setLayout(null);

		btnThem = new ColorButton2(Color.decode("#34e039"), Color.decode("#38f53e"), Color.decode("#32cf37"),
				Color.decode("#34e039"));
		btnThem.setText("Thêm Loại Phòng");
		btnThem.setBounds(10, 80, 100, 30);
		pSearch.add(btnThem);

		btnSua = new ColorButton2(Color.decode("#f0f03a"), Color.decode("#fafa3c"), Color.decode("#e0e034"),
				Color.decode("#f0f03a"));
		btnSua.setBounds(120, 80, 150, 30);
		btnSua.setText("Sửa Loại Phòng");
		pSearch.add(btnSua);

		btnXoa = new ColorButton2(Color.decode("#ed3752"), Color.decode("#ff425e"), Color.decode("#e63c55"),
				Color.decode("#ed3752"));
		btnXoa.setBounds(280, 80, 150, 30);
		btnXoa.setText("Xóa Loại Phòng");
		pSearch.add(btnXoa);

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
				//selectedKhachHang = lstLoaiPhong.getListData().get(selectedRow);
		}});
		scrollPane.setViewportView(tblDsKhachHang);

		JLabel lblNewLabel = new JLabel("Danh Loại Phòng");
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
		
		// === Add acction ====== 
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSearch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
