package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Supplier;

import maintenance.SupplierManagement;

public class SupplierView {

	private JFrame frmProveedor;
	public static JTextField txtIdSupplier;
	public static JTextField txtName;
	public static JTextField txtContact;
	public static JTextField txtDirection;
	public static JTextField txtPhone;
	public static JTextField txtEmail;
	private JTable tblDepature;

	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierView window = new SupplierView();
					window.frmProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupplierView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProveedor = new JFrame();
		frmProveedor.setTitle("Proveedor");
		frmProveedor.setBounds(100, 100, 937, 634);
		frmProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProveedor.getContentPane().setLayout(null);

		JLabel lblIdProveedor = new JLabel("Id de proveedor");
		lblIdProveedor.setBounds(10, 11, 221, 14);
		frmProveedor.getContentPane().add(lblIdProveedor);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(251, 11, 221, 14);
		frmProveedor.getContentPane().add(lblNombre);

		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 61, 221, 14);
		frmProveedor.getContentPane().add(lblContacto);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(251, 61, 221, 14);
		frmProveedor.getContentPane().add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 117, 221, 14);
		frmProveedor.getContentPane().add(lblTelefono);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(251, 117, 221, 14);
		frmProveedor.getContentPane().add(lblEmail);

		txtIdSupplier = new JTextField();
		txtIdSupplier.setBounds(10, 36, 221, 20);
		frmProveedor.getContentPane().add(txtIdSupplier);
		txtIdSupplier.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(251, 36, 660, 20);
		frmProveedor.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtContact = new JTextField();
		txtContact.setBounds(10, 86, 221, 20);
		frmProveedor.getContentPane().add(txtContact);
		txtContact.setColumns(10);

		txtDirection = new JTextField();
		txtDirection.setBounds(251, 86, 660, 20);
		frmProveedor.getContentPane().add(txtDirection);
		txtDirection.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setBounds(10, 142, 221, 20);
		frmProveedor.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(251, 142, 660, 20);
		frmProveedor.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 901, 336);
		frmProveedor.getContentPane().add(scrollPane);

		tblDepature = new JTable();
		tblDepature.setModel(model);
		model.addColumn("Id de proveedor");
		model.addColumn("Nombre");
		model.addColumn("Contacato");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Email");

		scrollPane.setViewportView(tblDepature);

		JButton btnSearchCode = new JButton("Buscar codigo");
		btnSearchCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search();
			}
		});
		btnSearchCode.setBounds(591, 549, 122, 23);
		frmProveedor.getContentPane().add(btnSearchCode);

		JButton btnRegister = new JButton("Registrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register();

			}
		});
		btnRegister.setBounds(723, 549, 89, 23);
		frmProveedor.getContentPane().add(btnRegister);

		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}

		});
		btnDelete.setBounds(822, 549, 89, 23);
		frmProveedor.getContentPane().add(btnDelete);

		JButton btnListOfSuppliers = new JButton("Lista de Proveedores");
		btnListOfSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list();
			}
		});
		btnListOfSuppliers.setBounds(10, 549, 156, 23);
		frmProveedor.getContentPane().add(btnListOfSuppliers);

		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit();
			}
		});
		btnEdit.setBounds(349, 549, 89, 23);
		frmProveedor.getContentPane().add(btnEdit);

		JButton btnSelection = new JButton("Seleccionar");
		btnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selection();
			}
		});
		btnSelection.setBounds(188, 549, 105, 23);
		frmProveedor.getContentPane().add(btnSelection);

		JButton btnSearchName = new JButton("Buscar Nombre");
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchName();
			}
		});
		btnSearchName.setBounds(448, 549, 133, 23);
		frmProveedor.getContentPane().add(btnSearchName);
	}

///////////////////////////////////////////////////////////////////LISTAR//////////////////////////////////////////////////////////////////
	void list() {
		@SuppressWarnings("unchecked")
		ArrayList<Supplier> lstSupplier = new SupplierManagement().listSupplier();
		if (lstSupplier.size() == 0) {
			JOptionPane.showMessageDialog(null, "Lista vacia");
		} else {
			model.setRowCount(0);
			for (Supplier s : lstSupplier) {
				Object aDatos[] = { s.getId_supplier(), s.getName_supplier(), s.getContact_supplier(),
						s.getDirection_supplier(), s.getPhone_supplier(), s.getEmail_supplier() };
				model.addRow(aDatos);
			}
		}

	}

/////////////////////////////////////////////////////////////////// REGISTRO//////////////////////////////////////////////////////////////////
	void Register() {
		String IdSupplier, Name, Contact, Direction, Phone, Email;

		IdSupplier = ReadIdSupplier();
		Name = ReadName();
		Contact = ReadContact();
		Direction = Readdirection();
		Phone = Readphone();
		Email = Reademail();

		Supplier s = new Supplier();

		s.setId_supplier(IdSupplier);
		s.setName_supplier(Name);
		s.setContact_supplier(Contact);
		s.setDirection_supplier(Direction);
		s.setPhone_supplier(Phone);
		s.setEmail_supplier(Email);

		int ok = new SupplierManagement().register(s);
		if (ok == 0) {
			JOptionPane.showMessageDialog(frmProveedor, this, "Error en registrar", ok);
		} else
			JOptionPane.showMessageDialog(frmProveedor, this, "Registro ok", ok);
		;
	}

	private String ReadIdSupplier() {
		if (txtIdSupplier.getText().length() == 0) {
			alert("Ingrese codigo");
			return null;
		}
		return txtIdSupplier.getText();
	}

	private String ReadName() {
		if (txtName.getText().length() == 0) {
			alert("Ingrese nombre");
			return null;
		}
		return txtName.getText();
	}

	private String ReadContact() {
		if (txtContact.getText().length() == 0) {
			alert("Ingrese Contacto");
			return null;
		}
		return txtContact.getText();
	}

	private String Readdirection() {
		if (txtDirection.getText().length() == 0) {
			alert("Ingrese Direccion");
			return null;
		}
		return txtDirection.getText();
	}

	private String Readphone() {
		if (txtPhone.getText().length() == 0) {
			alert("Ingrese Telefono");
			return null;
		}
		return txtPhone.getText();
	}

	private String Reademail() {
		if (txtEmail.getText().length() == 0) {
			alert("Ingrese Email");
			return null;
		}
		return txtEmail.getText();
	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Aviso", 2);

	}

/////////////////////////////////////////////////////////////////// ELIMINAR//////////////////////////////////////////////////////////////////					
	void Delete() {
		String idSupplier = ReadIdSupplier();
		Supplier s = new Supplier();
		s.setId_supplier(idSupplier);
		int ok = new SupplierManagement().delete(idSupplier);
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Ingrese los datos para borrar");
		} else {
			JOptionPane.showMessageDialog(null, "Borrado");
		}

	}

/////////////////////////////////////////////////////////////////// BUSCAR codigo////////////////////////////////////////////////////////////////////
	void Search() {
		String IdSupplier = ReadIdSupplier();
		Supplier s = new SupplierManagement().search(IdSupplier);
		if (s == null) {
			JOptionPane.showMessageDialog(null, "Id del proveedor no existe");
		} else {
			txtName.setText(s.getName_supplier());
			txtContact.setText(s.getContact_supplier());
			txtDirection.setText(s.getDirection_supplier());
			txtPhone.setText(s.getPhone_supplier());
			txtEmail.setText(s.getEmail_supplier());
		}

	}

/////////////////////////////////////////////////////////////////// BUSCAR Nombre////////////////////////////////////////////////////////////////////
	void SearchName() {
		String Name = ReadName();
		if (Name == null) {
			JOptionPane.showMessageDialog(null, "Debe ingresar el nombre");
		} else {
			Supplier s = new SupplierManagement().searchName(Name);
			if (s == null) {
				JOptionPane.showMessageDialog(null, "Nombre del proveedor no existe");
			} else {
				txtIdSupplier.setText(s.getId_supplier());
				txtContact.setText(s.getContact_supplier());
				txtDirection.setText(s.getDirection_supplier());
				txtPhone.setText(s.getPhone_supplier());
				txtEmail.setText(s.getEmail_supplier());
			}
		}

	}

/////////////////////////////////////////////////////////////////// EDITA/////////////////////////////////////////////////////////////////////////////
	void Edit() {
		String IdSupplier = ReadIdSupplier();
		String Name = ReadName();
		String Contact = ReadContact();
		String direction = Readdirection();
		String phone = Readphone();
		String email = Reademail();

		Supplier s = new Supplier();
		s.setId_supplier(IdSupplier);
		s.setName_supplier(Name);
		s.setContact_supplier(Contact);
		s.setDirection_supplier(direction);
		s.setPhone_supplier(phone);
		s.setEmail_supplier(email);
		int ok = new SupplierManagement().edit(s);

		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Error en editar");
		} else {
			JOptionPane.showMessageDialog(null, "Editado");
		}

	}

//////////////////////////////////////////////////////////////////Seleccionar al txt ////////////////////////////////////////////////////////////////////
	void Selection() {
		int fila = tblDepature.getSelectedRow();

		if (fila > -1) {
			txtIdSupplier.setText(tblDepature.getValueAt(fila, 0).toString());
			txtName.setText(tblDepature.getValueAt(fila, 1).toString());
			txtContact.setText(tblDepature.getValueAt(fila, 2).toString());
			txtDirection.setText(tblDepature.getValueAt(fila, 3).toString());
			txtPhone.setText(tblDepature.getValueAt(fila, 4).toString());
			txtEmail.setText(tblDepature.getValueAt(fila, 5).toString());
		} else {
			JOptionPane.showMessageDialog(null, "Selecciona un proveedor");
		}
	}
}
