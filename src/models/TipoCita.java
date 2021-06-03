package models;

public class TipoCita {

	private int id_tipo_cita;
	private String descripcion_tipo_cita;

	public TipoCita() {
	}

	public TipoCita(int id_tipo_cita, String descripcion_tipo_cita) {
		this.id_tipo_cita = id_tipo_cita;
		this.descripcion_tipo_cita = descripcion_tipo_cita;
	}

	public int getId_tipo_cita() {
		return id_tipo_cita;
	}

	public void setId_tipo_cita(int id_tipo_cita) {
		this.id_tipo_cita = id_tipo_cita;
	}

	public String getDescripcion_tipo_cita() {
		return descripcion_tipo_cita;
	}

	public void setDescripcion_tipo_cita(String descripcion_tipo_cita) {
		this.descripcion_tipo_cita = descripcion_tipo_cita;
	}

}
