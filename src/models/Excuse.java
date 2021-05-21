package models;

public class Excuse {

	private String idExcuse;
	private String excuseDescription;
	private String creationDate;
	private String idPatient;
	private String idPersonal;
	
	public Excuse() {

	}

	public Excuse(String idExcuse, String excuseDescription, String creationDate, String idPatient, String idPersonal) {
		this.idExcuse = idExcuse;
		this.excuseDescription = excuseDescription;
		this.creationDate = creationDate;
		this.idPatient = idPatient;
		this.idPersonal = idPersonal;
	}

	public String getIdExcuse() {
		return idExcuse;
	}

	public void setIdExcuse(String idExcuse) {
		this.idExcuse = idExcuse;
	}

	public String getExcuseDescription() {
		return excuseDescription;
	}

	public void setExcuseDescription(String excuseDescription) {
		this.excuseDescription = excuseDescription;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
}
