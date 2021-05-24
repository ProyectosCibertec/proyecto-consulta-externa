package models;

public class AppointmentState {
	private String appointmentState;
	private String appointmentStateDescription;
	
	public AppointmentState() {
		
	}

	public AppointmentState(String appointmentState, String appointmentStateDescription) {
		this.appointmentState = appointmentState;
		this.appointmentStateDescription = appointmentStateDescription;
	}

	public String getAppointmentState() {
		return appointmentState;
	}

	public void setAppointmentState(String appointmentState) {
		this.appointmentState = appointmentState;
	}

	public String getAppointmentStateDescription() {
		return appointmentStateDescription;
	}

	public void setAppointmentStateDescription(String appointmentStateDescription) {
		this.appointmentStateDescription = appointmentStateDescription;
	}
}
