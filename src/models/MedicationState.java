package models;

public class MedicationState {
	private String idMedicationState;
	private String medicationStateDescription;
	
	public MedicationState() {

	}

	public MedicationState(String idMedicationState, String medicationStateDescription) {
		this.idMedicationState = idMedicationState;
		this.medicationStateDescription = medicationStateDescription;
	}

	public String getIdMedicationState() {
		return idMedicationState;
	}

	public void setIdMedicationState(String idMedicationState) {
		this.idMedicationState = idMedicationState;
	}

	public String getMedicationStateDescription() {
		return medicationStateDescription;
	}

	public void setMedicationStateDescription(String medicationStateDescription) {
		this.medicationStateDescription = medicationStateDescription;
	}
}
