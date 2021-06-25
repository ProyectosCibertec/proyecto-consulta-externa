package models;

public class Supplier {

	private String id_supplier, name_supplier, contact_supplier, direction_supplier, phone_supplier, email_supplier;

	public Supplier() {

	}

	public Supplier(String id_supplier) {
		this.id_supplier = id_supplier;
	}

	public Supplier(String id_supplier, String name_supplier, String contact_supplier, String direction_supplier,
			String phone_supplier, String email_supplier) {

		this.id_supplier = id_supplier;
		this.name_supplier = name_supplier;
		this.contact_supplier = contact_supplier;
		this.direction_supplier = direction_supplier;
		this.phone_supplier = phone_supplier;
		this.email_supplier = email_supplier;
	}

	public String getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(String id_supplier) {
		this.id_supplier = id_supplier;
	}

	public String getName_supplier() {
		return name_supplier;
	}

	public void setName_supplier(String name_supplier) {
		this.name_supplier = name_supplier;
	}

	public String getContact_supplier() {
		return contact_supplier;
	}

	public void setContact_supplier(String contact_supplier) {
		this.contact_supplier = contact_supplier;
	}

	public String getDirection_supplier() {
		return direction_supplier;
	}

	public void setDirection_supplier(String direction_supplier) {
		this.direction_supplier = direction_supplier;
	}

	public String getPhone_supplier() {
		return phone_supplier;
	}

	public void setPhone_supplier(String phone_supplier) {
		this.phone_supplier = phone_supplier;
	}

	public String getEmail_supplier() {
		return email_supplier;
	}

	public void setEmail_supplier(String email_supplier) {
		this.email_supplier = email_supplier;
	}

}
