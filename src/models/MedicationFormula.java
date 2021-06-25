package models;

public class MedicationFormula {
	private String idFormula;
	private String idMedication;
	private int medicationFormulaQuantity;
	
	public MedicationFormula() {
	
	}

	public MedicationFormula(String idFormula, String idMedication, int medicationFormulaQuantity) {
		this.idFormula = idFormula;
		this.idMedication = idMedication;
		this.medicationFormulaQuantity = medicationFormulaQuantity;
	}

	public String getIdFormula() {
		return idFormula;
	}

	public void setIdFormula(String idFormula) {
		this.idFormula = idFormula;
	}

	public String getIdMedication() {
		return idMedication;
	}

	public void setIdMedication(String idMedication) {
		this.idMedication = idMedication;
	}

	public int getMedicationFormulaQuantity() {
		return medicationFormulaQuantity;
	}

	public void setMedicationFormulaQuantity(int medicationFormulaQuantity) {
		this.medicationFormulaQuantity = medicationFormulaQuantity;
	}
}
