package models;

public class Formula {
	private String idFormula;
	private String idPatient;
	private String idPersonal;
	
	public Formula() {

	}

	public Formula(String idFormula, String idPatient, String idPersonal) {
		this.idFormula = idFormula;
		this.idPatient = idPatient;
		this.idPersonal = idPersonal;
	}

	public String getIdFormula() {
		return idFormula;
	}

	public void setIdFormula(String idFormula) {
		this.idFormula = idFormula;
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
