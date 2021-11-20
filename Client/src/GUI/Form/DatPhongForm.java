package GUI.Form;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Dialog.ChooseCustomerDialog;
import Rmi.DTO.KhachHangDTO;
import java.awt.Font;

public class DatPhongForm extends JPanel {
	private static final long serialVersionUID = 1L;
	private KhachHangDTO selectedKH = new KhachHangDTO();
	private JLabel lblTenKH, lblCmtKH, lblSdtKH, lblEmailKH, lblDiaChiKH;

	public DatPhongForm() {
		setBackground(Color.decode("#d4d5d6"));
		setLayout(null);
		setBounds(0, 0, 1180, 820);

		JPanel pKhachHang = new JPanel();
		pKhachHang.setBackground(Color.WHITE);
		pKhachHang.setBounds(10, 10, 429, 780);
		add(pKhachHang);
		pKhachHang.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin kh\u00E1ch h\u00E0ng");
		lblNewLabel.setBounds(10, 10, 123, 24);
		pKhachHang.add(lblNewLabel);

		JButton btnNewButton = new JButton("Ch\u1ECDn kh\u00E1ch h\u00E0ng");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SampleOpenDialog();
			}
		});
		btnNewButton.setBounds(10, 53, 409, 24);
		pKhachHang.add(btnNewButton);

		JLabel lblNewLabel_5 = new JLabel("Tên Khách: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 150, 130, 40);
		pKhachHang.add(lblNewLabel_5);

		lblTenKH = new JLabel("............................");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenKH.setBounds(180, 150, 240, 40);
		pKhachHang.add(lblTenKH);

		JLabel lblNewLabel_5_1 = new JLabel("Số CMT: ");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(10, 200, 130, 40);
		pKhachHang.add(lblNewLabel_5_1);

		lblCmtKH = new JLabel("............................");
		lblCmtKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCmtKH.setBounds(180, 200, 240, 40);
		pKhachHang.add(lblCmtKH);

		JLabel lblNewLabel_5_1_1 = new JLabel("Số Điện Thoại: ");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(10, 250, 130, 40);
		pKhachHang.add(lblNewLabel_5_1_1);

		lblSdtKH = new JLabel("............................");
		lblSdtKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSdtKH.setBounds(180, 250, 240, 40);
		pKhachHang.add(lblSdtKH);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Địa Chỉ: ");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1_1_1.setBounds(10, 300, 130, 40);
		pKhachHang.add(lblNewLabel_5_1_1_1);

		lblDiaChiKH = new JLabel("............................");
		lblDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChiKH.setBounds(180, 300, 240, 40);
		pKhachHang.add(lblDiaChiKH);

		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Email: ");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1_1_1_1.setBounds(10, 350, 130, 40);
		pKhachHang.add(lblNewLabel_5_1_1_1_1);

		lblEmailKH = new JLabel("............................");
		lblEmailKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmailKH.setBounds(180, 350, 240, 40);
		pKhachHang.add(lblEmailKH);

		JPanel pThoiGian = new JPanel();
		pThoiGian.setBackground(Color.WHITE);
		pThoiGian.setBounds(449, 10, 721, 140);
		add(pThoiGian);
		pThoiGian.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ch\u1ECDn ng\u00E0y \u0111\u1EBFn ng\u00E0y \u0111i");
		lblNewLabel_1.setBounds(10, 10, 123, 23);
		pThoiGian.add(lblNewLabel_1);

		JPanel pPhong = new JPanel();
		pPhong.setBackground(Color.WHITE);
		pPhong.setBounds(449, 160, 721, 258);
		add(pPhong);
		pPhong.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Ch\u1ECDn lo\u1EA1i ph\u00F2ng, c\u00E1c th\u00F4ng tin k\u00E8m theo");
		lblNewLabel_2.setBounds(10, 10, 197, 25);
		pPhong.add(lblNewLabel_2);

		JPanel pThongTin = new JPanel();
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(449, 470, 721, 213);
		add(pThongTin);
		pThongTin.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Th\u00F4ng tin v\u1EC1 gi\u00E1 thu\u00EA.....");
		lblNewLabel_3.setBounds(10, 10, 131, 24);
		pThongTin.add(lblNewLabel_3);

		JPanel pControll = new JPanel();
		pControll.setBackground(Color.WHITE);
		pControll.setBounds(449, 708, 721, 82);
		add(pControll);
		pControll.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("C\u00E1c n\u00FAt th\u00EAm. l\u00E0m m\u1EDBi ...");
		lblNewLabel_4.setBounds(10, 10, 141, 13);
		pControll.add(lblNewLabel_4);

	}

	private void SampleOpenDialog() {
		ChooseCustomerDialog dialog = new ChooseCustomerDialog();

		dialog.setVisible(true);

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				selectedKH = dialog.getSelectdCustomer();
				setCustomerInfo(selectedKH);
			}
		});
	}

	private void setCustomerInfo(KhachHangDTO kh) {
		// JLabel lblTenKH, lblCmtKH, lblSdtKH, lblEmailKH;
		if (kh.getTen() != null) {
			lblTenKH.setText(kh.getTen());
			lblCmtKH.setText(kh.getSoCMND());
			lblSdtKH.setText(kh.getSdt());
			lblEmailKH.setText(kh.getEmail());
			lblDiaChiKH.setText(kh.getDiaChi());
		}
	}
}
