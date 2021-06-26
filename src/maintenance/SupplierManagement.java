package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.SupplierInterface;
import models.Supplier;
import utils.MySQLConection;

public class SupplierManagement implements SupplierInterface {

	@Override
	public ArrayList<Supplier> listSupplier() {
		ArrayList<Supplier> list = new ArrayList<Supplier>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_listsupplier()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}

		} catch (Exception e) {
			System.out.println("Error en listar" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public int register(Supplier S) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "INSERT INTO proveedor VALUES (?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, S.getId_supplier());
			pst.setString(2, S.getName_supplier());
			pst.setString(3, S.getContact_supplier());
			pst.setString(4, S.getDirection_supplier());
			pst.setString(5, S.getPhone_supplier());
			pst.setString(6, S.getEmail_supplier());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int delete(String idSupplier) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "delete from proveedor where id_proveedor=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, idSupplier);
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int edit(Supplier S) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_suppliert_update(?,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, S.getId_supplier());
			pst.setString(2, S.getName_supplier());
			pst.setString(3, S.getContact_supplier());
			pst.setString(4, S.getDirection_supplier());
			pst.setString(5, S.getPhone_supplier());
			pst.setString(6, S.getEmail_supplier());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al editar" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public Supplier search(String IDSupplier) {

		Supplier s = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "select  * from proveedor where id_proveedor = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, IDSupplier);

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println("Error al buscar" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}

		return s;
	}

	public Supplier searchName(String Name) {

		Supplier s = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		System.out.println(Name);
		try {
			con = MySQLConection.getConexion();
			String sql = "select * from proveedor where nombre_proveedor like '%" + Name + "%'";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println("Error al buscar" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return s;
	}

	@Override
	public ArrayList<Supplier> supplierListByName(String name) {
		ArrayList<Supplier> list = new ArrayList<Supplier>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_listSupplier_by_name(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}

		} catch (Exception e) {
			System.out.println("Error en supplierListByName()" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public Supplier supplierCodeGenerate() {
		Supplier p = null;
		String code = "P0001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			con = MySQLConection.getConexion();

			String sql = "SELECT SUBSTRING(MAX(id_proveedor),4) FROM proveedor;";

			pst = con.prepareStatement(sql);

			result = pst.executeQuery();

			if (result.next()) {
				code = String.format("PRO%02d", result.getInt(1) + 1);
				p = new Supplier(code);
			}

		} catch (Exception e) {
			System.out.println("Error en supplierCodeGenerate() :" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar : " + e2.getMessage());
			}
		}

		return p;
	}
}
