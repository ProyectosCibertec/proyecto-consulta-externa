package views;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import maintenance.PersonalManagement;
import maintenance.PersonalStateManagement;
import maintenance.SpecialityManagement;
import models.Personal;
import models.PersonalState;
import models.Speciality;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class FrmPersonalData extends JFrame implements MouseListener, WindowListener, ActionListener, PopupMenuListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoPersonal;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblCdigo;
	private JTextField txtCode;
	private JLabel lblNombres;
	private JTextField txtNames;
	private JLabel lblTelefono;
	private JTextField txtPhone;
	private JLabel lblDireccin;
	private JTextField txtDirection;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblClaveDePersonal;
	private JTextField txtKey;
	private JLabel lblTDeEmergencia;
	private JTextField txtEmergencyPhone;
	private JLabel lblFDeNacimiento;
	private JDateChooser dateBithday;
	private JLabel lblInformacinAdicional;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JComboBox cboSpeciality;
	private JLabel lblEspecialidad;
	private JLabel lblAgregar;
	private JLabel lblEstado;
	private JComboBox cboState;
	private JLabel lblAgregar_1;
	private JPanel panel_8;
	private JButton btnAgregar;
	private JButton btnActualizar;
	public static String codeOfPersonal;
	public static boolean isForAdd = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPersonalData frame = new FrmPersonalData();
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
	public FrmPersonalData() {
		addWindowListener(this);
		setTitle("Mantenimiento Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 400, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 100, 0, 50, 26, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblMantenimientoPersonal = new JLabel("Mantenimiento Personal");
		lblMantenimientoPersonal.setFont(new Font("C059", Font.BOLD, 25));
		GridBagConstraints gbc_lblMantenimientoPersonal = new GridBagConstraints();
		gbc_lblMantenimientoPersonal.insets = new Insets(0, 0, 5, 0);
		gbc_lblMantenimientoPersonal.gridx = 0;
		gbc_lblMantenimientoPersonal.gridy = 0;
		contentPane.add(lblMantenimientoPersonal, gbc_lblMantenimientoPersonal);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 30, 30));

		panel_2 = new JPanel();
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblCdigo = new JLabel("Código");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.anchor = GridBagConstraints.WEST;
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panel_2.add(lblCdigo, gbc_lblCdigo);

		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setColumns(10);
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.gridx = 1;
		gbc_txtCode.gridy = 0;
		panel_2.add(txtCode, gbc_txtCode);

		lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 1;
		panel_2.add(lblTelefono, gbc_lblTelefono);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 1;
		panel_2.add(txtPhone, gbc_txtPhone);

		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panel_2.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 2;
		panel_2.add(txtEmail, gbc_txtEmail);

		lblTDeEmergencia = new JLabel("T. de Emergencia");
		GridBagConstraints gbc_lblTDeEmergencia = new GridBagConstraints();
		gbc_lblTDeEmergencia.anchor = GridBagConstraints.EAST;
		gbc_lblTDeEmergencia.insets = new Insets(0, 0, 0, 5);
		gbc_lblTDeEmergencia.gridx = 0;
		gbc_lblTDeEmergencia.gridy = 3;
		panel_2.add(lblTDeEmergencia, gbc_lblTDeEmergencia);

		txtEmergencyPhone = new JTextField();
		txtEmergencyPhone.setColumns(10);
		GridBagConstraints gbc_txtEmergencyPhone = new GridBagConstraints();
		gbc_txtEmergencyPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmergencyPhone.gridx = 1;
		gbc_txtEmergencyPhone.gridy = 3;
		panel_2.add(txtEmergencyPhone, gbc_txtEmergencyPhone);

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 31, 30, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNombres = new JLabel("Nombres");
		GridBagConstraints gbc_lblNombres = new GridBagConstraints();
		gbc_lblNombres.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombres.anchor = GridBagConstraints.WEST;
		gbc_lblNombres.gridx = 0;
		gbc_lblNombres.gridy = 0;
		panel_3.add(lblNombres, gbc_lblNombres);

		txtNames = new JTextField();
		txtNames.setColumns(10);
		GridBagConstraints gbc_txtNames = new GridBagConstraints();
		gbc_txtNames.insets = new Insets(0, 0, 5, 0);
		gbc_txtNames.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNames.gridx = 1;
		gbc_txtNames.gridy = 0;
		panel_3.add(txtNames, gbc_txtNames);

		lblDireccin = new JLabel("Dirección");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.WEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 1;
		panel_3.add(lblDireccin, gbc_lblDireccin);

		txtDirection = new JTextField();
		txtDirection.setColumns(10);
		GridBagConstraints gbc_txtDirection = new GridBagConstraints();
		gbc_txtDirection.insets = new Insets(0, 0, 5, 0);
		gbc_txtDirection.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDirection.gridx = 1;
		gbc_txtDirection.gridy = 1;
		panel_3.add(txtDirection, gbc_txtDirection);

		lblClaveDePersonal = new JLabel("ID de personal");
		GridBagConstraints gbc_lblClaveDePersonal = new GridBagConstraints();
		gbc_lblClaveDePersonal.anchor = GridBagConstraints.WEST;
		gbc_lblClaveDePersonal.insets = new Insets(0, 0, 5, 5);
		gbc_lblClaveDePersonal.gridx = 0;
		gbc_lblClaveDePersonal.gridy = 2;
		panel_3.add(lblClaveDePersonal, gbc_lblClaveDePersonal);

		txtKey = new JTextField();
		txtKey.setColumns(10);
		GridBagConstraints gbc_txtKey = new GridBagConstraints();
		gbc_txtKey.insets = new Insets(0, 0, 5, 0);
		gbc_txtKey.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKey.gridx = 1;
		gbc_txtKey.gridy = 2;
		panel_3.add(txtKey, gbc_txtKey);

		lblFDeNacimiento = new JLabel("F. de Nacimiento");
		GridBagConstraints gbc_lblFDeNacimiento = new GridBagConstraints();
		gbc_lblFDeNacimiento.anchor = GridBagConstraints.NORTH;
		gbc_lblFDeNacimiento.insets = new Insets(0, 0, 0, 5);
		gbc_lblFDeNacimiento.gridx = 0;
		gbc_lblFDeNacimiento.gridy = 3;
		panel_3.add(lblFDeNacimiento, gbc_lblFDeNacimiento);

		dateBithday = new JDateChooser();
		GridBagConstraints gbc_dateBithday = new GridBagConstraints();
		gbc_dateBithday.anchor = GridBagConstraints.NORTH;
		gbc_dateBithday.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateBithday.gridx = 1;
		gbc_dateBithday.gridy = 3;
		panel_3.add(dateBithday, gbc_dateBithday);

		lblInformacinAdicional = new JLabel("Información Adicional");
		lblInformacinAdicional.setFont(new Font("C059", Font.BOLD, 20));
		GridBagConstraints gbc_lblInformacinAdicional = new GridBagConstraints();
		gbc_lblInformacinAdicional.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformacinAdicional.gridx = 0;
		gbc_lblInformacinAdicional.gridy = 2;
		contentPane.add(lblInformacinAdicional, gbc_lblInformacinAdicional);

		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		contentPane.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 482, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 30, 0));

		panel_6 = new JPanel();
		panel_5.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_6.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_6.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_6.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_6.setLayout(gbl_panel_6);

		lblAgregar = new JLabel("Agregar");
		lblAgregar.addMouseListener(this);
		GridBagConstraints gbc_lblAgregar = new GridBagConstraints();
		gbc_lblAgregar.anchor = GridBagConstraints.WEST;
		gbc_lblAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_lblAgregar.gridx = 1;
		gbc_lblAgregar.gridy = 0;
		panel_6.add(lblAgregar, gbc_lblAgregar);

		lblEspecialidad = new JLabel("Especialidad");
		GridBagConstraints gbc_lblEspecialidad = new GridBagConstraints();
		gbc_lblEspecialidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblEspecialidad.anchor = GridBagConstraints.EAST;
		gbc_lblEspecialidad.gridx = 0;
		gbc_lblEspecialidad.gridy = 1;
		panel_6.add(lblEspecialidad, gbc_lblEspecialidad);

		cboSpeciality = new JComboBox();
		cboSpeciality.addPopupMenuListener(this);
		cboSpeciality.addMouseListener(this);
		GridBagConstraints gbc_cboSpeciality = new GridBagConstraints();
		gbc_cboSpeciality.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboSpeciality.gridx = 1;
		gbc_cboSpeciality.gridy = 1;
		panel_6.add(cboSpeciality, gbc_cboSpeciality);

		panel_7 = new JPanel();
		panel_7.addMouseListener(this);
		panel_5.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_7.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		lblAgregar_1 = new JLabel("Agregar");
		lblAgregar_1.addMouseListener(this);
		GridBagConstraints gbc_lblAgregar_1 = new GridBagConstraints();
		gbc_lblAgregar_1.anchor = GridBagConstraints.WEST;
		gbc_lblAgregar_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAgregar_1.gridx = 1;
		gbc_lblAgregar_1.gridy = 0;
		panel_7.add(lblAgregar_1, gbc_lblAgregar_1);

		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 1;
		panel_7.add(lblEstado, gbc_lblEstado);

		cboState = new JComboBox();
		cboState.addPopupMenuListener(this);
		cboState.addMouseListener(this);
		GridBagConstraints gbc_cboState = new GridBagConstraints();
		gbc_cboState.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboState.gridx = 1;
		gbc_cboState.gridy = 1;
		panel_7.add(cboState, gbc_cboState);

		panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 4;
		contentPane.add(panel_8, gbc_panel_8);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(this);
		panel_8.add(btnAgregar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(this);
		panel_8.add(btnActualizar);
	}

	/*----- Methods -----*/

	public void listSpeciality() {
		cboSpeciality.removeAllItems();
		SpecialityManagement specialityM = new SpecialityManagement();
		for (Speciality speciality : specialityM.listSpeciality()) {
			cboSpeciality.addItem(speciality.getSpecialityDescription().toString());
		}
	}

	public void listPersonalState() {
		cboState.removeAllItems();
		PersonalStateManagement personalStateM = new PersonalStateManagement();
		for (PersonalState personalState : personalStateM.listPersonalState()) {
			cboState.addItem(personalState.getPersonalStateDescription().toString());
		}
	}

	public String getCodeOfPersonal() throws Exception {
		String result = null;
		if (txtCode.getText().length() != 0 && txtCode.getText().matches("P[0-9]{4}")) {
			try {
				result = txtCode.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir un código válido en el formato: P0001.");
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
		if (txtEmail.getText().length() != 0 && txtEmail.getText().matches("P[0-9]{4}@consultaexterna.com")) {
			try {
				result = txtEmail.getText();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Debe introducir un email válido en el formato: P0001@consultaexterna.com.");
			throw new Exception();
		}

		return result;
	}

	public String getKeyOfPersonal() throws Exception {
		String result = null;

		try {
			result = txtKey.getText();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
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
		if (Integer.parseInt(new SimpleDateFormat("yyyy").format(dateBithday.getDate())) <= Integer
				.parseInt(new SimpleDateFormat("yyyy").format(new Date()))) {
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

	public int addPersonal() {
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
			if (personalManagement.addPersonal(personal) >= 1) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
		}

		return 0;
	}

	public void deletePersonal() {
		PersonalManagement personalManagement = new PersonalManagement();
		try {
			personalManagement.deletePersonal(getCodeOfPersonal());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
		}
	}

	public int updatePersonal() {
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
			if (personalManagement.updatePersonal(personal) >= 1) {
				return 1;
			}
		} catch (Exception e) {

		}

		return 0;
	}

	/*----- Events -----*/

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cboSpeciality) {
			mouseClickedCboSpeciality(e);
		}
		if (e.getSource() == cboState) {
			mouseClickedCboState(e);
		}
		if (e.getSource() == lblAgregar_1) {
			mouseClickedLblAgregar_1(e);
		}
		if (e.getSource() == lblAgregar) {
			mouseClickedLblAgregar(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == panel_7) {
			mouseEnteredPanel_7(e);
		}
		lblAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	protected void mouseClickedLblAgregar(MouseEvent e) {
		FrmSpeciality speciality = new FrmSpeciality();
		speciality.setVisible(true);
	}

	protected void mouseClickedLblAgregar_1(MouseEvent e) {
		FrmPersonalState personalState = new FrmPersonalState();
		personalState.setVisible(true);
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		try {
			PersonalManagement personalManagement = new PersonalManagement();
			if(isForAdd) {
				txtCode.setText(personalManagement.getPersonalAutoGenerated());
				clearTxts();
				btnActualizar.setEnabled(false);
				btnAgregar.setEnabled(true);
			} else {
				btnActualizar.setEnabled(true);
				btnAgregar.setEnabled(false);
				Personal personal = personalManagement.getPersonal(codeOfPersonal);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				listSpeciality();
				listPersonalState();
				txtCode.setText(personal.getIdPersonal());
				txtNames.setText(personal.getPersonalName());
				txtPhone.setText(personal.getPersonalPhone());
				txtDirection.setText(personal.getPersonalDirection());
				txtEmail.setText(personal.getPersonalEmail());
				txtKey.setText(personal.getIdUsuario());
				txtEmergencyPhone.setText(personal.getEmergencyPhone());
				dateBithday.setDate(df.parse(personal.getBirthDate()));
				cboSpeciality.setSelectedIndex(Integer.parseInt(personal.getIdSpecialty()) - 1);
				cboState.setSelectedIndex(Integer.parseInt(personal.getIdPersonalState()) - 1);
			}
		} catch (Exception ex) {

		}
	}

	protected void mouseClickedCboState(MouseEvent e) {
		listPersonalState();
	}

	protected void mouseClickedCboSpeciality(MouseEvent e) {
		listSpeciality();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}

	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		if (addPersonal() == 1) {
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "No se agregó al usuario.");
		}
	}

	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		if (updatePersonal() == 1) {
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "No se actualizaron los datos.");
		}
	}

	protected void mouseEnteredPanel_7(MouseEvent e) {
		lblAgregar_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
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

	public void popupMenuCanceled(PopupMenuEvent arg0) {
	}
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
	}
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
		if (arg0.getSource() == cboState) {
			popupMenuWillBecomeVisibleCboState(arg0);
		}
		if (arg0.getSource() == cboSpeciality) {
			popupMenuWillBecomeVisibleCboSpeciality(arg0);
		}
	}
	protected void popupMenuWillBecomeVisibleCboSpeciality(PopupMenuEvent arg0) {
		listSpeciality();
	}
	protected void popupMenuWillBecomeVisibleCboState(PopupMenuEvent arg0) {
		listPersonalState();
	}
	
	public void clearTxts() {
		txtDirection.setText("");
		txtEmail.setText("");
		txtEmergencyPhone.setText("");
		txtKey.setText("");
		txtNames.setText("");
		txtPhone.setText("");
		cboSpeciality.setSelectedIndex(1);
		cboState.setSelectedIndex(1);
		dateBithday.setDate(null);
	}
}
