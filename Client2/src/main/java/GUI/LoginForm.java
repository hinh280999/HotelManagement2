package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ClientService.NhanVienService;
import ClientService.TaiKhoanService;
import CustomControll.ColorButton;
import CustomControll.GradientPanel;
import Rmi.DTO.NhanVienDTO;
import Rmi.DTO.TaiKhoanDTO;
import java.awt.Font;

public class LoginForm extends JFrame implements ActionListener {
	private ClientService.TaiKhoanService taiKhoanService;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private ColorButton btnDangNhap;
	private JButton btnQuenMk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String NimbusLookAndFeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginForm frame = new LoginForm();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0, 0, 720, 480, 20, 20));

		Color color1 = new Color(0, 82, 212);
		Color color2 = new Color(111, 177, 252);
		GradientPanel LogInfromPanel = new GradientPanel(color1, color2, 180, 180);
		LogInfromPanel.setBounds(0, 29, 719, 451);
		LogInfromPanel.setLayout(null);
		contentPane.add(LogInfromPanel);

		Panel panelForm = new Panel();
		panelForm.setForeground(SystemColor.window);
		panelForm.setBackground(Color.WHITE);
		panelForm.setBounds(390, 50, 295, 331);
		panelForm.setBackground(new Color(255, 250, 250, 0));
		panelForm.setLayout(null);
		LogInfromPanel.add(panelForm);

		txtUser = new JTextField();
		txtUser.setToolTipText("Nh???p t??i kho???n c???a b???n.");
		txtUser.setText("Nh???p t??n t??i kho???n");
		txtUser.setForeground(new Color(169, 169, 169));
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUser.getText().toString().equals("Nh???p t??n t??i kho???n")) {
					txtUser.setText("");
					txtUser.setForeground(new Color(0, 0, 0));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUser.getText().toString().equals("")) {
					txtUser.setText("Nh???p t??n t??i kho???n");
					txtUser.setForeground(new Color(169, 169, 169));
				}
			}
		});
		txtUser.setBounds(6, 97, 283, 36);
		txtUser.setColumns(10);
		panelForm.add(txtUser);

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Nh???p m???t kh???u cho t??i kho???n c???a b???n.");
		txtPassword.setBounds(6, 166, 283, 36);
		panelForm.add(txtPassword);

		btnDangNhap = new ColorButton();
		btnDangNhap.setBounds(6, 239, 283, 28);
		btnDangNhap.setText("????ng nh???p");
		btnDangNhap.setToolTipText("????ng nh???p h??? th???ng");
		panelForm.add(btnDangNhap);

		JLabel lblNewLabel_1 = new JLabel("T??i kho???n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(6, 79, 100, 20);
		panelForm.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M???t kh???u");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(6, 145, 100, 20);
		panelForm.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 9, 289, 58);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("img/a.png").getImage().getScaledInstance(289, 58, Image.SCALE_DEFAULT));
		lblNewLabel_3.setIcon(imageIcon);
		panelForm.add(lblNewLabel_3);

		btnQuenMk = new JButton("Qu??n m???t kh???u ? ");
		btnQuenMk.setBounds(6, 297, 121, 28);
		panelForm.add(btnQuenMk);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(
				new ImageIcon("img/hotel.png").getImage().getScaledInstance(286, 331, Image.SCALE_DEFAULT));
		lblNewLabel.setBounds(47, 50, 286, 331);
		lblNewLabel.setIcon(imageIcon2);

		LogInfromPanel.add(lblNewLabel);
		Panel pControll = new Panel();
		pControll.setBackground(new Color(237, 242, 242));
		pControll.setBounds(0, 0, 719, 28);
		contentPane.add(pControll);

		JButton btnMinimize = new JButton("");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setToolTipText("Thu g???n");
		btnMinimize.setIcon(new ImageIcon("img/minimize.png"));
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBounds(649, 0, 28, 28);

		JButton btnClose = new JButton("");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setToolTipText("tho??t");
		btnClose.setIcon(new ImageIcon("img/cross.png"));
		btnClose.setContentAreaFilled(false);
		btnClose.setBounds(691, 0, 28, 28);
		pControll.setLayout(null);
		
		pControll.add(btnMinimize);
		pControll.add(btnClose);

		// ===================================================
		btnDangNhap.addActionListener(this);
		btnQuenMk.addActionListener(this);
		txtPassword.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangNhap) || o.equals(txtPassword)) {
			try {
				FuntionDangNhap();
			} catch (MalformedURLException | RemoteException | NotBoundException | ConnectException e1) {

			}
		}
		if (o.equals(btnQuenMk)) {
			System.out.println("Qu??n m???t kh???u.");
		}

	}

	private void FuntionDangNhap() throws MalformedURLException, RemoteException, NotBoundException, ConnectException {
		String tenTk = txtUser.getText().toString();
		String mk = txtPassword.getText().toString();
		if (validateInput(tenTk, mk) == false)
			return;
		try {

			NhanVienDTO nhanvien = NhanVienService.getInstance().getNhanVienByTenTK(tenTk);
			TaiKhoanDTO rvTk = nhanvien.getTaiKhoan();
			
			if (rvTk.getMatKhau().equals(mk)) {
				MainFrame frame = new MainFrame(nhanvien);
				frame.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Nh???p sai m???t kh???u");
				txtPassword.requestFocus();
			}
		} catch (Exception e) {
			HandleException(e);
		}
	}

	private boolean validateInput(String tenTk, String mk) {
		if (tenTk.equals("Nh???p t??n t??i kho???n")) {
			JOptionPane.showMessageDialog(null, "Oops!, b???n ch??a nh???p t??i kho???n.");
			txtUser.requestFocus();
			return false;
		}
		if (mk.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Oops!, b???n ch??a nh???p m???t kh???u");
			txtPassword.requestFocus();
			return false;
		}
		return true;
	}

	private void HandleException(Exception exception) {
		if (exception instanceof NullPointerException) {
			JOptionPane.showMessageDialog(null, "T??n t??i kho???n kh??ng t???n t???i.");
			txtUser.requestFocus();
			return;
		}
		if (exception instanceof java.rmi.ConnectException) {
			JOptionPane.showMessageDialog(null, "Server hi???n kh??ng ho???t ?????ng");
			return;
		}
		exception.printStackTrace();
	}
}
