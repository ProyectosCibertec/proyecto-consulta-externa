package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.MedicationStateInterface;
import models.MedicationState;
import models.MedicationState;
import utils.MySQLConection;

public class MedicationStateManagement implements MedicationStateInterface {

	@Override
	public int addMedicationState(String MedicationStateT) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "{CALL usp_addMedicationState(?)}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, MedicationStateT);
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
	public ArrayList<MedicationState> listMedicationState() {
		ArrayList<MedicationState> listMedicationState = new ArrayList<MedicationState>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			final String SQL = "{CALL usp_listMedicationState()}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			result = pst.executeQuery();
			while (result.next()) {
				listMedicationState.add(new MedicationState(result.getString(1),
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

		return listMedicationState;
	}

	@Override
	public int removeMedicationState(int idMedicationState) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "DELETE FROM estado_medicamento WHERE id_estado_medicamento = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setInt(1, idMedicationState);
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
