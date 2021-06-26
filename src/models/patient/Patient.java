package models.patient;

public class Patient {

	private String id, name, lastName, address, birthDate, deathDate, telephone, dateCreation, dateUpdate;
	private int idSex, distrit;
	private double weight, height;

	public Patient() {
	}

	public Patient(String id) {
		this.id = id;
	}

	public Patient(String id, String name, String lastName, String address, String birthDate, String deathDate,
			String telephone, int idSex, double weight, double height, int distrit, String dateCreation,
			String dateUpdate) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.telephone = telephone;
		this.idSex = idSex;
		this.weight = weight;
		this.height = height;
		this.distrit = distrit;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getIdSex() {
		return idSex;
	}

	public void setIdSex(int idSex) {
		this.idSex = idSex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getDistrit() {
		return distrit;
	}

	public void setDistrit(int distrit) {
		this.distrit = distrit;
	}
}
