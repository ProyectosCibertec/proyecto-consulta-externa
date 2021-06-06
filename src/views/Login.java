package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Yarns.YarnEncriptKey;
import commons.ArrayList;
import commons.CMessage;
import maintenance.PersonalManagement;
import maintenance.UserManagement;
import models.Personal;
import models.User;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnSingIn;
	private JLabel lblForgotPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public Login() {
		setTitle("Hospital - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogoCibertec = new JLabel("");
		lblLogoCibertec.setIcon(new ImageIcon(Login.class.getResource("/assets/images/cibertec-logo.png")));
		lblLogoCibertec.setBounds(96, -11, 150, 122);
		contentPane.add(lblLogoCibertec);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(35, 120, 256, 2);
		contentPane.add(separator);

		JLabel lblAcceder = new JLabel("ACCEDER");
		lblAcceder.setFont(new Font("C059", Font.BOLD, 25));
		lblAcceder.setBounds(96, 134, 140, 30);
		contentPane.add(lblAcceder);

		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnSingIn.doClick();
			}
		});
		txtUser.setBackground(Color.LIGHT_GRAY);
		txtUser.setBounds(35, 199, 256, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnSingIn.doClick();
			}
		});
		txtPassword.setBackground(Color.LIGHT_GRAY);
		txtPassword.setBounds(35, 257, 256, 25);
		contentPane.add(txtPassword);

		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setBounds(35, 172, 182, 15);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(35, 230, 195, 15);
		contentPane.add(lblPassword);

		btnSingIn = new JButton("INGRESAR");
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn();
			}
		});
		btnSingIn.setBounds(100, 328, 117, 25);
		contentPane.add(btnSingIn);

		JLabel lblConsulting = new JLabel("¿No tienes cuenta?");
		lblConsulting.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblConsulting.setBounds(35, 377, 124, 15);
		contentPane.add(lblConsulting);

		JLabel lblRegister = new JLabel("Regístrate aquí");
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setCursor(new Cursor(HAND_CURSOR));
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register r = new Register();
				r.setVisible(true);
				r.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		lblRegister.setFont(new Font("Dialog", Font.BOLD, 11));
		lblRegister.setBounds(155, 377, 104, 15);
		contentPane.add(lblRegister);

		lblForgotPassword = new JLabel("Olvidé mi contraseña");
		lblForgotPassword.setVisible(false);
		lblForgotPassword.setCursor(new Cursor(HAND_CURSOR));
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePassword cp = new ChangePassword();
				cp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cp.setVisible(true);
				dispose();
			}
		});
		lblForgotPassword.setForeground(Color.BLUE);
		lblForgotPassword.setFont(new Font("Dialog", Font.BOLD, 11));
		lblForgotPassword.setBounds(141, 294, 150, 15);
		contentPane.add(lblForgotPassword);
		setLocationRelativeTo(null);

	}

	CMessage message = new CMessage();

	public static User u = new User();
	public static Personal p = new Personal();

	int counter = 0;

	void signIn() {
		String user, pass;

		user = readUser();
		pass = readPassword();

		String[][] string = { { user, "usuario" }, { pass, "contraseña" } };

		ArrayList yarnA = new ArrayList(this);
		boolean isNull = yarnA.validateInputs(string);

		if (!isNull) {
			u = new UserManagement().validateAccess(user, pass);

			if (u == null) {
				message.message(this, "Usuario y/o contraseña incorretos ");
				counter += 1;
				if (counter == 2) {
					lblForgotPassword.setVisible(true);
				}
			} else {
				p = new PersonalManagement().getPersonalWithUser(user);
				message.message(this, "Bienvenido " + p.getPersonalName());
			}
		}

	}

	public String readUser() {
		if (txtUser.getText().length() == 0) {
			return null;
		}
		return txtUser.getText();
	}

	public String readPassword() {
		String password = String.valueOf(txtPassword.getPassword());
		if (password.length() == 0) {
			return null;
		}

		YarnEncriptKey yarn = new YarnEncriptKey(password);
		password = yarn.encript();

		return password;
	}
}
