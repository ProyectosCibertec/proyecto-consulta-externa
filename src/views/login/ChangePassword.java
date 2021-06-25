package views.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Yarns.YarnEncriptKey;
import commons.ArrayList;
import commons.CMessage;
import maintenance.UserManagement;
import models.User;

public class ChangePassword extends JFrame {

	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JPanel contentPane;
	private JPasswordField txtRetryPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Login l = new Login();
				l.setVisible(true);
			}
		});

		setTitle("Hospital - Cambio contraseña");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogoCibertec = new JLabel("");
		lblLogoCibertec.setIcon(new ImageIcon(ChangePassword.class.getResource("/assets/images/cibertec-logo.png")));
		lblLogoCibertec.setBounds(96, -11, 150, 122);
		contentPane.add(lblLogoCibertec);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(35, 120, 256, 2);
		contentPane.add(separator);

		JLabel lblAcceder = new JLabel("CAMBIAR CONTRASEÑA");
		lblAcceder.setFont(new Font("C059", Font.BOLD, 17));
		lblAcceder.setBounds(45, 134, 233, 30);
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

		JLabel lblPassword = new JLabel("Nueva contraseña:");
		lblPassword.setBounds(35, 230, 195, 15);
		contentPane.add(lblPassword);

		JButton btnUpdate = new JButton("ACTUALIZAR");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassword();
			}
		});
		btnUpdate.setBounds(96, 375, 134, 25);
		contentPane.add(btnUpdate);

		txtRetryPassword = new JPasswordField();
		txtRetryPassword.setBackground(Color.LIGHT_GRAY);
		txtRetryPassword.setBounds(35, 321, 256, 25);
		contentPane.add(txtRetryPassword);

		JLabel lblRetryPassword = new JLabel("Repetir contraseña:");
		lblRetryPassword.setBounds(35, 294, 195, 15);
		contentPane.add(lblRetryPassword);
		setLocationRelativeTo(null);
	}

	CMessage message = new CMessage();
	ArrayList arr = new ArrayList();

	User u = new User();

	void updatePassword() {
		String user, pass, rpass;
		user = readUser();
		pass = readPassword();
		rpass = readRetryPassword();

		String[][] data = { { user, "usuario" }, { pass, "contraseña" }, { rpass, "repetir contraseña" } };
		boolean isNull = arr.validateInputs(data);

		if (!isNull) {
			if (!pass.matches(rpass)) {
				message.message(this, "Las contraseñas tienen que coincidir");
			} else if (!userExists()) {
				message.message(this, "El usuario no existe");
			} else {
				YarnEncriptKey yarnEK = new YarnEncriptKey(rpass);
				rpass = yarnEK.encript();

				u.setCode(user);
				u.setPassword(rpass);

				int ok = new UserManagement().changedUserPassword(u);

				if (ok == 0) {
					message.message(this, "Error al cambiar contraseña");
				} else {
					message.message(this, "Cambio de contraseña realizado", "Existoso");
				}
			}
		}
	}

	boolean userExists() {
		String user = readUser();
		u = new UserManagement().userExists(user);
		if (u == null) {
			return false;
		}
		return true;
	}

	String readUser() {
		return txtUser.getText().length() == 0 ? null : txtUser.getText();
	}

	String readPassword() {
		String pass = String.valueOf(txtPassword.getPassword());
		return pass.length() == 0 ? null : pass;
	}

	String readRetryPassword() {
		String rpass = String.valueOf(txtRetryPassword.getPassword());
		return rpass.length() == 0 ? null : rpass;
	}

}
