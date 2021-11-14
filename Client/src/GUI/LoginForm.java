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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import CustomControll.ColorButton;
import CustomControll.GradientPanel;

public class LoginForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtEmail;
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
		GradientPanel LogInfromPanel = new GradientPanel(color1, color2, 180, 480);
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

		txtEmail = new JTextField();
		txtEmail.setText("Sá»‘ Ä‘iá»‡n thoáº¡i/E-mail");
		txtEmail.setForeground(new Color(169, 169, 169));
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().toString().equals("Sá»‘ Ä‘iá»‡n thoáº¡i/E-mail")) {
					txtEmail.setText("");
					txtEmail.setForeground(new Color(0, 0, 0));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().toString().equals("")) {
					txtEmail.setText("Sá»‘ Ä‘iá»‡n thoáº¡i/E-mail");
					txtEmail.setForeground(new Color(169, 169, 169));
				}
			}
		});
		txtEmail.setBounds(6, 97, 283, 36);
		txtEmail.setColumns(10);
		panelForm.add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(6, 166, 283, 36);
		panelForm.add(txtPassword);

		btnDangNhap = new ColorButton();
		btnDangNhap.setBounds(6, 239, 283, 28);
		btnDangNhap.setText("Ä�Äƒng nháº­p");
		btnDangNhap.setToolTipText("Ä�Äƒng nháº­p");
		panelForm.add(btnDangNhap);

		JLabel lblNewLabel_1 = new JLabel("TÃ i khoáº£n");
		lblNewLabel_1.setBounds(6, 79, 59, 16);
		panelForm.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Máº­t kháº©u");
		lblNewLabel_2.setBounds(6, 150, 59, 16);
		panelForm.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 9, 289, 58);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("img/a.png").getImage().getScaledInstance(289, 58, Image.SCALE_DEFAULT));
		lblNewLabel_3.setIcon(imageIcon);
		panelForm.add(lblNewLabel_3);

		btnQuenMk = new JButton("QuÃªn máº­t kháº©u ? ");
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
		btnMinimize.setToolTipText("Thu g\u1ECDn");
		btnMinimize.setIcon(new ImageIcon("img/minimize.png"));
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBounds(649, 0, 28, 28);

		JButton btnClose = new JButton("");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setToolTipText("Tho\u00E1t");
		btnClose.setIcon(new ImageIcon("img/cross.png"));
		btnClose.setContentAreaFilled(false);
		btnClose.setBounds(691, 0, 28, 28);
		pControll.setLayout(null);
		pControll.add(btnMinimize);
		pControll.add(btnClose);

		// ===================================================
		btnDangNhap.addActionListener(this);
		btnQuenMk.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			System.out.println("Click Ä�Äƒng Nháº­p");
			FuntionDangNhap();
		}
		if (o.equals(btnQuenMk)) {
			System.out.println("Click QuÃªn máº­t kháº©u");
		}

	}

	private void FuntionDangNhap() {
		if (txtEmail.getText().toString().equals("admin") && txtPassword.getText().toString().equals("1")) {
			MainFrame frame = new MainFrame();
			frame.setLogInAccount("Admin", "Admin");
			frame.setVisible(true);
			this.dispose();
		}
	}
}
