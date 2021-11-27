package GUI.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ClientService.KhachHangService;
import CustomControll.ColorButton2;
import Model.PageList;
import Rmi.DTO.DichVuDTO;
import Rmi.DTO.KhachHangDTO;

public class QuanLyDichVuForm extends JPanel implements ActionListener {
	private ColorButton2 btnThemDichVu;
	private ColorButton2 btnSuaDichVu;
	private ColorButton2 btnXoaDichVu;
	private JTextField txtSearchText;
	private JButton btnSearch;
	private JTable tblDsDichVu;
	private JButton btnPrev;
	private JLabel lblPage;
	private JButton btnNext;
	private PageList<KhachHangDTO> lstKhachHang;
	private int currentPage, maxPage;
	private static int maxRow = 2;
	private KhachHangService khachHangService = null;

	public QuanLyDichVuForm() {
		setBackground(Color.decode("#d4d5d6"));
		setBounds(0, 0, 1180, 820);
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		pSearch.setBounds(10, 10, 1160, 120);
		add(pSearch);
		pSearch.setLayout(null);

		btnThemDichVu = new ColorButton2(Color.decode("#34e039"), Color.decode("#38f53e"), Color.decode("#32cf37"),
				Color.decode("#34e039"));
		btnThemDichVu.setText("Thêm Khách Hàng");
		btnThemDichVu.setBounds(10, 80, 100, 30);
		pSearch.add(btnThemDichVu);

		btnSuaDichVu = new ColorButton2(Color.decode("#f0f03a"), Color.decode("#fafa3c"), Color.decode("#e0e034"),
				Color.decode("#f0f03a"));
		btnSuaDichVu.setBounds(120, 80, 150, 30);
		btnSuaDichVu.setText("Sửa Thông Khách Hàng");
		pSearch.add(btnSuaDichVu);

		btnXoaDichVu = new ColorButton2(Color.decode("#ed3752"), Color.decode("#ff425e"), Color.decode("#e63c55"),
				Color.decode("#ed3752"));
		btnXoaDichVu.setBounds(280, 80, 150, 30);
		btnXoaDichVu.setText("Xóa Khách Hàng");
		pSearch.add(btnXoaDichVu);

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

		tblDsDichVu = new JTable();
		tblDsDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tblDsDichVu.getSelectedRow();
//				selectedPhong = lstPhong.getListData().get(selectedRow);
			}
		});
		scrollPane.setViewportView(tblDsDichVu);

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
		btnThemDichVu.addActionListener(this);
		btnSuaDichVu.addActionListener(this);
		btnXoaDichVu.addActionListener(this);
		btnSearch.addActionListener(this);

		// == load ds khach hang ====
//		try {
//			khachHangService = KhachHangService.getInstance();
//			lstKhachHang = khachHangService.getListKhachHangByPage(1, maxRow, "");
//			LoadDsDichVu(lstKhachHang);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	private void LoadDsDichVu(PageList<DichVuDTO> lstDichVu) {
		String[] tieude = { "Mã Khách Hàng", "Tên Khách Hàng", "Email", "SĐT", "Địa Chỉ", "Số CMND" };
		DefaultTableModel model = new DefaultTableModel(tieude, 0);

		for (KhachHangDTO khachhang : lstKhachHang.getListData()) {
			Object[] o = { khachhang.getMaKH(), khachhang.getTen(), khachhang.getEmail(), khachhang.getSdt(),
					khachhang.getDiaChi(), khachhang.getSoCMND() };
			model.addRow(o);
		}
		tblDsDichVu.setModel(model);

		currentPage = lstKhachHang.getCurrentPage();
		maxPage = lstKhachHang.getMaxPage();

		showPageNumber();

	}

	private void showPageNumber() {
		if (currentPage > maxPage) {
			currentPage = maxPage;
		}
		if (maxPage == 1) {
			lblPage.setText("1");
		} else {
			lblPage.setText(currentPage + "/" + maxPage);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnPrev)) {
			LoadPrevPage();
		}
		if (o.equals(btnNext)) {
			LoadNextPage();
		}
		if (o.equals(btnThemDichVu)) {
			System.out.println("Them clicked");
		}
		if (o.equals(btnXoaDichVu)) {
			System.out.println("Xoa Clicked");
		}
		if (o.equals(btnSuaDichVu)) {
			System.out.println("Sua Clicked");
		}
		if (o.equals(btnSearch)) {
			SearchDsDichVu();
		}
	}

	private void SearchDsDichVu() {
//		String nameSearch = txtSearchText.getText().toString();
//		if (nameSearch.length() <= 0) {
//			JOptionPane.showMessageDialog(null, "Oops!, bạn chưa nhập tên khách hàng cần tìm");
//			txtSearchText.requestFocus();
//			return;
//		}
//
//		try {
//			lstKhachHang = khachHangService.getListKhachHangByPage(1, maxRow, nameSearch);
//			LoadDsKhachHang(lstKhachHang);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	private void LoadNextPage() {
//		currentPage++;
//		if (currentPage > maxPage) {
//			currentPage = maxPage;
//			return;
//		}
//
//		int nextPageNumb = lstKhachHang.getCurrentPage() + 1;
//		try {
//			String nameSearch = txtSearchText.getText().toString();
//			lstKhachHang = khachHangService.getListKhachHangByPage(nextPageNumb, maxRow,
//					nameSearch.length() > 0 ? nameSearch : "");
//			LoadDsKhachHang(lstKhachHang);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	private void LoadPrevPage() {
//		currentPage--;
//		if (currentPage < 1) {
//			currentPage = 1;
//			return;
//		}
//
//		int PrevPageNumb = lstKhachHang.getCurrentPage() - 1;
//		try {
//			String nameSearch = txtSearchText.getText().toString();
//			lstKhachHang = khachHangService.getListKhachHangByPage(PrevPageNumb, maxRow,
//					nameSearch.length() > 0 ? nameSearch : "");
//			LoadDsKhachHang(lstKhachHang);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

}
