package views.login;

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

import javax.swing.AbstractButton;
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

import Yarns.YarnEncriptKey;
import Yarns.YarnSetVisibleComponents;
import commons.CMessage;
import commons.ArrayList;
import maintenance.PersonalManagement;
import maintenance.UserManagement;
import models.Personal;
import models.User;
import models.NewUser;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

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
	private JLabel lblRolDeUsuario;
	private JComboBox cboRol;

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
		setBounds(100, 100, 342, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogoCibertec = new JLabel("");
		lblLogoCibertec.setIcon(new ImageIcon(Register.class.getResource("/assets/images/cibertec-logo.png")));
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
		lblPassword.setBounds(35, 371, 195, 15);
		contentPane.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.LIGHT_GRAY);
		txtPassword.setBounds(35, 398, 256, 25);
		contentPane.add(txtPassword);

		lblRetryPassword = new JLabel("Repita contraseña:");
		lblRetryPassword.setBounds(35, 435, 195, 15);
		contentPane.add(lblRetryPassword);

		btnSingUp = new JButton("REGISTRARSE");
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});

		txtRetryPassword = new JPasswordField();
		txtRetryPassword.setBackground(Color.LIGHT_GRAY);
		txtRetryPassword.setBounds(35, 462, 256, 25);
		contentPane.add(txtRetryPassword);
		btnSingUp.setBounds(106, 515, 130, 25);
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
					message.message(this, "Debe ingresar el codigo de personal");
				} else {
					p = new PersonalManagement().verify(code);
					if (p == null) {
						message.message(this,
								"Código inexistente \n _______________________________________ \n Debe ser trabajador del hospital");
						hiddenInputs();
					} else {
						if (p.getIdUsuario() != null) {
							message.message(this, "Ya cuenta con un usuario");
							hiddenInputs();
						} else {
							u = new UserManagement().userGenerate();
							txtUser.setText(u.getCode());
							showInputs();
						}
					}
				}

			}
		});

		contentPane.add(lblSearch);

		lblRolDeUsuario = new JLabel("Rol de usuario:");
		lblRolDeUsuario.setBounds(35, 312, 182, 15);
		contentPane.add(lblRolDeUsuario);

		cboRol = new JComboBox();
		cboRol.setBackground(Color.LIGHT_GRAY);
		cboRol.setBounds(35, 335, 256, 25);
		contentPane.add(cboRol);
		hiddenInputs();
	}

	public static Personal p = new Personal();
	public static User u = new User();

	YarnSetVisibleComponents yarn = new YarnSetVisibleComponents();
	ArrayList yarnA = new ArrayList(this);
	CMessage message = new CMessage();

	void signUp() {
		String user, pass, rpass, pers;
		pers = readPersonal();
		user = readUser();
		pass = readPassword();
		rpass = readRetryPassword();

		String[][] string = { { pass, "contraseña" }, { rpass, "repetir contraseña" } };

		boolean isNull = yarnA.validateInputs(string);

		if (!isNull) {
			if (!pass.matches(rpass)) {
				message.message(this, "Las contraseñas tienen que coincidir");
			} else {
				YarnEncriptKey yarnEK = new YarnEncriptKey(rpass);
				rpass = yarnEK.encript();

				NewUser nu = new NewUser();

				nu.setUserPersonal(pers);
				nu.setUserCode(user);
				nu.setNewPassword(rpass);
				nu.setUserType(1);

				int ok = new UserManagement().userCreate(nu);

				if (ok == 0) {
					message.message(this, "Error al registrar");
				} else {
					message.message(this, "Registro ok", "Existoso");
				}
			}

		}
	}

	void showInputs() {
		JComponent[] components = { txtUser, txtPassword, txtRetryPassword, lblUser, lblPassword, lblRetryPassword,
				lblErrorMessage, btnSingUp };
		yarn.show(components);
		setBounds(100, 100, 342, 628);
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
		return txtPersonal.getText().length() == 0 ? null : txtPersonal.getText();
	}

	public String readUser() {
		return txtUser.getText().length() == 0 ? null : txtUser.getText();
	}

	public String readPassword() {
		String password = String.valueOf(txtPassword.getPassword());
		return password.length() == 0 ? null : password;
	}

	public String readRetryPassword() {
		String password = String.valueOf(txtRetryPassword.getPassword());
		return password.length() == 0 ? null : password;
	}

	public int readRol() {
		return cboRol.getSelectedIndex() == 0 ? null : cboRol.getSelectedIndex();
	}
}
