package models;

public class HistoriaPersonal {

	private int id_historia, id_personal;

	public HistoriaPersonal() {

	}

	public HistoriaPersonal(int id_historia, int id_personal) {

		this.id_historia = id_historia;
		this.id_personal = id_personal;
	}

	public int getId_historia() {
		return id_historia;
	}

	public void setId_historia(int id_historia) {
		this.id_historia = id_historia;
	}

	public int getId_personal() {
		return id_personal;
	}

	public void setId_personal(int id_personal) {
		this.id_personal = id_personal;
	}

}
