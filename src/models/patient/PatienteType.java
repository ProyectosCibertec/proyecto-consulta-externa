package models.patient;

public class PatienteType {
	private String id, name, lastName, address, birthDate, deathDate, telephone, sex, dateCreation, distrito;
	private double weight, height;

	public PatienteType() {
	}

	public PatienteType(String id, String name, String lastName, String address, String birthDate, String deathDate,
			String telephone, String sex, double weight, double height, String distrito, String dateCreation) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.telephone = telephone;
		this.sex = sex;
		this.dateCreation = dateCreation;
		this.distrito = distrito;
		this.weight = weight;
		this.height = height;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
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

}
