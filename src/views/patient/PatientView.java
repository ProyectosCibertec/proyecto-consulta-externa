package views.patient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import commons.CMessage;
import maintenance.SupplierManagement;
import maintenance.patient.PatientManagement;
import models.Supplier;
import models.patient.Patient;
import models.patient.PatienteType;
import views.supplier.SupplierUpdateView;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class PatientView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtFullName;
	private JTable tblResult;
	private JDateChooser txtStartDate;
	private JDateChooser txtEndDate;
	private JButton btnNuevoPaciente;
	private JButton btnConsultar;

	DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientView frame = new PatientView();
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
	public PatientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(30, 20, 70, 20);
		contentPane.add(lblCdigo);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(120, 20, 150, 20);
		contentPane.add(lblNombreYApellido);

		JLabel lblFecha = new JLabel("Fecha inicio");
		lblFecha.setBounds(400, 20, 100, 15);
		contentPane.add(lblFecha);

		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(400, 50, 100, 20);
		contentPane.add(lblFechaFin);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consult();
			}
		});
		btnConsultar.setBounds(683, 32, 117, 25);
		contentPane.add(btnConsultar);

		btnNuevoPaciente = new JButton("Nuevo paciente");
		btnNuevoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoPaciente.setBounds(324, 389, 171, 25);
		contentPane.add(btnNuevoPaciente);

		txtCode = new JTextField();
		txtCode.setBounds(30, 50, 70, 20);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtFullName = new JTextField();
		txtFullName.setBounds(120, 50, 250, 20);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);
		txtFullName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listByName();
			}
		});

		txtStartDate = new JDateChooser();
		txtStartDate.setDateFormatString("dd/MM/yyyy");
		txtStartDate.setBounds(520, 20, 120, 20);
		contentPane.add(txtStartDate);

		txtEndDate = new JDateChooser();
		txtEndDate.setDateFormatString("dd/MM/yyyy");
		txtEndDate.setBounds(520, 50, 120, 20);
		contentPane.add(txtEndDate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 87, 803, 291);
		contentPane.add(scrollPane);

		tblResult = new JTable();
		scrollPane.setViewportView(tblResult);

		tblResult.setModel(tableModel);
		tableModel.addColumn("Código paciente");
		tableModel.addColumn("Nombres y apelidos");
		tableModel.addColumn("Dirección");
		tableModel.addColumn("Fecha Nacimiento");
		tableModel.addColumn("Fecha de muerte");
		tableModel.addColumn("Teléfono");
		tableModel.addColumn("Género");
		tableModel.addColumn("Estatura");
		tableModel.addColumn("Peso");
		tableModel.addColumn("Distrito");
		tableModel.addColumn("Fecha de registro");
		tableModel.addColumn("Editar");
		tblResult.getTableHeader().setBackground(new Color(32, 136, 203));
		tblResult.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				int column = target.getSelectedColumn();

				if (column == 6) {
					String code = (String) tableModel.getValueAt(row, 0);
//					SupplierUpdateView.CODE_SUPPLIER = code;
					SupplierUpdateView sup = new SupplierUpdateView();

					sup.setVisible(true);
					sup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});

		setLocationRelativeTo(null);
		showResult();
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	PatienteType pt = new PatienteType();
	CMessage message = new CMessage();

	void showResult() {

		ArrayList<PatienteType> patienteList = new PatientManagement().listAll();
		if (patienteList.size() == 0) {
			message.message(this, "Lista vacia");
		} else {
			tableModel.setRowCount(0);
			for (PatienteType pt : patienteList) {
				String deadDate = pt.getDeathDate() == null ? "vivo" : pt.getDeathDate();
				Object aDatos[] = { pt.getId(), pt.getName() + " " + pt.getLastName(), pt.getAddress(),
						pt.getBirthDate(), deadDate, pt.getTelephone(), pt.getSex(), pt.getHeight(), pt.getWeight(),
						pt.getDistrito(), pt.getDateCreation(), "CLICK" };
				tableModel.addRow(aDatos);
			}
		}
	}

	void listByName() {
		String name = readFullName();
		if (name != null) {
			ArrayList<PatienteType> patienteList = new PatientManagement().getByName(name);
			if (patienteList.size() == 0) {
				tableModel.setRowCount(0);
			} else {
				tableModel.setRowCount(0);
				for (PatienteType pt : patienteList) {
					String deadDate = pt.getDeathDate() == null ? "vivo" : pt.getDeathDate();
					Object aDatos[] = { pt.getId(), pt.getName() + " " + pt.getLastName(), pt.getAddress(),
							pt.getBirthDate(), deadDate, pt.getTelephone(), pt.getSex(), pt.getHeight(), pt.getWeight(),
							pt.getDistrito(), pt.getDateCreation(), "CLICK" };
					tableModel.addRow(aDatos);
				}
			}
		} else {
			tableModel.setRowCount(0);
			showResult();
		}
	}

	void consult() {
		String code, fullName, startDate, endDate;

		code = readCode();
		fullName = readFullName();
		startDate = readStartDate();
		endDate = readEndDate() == null ? startDate : readEndDate();

		if (code != null) {
			pt = new PatientManagement().getById(code);
			if (pt == null) {
				message.message(this, "No se encontró registro con ese código");
			} else {
				tableModel.setRowCount(0);
				String deadDate = pt.getDeathDate() == null ? "vivo" : pt.getDeathDate();
				Object aDatos[] = { pt.getId(), pt.getName() + " " + pt.getLastName(), pt.getAddress(),
						pt.getBirthDate(), deadDate, pt.getTelephone(), pt.getSex(), pt.getHeight(), pt.getWeight(),
						pt.getDistrito(), pt.getDateCreation(), "CLICK" };
				tableModel.addRow(aDatos);
			}
			return;
		} else if (startDate != null) {
			ArrayList<PatienteType> patienteList = new PatientManagement().getByDate(startDate, endDate);
			if (patienteList.size() == 0) {
				tableModel.setRowCount(0);
			} else {
				tableModel.setRowCount(0);
				for (PatienteType pt : patienteList) {
					String deadDate = pt.getDeathDate() == null ? "vivo" : pt.getDeathDate();
					Object aDatos[] = { pt.getId(), pt.getName() + " " + pt.getLastName(), pt.getAddress(),
							pt.getBirthDate(), deadDate, pt.getTelephone(), pt.getSex(), pt.getHeight(), pt.getWeight(),
							pt.getDistrito(), pt.getDateCreation(), "CLICK" };
					tableModel.addRow(aDatos);
				}
			}
		} else {
			message.message(this, "Debe al menos ingresar el código y/o la fecha");
		}
	}

	String readCode() {
		return txtCode.getText().length() == 0 ? null : txtCode.getText();
	}

	String readFullName() {
		return txtFullName.getText().length() == 0 ? null : txtFullName.getText();
	}

	String readStartDate() {
		return txtStartDate.getDate() == null ? null : sdf.format(txtStartDate.getDate());
	}

	String readEndDate() {
		return txtEndDate.getDate() == null ? null : sdf.format(txtEndDate.getDate());
	}

}
