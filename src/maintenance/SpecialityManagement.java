package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.SpecialityInterface;
import models.Speciality;
import utils.MySQLConection;

public class SpecialityManagement implements SpecialityInterface {

	@Override
	public ArrayList<Speciality> listSpeciality() {
		ArrayList<Speciality> listSpeciality = new ArrayList<Speciality>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			final String SQL = "{CALL usp_listSpeciality()}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			result = pst.executeQuery();
			while (result.next()) {
				listSpeciality.add(new Speciality(	result.getString(1),
													result.getString(2)));
			}
		} catch (Exception e) {
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

		return listSpeciality;
	}

	@Override
	public int addSpeciality(String specialityT) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "{CALL usp_addSpeciality(?)}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, specialityT);
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
	public int removeSpeciality(int idSpeciality) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "DELETE FROM especialidad WHERE id_estado_personal = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setInt(1, idSpeciality);
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

}
