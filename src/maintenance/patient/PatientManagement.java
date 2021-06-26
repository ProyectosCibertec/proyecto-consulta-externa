package maintenance.patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.patient.PatientInterface;
import models.patient.Patient;
import models.patient.PatienteType;
import utils.MySQLConection;

public class PatientManagement implements PatientInterface {

	@Override
	public int register(Patient P) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,null)";
			pst = con.prepareStatement(sql);
			pst.setString(1, P.getId());
			pst.setString(2, P.getName());
			pst.setString(3, P.getLastName());
			pst.setString(4, P.getAddress());
			pst.setString(5, P.getBirthDate());
			pst.setString(6, P.getDeathDate());
			pst.setString(7, P.getTelephone());
			pst.setInt(8, P.getIdSex());
			pst.setDouble(9, P.getHeight());
			pst.setDouble(10, P.getWeight());
			pst.setInt(11, P.getDistrit());
			pst.setString(12, P.getDateCreation());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al register(): " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int update(Patient P) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_patient_update(?,?,?,?,?,?,?,?,?,?,?)}";
			pst.setString(1, P.getId());
			pst.setString(2, P.getName());
			pst.setString(3, P.getLastName());
			pst.setString(4, P.getAddress());
			pst.setString(5, P.getBirthDate());
			pst.setString(6, P.getDeathDate());
			pst.setString(7, P.getTelephone());
			pst.setInt(8, P.getIdSex());
			pst.setDouble(9, P.getHeight());
			pst.setDouble(10, P.getWeight());
			pst.setInt(11, P.getDistrit());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en update(): " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int delete(String id) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "delete from paciente where id_paciente=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, id);
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en delete()" + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public Patient codeGenerate() {
		Patient p = null;
		String code = "PAC0000001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try {
			con = MySQLConection.getConexion();

			String sql = "SELECT SUBSTRING(MAX(id_paciente),4) FROM paciente;";

			pst = con.prepareStatement(sql);

			result = pst.executeQuery();

			if (result.next()) {
				code = String.format("PAC%07d", result.getInt(1) + 1);
				p = new Patient(code);
			}

		} catch (Exception e) {
			System.out.println("Error en codeGenerate(): " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar : " + e2.getMessage());
			}
		}

		return p;
	}

	@Override
	public PatienteType getById(String code) {
		PatienteType pt = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{CALL usp_patient_list_by_id(?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, code);

			rs = pst.executeQuery();
			while (rs.next()) {
				pt = new PatienteType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9),
						rs.getDouble(10), rs.getString(11), rs.getString(12));
			}

		} catch (Exception e) {
			System.out.println("Error al getById(): " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}

		return pt;
	}

	@Override
	public ArrayList<PatienteType> listAll() {
		ArrayList<PatienteType> list = new ArrayList<PatienteType>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_patient_list_all()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new PatienteType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9),
						rs.getDouble(10), rs.getString(11), rs.getString(12)));
			}

		} catch (Exception e) {
			System.out.println("Error en listAll(): " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public ArrayList<PatienteType> getByName(String name) {
		ArrayList<PatienteType> list = new ArrayList<PatienteType>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_patient_list_by_name(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, name);

			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new PatienteType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9),
						rs.getDouble(10), rs.getString(11), rs.getString(12)));
			}

		} catch (Exception e) {
			System.out.println("Error en listAll(): " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return list;
	}

	@Override
	public ArrayList<PatienteType> getByDate(String start, String end) {
		String endDate = end != null ? end : start;

		ArrayList<PatienteType> list = new ArrayList<PatienteType>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConection.getConexion();
			String sql = "{call usp_patient_list_by_date(?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, start);
			pst.setString(2, endDate);

			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new PatienteType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9),
						rs.getDouble(10), rs.getString(11), rs.getString(12)));
			}

		} catch (Exception e) {
			System.out.println("Error en listAll(): " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar:" + e.getMessage());
			}
		}
		return list;
	}

}
