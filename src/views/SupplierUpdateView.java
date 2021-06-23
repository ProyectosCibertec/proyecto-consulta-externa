package views;

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
		setBounds(100, 100, 495, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblActualizacinDeDatos = new JLabel("Actualización Proveedor");
		lblActualizacinDeDatos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActualizacinDeDatos.setForeground(SystemColor.desktop);
		lblActualizacinDeDatos.setBounds(131, 12, 273, 40);
		contentPane.add(lblActualizacinDeDatos);

		JLabel lblCode = new JLabel("Código");
		lblCode.setBounds(27, 88, 163, 25);
		contentPane.add(lblCode);

		JLabel lblFullName = new JLabel("Nombre completo");
		lblFullName.setBounds(27, 128, 163, 25);
		contentPane.add(lblFullName);

		JLabel lblContact = new JLabel("Contacto");
		lblContact.setBounds(27, 168, 163, 25);
		contentPane.add(lblContact);

		JLabel lblAddress = new JLabel("Dirección");
		lblAddress.setBounds(27, 208, 163, 25);
		contentPane.add(lblAddress);

		JLabel lblTelephone = new JLabel("Teléfono");
		lblTelephone.setBounds(27, 248, 163, 25);
		contentPane.add(lblTelephone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 288, 163, 25);
		contentPane.add(lblEmail);

		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setBounds(208, 88, 135, 25);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtFullName = new JTextField();
		txtFullName.setBounds(208, 128, 264, 25);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);

		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSupplier();
			}
		});
		btnUpdate.setBounds(177, 342, 117, 25);
		contentPane.add(btnUpdate);

		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(208, 168, 264, 25);
		contentPane.add(txtContact);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(208, 208, 264, 25);
		contentPane.add(txtAddress);

		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(208, 248, 264, 25);
		contentPane.add(txtTelephone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(208, 288, 264, 25);
		contentPane.add(txtEmail);
		setLocationRelativeTo(null);
		getSupplier();
	}

	public static String CODE_SUPPLIER;

	void getSupplier() {
		String code = CODE_SUPPLIER;
		Supplier s = new SupplierManagement().search(code);

		if (s == null) {
			JOptionPane.showMessageDialog(this, "Código no existe");
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

		Supplier s = new Supplier();

		s.setId_supplier(CODE_SUPPLIER);
		s.setName_supplier(fullName);
		s.setContact_supplier(contact);
		s.setDirection_supplier(address);
		s.setPhone_supplier(telephone);
		s.setEmail_supplier(email);

		int ok = new SupplierManagement().edit(s);

		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Algo salió mal");
		} else {
			SupplierView.SUPPLIER_UPDATE_WINDOW = true;
			JOptionPane.showMessageDialog(this, "Update OK");
			dispose();
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
