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

import javax.swing.JTextField;

import Rmi.DTO.KhachHangDTO;

public class ChooseCustomerDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable tbDsKH;
	private JTextField txtTenKH;
	private JButton btnPrev, btnNext, btnSearch, btnOK;
	private KhachHangDTO khDTO = new KhachHangDTO();

	public ChooseCustomerDialog() {
		setModal(true);
		setSize(800, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel pDsKH = new JPanel();
		pDsKH.setBackground(Color.WHITE);
		pDsKH.setBounds(10, 10, 766, 450);
		getContentPane().add(pDsKH);
		pDsKH.setLayout(null);

		JScrollPane scpDsKh = new JScrollPane();
		scpDsKh.setBounds(10, 65, 746, 342);
		pDsKH.add(scpDsKh);

		tbDsKH = new JTable();
		scpDsKh.setViewportView(tbDsKH);

		btnPrev = new JButton("<");
		btnPrev.setBounds(10, 420, 85, 20);
		pDsKH.add(btnPrev);

		JLabel lblNewLabel = new JLabel("pageNumb");
		lblNewLabel.setBounds(100, 420, 45, 20);
		pDsKH.add(lblNewLabel);

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnOK)) {
			setSelectedCustomer();
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
		}
	}

	private void setSelectedCustomer() {
		System.out.println("Click OK");
	}

	public KhachHangDTO getSelectdCustomer() {
		KhachHangDTO kh = new KhachHangDTO("Ten", "Mail", "Sdt", "diachi", "cmnd");
		kh.setMaKH(1);
		return kh;
	}
}
