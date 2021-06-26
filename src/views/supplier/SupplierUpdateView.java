package views.supplier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import commons.ArrayList;
import commons.CMessage;
import commons.Regex;
import maintenance.SupplierManagement;
import models.Supplier;

public class SupplierUpdateView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtFullName;
	private JTextField txtContact;
	private JTextField txtAddress;
	private JTextField txtTelephone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierUpdateView frame = new SupplierUpdateView();
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
	public SupplierUpdateView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblActualizacinDeDatos = new JLabel("Actualización Proveedor");
		lblActualizacinDeDatos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActualizacinDeDatos.setForeground(SystemColor.desktop);
		lblActualizacinDeDatos.setBounds(42, 0, 228, 25);
		contentPane.add(lblActualizacinDeDatos);

		JLabel lblCode = new JLabel("Código");
		lblCode.setBounds(20, 50, 163, 20);
		contentPane.add(lblCode);

		JLabel lblFullName = new JLabel("Nombre completo");
		lblFullName.setBounds(20, 100, 150, 20);
		contentPane.add(lblFullName);

		JLabel lblContact = new JLabel("Contacto");
		lblContact.setBounds(20, 150, 150, 20);
		contentPane.add(lblContact);

		JLabel lblAddress = new JLabel("Dirección");
		lblAddress.setBounds(20, 200, 150, 20);
		contentPane.add(lblAddress);

		JLabel lblTelephone = new JLabel("Teléfono");
		lblTelephone.setBounds(20, 250, 150, 20);
		contentPane.add(lblTelephone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 300, 150, 20);
		contentPane.add(lblEmail);

		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setBounds(20, 70, 100, 20);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtFullName = new JTextField();
		txtFullName.setBounds(20, 120, 250, 20);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);

		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSupplier();
			}
		});
		btnUpdate.setBounds(78, 352, 117, 25);
		contentPane.add(btnUpdate);

		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(20, 170, 250, 20);
		contentPane.add(txtContact);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(20, 220, 250, 20);
		contentPane.add(txtAddress);

		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(20, 270, 250, 20);
		contentPane.add(txtTelephone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(20, 320, 250, 20);
		contentPane.add(txtEmail);
		setLocationRelativeTo(null);
		getSupplier();
	}

	public static String CODE_SUPPLIER;

	CMessage message = new CMessage();
	Regex regex = new Regex();
	ArrayList yarnA = new ArrayList(this);

	void getSupplier() {
		String code = CODE_SUPPLIER;
		Supplier s = new SupplierManagement().search(code);

		if (s == null) {
			message.message(this, "Código no existe", "Not Found");
		} else {
			txtCode.setText(code);
			txtFullName.setText(s.getName_supplier());
			txtContact.setText(s.getContact_supplier());
			txtAddress.setText(s.getDirection_supplier());
			txtTelephone.setText(s.getPhone_supplier());
			txtEmail.setText(s.getEmail_supplier());
		}
	}

	void updateSupplier() {
		String fullName, contact, address, telephone, email;
		fullName = readFullName();
		contact = readContact();
		address = readAddress();
		telephone = readTelephone();
		email = readEmail();

		String[][] string = { { fullName, "nombre" }, { contact, "contacto" }, { address, "Dirección" },
				{ telephone, "Teléfono" }, { email, "email" } };

		if (!yarnA.validateInputs(string)) {
			if (regex.regexMatch(fullName)) {
				if (regex.regexMatch(contact)) {
					if (regex.regexMatch(telephone, "phone")) {
						if (regex.regexMatch(email, "email")) {
							Supplier s = new Supplier();

							s.setId_supplier(CODE_SUPPLIER);
							s.setName_supplier(fullName);
							s.setContact_supplier(contact);
							s.setDirection_supplier(address);
							s.setPhone_supplier(telephone);
							s.setEmail_supplier(email);

							int ok = new SupplierManagement().edit(s);

							if (ok == 0) {
								message.message(this, "No se puedo actualizar");
							} else {
								message.message(this, "Se actualizó correctamente", "Success");
								dispose();
							}
						} else {
							message.message(this, "Debe agregar correctamente el email demo@demo.com");
						}
					} else {
						message.message(this, "Debe agregar correctamente el teléfono \n 999999999");
					}
				} else {
					message.message(this, "Debe agregar correctamente el nombre del contacto");
				}
			} else {
				message.message(this, "Debe agregar correctamente el nombre del personal");
			}
		}

	}

	String readFullName() {
		return txtFullName.getText().length() == 0 ? null : txtFullName.getText();
	}

	String readContact() {
		return txtContact.getText().length() == 0 ? null : txtContact.getText();
	}

	String readAddress() {
		return txtAddress.getText().length() == 0 ? null : txtAddress.getText();
	}

	String readTelephone() {
		return txtTelephone.getText().length() == 0 ? null : txtTelephone.getText();
	}

	String readEmail() {
		return txtEmail.getText().length() == 0 ? null : txtEmail.getText();
	}
}
