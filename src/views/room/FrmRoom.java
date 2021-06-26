package views.room;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import maintenance.PersonalStateManagement;
import maintenance.RoomManagement;
import maintenance.RoomStateManagement;
import maintenance.RoomManagement;
import models.PersonalState;
import models.Room;
import models.RoomState;
import models.RoomWithRoomState;
import models.Room;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class FrmRoom extends JFrame implements ActionListener, WindowListener, MouseListener, PopupMenuListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoConsultorios;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblId;
	private JLabel lblEstado;
	private JTextField txtId;
	private JComboBox cboState;
	private JPanel panel_4;
	private JLabel lblDescripcin;
	private JTextField txtDescription;
	private JPanel panel_5;
	private JScrollPane scrollPane;
	private JTable listOfRooms;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JButton btnAdd;
	private JButton btnDelete;
	DefaultTableModel dtm;
	private JLabel lblAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRoom frame = new FrmRoom();
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
	public FrmRoom() {
		addMouseListener(this);
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 208, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblMantenimientoConsultorios = new JLabel("Mantenimiento Consultorios");
		lblMantenimientoConsultorios.setFont(new Font("C059", Font.BOLD, 25));
		GridBagConstraints gbc_lblMantenimientoConsultorios = new GridBagConstraints();
		gbc_lblMantenimientoConsultorios.insets = new Insets(0, 0, 5, 0);
		gbc_lblMantenimientoConsultorios.gridx = 0;
		gbc_lblMantenimientoConsultorios.gridy = 0;
		contentPane.add(lblMantenimientoConsultorios, gbc_lblMantenimientoConsultorios);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 3, 28, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		panel_2 = new JPanel();
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 24, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 0, 5);
		gbc_lblId.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel_2.add(lblId, gbc_lblId);

		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.SOUTHWEST;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		panel_2.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 20, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.addMouseListener(this);
		GridBagConstraints gbc_lblAgregar = new GridBagConstraints();
		gbc_lblAgregar.anchor = GridBagConstraints.WEST;
		gbc_lblAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_lblAgregar.gridx = 1;
		gbc_lblAgregar.gridy = 0;
		panel_3.add(lblAgregar, gbc_lblAgregar);

		lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 1;
		panel_3.add(lblEstado, gbc_lblEstado);

		cboState = new JComboBox();
		cboState.addPopupMenuListener(this);
		cboState.addMouseListener(this);
		cboState.addActionListener(this);
		GridBagConstraints gbc_cboState = new GridBagConstraints();
		gbc_cboState.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboState.gridx = 1;
		gbc_cboState.gridy = 1;
		panel_3.add(cboState, gbc_cboState);

		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.addMouseListener(this);
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 0;
		panel_4.add(lblDescripcin, gbc_lblDescripcin);

		txtDescription = new JTextField();
		GridBagConstraints gbc_txtDescription = new GridBagConstraints();
		gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescription.gridx = 1;
		gbc_txtDescription.gridy = 0;
		panel_4.add(txtDescription, gbc_txtDescription);
		txtDescription.setColumns(10);

		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_5.add(scrollPane, gbc_scrollPane);

		Object titles[] = { "Código", "Descripción", "Estado" };
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(titles);
		listOfRooms = new JTable(dtm);
		listOfRooms.setFillsViewportHeight(true);
		scrollPane.setViewportView(listOfRooms);

		panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		contentPane.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));

		panel_7 = new JPanel();
		panel_6.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 0, 0 };
		gbl_panel_7.rowHeights = new int[] { 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		btnAdd = new JButton("Registrar");
		btnAdd.addActionListener(this);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel_7.add(btnAdd, gbc_btnAdd);

		panel_8 = new JPanel();
		panel_6.add(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 0, 0 };
		gbl_panel_8.rowHeights = new int[] { 0, 0 };
		gbl_panel_8.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(this);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 0;
		panel_8.add(btnDelete, gbc_btnDelete);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboState) {
			actionPerformedCboState(arg0);
		}
		if (arg0.getSource() == btnDelete) {
			actionPerformedBtnDelete(arg0);
		}
		if (arg0.getSource() == btnAdd) {
			actionPerformedBtnAdd(arg0);
		}
	}

	/*----- Methods -----*/
	
	public void listRoomState() {
		cboState.removeAllItems();
		RoomStateManagement roomStateM = new RoomStateManagement();
		for (RoomState roomState : roomStateM.listRoomState()) {
			cboState.addItem(roomState.getIdRoomState().toString() + " - " + roomState.getRoomStateDescription().toString());
		}
	}

	public String getCodeOfRoom() {
		String result = null;

		try {
			result = txtId.getText();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}

		return result;
	}

	public String getDescriptionOfRoom() {
		String result = null;

		try {
			result = txtDescription.getText();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}

		return result;
	}

	public int getStateOfRoom() {
		int result = 0;

		try {
			result = Integer.parseInt(cboState.getSelectedItem().toString().split(" - ")[0]);
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}

		return result;
	}

	public int addRoom() {
		RoomManagement roomManagement = new RoomManagement();
		Room room = new Room();
		try {
			room.setIdConsultingRoom(getCodeOfRoom());
			room.setPrivateRoomDescription(getDescriptionOfRoom());
			room.setIdPrivateRoomState(String.valueOf(getStateOfRoom()));
			if (roomManagement.addRoom(room) >= 1) {
				listRooms();
				clearTxts();
				return 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
		}

		return 0;
	}

	public int deleteRoom() {
		return 0;
	}

	public void listRooms() {
		dtm.setRowCount(0);
		RoomManagement roomManagement = new RoomManagement();
		ArrayList<Room> listRoom = roomManagement.listRoom();

		for (Room room : listRoom) {
			dtm.addRow(new Object[] { room.getIdConsultingRoom(), room.getPrivateRoomDescription(),
					room.getIdPrivateRoomState() });
		}
	}
	
	public void clearTxts() {
		txtId.setText("");
		txtDescription.setText("");
		cboState.setSelectedIndex(0);
	}

	/*----- Events -----*/

	protected void actionPerformedBtnAdd(ActionEvent arg0) {
		if(addRoom() == 0) {
			JOptionPane.showMessageDialog(null, "No se registró ningún consultorio.");
		} else {
			JOptionPane.showMessageDialog(null, "Consultorio registrado con éxito.");
		}
	}

	protected void actionPerformedBtnDelete(ActionEvent arg0) {
		if(addRoom() == 0) {
			JOptionPane.showMessageDialog(null, "No se eliminó ningún consultorio.");
		} else {
			JOptionPane.showMessageDialog(null, "Consultorio eliminado con éxito.");
		}
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

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		listRooms();
		listRoomState();
	}
	public void mouseEntered(MouseEvent e) {
		lblAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void actionPerformedCboState(ActionEvent arg0) {
		
	}
	protected void mouseClickedCboState(MouseEvent e) {
		listRoomState();
	}
	public void popupMenuCanceled(PopupMenuEvent arg0) {
	}
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
	}
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
		if (arg0.getSource() == cboState) {
			popupMenuWillBecomeVisibleCboState(arg0);
		}
	}
	protected void popupMenuWillBecomeVisibleCboState(PopupMenuEvent arg0) {
		listRoomState();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblAgregar) {
			mouseClickedLblAgregar(arg0);
		}
		if (arg0.getSource() == lblDescripcin) {
			mouseClickedLblDescripcin(arg0);
		}
		if (arg0.getSource() == this) {
			mouseClickedThis(arg0);
		}
		// TODO Auto-generated method stub
		
	}
	protected void mouseClickedThis(MouseEvent arg0) {
	}
	protected void mouseClickedLblDescripcin(MouseEvent arg0) {
	}
	protected void mouseClickedLblAgregar(MouseEvent arg0) {
		FrmRoomState frs = new FrmRoomState();
		frs.setVisible(true);
	}
}
