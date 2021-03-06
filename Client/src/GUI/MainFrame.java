package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import CustomControll.PanelMenu;
import GUI.Form.DatPhongForm;
import GUI.Form.QuanLyKhachHangForm;
import GUI.Form.QuanLyNhanVienForm;
import GUI.Form.QuanLyPhongForm;

public class MainFrame extends JFrame {
	private Color colorEnter = Color.WHITE;
	private String username = "Sample";
	private String password;
	private boolean permission;
	private JPanel contentPane, panelMain;
	private JLabel titleLabel, lblIconTitle;
	private final JSeparator separator = new JSeparator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JPanel panelContainer = new JPanel();
		panelContainer.setBounds(0, 0, 1436, 854);
		panelContainer.setLayout(null);
		contentPane.add(panelContainer);

		JPanel panelSideBar = new JPanel();
		panelSideBar.setBounds(0, 0, 250, 858);
		panelSideBar.setBackground(Color.decode("#3a71fc"));
		panelContainer.add(panelSideBar);
		panelSideBar.setLayout(null);

		JLabel lblUsername = new JLabel();
		lblUsername.setText("Hello: " + username);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setForeground(SystemColor.text);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(0, 10, 250, 83);
		panelSideBar.add(lblUsername);

		ImageIcon pDieuKhienIcon = new ImageIcon(new ImageIcon("icon/monitor.png").getImage());
		PanelMenu pDieuKhien = new PanelMenu("B???ng ??i???u khi???n", pDieuKhienIcon);
		pDieuKhien.setBounds(0, 103, 250, 40);
		panelSideBar.add(pDieuKhien);

		separator.setBounds(0, 91, 250, 2);
		panelSideBar.add(separator);

		JLabel lbLeTan = new JLabel("Nghi???p v??? l??? t??n");
		lbLeTan.setForeground(SystemColor.text);
		lbLeTan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbLeTan.setBounds(0, 150, 250, 30);
		panelSideBar.add(lbLeTan);

		ImageIcon pDatPhongIcon = new ImageIcon(new ImageIcon("icon/iconDatPhong.png").getImage());
		PanelMenu pDatPhong = new PanelMenu("?????t Ph??ng", pDatPhongIcon);
		pDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(new DatPhongForm(), "?????t Ph??ng", pDatPhongIcon);
			}
		});
		pDatPhong.setBounds(0, 190, 250, 40);
		panelSideBar.add(pDatPhong);
		pDatPhong.setLayout(null);

		ImageIcon pNhanPhongIcon = new ImageIcon(new ImageIcon("icon/iconNhanPhong.png").getImage());
		PanelMenu pNhanPhong = new PanelMenu("Nh???n Ph??ng", pNhanPhongIcon);
		pNhanPhong.setBounds(0, 230, 250, 40);
		panelSideBar.add(pNhanPhong);

		ImageIcon pTraPhongIcon = new ImageIcon(new ImageIcon("icon/iconTraPhong.png").getImage());
		PanelMenu pTraPhong = new PanelMenu("Tr??? Ph??ng", pTraPhongIcon);
		pTraPhong.setBounds(0, 270, 250, 40);
		panelSideBar.add(pTraPhong);

		ImageIcon pGoiDichVuIcon = new ImageIcon(new ImageIcon("icon/iconGoiDichVu.png").getImage());
		PanelMenu pGoiDichVu = new PanelMenu("G???i D???ch V???", pGoiDichVuIcon);
		pGoiDichVu.setBounds(0, 310, 250, 40);
		panelSideBar.add(pGoiDichVu);

		ImageIcon pThanhToanIcon = new ImageIcon(new ImageIcon("icon/iconThanhToan.png").getImage());
		PanelMenu pThanhToan = new PanelMenu("Thanh To??n", pThanhToanIcon);
		pThanhToan.setBounds(0, 350, 250, 40);
		panelSideBar.add(pThanhToan);

		JLabel LbQuanLy = new JLabel("Qu???n L??");
		LbQuanLy.setForeground(Color.WHITE);
		LbQuanLy.setFont(new Font("Tahoma", Font.BOLD, 16));
		LbQuanLy.setBounds(0, 390, 250, 30);
		panelSideBar.add(LbQuanLy);

		ImageIcon pQLPhongIcon = new ImageIcon(new ImageIcon("icon/iconQlPhong.png").getImage());
		PanelMenu pQLPhong = new PanelMenu("Qu???n l?? ph??ng", pQLPhongIcon);
		pQLPhong.setBounds(0, 430, 250, 40);
		pQLPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(new QuanLyPhongForm(), "Qu???n L?? Ph??ng", pQLPhongIcon);
			}
		});
		panelSideBar.add(pQLPhong);

		ImageIcon pQLKhachIcon = new ImageIcon(new ImageIcon("icon/iconQlKhach.png").getImage());
		PanelMenu pQLKhach = new PanelMenu("Qu???n Kh??ch H??ng", pQLKhachIcon);
		pQLKhach.setBounds(0, 470, 250, 40);
		pQLKhach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(new QuanLyKhachHangForm(), "Qu???n Kh??ch H??ng", pQLKhachIcon);
			}
		});
		panelSideBar.add(pQLKhach);
		
		ImageIcon pQLNhanVienIcon = new ImageIcon(new ImageIcon("icon/iconQlKhach.png").getImage());
		PanelMenu pQLNhanVien = new PanelMenu("Qu???n l?? nh??n vi??n", pQLNhanVienIcon);
		pQLNhanVien.setBounds(0, 510, 250, 40);
		pQLNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(new QuanLyNhanVienForm(), "Qu???n L?? Nh??n Vi??n", pQLNhanVienIcon);
			}
		});
		panelSideBar.add(pQLNhanVien);

		panelMain = new JPanel();
		panelMain.setBounds(250, 40, 1186, 818);
		panelContainer.add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));

		JPanel pTitle = new JPanel();
		pTitle.setBackground(Color.decode("#ffa454"));
		pTitle.setBounds(250, 0, 1186, 40);
		pTitle.setLayout(null);

		lblIconTitle = new JLabel("");
		lblIconTitle.setBounds(10, 0, 40, 40);
		pTitle.add(lblIconTitle);

		titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		titleLabel.setBounds(60, 0, 100, 40);
		pTitle.add(titleLabel);
		panelContainer.add(pTitle);

		// =====================================
	}

	public void setLogInAccount(String username, String password, boolean permission) {
		this.username = username;
		this.password = password;
		this.permission = permission;
	}

	private void setMainPanel(JPanel panel, String text, ImageIcon icon) {
		titleLabel.setText(text);
		lblIconTitle.setIcon(icon);
		panelMain.removeAll();
		panelMain.add(panel, BorderLayout.CENTER);
	}
}
