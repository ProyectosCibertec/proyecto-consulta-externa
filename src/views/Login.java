package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Yarns.YarnEncriptKey;
import maintenance.UserM;
import models.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;

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
		setBounds(100, 100, 342, 429);
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
		txtUser.setBackground(Color.LIGHT_GRAY);
		txtUser.setBounds(35, 199, 256, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.LIGHT_GRAY);
		txtPassword.setBounds(35, 257, 256, 25);
		contentPane.add(txtPassword);

		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setBounds(35, 172, 182, 15);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(35, 230, 195, 15);
		contentPane.add(lblPassword);

		JButton btnSingIn = new JButton("INGRESAR");
		btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn();
			}
		});
		btnSingIn.setBounds(100, 304, 117, 25);
		contentPane.add(btnSingIn);

		JLabel lblConsulting = new JLabel("¿No tienes cuenta?");
		lblConsulting.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblConsulting.setBounds(35, 353, 124, 15);
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
		lblRegister.setBounds(155, 353, 104, 15);
		contentPane.add(lblRegister);
		setLocationRelativeTo(null);

	}

	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Avisos", 2);
	}

	public static User u = new User();

	void signIn() {
		String user, pass;

		user = readUser();
		pass = readPassword();

		if (user == null || pass == null) {
			message("Debe llenar los campos");
		} else {
			u = new UserM().validateAccess(user, pass);

			if (u == null) {
				message("Usuario y/o contraseña incorretos " + pass);

			} else {
				message("Bienvenido " + u.getUser());
			}
		}

	}

	public String readUser() {
		if (txtUser.getText().length() == 0) {
			message("Debe ingresar el usuario");
			return null;
		}
		return txtUser.getText();
	}

	public String readPassword() {
		String password = String.valueOf(txtPassword.getPassword());
		if (password.length() == 0) {
			message("Debe ingresar el usuario");
			return null;
		}

		YarnEncriptKey yarn = new YarnEncriptKey(password);
		password = yarn.encript();

		return password;
	}

}
