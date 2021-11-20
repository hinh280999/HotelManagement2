package GUI.Dialog;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.KhachHangService;
import Model.PageList;
import Rmi.DTO.KhachHangDTO;

public class ChooseCustomerDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable tbDsKH;
	private JTextField txtTenKH;
	private JButton btnPrev, btnNext, btnSearch, btnOK;
	private KhachHangDTO selectedKh = new KhachHangDTO();
	private PageList<KhachHangDTO> lstKH;
	private KhachHangService khachHangService;
	private JLabel lblPageNumb;

	public ChooseCustomerDialog() {
		setModal(true);
		setSize(800, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel pDsKH = new JPanel();
		pDsKH.setBackground(Color.WHITE);
		pDsKH.setBounds(10, 10, 766, 450);
		pDsKH.setLayout(null);
		getContentPane().add(pDsKH);

		JScrollPane scpDsKh = new JScrollPane();
		scpDsKh.setBounds(10, 65, 746, 342);
		pDsKH.add(scpDsKh);

		tbDsKH = new JTable();
		scpDsKh.setViewportView(tbDsKH);

		tbDsKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tbDsKH.getSelectedRow();
				selectedKh = lstKH.getListData().get(selectedRow);
			}
		});

		btnPrev = new JButton("<");
		btnPrev.setBounds(10, 420, 85, 20);
		pDsKH.add(btnPrev);

		lblPageNumb = new JLabel("pageNumb");
		lblPageNumb.setBounds(100, 420, 45, 20);
		pDsKH.add(lblPageNumb);

		btnNext = new JButton(">");
		btnNext.setBounds(150, 420, 85, 20);
		pDsKH.add(btnNext);

		txtTenKH = new JTextField();
		txtTenKH.setBounds(10, 20, 413, 20);
		pDsKH.add(txtTenKH);
		txtTenKH.setColumns(10);

		btnSearch = new JButton("T\u00ECm ki\u1EBFm");
		btnSearch.setBounds(433, 19, 95, 21);
		pDsKH.add(btnSearch);

		btnOK = new JButton("OK");
		btnOK.setBounds(671, 420, 85, 21);
		pDsKH.add(btnOK);

		// ===== Add Action ====================== //
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOK.addActionListener(this);
		// =======///

		// === Load data ====
		try {
			khachHangService = new KhachHangService();
			lstKH = khachHangService.searchListKhachHang("", 1);
			loadDsKhachHang(lstKH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnOK)) {
			this.dispose();
		}
		if (o.equals(btnPrev)) {
			// get previous page
			System.out.println("Prev Clicked");
		}
		if (o.equals(btnNext)) {
			// get next page
			System.out.println("Next Clicked");
		}
		if (o.equals(btnSearch)) {
			// list customer by name, page 1
			System.out.println("Search Clicked");
			SearchKhachHang();
		}
	}

	private void SearchKhachHang() {
		String name = txtTenKH.getText().toString();
		try {
			lstKH = khachHangService.searchListKhachHang(name, 1);
			loadDsKhachHang(lstKH);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public KhachHangDTO getSelectdCustomer() {
		return selectedKh;
	}

	private void loadDsKhachHang(PageList<KhachHangDTO> pageListModel) {
		String[] tieude = { "Tên", "Số CMT", "SĐT", "Email", "Địa Chỉ" };
		DefaultTableModel model = new DefaultTableModel(tieude, 0);
		for (KhachHangDTO KH : pageListModel.getListData()) {
			Object[] o = { KH.getTen(), KH.getSoCMND(), KH.getSdt(), KH.getEmail(), KH.getDiaChi() };
			model.addRow(o);
		}
		tbDsKH.setModel(model);
		System.out.println(pageListModel.getMaxPage());
		if (pageListModel.getMaxPage() == 1) {
			lblPageNumb.setText("1");
		} else {
			lblPageNumb.setText(pageListModel.getCurrentPage() + "/" + pageListModel.getMaxPage());
		}

	}

}
