package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import CustomControll.PanelMenu;

public class MainFrame extends JFrame {
	private Color colorEnter = Color.WHITE;
	private String username;
	private String permission;
	private JPanel contentPane, panelMain;
	private List<JPanel> listMenuPanel;
	private JLabel titleLabel;
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
		setBounds(0, 0, 1290, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JPanel panelContainer = new JPanel();
		panelContainer.setBounds(0, 0, 1286, 692);
		panelContainer.setLayout(null);
		contentPane.add(panelContainer);

		JPanel panelSideBar = new JPanel();
		panelSideBar.setBounds(0, 0, 250, 692);
		panelSideBar.setBackground(Color.decode("#3a71fc"));
		panelContainer.add(panelSideBar);
		panelSideBar.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setText("CLick me");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 10, 250, 83);
		panelSideBar.add(lblNewLabel);

		separator.setBounds(0, 91, 250, 2);
		panelSideBar.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Xá»­ lÃ½");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 103, 55, 30);
		panelSideBar.add(lblNewLabel_1);

		PanelMenu panel = new PanelMenu("Ä�áº·t PhÃ²ng");
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(new Page1(),"Dat Phong", null);
			}
		});
		panel.setBounds(0, 140, 250, 40);
		panelSideBar.add(panel);
		panel.setLayout(null);

		PanelMenu panel_1 = new PanelMenu("XÃ³a PhÃ²ng");
		panel_1.setLayout(null);
		panel_1.setBounds(0, 180, 250, 40);
		panelSideBar.add(panel_1);

		panelMain = new JPanel();
		panelMain.setBounds(250, 40, 1035, 692);
		panelContainer.add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#ffa454"));
		panel_2.setBounds(250, 0, 1035, 40);
		panelContainer.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("icon");
		lblNewLabel_2.setBounds(10, 0, 40, 40);
		panel_2.add(lblNewLabel_2);

		titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		titleLabel.setBounds(60, 0, 100, 40);
		panel_2.add(titleLabel);

		
		// =====================================
		listMenuPanel = new ArrayList<JPanel>();
	}

	public void setLogInAccount(String string, String string2) {
		this.username = string;
		this.permission = string2;
	}

	private void setCorlor(JPanel panel) {
		panel.setBackground(Color.decode("#fafafa"));
		panel.setForeground(Color.WHITE);
	}

	private void resetCorlor(JPanel panel) {

		for (JPanel jPanel : listMenuPanel) {
			if (jPanel.equals(panel)) {
				continue;
			}
			jPanel.setBackground(Color.BLACK);
			jPanel.setForeground(Color.WHITE);
		}
	}

	private void setMainPanel(JPanel panel, String text, Icon icon) {
		titleLabel.setText(text);
		panelMain.removeAll();
		panelMain.add(panel, BorderLayout.CENTER);
	}
}
