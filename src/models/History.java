package models;

public class History {
	private String idHistory;
	private String idAppointment;
	
	public History() {
		super();
	}

	public History(String idHistory, String idAppointment) {
		this.idHistory = idHistory;
		this.idAppointment = idAppointment;
	}

	public String getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(String idHistory) {
		this.idHistory = idHistory;
	}

	public String getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(String idAppointment) {
		this.idAppointment = idAppointment;
	}
}
