package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonLiteral;

import java.lang.reflect.Field;

import Yarns.YarnArrayList;
import Yarns.YarnEncriptKey;
import Yarns.YarnSetVisibleComponents;
import maintenance.PersonalManagement;
import maintenance.UserM;
import models.Personal;
import models.User;
import models.newUser;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JPasswordField txtRetryPassword;
	private JTextField txtPersonal;
	private JButton btnSingUp;
	private JLabel lblSearch;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblRetryPassword;
	private JLabel lblErrorMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Login l = new Login();
				l.setVisible(true);
			}
		});
		setTitle("Hospital - Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 551);
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

		JLabel lblRegister = new JLabel("Registrarse");
		lblRegister.setFont(new Font("C059", Font.BOLD, 25));
		lblRegister.setBounds(84, 130, 162, 30);
		contentPane.add(lblRegister);

		lblUser = new JLabel("Nombre de usuario:");
		lblUser.setBounds(35, 248, 182, 15);
		contentPane.add(lblUser);

		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBackground(Color.LIGHT_GRAY);
		txtUser.setBounds(35, 275, 256, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(35, 306, 195, 15);
		contentPane.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.LIGHT_GRAY);
		txtPassword.setBounds(35, 333, 256, 25);
		contentPane.add(txtPassword);

		lblRetryPassword = new JLabel("Repita contraseña:");
		lblRetryPassword.setBounds(35, 370, 195, 15);
		contentPane.add(lblRetryPassword);

		btnSingUp = new JButton("REGISTRARSE");
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});

		txtRetryPassword = new JPasswordField();
		txtRetryPassword.setBackground(Color.LIGHT_GRAY);
		txtRetryPassword.setBounds(35, 397, 256, 25);
		contentPane.add(txtRetryPassword);
		btnSingUp.setBounds(106, 450, 130, 25);
		contentPane.add(btnSingUp);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblErrorMessage.setBounds(157, 487, 162, 15);
		contentPane.add(lblErrorMessage);

		txtPersonal = new JTextField();
		txtPersonal.setColumns(10);
		txtPersonal.setBackground(Color.LIGHT_GRAY);
		txtPersonal.setBounds(35, 194, 189, 25);
		contentPane.add(txtPersonal);

		JLabel lblPersonal = new JLabel("Código de Personal:");
		lblPersonal.setBounds(35, 167, 182, 15);
		contentPane.add(lblPersonal);

		lblSearch = new JLabel("");
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/assets/images/search.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lblSearch.setIcon(iconoEscalado);
		lblSearch.setBounds(252, 189, 39, 30);
		lblSearch.setCursor(new Cursor(HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String code = readPersonal();
				if (code == null) {
					message("Debe ingresar el codigo de personal");
				} else {
					p = new PersonalManagement().verify(code);
					if (p == null) {
						message("Código inexistente \n _______________________________________ \n Debe ser trabajador del hospital");
						hiddenInputs();
					} else {
						u = new UserM().getUser();
						txtUser.setText(u.getCode());
						showInputs();
					}
				}

			}
		});

		contentPane.add(lblSearch);
		hiddenInputs();
	}

	public static Personal p = new Personal();
	public static User u = new User();

	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Avisos", 2);
	}

	YarnSetVisibleComponents yarn = new YarnSetVisibleComponents();

	void signUp() {
		String user, pass, rpass, pers;
		pers = readPersonal();
		user = readUser();
		pass = readPassword();
		rpass = readRetryPassword();

		String[][] string = { { pass, "contraseña" }, { rpass, "repetir contraseña" } };
		YarnArrayList yarnA = new YarnArrayList(this);
		boolean isNull = yarnA.validateInputs(string);

		if (!isNull) {
			if (!pass.matches(rpass)) {
				message("Las contraseñas tienen que coincidir");
			} else {
				YarnEncriptKey yarnEK = new YarnEncriptKey(rpass);
				rpass = yarnEK.encript();

				newUser nu = new newUser();

				nu.setUserPersonal(pers);
				nu.setNewUser(user);
				nu.setNewPassword(rpass);
				nu.setUserType(1);

				int ok = new UserM().createUser(nu);

				if (ok == 0) {
					message("Error al registrar");
				} else {
					message("Registro ok");
				}
			}

		}
	}

	void showInputs() {
		JComponent[] components = { txtUser, txtPassword, txtRetryPassword, lblUser, lblPassword, lblRetryPassword,
				lblErrorMessage, btnSingUp };
		yarn.show(components);
		setBounds(100, 100, 342, 551);
		setLocationRelativeTo(null);
	}

	void hiddenInputs() {
		JComponent[] components = { txtUser, txtPassword, txtRetryPassword, lblUser, lblPassword, lblRetryPassword,
				lblErrorMessage, btnSingUp };
		yarn.hidden(components);
		setBounds(100, 100, 342, 280);
		setLocationRelativeTo(null);
	}

	public String readPersonal() {
		if (txtPersonal.getText().length() == 0) {
			return null;
		}
		return txtPersonal.getText();
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
		return password;
	}

	public String readRetryPassword() {
		String password = String.valueOf(txtRetryPassword.getPassword());
		if (password.length() == 0) {
			return null;
		}
		return password;
	}
}
