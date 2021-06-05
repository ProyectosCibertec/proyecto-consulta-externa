package models;

public class AppointmentState {
	private String idAppointmentState;
	private String appointmentStateDescription;
	
	public AppointmentState() {
		
	}

	public AppointmentState(String idAppointmentState, String appointmentStateDescription) {
		this.idAppointmentState = idAppointmentState;
		this.appointmentStateDescription = appointmentStateDescription;
	}

	public String getIdAppointmentState() {
		return idAppointmentState;
	}

	public void setIdAppointmentState(String idAppointmentState) {
		this.idAppointmentState = idAppointmentState;
	}

	public String getAppointmentStateDescription() {
		return appointmentStateDescription;
	}

	public void setAppointmentStateDescription(String appointmentStateDescription) {
		this.appointmentStateDescription = appointmentStateDescription;
	}
}
