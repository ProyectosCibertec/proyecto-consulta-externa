package models;

public class Medicamento {

	private int id_medicamento, id_estado_medicamento;
	private String nombre_medicamento, marca_medicamento;

	public Medicamento() {

	}

	public Medicamento(int id_medicamento, int id_estado_medicamento, String nombre_medicamento,
			String marca_medicamento) {

		this.id_medicamento = id_medicamento;
		this.id_estado_medicamento = id_estado_medicamento;
		this.nombre_medicamento = nombre_medicamento;
		this.marca_medicamento = marca_medicamento;
	}

	public int getId_medicamento() {
		return id_medicamento;
	}

	public void setId_medicamento(int id_medicamento) {
		this.id_medicamento = id_medicamento;
	}

	public int getId_estado_medicamento() {
		return id_estado_medicamento;
	}

	public void setId_estado_medicamento(int id_estado_medicamento) {
		this.id_estado_medicamento = id_estado_medicamento;
	}

	public String getNombre_medicamento() {
		return nombre_medicamento;
	}

	public void setNombre_medicamento(String nombre_medicamento) {
		this.nombre_medicamento = nombre_medicamento;
	}

	public String getMarca_medicamento() {
		return marca_medicamento;
	}

	public void setMarca_medicamento(String marca_medicamento) {
		this.marca_medicamento = marca_medicamento;
	}

}
