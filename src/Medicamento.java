import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Medicamento {

	private JFrame frmMedicamento;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicamento window = new Medicamento();
					window.frmMedicamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Medicamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicamento = new JFrame();
		frmMedicamento.setTitle("Medicamento");
		frmMedicamento.setBounds(100, 100, 450, 154);
		frmMedicamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicamento.getContentPane().setLayout(null);

		JLabel lblIdMedicamento = new JLabel("ID Medicamento");
		lblIdMedicamento.setBounds(10, 11, 129, 14);
		frmMedicamento.getContentPane().add(lblIdMedicamento);

		JLabel lblNombreMedicamento = new JLabel("Nombre medicamento");
		lblNombreMedicamento.setBounds(10, 36, 129, 14);
		frmMedicamento.getContentPane().add(lblNombreMedicamento);

		JLabel lblMarcaMedicamento = new JLabel("Marca medicamento");
		lblMarcaMedicamento.setBounds(10, 61, 129, 14);
		frmMedicamento.getContentPane().add(lblMarcaMedicamento);

		JLabel lblIdEstadoMedico = new JLabel("Id estado medico");
		lblIdEstadoMedico.setBounds(10, 86, 129, 14);
		frmMedicamento.getContentPane().add(lblIdEstadoMedico);

		textField = new JTextField();
		textField.setBounds(154, 8, 171, 20);
		frmMedicamento.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(154, 33, 171, 20);
		frmMedicamento.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(154, 58, 171, 20);
		frmMedicamento.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, 7, 89, 23);
		frmMedicamento.getContentPane().add(btnBuscar);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(154, 83, 171, 20);
		frmMedicamento.getContentPane().add(comboBox);
	}
}
