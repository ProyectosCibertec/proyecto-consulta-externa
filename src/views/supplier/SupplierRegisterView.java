package views.supplier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commons.CMessage;
import maintenance.SupplierManagement;
import models.Supplier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierRegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtContact;
	private JTextField txtTelephone;
	private JTextField txtEmail;
	private JButton btnRegistar;
	private JButton btnCancelar;
	private JTextField txtFullName;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierRegisterView frame = new SupplierRegisterView();
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
	public SupplierRegisterView() {
		setTitle("Proveedor - Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(30, 20, 70, 15);
		contentPane.add(lblCodigo);

		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setText("       ");
		txtCode.setBounds(30, 40, 120, 20);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre y apellidos");
		lblNewLabel.setBounds(30, 70, 150, 15);
		contentPane.add(lblNewLabel);

		txtFullName = new JTextField();
		txtFullName.setBounds(30, 90, 250, 20);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);

		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(30, 120, 150, 15);
		contentPane.add(lblContacto);

		txtContact = new JTextField();
		txtContact.setBounds(30, 140, 250, 20);
		contentPane.add(txtContact);
		txtContact.setColumns(10);

		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(30, 170, 150, 15);
		contentPane.add(lblDireccin);

		txtAddress = new JTextField();
		txtAddress.setBounds(30, 190, 250, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(30, 220, 150, 15);
		contentPane.add(lblTelfono);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(30, 240, 250, 19);
		contentPane.add(txtTelephone);
		txtTelephone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 270, 150, 15);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(30, 290, 250, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegistar.setBounds(25, 340, 117, 25);
		contentPane.add(btnRegistar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierView sv = new SupplierView();
				sv.showList();
				dispose();
			}
		});
		btnCancelar.setBounds(169, 340, 117, 25);
		contentPane.add(btnCancelar);

		setLocationRelativeTo(null);
		getNewCode();
	}

	Supplier s = new Supplier();
	CMessage message = new CMessage();

	void getNewCode() {
		s = new SupplierManagement().supplierCodeGenerate();
		txtCode.setText(s.getId_supplier());
	}

	void register() {
		String code, name, contact, address, telephone, email;

		code = s.getId_supplier();
		name = readFullName();
		contact = readContact();
		address = readAddres();
		telephone = readTelephone();
		email = readEmail();

		s.setId_supplier(code);
		s.setName_supplier(name);
		s.setContact_supplier(contact);
		s.setDirection_supplier(address);
		s.setPhone_supplier(telephone);
		s.setEmail_supplier(email);

		int ok = new SupplierManagement().register(s);

		if (ok == 0) {
			message.message(this, "No se puedo registrar");
		} else {
			message.message(this, "Se registró correctamente", "Success");
			dispose();
		}
	}

	String readFullName() {
		return txtFullName.getText().length() == 0 ? null : txtFullName.getText();
	}

	String readContact() {
		return txtContact.getText().length() == 0 ? null : txtContact.getText();
	}

	String readAddres() {
		return txtAddress.getText().length() == 0 ? null : txtAddress.getText();
	}

	String readTelephone() {
		return txtTelephone.getText().length() == 0 ? null : txtTelephone.getText();
	}

	String readEmail() {
		return txtEmail.getText().length() == 0 ? null : txtEmail.getText();
	}
}
