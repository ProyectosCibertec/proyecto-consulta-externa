package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Personal;
import utils.MySQLConection;

public class PersonalManagement {

	public Personal verifyPersonal(String user) {
		Personal p = null;
		ResultSet result = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConection.getConexion();
			String sql = "SELECT * FROM personal WHERE id_personal = ?";

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
}
