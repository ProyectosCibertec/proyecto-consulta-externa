package models;

public class Speciality {
	private String idSpeciality;
	private String specialityDescription;
	
	public Speciality() {
		
	}

	public Speciality(String idSpeciality, String specialityDescription) {
		this.idSpeciality = idSpeciality;
		this.specialityDescription = specialityDescription;
	}

	public String getIdSpeciality() {
		return idSpeciality;
	}

	public void setIdSpeciality(String idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

	public String getSpecialityDescription() {
		return specialityDescription;
	}

	public void setSpecialityDescription(String specialityDescription) {
		this.specialityDescription = specialityDescription;
	}
}
