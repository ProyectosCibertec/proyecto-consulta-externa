package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.RoomStateInterface;
import models.RoomState;
import utils.MySQLConection;

public class RoomStateManagement implements RoomStateInterface {

	@Override
	public int addRoomState(String RoomStateT) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "{CALL usp_addRoomState(?)}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, RoomStateT);
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
	public ArrayList<RoomState> listRoomState() {
		ArrayList<RoomState> listRoomState = new ArrayList<RoomState>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			final String SQL = "{CALL usp_listRoomState()}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			result = pst.executeQuery();
			while (result.next()) {
				listRoomState.add(new RoomState(result.getString(1),
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

		return listRoomState;
	}

	@Override
	public int removeRoomState(int idRoomState) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "DELETE FROM estado_consultorio WHERE id_estado_consultorio = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setInt(1, idRoomState);
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

}
