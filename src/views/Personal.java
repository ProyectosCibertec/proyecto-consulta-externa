package views;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Personal extends JFrame implements ActionListener {

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
	private JComboBox cbpSpeciality;
	private JComboBox cboState;
	private JLabel lblInformacinAdicional;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable dataTable;
	DefaultTableModel dmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal frame = new Personal();
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
	public Personal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 538);
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
		lblEspecialidad.setBounds(32, 231, 114, 15);
		contentPane.add(lblEspecialidad);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(368, 231, 70, 15);
		contentPane.add(lblEstado);
		
		cbpSpeciality = new JComboBox();
		cbpSpeciality.setBounds(136, 228, 114, 20);
		contentPane.add(cbpSpeciality);
		
		cboState = new JComboBox();
		cboState.setBounds(441, 228, 114, 20);
		contentPane.add(cboState);
		
		lblInformacinAdicional = new JLabel("Información Adicional");
		lblInformacinAdicional.setFont(new Font("C059", Font.BOLD, 20));
		lblInformacinAdicional.setBounds(32, 193, 330, 26);
		contentPane.add(lblInformacinAdicional);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(32, 258, 117, 25);
		contentPane.add(btnAgregar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(164, 258, 117, 25);
		contentPane.add(btnBuscar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(302, 258, 117, 25);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(438, 258, 117, 25);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 290, 538, 199);
		contentPane.add(scrollPane);
		
		Object title[] = {"Código", "Nombres", "Teléfono", "Dirección", "Email", "T. de Emergencia", "F. de Nacimiento", "Especialidad", "Estado"};
		dmt = new DefaultTableModel();
		dmt.setColumnIdentifiers(title);
		dataTable = new JTable(dmt);
		dataTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(dataTable);
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
		
	}
	
	public void addPersonal() {
		
	}
	
	public void deletePersonal() {
		
	}
	
	public void updatePersonal() {
		
	}
	
	public void searchPersonal() {
		
	}
	
	public String getCode() {
		try {
			return String.valueOf(txtCode);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getName() {
		try {
			return String.valueOf(txtNames);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getPhone() {
		try {
			return String.valueOf(txtPhone);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getDirection() {
		try {
			return String.valueOf(txtDirection);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getEmail() {
		try {
			return String.valueOf(txtEmail);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getKey() {
		try {
			return String.valueOf(txtKey);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getEmergencyPhone() {
		try {
			return String.valueOf(txtEmergencyPhone);
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
	}
	
	public String getBirthday() {
		try {
			return new SimpleDateFormat("").format(dateBithday.getDate());
		} catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
		return null;
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
}
