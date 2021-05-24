package models;

public class MedicamentoProveedor {
	
   private int  id_medicamento_proveedor, cantidad_medicamento,lote_medicamento, id_medicamento, id_proveedor;               
    private String fecha_vencimiento ;
	
    public MedicamentoProveedor() {
	
	}
	public MedicamentoProveedor(int id_medicamento_proveedor, int cantidad_medicamento, int lote_medicamento,
			int id_medicamento, int id_proveedor, String fecha_vencimiento) {
		
		this.id_medicamento_proveedor = id_medicamento_proveedor;
		this.cantidad_medicamento = cantidad_medicamento;
		this.lote_medicamento = lote_medicamento;
		this.id_medicamento = id_medicamento;
		this.id_proveedor = id_proveedor;
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public int getId_medicamento_proveedor() {
		return id_medicamento_proveedor;
	}
	public void setId_medicamento_proveedor(int id_medicamento_proveedor) {
		this.id_medicamento_proveedor = id_medicamento_proveedor;
	}
	public int getCantidad_medicamento() {
		return cantidad_medicamento;
	}
	public void setCantidad_medicamento(int cantidad_medicamento) {
		this.cantidad_medicamento = cantidad_medicamento;
	}
	public int getLote_medicamento() {
		return lote_medicamento;
	}
	public void setLote_medicamento(int lote_medicamento) {
		this.lote_medicamento = lote_medicamento;
	}
	public int getId_medicamento() {
		return id_medicamento;
	}
	public void setId_medicamento(int id_medicamento) {
		this.id_medicamento = id_medicamento;
	}
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}             

}
