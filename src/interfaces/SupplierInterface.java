package interfaces;

import models.Supplier;

public interface SupplierInterface {
	public int add(Supplier supplier);
	public int update(Supplier supplier);
	public int delete(String id);
	public Supplier get(String id);
}
