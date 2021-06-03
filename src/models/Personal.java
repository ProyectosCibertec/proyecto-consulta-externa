package models;

public class Personal {
	private String idPersonal;
	private String personalName;
	private String personalPhone;
	private String personalDirection;
	private String personalEmail;
	private String emergencyPhone;
	private String birthDate;
	private int idUsuario;
	private String idSpecialty;
	private String idPersonalState;

	public Personal() {

	}

	public Personal(String idPersonal, String personalName, String personalPhone, String personalDirection,
			String personalEmail, String emergencyPhone, String birthDate, int idUsuario, String idSpecialty,
			String idPersonalState) {
		this.idPersonal = idPersonal;
		this.personalName = personalName;
		this.personalPhone = personalPhone;
		this.personalDirection = personalDirection;
		this.personalEmail = personalEmail;
		this.emergencyPhone = emergencyPhone;
		this.birthDate = birthDate;
		this.idUsuario = idUsuario;
		this.idSpecialty = idSpecialty;
		this.idPersonalState = idPersonalState;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	public String getPersonalDirection() {
		return personalDirection;
	}

	public void setPersonalDirection(String personalDirection) {
		this.personalDirection = personalDirection;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdSpecialty() {
		return idSpecialty;
	}

	public void setIdSpecialty(String idSpecialty) {
		this.idSpecialty = idSpecialty;
	}

	public String getIdPersonalState() {
		return idPersonalState;
	}

	public void setIdPersonalState(String idPersonalState) {
		this.idPersonalState = idPersonalState;
	}
}
