package maintenance;

import utils.MySQLConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.MedicationInterface;
import models.Medication;

public class MedicationManagement implements MedicationInterface {

	@Override
	public Medication get(int codigo) {
		Medication m = null;
		Connection con = null;
		PreparedStatement pst = null;

		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "select * from medicamento  where  id_medicamento = ?";
			pst = con.prepareStatement(sql);
			pst = con.prepareStatement(sql);
			pst.setInt(1, m.getId_medicamento());
			rs = pst.executeQuery();
			if (rs.next()) {
				m = new Medication(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar:" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return null;
	}
}
