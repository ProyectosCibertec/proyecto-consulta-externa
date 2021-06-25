package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.*;
import interfaces.UserInterface;
import utils.MySQLConection;

public class UserManagement implements UserInterface {

	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String currentDate = date.format(LocalDateTime.now());

	@Override
	public User userGenerate() {
		User u = null;
		String code = "U0001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			con = MySQLConection.getConexion();

			String sql = "SELECT SUBSTRING(MAX(id_usuario),2) FROM usuario";

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
	public int userCreate(NewUser user) {
		int result = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConection.getConexion();
			String sql = "{call sp_register_usuario(?,?,?,?,?)}";

			pst = con.prepareStatement(sql);

			pst.setString(1, user.getUserPersonal());
			pst.setString(2, user.getUserCode());
			pst.setString(3, user.getNewPassword());
			pst.setInt(4, user.getUserType());
			pst.setString(5, currentDate);

			result = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al crear usuario : " + e.getMessage());
		} finally {
			try {
				if (pst != null || con != null)
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
				u = new User(result.getString(1), result.getString(2), result.getInt(3), result.getString(4),
						result.getString(5));
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

	@Override
	public int changedUserPassword(User u) {
		int result = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConection.getConexion();
			String sql = "UPDATE usuario SET contrasena_usuario=?, fecha_hora_edicion=? WHERE id_usuario=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, u.getPassword());
			pst.setString(2, currentDate);
			pst.setString(3, u.getCode());

			result = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al crear usuario : " + e.getMessage());
		} finally {
			try {
				if (pst != null || con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return result;
	}

	@Override
	public User userExists(String user) {
		User u = null;
		ResultSet result = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConection.getConexion();
			String sql = "SELECT * FROM usuario WHERE id_usuario=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, user);

			result = pst.executeQuery();

			if (result.next()) {
				u = new User(result.getString(1), result.getString(2), result.getInt(3), result.getString(4),
						result.getString(5));
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
