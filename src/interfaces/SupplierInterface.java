package interfaces;

import java.util.ArrayList;
import models.Supplier;

public interface SupplierInterface {

	public int register(Supplier S);

	public int delete(String idSupplier);

	public int edit(Supplier S);

	public Supplier search(String IDSupplier);

	public Supplier searchName(String Name);

	public ArrayList<Supplier> listSupplier();

	public ArrayList<Supplier> supplierListByName(String name);

	public Supplier supplierCodeGenerate();
}
