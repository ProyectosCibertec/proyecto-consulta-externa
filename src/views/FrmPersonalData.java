package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.Font;

public class FrmPersonalData extends JFrame {

	private JPanel contentPane;
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblTelefono;
	private JLabel lblDireccin;
	private JLabel lblEmail;
	private JLabel lblTelfonoDeEmergencia;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblClaveDePersonal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JDateChooser dateBithday;
	private JTextField textField_6;
	private JLabel lblEspecialidad;
	private JLabel lblEstado;
	private JComboBox cboSpeciality;
	private JComboBox cboState;
	private JLabel lblInformacinAdicional;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(12, 2, 91, 15);
		contentPane.add(lblCdigo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(272, 2, 70, 15);
		contentPane.add(lblNombres);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 29, 70, 15);
		contentPane.add(lblTelefono);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(272, 29, 70, 15);
		contentPane.add(lblDireccin);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 56, 70, 15);
		contentPane.add(lblEmail);
		
		lblTelfonoDeEmergencia = new JLabel("Teléfono de Emergencia");
		lblTelfonoDeEmergencia.setBounds(12, 83, 185, 15);
		contentPane.add(lblTelfonoDeEmergencia);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(12, 110, 174, 15);
		contentPane.add(lblFechaDeNacimiento);
		
		lblClaveDePersonal = new JLabel("Clave de Personal");
		lblClaveDePersonal.setBounds(272, 54, 174, 15);
		contentPane.add(lblClaveDePersonal);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 0, 114, 19);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(421, 0, 114, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 27, 114, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(421, 27, 114, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 54, 114, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(227, 81, 308, 19);
		contentPane.add(textField_5);
		
		dateBithday = new JDateChooser();
		dateBithday.setBounds(227, 106, 308, 19);
		contentPane.add(dateBithday);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(421, 52, 114, 19);
		contentPane.add(textField_6);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(12, 188, 114, 15);
		contentPane.add(lblEspecialidad);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(348, 188, 70, 15);
		contentPane.add(lblEstado);
		
		cboSpeciality = new JComboBox();
		cboSpeciality.setBounds(116, 185, 114, 20);
		contentPane.add(cboSpeciality);
		
		cboState = new JComboBox();
		cboState.setBounds(421, 185, 114, 20);
		contentPane.add(cboState);
		
		lblInformacinAdicional = new JLabel("Información Adicional");
		lblInformacinAdicional.setFont(new Font("C059", Font.BOLD, 20));
		lblInformacinAdicional.setBounds(12, 150, 330, 26);
		contentPane.add(lblInformacinAdicional);
	}
}
