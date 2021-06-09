package models;

public class AppointmentType {
	private String idAppointmentType;
	private String appointmentTypeDescription;
	
	public AppointmentType() {
	
	}

	public AppointmentType(String idAppointmentType, String appointmentTypeDescription) {
		this.idAppointmentType = idAppointmentType;
		this.appointmentTypeDescription = appointmentTypeDescription;
	}

	public String getIdAppointmentType() {
		return idAppointmentType;
	}

	public void setIdAppointmentType(String idAppointmentType) {
		this.idAppointmentType = idAppointmentType;
	}

	public String getAppointmentTypeDescription() {
		return appointmentTypeDescription;
	}

	public void setAppointmentTypeDescription(String appointmentTypeDescription) {
		this.appointmentTypeDescription = appointmentTypeDescription;
	}
}
