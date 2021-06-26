package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.appointment.FrmAppointmentState;
import views.login.Login;
import views.medicine.FrmMedicationState;
import views.medicine.Medicamento;
import views.personal.FrmPersonal;
import views.room.FrmRoom;
import views.supplier.SupplierView;

import javax.swing.JMenuBar;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

public class Main extends JFrame implements MouseListener, ActionListener, WindowListener, PropertyChangeListener, ComponentListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JPanel panel;
	private JPanel panel_1;
	GridBagLayout gbl_contentPane;
	private JButton btnCerrarMen;
	private boolean closed = false;
	private JLabel lblWelcome;
	private JButton btnMantenerPersonal;
	private JButton btnConsultorios;
	private JButton btnProveedores;
	private JButton btnCitas;
	private JButton btnMedicinas;
	private JLabel lblUser;
	private JLabel lblAcceder;
	private JLabel lblImage;
	private ImageIcon imageIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// s
					Main frame = new Main();
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
	public Main() {
		addWindowListener(this);
		setTitle("Sistema de Consulta Externa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 408);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnSistema.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{171, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(7,0,86));
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		lblWelcome = new JLabel("Bienvenido(a)");
		lblWelcome.setBounds(12, 12, 141, 22);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWelcome.setForeground(Color.WHITE);
		panel.add(lblWelcome);
		
		btnMantenerPersonal = new JButton("Personal");
		btnMantenerPersonal.addActionListener(this);
		btnMantenerPersonal.setForeground(Color.WHITE);
		btnMantenerPersonal.setBounds(12, 67, 141, 25);
		btnMantenerPersonal.setOpaque(false);
		btnMantenerPersonal.setContentAreaFilled(false);
		btnMantenerPersonal.setBorderPainted(false);
		panel.add(btnMantenerPersonal);
		
		btnConsultorios = new JButton("Consultorios");
		btnConsultorios.addActionListener(this);
		btnConsultorios.setBackground(Color.PINK);
		btnConsultorios.setForeground(Color.WHITE);
		btnConsultorios.setBounds(12, 104, 141, 25);
		btnConsultorios.setOpaque(false);
		btnConsultorios.setContentAreaFilled(false);
		btnConsultorios.setBorderPainted(false);
		panel.add(btnConsultorios);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.addActionListener(this);
		btnProveedores.setBackground(Color.PINK);
		btnProveedores.setForeground(Color.WHITE);
		btnProveedores.setBounds(12, 141, 141, 25);
		btnProveedores.setOpaque(false);
		btnProveedores.setContentAreaFilled(false);
		btnProveedores.setBorderPainted(false);
		panel.add(btnProveedores);
		
		btnCitas = new JButton("Citas");
		btnCitas.addActionListener(this);
		btnCitas.setBackground(Color.PINK);
		btnCitas.setForeground(Color.WHITE);
		btnCitas.setBounds(12, 178, 141, 25);
		btnCitas.setOpaque(false);
		btnCitas.setContentAreaFilled(false);
		btnCitas.setBorderPainted(false);
		panel.add(btnCitas);
		
		btnMedicinas = new JButton("Medicinas");
		btnMedicinas.addActionListener(this);
		btnMedicinas.setBackground(Color.PINK);
		btnMedicinas.setForeground(Color.WHITE);
		btnMedicinas.setBounds(12, 215, 141, 25);
		btnMedicinas.setOpaque(false);
		btnMedicinas.setContentAreaFilled(false);
		btnMedicinas.setBorderPainted(false);
		panel.add(btnMedicinas);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{177, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 24, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnCerrarMen = new JButton("Cerrar");
		btnCerrarMen.setForeground(Color.BLACK);
		btnCerrarMen.setBackground(Color.WHITE);
		btnCerrarMen.addActionListener(this);
		GridBagConstraints gbc_btnCerrarMen = new GridBagConstraints();
		gbc_btnCerrarMen.anchor = GridBagConstraints.WEST;
		gbc_btnCerrarMen.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrarMen.gridx = 0;
		gbc_btnCerrarMen.gridy = 0;
		panel_1.add(btnCerrarMen, gbc_btnCerrarMen);
		
		lblAcceder = new JLabel("Sistema de Consulta Externa");
		lblAcceder.setFont(new Font("C059", Font.BOLD, 25));
		GridBagConstraints gbc_lblAcceder = new GridBagConstraints();
		gbc_lblAcceder.anchor = GridBagConstraints.SOUTH;
		gbc_lblAcceder.insets = new Insets(0, 0, 5, 0);
		gbc_lblAcceder.gridwidth = 2;
		gbc_lblAcceder.gridx = 0;
		gbc_lblAcceder.gridy = 2;
		panel_1.add(lblAcceder, gbc_lblAcceder);
		
		lblImage = new JLabel("");
		lblImage.addComponentListener(this);
		lblImage.addPropertyChangeListener(this);
		imageIcon = new ImageIcon(new ImageIcon(Main.class.getResource("/assets/images/slide1.jpg")).getImage().getScaledInstance(1, 1, Image.SCALE_DEFAULT));
		lblImage.setIcon(imageIcon);
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.fill = GridBagConstraints.BOTH;
		gbc_lblImage.gridwidth = 2;
		gbc_lblImage.gridx = 0;
		gbc_lblImage.gridy = 3;
		panel_1.add(lblImage, gbc_lblImage);
		
		
		lblUser = new JLabel("");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUser.setBounds(12, 33, 141, 22);
		panel.add(lblUser);
		lblWelcome.setText("Bienvenido(a)");
		lblUser.setText("null");
		lblUser.setText(Login.NameOfUser);
	}

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnMedicinas) {
			actionPerformedBtnMedicinas(arg0);
		}
		if (arg0.getSource() == btnCitas) {
			actionPerformedBtnCitas(arg0);
		}
		if (arg0.getSource() == btnProveedores) {
			actionPerformedBtnProveedores(arg0);
		}
		if (arg0.getSource() == btnConsultorios) {
			actionPerformedBtnConsultorios(arg0);
		}
		if (arg0.getSource() == btnMantenerPersonal) {
			actionPerformedBtnMantenerPersonal(arg0);
		}
		if (arg0.getSource() == btnCerrarMen) {
			actionPerformedBtnCerrarMen(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(ABORT);
	}

	protected void actionPerformedBtnCerrarMen(ActionEvent arg0) {
		if(closed == false) {
			gbl_contentPane.columnWidths = new int[]{0, 0, 0};
			contentPane.updateUI();
			btnCerrarMen.setText("Abrir");
			closed = true;
		} else {
			gbl_contentPane.columnWidths = new int[]{171, 0, 0};
			contentPane.updateUI();
			btnCerrarMen.setText("Cerrar");
			closed = false;
		}
	}
	protected void actionPerformedBtnMantenerPersonal(ActionEvent arg0) {
		FrmPersonal frmPersonal = new FrmPersonal();
		frmPersonal.setVisible(true);
	}
	protected void actionPerformedBtnConsultorios(ActionEvent arg0) {
		FrmRoom frmRoom = new FrmRoom();
		frmRoom.setVisible(true);
	}
	protected void actionPerformedBtnProveedores(ActionEvent arg0) {
		SupplierView supplierView = new SupplierView();
		supplierView.setVisible(true);
	}
	protected void actionPerformedBtnCitas(ActionEvent arg0) {
		FrmAppointmentState appointmentState = new FrmAppointmentState();
		appointmentState.setVisible(true);
	}
	protected void actionPerformedBtnMedicinas(ActionEvent arg0) {
		Medicamento medicationState = new Medicamento();
		medicationState.main(null);
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
		imageIcon = new ImageIcon(new ImageIcon(Main.class.getResource("/assets/images/slide1.jpg")).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
		lblImage.setIcon(imageIcon);
	}
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getSource() == lblImage) {
			propertyChangeLblImage(arg0);
		}
	}
	protected void propertyChangeLblImage(PropertyChangeEvent arg0) {
	}
	public void componentHidden(ComponentEvent e) {
	}
	public void componentMoved(ComponentEvent e) {
	}
	public void componentResized(ComponentEvent e) {
		if (e.getSource() == lblImage) {
			componentResizedLblImage(e);
		}
	}
	public void componentShown(ComponentEvent e) {
	}
	protected void componentResizedLblImage(ComponentEvent e) {
		try {
			imageIcon = new ImageIcon(new ImageIcon(Main.class.getResource("/assets/images/slide1.jpg")).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
			lblImage.setIcon(imageIcon);			
		} catch(Exception ex) {
			
		}
	}
}
