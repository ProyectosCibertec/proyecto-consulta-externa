package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.AppointmentStateInterface;
import models.AppointmentState;
import utils.MySQLConection;

public class AppointmentStateManagement implements AppointmentStateInterface {

	@Override
	public int addAppointmentState(String appointmentStateT) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "{CALL usp_addAppointmentState(?)}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, appointmentStateT);
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
	public ArrayList<AppointmentState> listAppointmentState() {
		ArrayList<AppointmentState> listAppointmentState = new ArrayList<AppointmentState>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			final String SQL = "{CALL usp_listAppointmentState()}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			result = pst.executeQuery();
			while (result.next()) {
				listAppointmentState.add(new AppointmentState(result.getString(1),
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

		return listAppointmentState;
	}

	@Override
	public int removeAppointmentState(int idAppointmentState) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "DELETE FROM estado_cita WHERE id_estado_cita = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setInt(1, idAppointmentState);
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
