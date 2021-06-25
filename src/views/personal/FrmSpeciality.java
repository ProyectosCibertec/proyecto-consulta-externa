package views.personal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import maintenance.SpecialityManagement;
import models.Speciality;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmSpeciality extends JFrame implements ActionListener, WindowListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoEspecialidad;
	private JPanel panel;
	private JTextField txtSpeciality;
	private JScrollPane scrollPane;
	private JTable dataTableSpeciality;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAddSpeciality;
	private JButton btnRemoveSpeciality;
	DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSpeciality frame = new FrmSpeciality();
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
	public FrmSpeciality() {
		addWindowListener(this);
		setTitle("Mantenimiento Especialidad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 221, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblMantenimientoEspecialidad = new JLabel("Especialidades");
		lblMantenimientoEspecialidad.setFont(new Font("C059", Font.BOLD, 25));
		GridBagConstraints gbc_lblMantenimientoEspecialidad = new GridBagConstraints();
		gbc_lblMantenimientoEspecialidad.insets = new Insets(0, 0, 5, 0);
		gbc_lblMantenimientoEspecialidad.gridx = 0;
		gbc_lblMantenimientoEspecialidad.gridy = 0;
		contentPane.add(lblMantenimientoEspecialidad, gbc_lblMantenimientoEspecialidad);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 191, 32, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		txtSpeciality = new JTextField();
		GridBagConstraints gbc_txtSpeciality = new GridBagConstraints();
		gbc_txtSpeciality.insets = new Insets(0, 0, 5, 0);
		gbc_txtSpeciality.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSpeciality.gridx = 0;
		gbc_txtSpeciality.gridy = 0;
		panel.add(txtSpeciality, gbc_txtSpeciality);
		txtSpeciality.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		Object[] columns = { "ID", "Descripción" };
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		dataTableSpeciality = new JTable(dtm);
		dataTableSpeciality.addMouseListener(this);
		dataTableSpeciality.setFillsViewportHeight(true);
		scrollPane.setViewportView(dataTableSpeciality);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAddSpeciality = new JButton("Agregar");
		btnAddSpeciality.addActionListener(this);
		panel_2.add(btnAddSpeciality);

		btnRemoveSpeciality = new JButton("Eliminar");
		btnRemoveSpeciality.addActionListener(this);
		panel_2.add(btnRemoveSpeciality);
	}

	/*----- Methods -----*/

	public void listSpeciality() {
		dtm.setRowCount(0);
		SpecialityManagement specialityM = new SpecialityManagement();
		for (Speciality speciality : specialityM.listSpeciality()) {
			dtm.addRow(new Object[] { speciality.getIdSpeciality(), speciality.getSpecialityDescription() });
		}
	}

	public void clearTxt() {
		txtSpeciality.setText("");
	}

	/*----- Events -----*/

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRemoveSpeciality) {
			actionPerformedBtnRemoveSpeciality(arg0);
		}
		if (arg0.getSource() == btnAddSpeciality) {
			actionPerformedBtnAddSpeciality(arg0);
		}
	}

	protected void actionPerformedBtnAddSpeciality(ActionEvent arg0) {
		String result = null;
		SpecialityManagement specialityM = new SpecialityManagement();

		if (txtSpeciality.getText().length() != 0) {
			try {
				result = txtSpeciality.getText();
				specialityM.addSpeciality(result);
				listSpeciality();
				clearTxt();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir un estado de personal");
		}
	}

	protected void actionPerformedBtnRemoveSpeciality(ActionEvent arg0) {
		SpecialityManagement specialityM = new SpecialityManagement();
		specialityM.removeSpeciality(Integer.parseInt(txtSpeciality.getText()));
		listSpeciality();
		clearTxt();
	}

	public void windowClosed(WindowEvent e) {
		this.dispose();
	}

	protected void mouseClickedDataTableSpeciality(MouseEvent e) {
		int row = dataTableSpeciality.getSelectedRow();
		try {
			Speciality speciality = new Speciality();
			speciality.setIdSpeciality(dtm.getValueAt(row, 0).toString());
			txtSpeciality.setText(speciality.getIdSpeciality());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + ex.getMessage());
		}
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		listSpeciality();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == dataTableSpeciality) {
			mouseClickedDataTableSpeciality(e);
		}
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {

	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
