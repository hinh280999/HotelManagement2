package GUI.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.PhongDao;
import Model.PageList;
import Rmi.DTO.PhongDTO;

public class QuanLyPhongForm extends JPanel implements ActionListener {
	private PhongDao phongDao = null;
	private JTable tblDsPhong;
	private JButton btnPrev, btnNext;
	private JLabel lblPage;
	private PageList<PhongDTO> lstPhong;
	private int currentPage, maxPage;
	private static int maxRow = 2;

	public QuanLyPhongForm() {
		setBackground(Color.decode("#d4d5d6"));
		setBounds(0, 0, 1180, 820);
		setLayout(null);

		JPanel pSearch = new JPanel();
		pSearch.setBackground(Color.WHITE);
		pSearch.setBounds(10, 10, 1160, 120);
		add(pSearch);

		JPanel pTable = new JPanel();
		pTable.setBackground(Color.WHITE);
		pTable.setBounds(10, 170, 1160, 640);
		add(pTable);
		pTable.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 1140, 508);
		pTable.add(scrollPane);

		tblDsPhong = new JTable();
		scrollPane.setViewportView(tblDsPhong);

		JLabel lblNewLabel = new JLabel("Danh sách phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 10, 150, 30);
		pTable.add(lblNewLabel);

		btnPrev = new JButton("<");
		btnPrev.setBounds(359, 589, 85, 21);
		pTable.add(btnPrev);

		lblPage = new JLabel("paging");
		lblPage.setBounds(479, 593, 45, 13);
		pTable.add(lblPage);

		btnNext = new JButton(">");
		btnNext.setBounds(578, 589, 85, 21);
		pTable.add(btnNext);

		// == action ============
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);

		// == load ds phong ====
		try {
			phongDao = PhongDao.getInstance();
			lstPhong = phongDao.getListPhongPaged(1, maxRow, "");
			LoadDsPhong(lstPhong);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private void LoadDsPhong(PageList<PhongDTO> lstPhong) {
		String[] tieude = { "Mã Phòng", "Tên Phòng", "Trạng Thái", "Loại Phòng" };
		DefaultTableModel model = new DefaultTableModel(tieude, 0);

		for (PhongDTO phong : lstPhong.getListData()) {
			Object[] o = { phong.getTen(), phong.getTen(), phong.getTinhTrangPhong_id(), phong.getLoaiPhong_id() };
			model.addRow(o);
		}
		tblDsPhong.setModel(model);

		currentPage = lstPhong.getCurrentPage();
		maxPage = lstPhong.getMaxPage();

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
			System.out.println("Prev Clicked");
			LoadPrevPage();
		}
		if (o.equals(btnNext)) {
			System.out.println("Next Clicked");
			loadNextPage();
		}

	}

	private void loadNextPage() {
		// String searchName = txtTenKH.getText().toString();
		currentPage++;
		if (currentPage > maxPage) {
			currentPage = maxPage;
			return;
		}

		int nextPageNumb = lstPhong.getCurrentPage() + 1;
		try {
			lstPhong = phongDao.getListPhongPaged(nextPageNumb, maxRow, "");
			LoadDsPhong(lstPhong);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void LoadPrevPage() {
		// String name = txtTenKH.getText().toString();
		currentPage--;
		if (currentPage < 1) {
			currentPage = 1;
			return;
		}

		int PrevPageNumb = lstPhong.getCurrentPage() - 1;
		try {
			lstPhong = phongDao.getListPhongPaged(PrevPageNumb, maxRow, "");
			LoadDsPhong(lstPhong);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
