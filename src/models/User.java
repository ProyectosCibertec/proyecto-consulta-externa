package models;

public class User {

	private String code, password, fecha_hora_creacion, fecha_hora_edicion;
	private int userType;

	public User() {

	}

	public User(String code) {
		this.code = code;
	}

	public User(String code, String password, int userType, String fecha_hora_creacion, String fecha_hora_edicion) {
		this.code = code;
		this.password = password;
		this.fecha_hora_creacion = fecha_hora_creacion;
		this.fecha_hora_edicion = fecha_hora_edicion;
	}

	public String getFecha_hora_creacion() {
		return fecha_hora_creacion;
	}

	public void setFecha_hora_creacion(String fecha_hora_creacion) {
		this.fecha_hora_creacion = fecha_hora_creacion;
	}

	public String getFecha_hora_edicion() {
		return fecha_hora_edicion;
	}

	public void setFecha_hora_edicion(String fecha_hora_edicion) {
		this.fecha_hora_edicion = fecha_hora_edicion;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
