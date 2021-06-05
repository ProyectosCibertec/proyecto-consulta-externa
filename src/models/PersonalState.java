package models;

public class PersonalState {
	private String idPersonalState;
	private String personalStateDescription;
	
	public PersonalState() {
		
	}

	public PersonalState(String idPersonalState, String personalStateDescription) {
		this.idPersonalState = idPersonalState;
		this.personalStateDescription = personalStateDescription;
	}

	public String getIdPersonalState() {
		return idPersonalState;
	}

	public void setIdPersonalState(String idPersonalState) {
		this.idPersonalState = idPersonalState;
	}

	public String getPersonalStateDescription() {
		return personalStateDescription;
	}

	public void setPersonalStateDescription(String personalStateDescription) {
		this.personalStateDescription = personalStateDescription;
	}
}
