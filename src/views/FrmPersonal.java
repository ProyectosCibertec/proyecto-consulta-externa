package views;

import models.Personal;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import maintenance.PersonalManagement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmPersonal extends JFrame implements ActionListener, WindowListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoPersonal;
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblTelefono;
	private JLabel lblDireccin;
	private JLabel lblEmail;
	private JLabel lblTelfonoDeEmergencia;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblClaveDePersonal;
	private JTextField txtCode;
	private JTextField txtNames;
	private JTextField txtPhone;
	private JTextField txtDirection;
	private JTextField txtEmail;
	private JTextField txtEmergencyPhone;
	private JDateChooser dateBithday;
	private JTextField txtKey;
	private JLabel lblEspecialidad;
	private JLabel lblEstado;
	private JComboBox cboSpeciality;
	private JComboBox cboState;
	private JLabel lblInformacinAdicional;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable dataTable;
	DefaultTableModel dmt;
	private JLabel lblAgregar;
	private JLabel lblAgregar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPersonal frame = new FrmPersonal();
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
	public FrmPersonal() {
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoPersonal = new JLabel("Mantenimiento Personal");
		lblMantenimientoPersonal.setFont(new Font("C059", Font.BOLD, 25));
		lblMantenimientoPersonal.setBounds(117, 7, 367, 31);
		contentPane.add(lblMantenimientoPersonal);

		lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(32, 45, 91, 15);
		contentPane.add(lblCdigo);

		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(292, 45, 70, 15);
		contentPane.add(lblNombres);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(32, 72, 70, 15);
		contentPane.add(lblTelefono);

		lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(292, 72, 70, 15);
		contentPane.add(lblDireccin);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(32, 99, 70, 15);
		contentPane.add(lblEmail);

		lblTelfonoDeEmergencia = new JLabel("Teléfono de Emergencia");
		lblTelfonoDeEmergencia.setBounds(32, 126, 185, 15);
		contentPane.add(lblTelfonoDeEmergencia);

		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(32, 153, 174, 15);
		contentPane.add(lblFechaDeNacimiento);

		lblClaveDePersonal = new JLabel("Clave de Personal");
		lblClaveDePersonal.setBounds(292, 97, 174, 15);
		contentPane.add(lblClaveDePersonal);

		txtCode = new JTextField();
		txtCode.setBounds(136, 43, 114, 19);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtNames = new JTextField();
		txtNames.setBounds(441, 43, 114, 19);
		contentPane.add(txtNames);
		txtNames.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setBounds(136, 70, 114, 19);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		txtDirection = new JTextField();
		txtDirection.setBounds(441, 70, 114, 19);
		contentPane.add(txtDirection);
		txtDirection.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(136, 97, 114, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtEmergencyPhone = new JTextField();
		txtEmergencyPhone.setBounds(247, 124, 308, 19);
		contentPane.add(txtEmergencyPhone);
		txtEmergencyPhone.setColumns(10);

		dateBithday = new JDateChooser();
		dateBithday.setBounds(247, 149, 308, 19);
		contentPane.add(dateBithday);

		txtKey = new JTextField();
		txtKey.setBounds(441, 95, 114, 19);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(32, 245, 114, 15);
		contentPane.add(lblEspecialidad);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(368, 245, 70, 15);
		contentPane.add(lblEstado);

		cboSpeciality = new JComboBox();
		cboSpeciality.setBounds(136, 242, 114, 20);
		contentPane.add(cboSpeciality);

		cboState = new JComboBox();
		cboState.setBounds(441, 242, 114, 20);
		contentPane.add(cboState);

		lblInformacinAdicional = new JLabel("Información Adicional");
		lblInformacinAdicional.setFont(new Font("C059", Font.BOLD, 20));
		lblInformacinAdicional.setBounds(32, 193, 330, 26);
		contentPane.add(lblInformacinAdicional);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(32, 274, 117, 25);
		contentPane.add(btnAgregar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(164, 274, 117, 25);
		contentPane.add(btnBuscar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(302, 274, 117, 25);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(438, 274, 117, 25);
		contentPane.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 320, 538, 199);
		contentPane.add(scrollPane);

		Object title[] = { "Código", "Nombres", "Teléfono", "Dirección", "Email", "T. de Emergencia",
				"F. de Nacimiento", "Especialidad", "Estado" };
		dmt = new DefaultTableModel();
		dmt.setColumnIdentifiers(title);
		dataTable = new JTable(dmt);
		dataTable.addMouseListener(this);
		dataTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(dataTable);
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.addMouseListener(this);
		lblAgregar.setBounds(138, 226, 70, 15);
		contentPane.add(lblAgregar);
		
		lblAgregar_1 = new JLabel("Agregar");
		lblAgregar_1.addMouseListener(this);
		lblAgregar_1.setBounds(441, 226, 70, 15);
		contentPane.add(lblAgregar_1);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}

	public void listPersonal() {
		dmt.setRowCount(0);
		PersonalManagement personalManagement = new PersonalManagement();
		ArrayList<Personal> listPersonal = personalManagement.listPersonal();

		for (Personal personal : listPersonal) {
			dmt.addRow(new Object[] { personal.getIdPersonal(), personal.getPersonalName(), personal.getPersonalPhone(),
					personal.getPersonalDirection(), personal.getPersonalEmail(), personal.getEmergencyPhone(),
					personal.getBirthDate(), personal.getIdSpecialty(), personal.getIdPersonalState() });
		}
	}

	public void addPersonal() {
		PersonalManagement personalManagement = new PersonalManagement();
		Personal personal = new Personal();
		try {
			personal.setIdPersonal(getCodeOfPersonal());
			personal.setPersonalName(getNameOfPersonal());
			personal.setEmergencyPhone(getEmergencyPhoneOfPersonal());
			personal.setBirthDate(getBirthday());
			personal.setIdPersonalState(getStateOfPersonal());
			personal.setPersonalDirection(getDirectionOfPersonal());
			personal.setIdUsuario(getKeyOfPersonal());
			personal.setPersonalEmail(getEmailOfPersonal());
			personal.setPersonalPhone(getPhoneOfPersonal());
			personal.setIdSpecialty(getSpecialityOfPersonal());
			personalManagement.addPersonal(personal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		listPersonal();
	}

	public void deletePersonal() {
		PersonalManagement personalManagement = new PersonalManagement();
		try {
			personalManagement.deletePersonal(getCodeOfPersonal());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
		}
		listPersonal();
	}

	public void updatePersonal() {
		PersonalManagement personalManagement = new PersonalManagement();
		Personal personal = new Personal();
		try {
			personal.setIdPersonal(getCodeOfPersonal());
			personal.setPersonalName(getNameOfPersonal());
			personal.setEmergencyPhone(getEmergencyPhoneOfPersonal());
			personal.setBirthDate(getBirthday());
			personal.setIdPersonalState(getStateOfPersonal());
			personal.setPersonalDirection(getDirectionOfPersonal());
			personal.setIdUsuario(getKeyOfPersonal());
			personal.setPersonalEmail(getEmailOfPersonal());
			personal.setPersonalPhone(getPhoneOfPersonal());
			personal.setIdSpecialty(getSpecialityOfPersonal());
			personalManagement.updatePersonal(personal);
		} catch (Exception e) {

		}
		listPersonal();
	}

	public void searchPersonal() {
		PersonalManagement personalManagement = new PersonalManagement();
		try {
			personalManagement.getPersonal(getCodeOfPersonal());			
		} catch(Exception e) {
			
		}
		listPersonal();
	}

	public String getCodeOfPersonal() throws Exception {
		String result = null;
		if (txtCode.getText().length() != 0 && txtCode.getText().matches("P[0-9]{5}")) {
			try {
				result = txtCode.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir un código válido en el formato: PE001.");
			throw new Exception();
		}

		return result;
	}

	public String getNameOfPersonal() throws Exception {
		String result = null;
		if (txtNames.getText().length() != 0) {
			try {
				result = txtNames.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir un nombre válido.");
			throw new Exception();
		}

		return result;
	}

	public String getPhoneOfPersonal() throws Exception {
		String result = null;
		if (txtPhone.getText().length() != 0 && txtPhone.getText().matches("[0-9]{9}")) {
			try {
				result = txtPhone.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir un teléfono válido, en formato: 999999999.");
			throw new Exception();
		}

		return result;
	}

	public String getDirectionOfPersonal() throws Exception {
		String result = null;
		if (txtDirection.getText().length() != 0) {
			try {
				result = txtDirection.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir una dirección válida.");
			throw new Exception();
		}

		return result;
	}

	public String getEmailOfPersonal() throws Exception {
		String result = null;
		if (txtEmail.getText().length() != 0 && txtEmail.getText().matches("P[0-9]{5}@consultaexterna.com")) {
			try {
				result = txtEmail.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Debe introducir un email válido en el formato: PE00001@consultaexterna.com.");
			throw new Exception();
		}

		return result;
	}

	public String getKeyOfPersonal() throws Exception {
		String result = null;
		if (txtKey.getText().length() != 0) {
			try {
				result = txtKey.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir una clave válida.");
			throw new Exception();
		}

		return result;
	}

	public String getEmergencyPhoneOfPersonal() throws Exception {
		String result = null;
		if (txtEmergencyPhone.getText().length() != 0 && txtPhone.getText().matches("[0-9]{9}")) {
			try {
				result = txtEmergencyPhone.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Debe introducir un teléfono de emergencia válido, en formato: 999999999.");
			throw new Exception();
		}

		return result;
	}

	public String getBirthday() throws Exception {
		String result = null;
		if (Integer.parseInt(new SimpleDateFormat("yyyy-MM-dd").format(dateBithday.getDate())) < Integer
				.parseInt(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))) {
			try {
				result = new SimpleDateFormat("yyyy-MM-dd").format(dateBithday.getDate());
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser mayor a la fecha actual.");
			throw new Exception();
		}

		return result;
	}

	public String getStateOfPersonal() throws Exception {
		String result = null;

		if (cboState.getSelectedItem() != null) {
			try {
				result = cboState.getSelectedItem().toString();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un estado.");
			throw new Exception();
		}

		return result;
	}

	public String getSpecialityOfPersonal() throws Exception {
		String result = null;

		if (cboSpeciality.getSelectedItem() != null) {
			try {
				result = cboSpeciality.getSelectedItem().toString();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una especialidad.");
			throw new Exception();
		}

		return result;
	}

	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		addPersonal();
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		searchPersonal();
	}

	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		updatePersonal();
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		deletePersonal();
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		listPersonal();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblAgregar_1) {
			mouseClickedLblAgregar_1(e);
		}
		if (e.getSource() == lblAgregar) {
			mouseClickedLblAgregar(e);
		}
		if (e.getSource() == dataTable) {
			mouseClickedDataTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedDataTable(MouseEvent e) {
		int row = dataTable.getSelectedRow();
		try {
			Personal personal = new Personal(
					dmt.getValueAt(row, 0).toString(),
					dmt.getValueAt(row, 1).toString(),
					dmt.getValueAt(row, 2).toString(),
					dmt.getValueAt(row, 3).toString(),
					dmt.getValueAt(row, 4).toString(),
					dmt.getValueAt(row, 5).toString(),
					dmt.getValueAt(row, 6).toString(),
					dmt.getValueAt(row, 7).toString(),
					dmt.getValueAt(row, 8).toString(),
					dmt.getValueAt(row, 9).toString()
					);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			txtCode.setText(personal.getIdPersonal());
			txtNames.setText(personal.getPersonalName());
			txtPhone.setText(personal.getPersonalPhone());
			txtDirection.setText(personal.getPersonalDirection());
			txtEmail.setText(personal.getPersonalEmail());
			txtKey.setText(personal.getIdUsuario());
			txtEmergencyPhone.setText(personal.getEmergencyPhone());
			dateBithday.setDate(df.parse(personal.getBirthDate()));
			cboSpeciality.setSelectedItem(personal.getIdPersonal());
			cboState.setSelectedItem(personal.getIdPersonal());
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + ex.getMessage());
		}
	}
	protected void mouseClickedLblAgregar(MouseEvent e) {
	}
	protected void mouseClickedLblAgregar_1(MouseEvent e) {
	}
}
