package models;

public class PatientAndPersonalHistory {

	private int id_historia, id_cita;

	public PatientAndPersonalHistory() {
	}

	public PatientAndPersonalHistory(int id_historia, int id_cita) {
		this.id_historia = id_historia;
		this.id_cita = id_cita;
	}

	public int getId_historia() {
		return id_historia;
	}

	public void setId_historia(int id_historia) {
		this.id_historia = id_historia;
	}

	public int getId_cita() {
		return id_cita;
	}

	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}

}
