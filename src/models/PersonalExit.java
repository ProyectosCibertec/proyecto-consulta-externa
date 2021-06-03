package models;

public class PersonalExit {
	private String idPersonalExit;
	private String exitHour;
	private String exitDate;
	private String idPersonal;

	public PersonalExit() {

	}

	public PersonalExit(String idPersonalExit, String exitHour, String exitDate, String idPersonal) {
		this.idPersonalExit = idPersonalExit;
		this.exitHour = exitHour;
		this.exitDate = exitDate;
		this.idPersonal = idPersonal;
	}

	public String getIdPersonalExit() {
		return idPersonalExit;
	}

	public void setIdPersonalExit(String idPersonalExit) {
		this.idPersonalExit = idPersonalExit;
	}

	public String getExitHour() {
		return exitHour;
	}

	public void setExitHour(String exitHour) {
		this.exitHour = exitHour;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
}
