package models;

public class Appointment {
	private String idAppointment;
	private String creationDate;
	private String idPatient;
	private String idAppointmentType;
	private String idAppointmentState;
	private String idConsultingRoom;
	private String idPersonal;

	public Appointment() {

	}

	public Appointment(String idAppointment, String creationDate, String idPatient, String idAppointmentType,
			String idAppointmentState, String idConsultingRoom, String idPersonal) {
		this.idAppointment = idAppointment;
		this.creationDate = creationDate;
		this.idPatient = idPatient;
		this.idAppointmentType = idAppointmentType;
		this.idAppointmentState = idAppointmentState;
		this.idConsultingRoom = idConsultingRoom;
		this.idPersonal = idPersonal;
	}

	public String getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(String idAppointment) {
		this.idAppointment = idAppointment;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	public String getIdAppointmentType() {
		return idAppointmentType;
	}

	public void setIdAppointmentType(String idAppointmentType) {
		this.idAppointmentType = idAppointmentType;
	}

	public String getIdAppointmentState() {
		return idAppointmentState;
	}

	public void setIdAppointmentState(String idAppointmentState) {
		this.idAppointmentState = idAppointmentState;
	}

	public String getIdConsultingRoom() {
		return idConsultingRoom;
	}

	public void setIdConsultingRoom(String idConsultingRoom) {
		this.idConsultingRoom = idConsultingRoom;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
}
