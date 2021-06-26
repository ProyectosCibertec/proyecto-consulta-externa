package views.patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import commons.ArrayList;
import commons.CMessage;
import commons.Regex;
import maintenance.SupplierManagement;
import models.Supplier;
import views.supplier.SupplierView;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class PatientRegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtTelephone;
	private JTextField txtHeight;
	private JButton btnRegistar;
	private JButton btnCancelar;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRegisterView frame = new PatientRegisterView();
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
	public PatientRegisterView() {
		setTitle("Paciente - Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 627);
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

		JLabel lblName = new JLabel("Nombre y apellidos");
		lblName.setBounds(30, 70, 150, 15);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(30, 90, 250, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblBirthDate = new JLabel("Contacto");
		lblBirthDate.setBounds(30, 170, 150, 15);
		contentPane.add(lblBirthDate);

		JLabel lblDireccin = new JLabel("Género");
		lblDireccin.setBounds(30, 220, 150, 15);
		contentPane.add(lblDireccin);

		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(30, 270, 150, 15);
		contentPane.add(lblTelfono);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(30, 290, 250, 19);
		contentPane.add(txtTelephone);
		txtTelephone.setColumns(10);

		JLabel lblHeight = new JLabel("Estatura");
		lblHeight.setBounds(30, 320, 150, 15);
		contentPane.add(lblHeight);

		txtHeight = new JTextField();
		txtHeight.setBounds(30, 340, 250, 20);
		contentPane.add(txtHeight);
		txtHeight.setColumns(10);

		btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegistar.setBounds(30, 529, 117, 25);
		contentPane.add(btnRegistar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierView sv = new SupplierView();
//				sv.showList();
				dispose();
			}
		});
		btnCancelar.setBounds(174, 529, 117, 25);
		contentPane.add(btnCancelar);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(30, 140, 250, 20);
		contentPane.add(txtLastName);

		JLabel lblLastName = new JLabel("Nombre y apellidos");
		lblLastName.setBounds(30, 120, 150, 15);
		contentPane.add(lblLastName);

		txtBirthDate = new JDateChooser();
		txtBirthDate.setBounds(30, 190, 250, 19);
		contentPane.add(txtBirthDate);

		comboBox = new JComboBox();
		comboBox.setBounds(30, 240, 250, 20);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 390, 250, 20);
		contentPane.add(textField);

		JLabel lblWeight = new JLabel("Peso");
		lblWeight.setBounds(30, 370, 150, 15);
		contentPane.add(lblWeight);

		cboGender = new JComboBox();
		cboGender.setBounds(30, 440, 250, 20);
		contentPane.add(cboGender);

		JLabel lblGender = new JLabel("Género");
		lblGender.setBounds(30, 420, 150, 15);
		contentPane.add(lblGender);

		setLocationRelativeTo(null);
		getNewCode();
	}

	Supplier s = new Supplier();
	CMessage message = new CMessage();
	Regex regex = new Regex();
	ArrayList yarnA = new ArrayList(this);
	private JTextField txtLastName;
	private JTextField textField;
	private JComboBox cboGender;
	private JComboBox comboBox;
	private JDateChooser txtBirthDate;

	void getNewCode() {
		s = new SupplierManagement().supplierCodeGenerate();
		txtCode.setText(s.getId_supplier());
	}

	void register() {
		String code, name, contact, address, telephone, email;

		code = s.getId_supplier();
		name = readName();
		contact = readLastName();
//		address = readAddres();
//		telephone = readTelephone();
		email = readEmail();

//		String[][] string = { { name, "nombre" }, { contact, "contacto" }, { address, "Dirección" },
//				{ telephone, "Teléfono" }, { email, "email" } };
//
//		if (!yarnA.validateInputs(string)) {
//			if (regex.regexMatch(name)) {
//				if (regex.regexMatch(contact)) {
//					if (regex.regexMatch(telephone, "phone")) {
//						if (regex.regexMatch(email, "email")) {
//
//							s.setId_supplier(code);
//							s.setName_supplier(name);
//							s.setContact_supplier(contact);
//							s.setDirection_supplier(address);
//							s.setPhone_supplier(telephone);
//							s.setEmail_supplier(email);
//
//							int ok = new SupplierManagement().register(s);
//
//							if (ok == 0) {
//								message.message(this, "No se puedo registrar");
//							} else {
//								message.message(this, "Se registró correctamente", "Success");
//								dispose();
//							}
//						} else {
//							message.message(this, "Debe agregar correctamente el email demo@demo.com");
//						}
//					} else {
//						message.message(this, "Debe agregar correctamente el teléfono \n 999999999");
//					}
//				} else {
//					message.message(this, "Debe agregar correctamente el nombre del contacto");
//				}
//			} else {
//				message.message(this, "Debe agregar correctamente el nombre del personal");
//			}
//		}
	}

	String readName() {
		return txtName.getText().length() == 0 ? null : txtName.getText();
	}

	String readLastName() {
		return txtLastName.getText().length() == 0 ? null : txtLastName.getText();
	}

//	String readAddres() {
//		return txtAddress.getText().length() == 0 ? null : txtAddress.getText();
//	}

	String readBirthDate() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return txtBirthDate.getDate() == null ? null : sdf.format(txtBirthDate.getDate());
	}

	String readEmail() {
		return txtHeight.getText().length() == 0 ? null : txtHeight.getText();
	}
}
