package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.PersonalInterface;
import models.Personal;
import utils.MySQLConection;

public class PersonalManagement implements PersonalInterface {

	public Personal verify(String user) {
		Personal p = null;
		ResultSet result = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConection.getConexion();
			String sql = "SELECT * FROM personal WHERE id_personal = ?";
			System.out.println(user);
			pst = con.prepareStatement(sql);

			pst.setString(1, user);

			result = pst.executeQuery();

			if (result.next()) {
				p = new Personal(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6), result.getString(7), result.getInt(8),
						result.getString(9), result.getString(10));
			}

		} catch (Exception e) {
			System.out.println("Error al verificar personal : " + e.getMessage());
		} finally {
			try {
				if (pst != null || con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return p;
	}

	@Override
	public int addPersonal(Personal personal) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "CALL usp_signUpPersonal(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, personal.getIdPersonal());
			pst.setString(2, personal.getPersonalName());
			pst.setString(3, personal.getPersonalPhone());
			pst.setString(4, personal.getPersonalDirection());
			pst.setString(5, personal.getPersonalEmail());
			pst.setString(6, personal.getEmergencyPhone());
			pst.setString(7, personal.getBirthDate());
			pst.setInt(8, personal.getIdUsuario());
			pst.setString(9, personal.getIdSpecialty());
			pst.setString(10, personal.getIdPersonalState());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar : " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					con.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		return result;
	}

	@Override
	public int updatePersonal(Personal personal) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "CALL usp_updatePersonal(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, personal.getIdPersonal());
			pst.setString(2, personal.getPersonalName());
			pst.setString(3, personal.getPersonalPhone());
			pst.setString(4, personal.getPersonalDirection());
			pst.setString(5, personal.getPersonalEmail());
			pst.setString(6, personal.getEmergencyPhone());
			pst.setString(7, personal.getBirthDate());
			pst.setInt(8, personal.getIdUsuario());
			pst.setString(9, personal.getIdSpecialty());
			pst.setString(10, personal.getIdPersonalState());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar : " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					con.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		return result;
	}

	@Override
	public int deletePersonal(String id) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "DELETE FROM personal WHERE id_personal = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar : " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					con.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		return result;
	}

	@Override
	public Personal getPersonal(String id) {
		// template
		Personal personal = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			final String SQL = "SELECT * FROM personal WHERE id_personal = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, id);
			result = pst.executeQuery();
			if(result.next()) {
				personal = new Personal(
							result.getString(1),
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6),
							result.getString(7),
							result.getInt(8),
							result.getString(9),
							result.getString(10)
						);
			}
		} catch (Exception e) {
			System.out.println("Error al consultar : " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					con.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		return personal;
	}

	
	public ArrayList<Personal> listPersonal() {
		ArrayList<Personal> listPersonal = new ArrayList<Personal>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		
		try {
			final String SQL = "CALL usp_listPersonal()";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);
			
			result = pst.executeQuery();
			while(result.next()) {
				listPersonal.add(new Personal(
							result.getString(1),
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6),
							result.getString(7),
							result.getInt(8),
							result.getString(9),
							result.getString(10)
						));
			}
		} catch(Exception e) {
			System.out.println("Error en listado : " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					con.close();
				;
				if (con != null)
					con.close();
				;
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}
		
		return listPersonal;
	}
	
	@Override
	public ArrayList<Personal> listByPersonalState(String id) {
		ArrayList<Personal> listPersonal = new ArrayList<Personal>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		
		try {
			final String SQL = "CALL usp_list()";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);
			
			result = pst.executeQuery();
			while(result.next()) {
				listPersonal.add(new Personal(
							result.getString(1),
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6),
							result.getString(7),
							result.getInt(8),
							result.getString(9),
							result.getString(10)
						));
			}
		} catch(Exception e) {
			System.out.println("Error en listado : " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					con.close();
				;
				if (con != null)
					con.close();
				;
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}
		
		return listPersonal;
	}

	@Override
	public ArrayList<Personal> listBySpeciality(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
