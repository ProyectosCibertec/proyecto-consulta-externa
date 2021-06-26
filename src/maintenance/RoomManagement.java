package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.RoomInterface;
import models.Room;
import utils.MySQLConection;

public class RoomManagement implements RoomInterface {

	@Override
	public int addRoom(Room room) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "{CALL usp_addRoom(?, ?, ?)}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, room.getIdConsultingRoom());
			pst.setString(2, room.getPrivateRoomDescription());
			pst.setString(3, room.getIdPrivateRoomState());
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
	public ArrayList<Room> listRoom() {
		ArrayList<Room> listRoom = new ArrayList<Room>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			final String SQL = "{CALL usp_listRoom()}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			result = pst.executeQuery();
			while (result.next()) {
				listRoom.add(new Room(result.getString(1), result.getString(2), result.getString(3)));
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

		return listRoom;
	}

	@Override
	public int removeRoom(String idRoom) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "DELETE FROM consultorio WHERE id_consultorio = ?";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, idRoom);
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
	public int updateRoom(Room room) {
		int result = 0;

		// template
		Connection con = null;
		PreparedStatement pst = null;

		try {
			final String SQL = "{CALL usp_updateRoom(?, ?, ?)}";
			con = MySQLConection.getConexion();
			pst = con.prepareStatement(SQL);

			pst.setString(1, room.getIdConsultingRoom());
			pst.setString(2, room.getPrivateRoomDescription());
			pst.setString(3, room.getIdPrivateRoomState());
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
