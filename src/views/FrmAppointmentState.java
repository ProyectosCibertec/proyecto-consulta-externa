package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import maintenance.AppointmentStateManagement;
import maintenance.PersonalStateManagement;
import models.AppointmentState;
import models.PersonalState;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmAppointmentState extends JFrame implements ActionListener, WindowListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoEstado;
	private JButton btnDelete;
	private JButton btnAdd;
	private JPanel panel;
	private JTextField txtAppointmentState;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable dataListAppointmentState;
	private JPanel panel_2;
	DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAppointmentState frame = new FrmAppointmentState();
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
	public FrmAppointmentState() {
		addWindowListener(this);
		setTitle("Mantenimiento Estado Citas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 284, 0 };
		gbl_contentPane.rowHeights = new int[] { 44, 152, 31, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblMantenimientoEstado = new JLabel("Estados de citas");
		lblMantenimientoEstado.setFont(new Font("C059", Font.BOLD, 25));
		GridBagConstraints gbc_lblMantenimientoEstado = new GridBagConstraints();
		gbc_lblMantenimientoEstado.fill = GridBagConstraints.BOTH;
		gbc_lblMantenimientoEstado.insets = new Insets(0, 0, 5, 0);
		gbc_lblMantenimientoEstado.gridx = 0;
		gbc_lblMantenimientoEstado.gridy = 0;
		contentPane.add(lblMantenimientoEstado, gbc_lblMantenimientoEstado);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 284, 0 };
		gbl_panel_1.rowHeights = new int[] { 25, 30, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		txtAppointmentState = new JTextField();
		GridBagConstraints gbc_txtAppointmentState = new GridBagConstraints();
		gbc_txtAppointmentState.insets = new Insets(0, 0, 5, 0);
		gbc_txtAppointmentState.fill = GridBagConstraints.BOTH;
		gbc_txtAppointmentState.gridx = 0;
		gbc_txtAppointmentState.gridy = 0;
		panel_1.add(txtAppointmentState, gbc_txtAppointmentState);
		txtAppointmentState.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		Object[] columns = { "ID", "Descripción" };
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		dataListAppointmentState = new JTable(dtm);
		dataListAppointmentState.addMouseListener(this);
		dataListAppointmentState.setFillsViewportHeight(true);
		scrollPane.setViewportView(dataListAppointmentState);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("Agregar");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);

		btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(this);
		panel_2.add(btnDelete);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDelete) {
			actionPerformedBtnDelete(arg0);
		}
		if (arg0.getSource() == btnAdd) {
			actionPerformedBtnAdd(arg0);
		}
	}

	protected void actionPerformedBtnAdd(ActionEvent arg0) {
		String result = null;
		AppointmentStateManagement appointmentStateM = new AppointmentStateManagement();

		if (txtAppointmentState.getText().length() != 0) {
			try {
				result = txtAppointmentState.getText();
				appointmentStateM.addAppointmentState(result);
				listAppointmentState();
				clearTxt();
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir un estado de personal");
		}
	}

	public void listAppointmentState() {
		dtm.setRowCount(0);
		AppointmentStateManagement appointmentStateM = new AppointmentStateManagement();
		for (AppointmentState appointmentState : appointmentStateM.listAppointmentState()) {
			dtm.addRow(
					new Object[] { appointmentState.getIdAppointmentState(), appointmentState.getAppointmentStateDescription() });
		}
	}

	protected void mouseClickedDataListPersonalState(MouseEvent e) {
		int row = dataListAppointmentState.getSelectedRow();
		try {
			AppointmentState appointmentState = new AppointmentState();
			appointmentState.setIdAppointmentState(dtm.getValueAt(row, 0).toString());
			txtAppointmentState.setText(appointmentState.getIdAppointmentState());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + ex.getMessage());
		}
	}

	public void windowClosed(WindowEvent e) {
		this.dispose();
	}

	public void windowClosing(WindowEvent e) {
		this.dispose();
	}

	public void windowDeactivated(WindowEvent e) {
		this.dispose();
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		listAppointmentState();
	}

	protected void actionPerformedBtnDelete(ActionEvent arg0) {
		AppointmentStateManagement appointmentStateM = new AppointmentStateManagement();
		appointmentStateM.removeAppointmentState(Integer.parseInt(txtAppointmentState.getText()));
		listAppointmentState();
		clearTxt();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == dataListAppointmentState) {
			mouseClickedDataListPersonalState(e);
		}
	}

	public void clearTxt() {
		txtAppointmentState.setText("");
	}

	public void windowActivated(WindowEvent e) {
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
