package views.supplier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import commons.CMessage;
import maintenance.SupplierManagement;
import models.Supplier;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SupplierView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;
	private JTable tblResult;
	private JButton btnSearch;
	private JButton btnRegister;

	DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierView frame = new SupplierView();
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
	public SupplierView() {
		setTitle("Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 778, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(30, 15, 70, 15);
		contentPane.add(lblCdigo);

		txtCode = new JTextField();
		txtCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnSearch.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (readSupplierId() == null) {
					btnSearch.setVisible(false);
				}
			}
		});
		txtCode.setBounds(30, 40, 114, 19);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(190, 15, 70, 15);
		contentPane.add(lblNombre);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listByName();
			}
		});
		txtName.setBounds(190, 40, 328, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);

		btnSearch = new JButton("Consultar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchById();
			}
		});
		btnSearch.setVisible(false);
		btnSearch.setBounds(597, 35, 117, 25);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 69, 743, 271);
		contentPane.add(scrollPane);

		tblResult = new JTable();
		scrollPane.setViewportView(tblResult);

		tblResult.setModel(tableModel);
		tableModel.addColumn("Id de proveedor");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Contacto");
		tableModel.addColumn("Direccion");
		tableModel.addColumn("Telefono");
		tableModel.addColumn("Email");
		tableModel.addColumn("Editar");
		tblResult.getTableHeader().setBackground(new Color(32, 136, 203));
		tblResult.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				int column = target.getSelectedColumn();

				if (column == 6) {
					String code = (String) tableModel.getValueAt(row, 0);
					SupplierUpdateView.CODE_SUPPLIER = code;
					SupplierUpdateView sup = new SupplierUpdateView();

					sup.setVisible(true);
					sup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});

		btnRegister = new JButton("Nuevo proveedor");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SupplierRegisterView sr = new SupplierRegisterView();

				sr.setVisible(true);
				sr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

			}
		});
		btnRegister.setBounds(266, 359, 179, 25);
		contentPane.add(btnRegister);

		showList();
		setLocationRelativeTo(null);
	}

	CMessage message = new CMessage();

	void showList() {
		ArrayList<Supplier> lstSupplier = new SupplierManagement().listSupplier();
		if (lstSupplier.size() == 0) {
			message.message(this, "Lista vacia", "Not Found");
		} else {
			tableModel.setRowCount(0);
			for (Supplier s : lstSupplier) {
				Object aDatos[] = { s.getId_supplier(), s.getName_supplier(), s.getContact_supplier(),
						s.getDirection_supplier(), s.getPhone_supplier(), s.getEmail_supplier(), "CLICK" };
				tableModel.addRow(aDatos);
			}
		}

	}

	void searchById() {
		String code = readSupplierId();
		if (code != null) {
			Supplier s = new Supplier();

			s = new SupplierManagement().search(code);

			if (s == null) {
				message.message(this, "Lista vacia", "Not Found");
				tableModel.setRowCount(0);
			} else {
				tableModel.setRowCount(0);

				Object aDatos[] = { s.getId_supplier(), s.getName_supplier(), s.getContact_supplier(),
						s.getDirection_supplier(), s.getPhone_supplier(), s.getEmail_supplier(), "CLICK" };
				tableModel.addRow(aDatos);

			}
		} else {
			tableModel.setRowCount(0);
		}
	}

	void listByName() {
		String idSupplier = readSupplierName();
		if (idSupplier != null) {
			ArrayList<Supplier> supplierList = new SupplierManagement().supplierListByName(idSupplier);
			if (supplierList.size() == 0) {
				tableModel.setRowCount(0);
			} else {
				tableModel.setRowCount(0);
				for (Supplier s : supplierList) {
					Object aDatos[] = { s.getId_supplier(), s.getName_supplier(), s.getContact_supplier(),
							s.getDirection_supplier(), s.getPhone_supplier(), s.getEmail_supplier(), "CLICK" };
					tableModel.addRow(aDatos);
				}
			}
		} else {
			tableModel.setRowCount(0);
			showList();
		}
	}

	private String readSupplierId() {
		return txtCode.getText().length() == 0 ? null : txtCode.getText();
	}

	private String readSupplierName() {
		return txtName.getText().length() == 0 ? null : txtName.getText();
	}
}
