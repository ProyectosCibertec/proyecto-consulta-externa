package models;

import java.util.Date;

public class PersonalInput {
	private String idPersonalInput;
	private String hourInput;
	private Date dateInput;
	private String idPersonal;
	
	public PersonalInput() {

	}

	public PersonalInput(String idPersonalInput, String hourInput, Date dateInput, String idPersonal) {
		this.idPersonalInput = idPersonalInput;
		this.hourInput = hourInput;
		this.dateInput = dateInput;
		this.idPersonal = idPersonal;
	}

	public String getIdPersonalInput() {
		return idPersonalInput;
	}

	public void setIdPersonalInput(String idPersonalInput) {
		this.idPersonalInput = idPersonalInput;
	}

	public String getHourInput() {
		return hourInput;
	}

	public void setHourInput(String hourInput) {
		this.hourInput = hourInput;
	}

	public Date getDateInput() {
		return dateInput;
	}

	public void setDateInput(Date dateInput) {
		this.dateInput = dateInput;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
}
