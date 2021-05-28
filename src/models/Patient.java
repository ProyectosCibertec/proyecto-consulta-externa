package models;
public class Patient {

	private String idPatient;
	private String patientName;
	private String patientLastName;
	private String patientDirection;
	private String birthDate;
	private String deathDate;
	private String patientPhone;
	private String patientSex;
	private String patientPassword;
	private String idDistrict;
	private Float patientHeight;
	private Float patientWeight;
	
	public Patient() {
		
	}

	public Patient(String idPatient, String patientName, String patientLastName, String patientDirection,
			String birthDate, String deathDate, String patientPhone, String patientSex, String patientPassword,
			String idDistrict, Float patientHeight, Float patientWeight) {
		this.idPatient = idPatient;
		this.patientName = patientName;
		this.patientLastName = patientLastName;
		this.patientDirection = patientDirection;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.patientPhone = patientPhone;
		this.patientSex = patientSex;
		this.patientPassword = patientPassword;
		this.idDistrict = idDistrict;
		this.patientHeight = patientHeight;
		this.patientWeight = patientWeight;
	}

	public String getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientDirection() {
		return patientDirection;
	}

	public void setPatientDirection(String patientDirection) {
		this.patientDirection = patientDirection;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(String idDistrict) {
		this.idDistrict = idDistrict;
	}

	public Float getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(Float patientHeight) {
		this.patientHeight = patientHeight;
	}

	public Float getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(Float patientWeight) {
		this.patientWeight = patientWeight;
	}
}
