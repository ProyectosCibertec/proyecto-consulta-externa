package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.*;
import interfaces.UserInterface;
import utils.MySQLConection;

public class UserManagement implements UserInterface {
	
	@Override
	public User getUser() {
		User u = null;
		String code = "U0001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			con = MySQLConection.getConexion();

			String sql = "SELECT SUBSTRING(MAX(usuario),2) FROM usuario";

			pst = con.prepareStatement(sql);
			result = pst.executeQuery();

			if (result.next()) {
				code = String.format("U%04d", result.getInt(1) + 1);
				u = new User(code);
			}

		} catch (Exception e) {
			System.out.println("Error al generar nuevo usuario :" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar : " + e2.getMessage());
			}
		}

		return u;
	}

	@Override
	public int createUser(NewUser user) {
		int result = 0;
		int code = -1;
		ResultSet result1 = null;

		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;

		try {
			con = MySQLConection.getConexion();
			String createUser = "SELECT MAX(id_usuario) FROM usuario";

			pst1 = con.prepareStatement(createUser);
			result1 = pst1.executeQuery();
			if (result1.next()) {
				code = result1.getInt(1) + 1;
			}
			String sql = "{call sp_register_usuario(?,?,?,?,?)}";

			pst2 = con.prepareStatement(sql);

			pst2.setString(1, user.getUserPersonal());
			pst2.setInt(2, code);
			pst2.setString(3, user.getNewUser());
			pst2.setString(4, user.getNewPassword());
			pst2.setInt(5, user.getUserType());

			result = pst2.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al crear usuario : " + e.getMessage());
		} finally {
			try {
				if (pst1 != null || con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return result;
	}

	@Override
	public User validateAccess(String user, String pass) {
		User u = null;
		ResultSet result = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConection.getConexion();
			String sql = "call sp_validate_usuario(?,?)";

			pst = con.prepareStatement(sql);

			pst.setString(1, user);
			pst.setString(2, pass);

			result = pst.executeQuery();

			if (result.next()) {
				u = new User(result.getString(1), result.getString(2), result.getString(3), result.getInt(4));
			}

		} catch (Exception e) {
			System.out.println("Error al validar el acceso : " + e.getMessage());
		} finally {
			try {
				if (pst != null || con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return u;
	}

}
