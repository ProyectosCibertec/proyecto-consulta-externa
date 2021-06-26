package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import maintenance.PersonalManagement;
import models.Personal;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmPersonal extends JFrame implements ActionListener, WindowListener, MouseListener,
		PropertyChangeListener, InputMethodListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoPersonal;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JPanel panel_6;
	private JLabel lblCdigo;
	private JTextField txtCode;
	private JScrollPane scrollPane;
	private JTable dataTable;
	DefaultTableModel dmt;
	private JTextField txtName;
	private JLabel lblNombre;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 687, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblMantenimientoPersonal = new JLabel("Mantenimiento Personal");
		lblMantenimientoPersonal.setFont(new Font("C059", Font.BOLD, 25));
		GridBagConstraints gbc_lblMantenimientoPersonal = new GridBagConstraints();
		gbc_lblMantenimientoPersonal.anchor = GridBagConstraints.NORTH;
		gbc_lblMantenimientoPersonal.insets = new Insets(0, 0, 5, 0);
		gbc_lblMantenimientoPersonal.gridx = 0;
		gbc_lblMantenimientoPersonal.gridy = 0;
		contentPane.add(lblMantenimientoPersonal, gbc_lblMantenimientoPersonal);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 220, 397, 0 };
		gbl_panel.rowHeights = new int[] { 217, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { -4, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 17, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.BASELINE;
		gbc_panel_6.gridwidth = 2;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_1.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_6.rowHeights = new int[] { 0, 0 };
		gbl_panel_6.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_6.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_6.setLayout(gbl_panel_6);

		lblCdigo = new JLabel("Código");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.insets = new Insets(0, 0, 0, 5);
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panel_6.add(lblCdigo, gbc_lblCdigo);

		txtCode = new JTextField();
		txtCode.setColumns(10);
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.gridx = 1;
		gbc_txtCode.gridy = 0;
		panel_6.add(txtCode, gbc_txtCode);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 10, 0));

		panel_4 = new JPanel();
		panel_3.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 131, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		panel_4.add(btnAgregar, gbc_btnAgregar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 1;
		panel_4.add(btnBuscar, gbc_btnBuscar);

		panel_5 = new JPanel();
		panel_3.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizar.gridx = 0;
		gbc_btnActualizar.gridy = 0;
		panel_5.add(btnActualizar, gbc_btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 1;
		panel_5.add(btnEliminar, gbc_btnEliminar);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		Object title[] = { "Código", "Nombres", "Teléfono", "Dirección", "Email", "T. de Emergencia",
				"F. de Nacimiento", "Especialidad", "Estado" };
		dmt = new DefaultTableModel();
		dmt.setColumnIdentifiers(title);

		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panel_2.add(lblNombre, gbc_lblNombre);

		txtName = new JTextField();
		txtName.addKeyListener(this);
		txtName.addInputMethodListener(this);
		txtName.addPropertyChangeListener(this);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		panel_2.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_2.add(scrollPane, gbc_scrollPane);
		dataTable = new JTable(dmt);
		dataTable.addMouseListener(this);
		dataTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(dataTable);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}

	/*----- Methods -----*/

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

	/*----- Events -----*/

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		PersonalManagement personalManagement = new PersonalManagement();
		try {
			personalManagement.deletePersonal(getCodeOfPersonal());
			listPersonal();
			txtCode.setText("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		ArrayList<Personal> listPersonal = new ArrayList<Personal>();
		int row = 0;

		for (int i = 0; i < listPersonal.size(); i++) {
			if (listPersonal.get(i).getIdPersonal() == txtCode.getText()) {
				row = i;
			}
		}

		dataTable.setRowSelectionInterval(row, row);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == dataTable) {
			mouseClickedDataTable(e);
		}
	}

	public void windowIconified(WindowEvent e) {
		if (e.getSource() == this) {
			windowIconifiedThis(e);
		}
	}

	public void windowActivated(WindowEvent e) {
		listPersonal();
	}

	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		FrmPersonalData.isForAdd = true;
		FrmPersonalData personalData = new FrmPersonalData();
		personalData.setVisible(true);
	}

	protected void mouseClickedDataTable(MouseEvent e) {
		try {
			int row = dataTable.getSelectedRow();
			txtCode.setText(dmt.getValueAt(row, 0).toString());
		} catch (Exception ex) {

		}
	}

	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		if (!txtCode.getText().matches("P[0-9]{4}")) {
			JOptionPane.showMessageDialog(null, "Para actualizar un usuario, selecciónelo o escriba su código.");
		} else {
			FrmPersonalData.isForAdd = false;
			FrmPersonalData personalData = new FrmPersonalData();
			personalData.codeOfPersonal = txtCode.getText();
			personalData.setVisible(true);
		}
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	protected void windowIconifiedThis(WindowEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getSource() == txtName) {
			propertyChangeTextField(arg0);
		}
	}

	protected void propertyChangeTextField(PropertyChangeEvent arg0) {

	}

	public void caretPositionChanged(InputMethodEvent arg0) {
	}

	public void inputMethodTextChanged(InputMethodEvent arg0) {
		if (arg0.getSource() == txtName) {
			inputMethodTextChangedTextField(arg0);
		}
	}

	protected void inputMethodTextChangedTextField(InputMethodEvent arg0) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtName) {
			keyPressedTextField(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		dmt.setRowCount(0);
		PersonalManagement personalManagement = new PersonalManagement();
		ArrayList<Personal> listPersonal = personalManagement.listPersonalByName(txtName.getText());

		for (Personal personal : listPersonal) {
			dmt.addRow(new Object[] { personal.getIdPersonal(), personal.getPersonalName(), personal.getPersonalPhone(),
					personal.getPersonalDirection(), personal.getPersonalEmail(), personal.getEmergencyPhone(),
					personal.getBirthDate(), personal.getIdSpecialty(), personal.getIdPersonalState() });
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTextField(KeyEvent e) {
	}
}
