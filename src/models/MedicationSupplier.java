package models;

import java.util.Date;

public class MedicationSupplier {
	private String idMedicationSupplier;
	private int medicationQuantity;
	private String medicationLot;
	private Date expirationDate;
	private String idMedication;
	private String idSupplier;
	
	public MedicationSupplier() {

	}

	public MedicationSupplier(String idMedicationSupplier, int medicationQuantity, String medicationLot,
			Date expirationDate, String idMedication, String idSupplier) {
		super();
		this.idMedicationSupplier = idMedicationSupplier;
		this.medicationQuantity = medicationQuantity;
		this.medicationLot = medicationLot;
		this.expirationDate = expirationDate;
		this.idMedication = idMedication;
		this.idSupplier = idSupplier;
	}

	public String getIdMedicationSupplier() {
		return idMedicationSupplier;
	}

	public void setIdMedicationSupplier(String idMedicationSupplier) {
		this.idMedicationSupplier = idMedicationSupplier;
	}

	public int getMedicationQuantity() {
		return medicationQuantity;
	}

	public void setMedicationQuantity(int medicationQuantity) {
		this.medicationQuantity = medicationQuantity;
	}

	public String getMedicationLot() {
		return medicationLot;
	}

	public void setMedicationLot(String medicationLot) {
		this.medicationLot = medicationLot;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getIdMedication() {
		return idMedication;
	}

	public void setIdMedication(String idMedication) {
		this.idMedication = idMedication;
	}

	public String getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}
}
