package views;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MedicamentoProveedor {

	private JFrame frmMedicamentoProveedor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicamentoProveedor window = new MedicamentoProveedor();
					window.frmMedicamentoProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MedicamentoProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedicamentoProveedor = new JFrame();
		frmMedicamentoProveedor.setTitle("Medicamento Proveedor");
		frmMedicamentoProveedor.setBounds(100, 100, 450, 216);
		frmMedicamentoProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedicamentoProveedor.getContentPane().setLayout(null);

		JLabel lblIdMedicoDe = new JLabel("Id medico de proveedor");
		lblIdMedicoDe.setBounds(10, 11, 151, 14);
		frmMedicamentoProveedor.getContentPane().add(lblIdMedicoDe);

		JLabel lblCantidadDeMedicamento = new JLabel("Cantidad de medicamento");
		lblCantidadDeMedicamento.setBounds(10, 36, 151, 14);
		frmMedicamentoProveedor.getContentPane().add(lblCantidadDeMedicamento);

		JLabel lblLoteMedicamento = new JLabel("Lote medicamento");
		lblLoteMedicamento.setBounds(10, 61, 151, 14);
		frmMedicamentoProveedor.getContentPane().add(lblLoteMedicamento);

		JLabel lblFechaVencimiento = new JLabel("Fecha vencimiento");
		lblFechaVencimiento.setBounds(10, 86, 151, 14);
		frmMedicamentoProveedor.getContentPane().add(lblFechaVencimiento);

		JLabel lblIdMedicamento = new JLabel("Id medicamento");
		lblIdMedicamento.setBounds(10, 111, 151, 14);
		frmMedicamentoProveedor.getContentPane().add(lblIdMedicamento);

		JLabel lblIdProveedor = new JLabel("Id proveedor");
		lblIdProveedor.setBounds(10, 136, 151, 14);
		frmMedicamentoProveedor.getContentPane().add(lblIdProveedor);

		textField = new JTextField();
		textField.setBounds(171, 8, 154, 20);
		frmMedicamentoProveedor.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(171, 33, 154, 20);
		frmMedicamentoProveedor.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(171, 58, 154, 20);
		frmMedicamentoProveedor.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(171, 83, 154, 20);
		frmMedicamentoProveedor.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, 7, 89, 23);
		frmMedicamentoProveedor.getContentPane().add(btnBuscar);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 108, 154, 20);
		frmMedicamentoProveedor.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(171, 133, 154, 20);
		frmMedicamentoProveedor.getContentPane().add(comboBox_1);
	}

}
