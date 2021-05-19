package models;

public class ConsultingRoomState {
	private String idConsultingRoomState;
	private String consultingRoomStateDescription;
	
	public ConsultingRoomState() {

	}

	public ConsultingRoomState(String idConsultingRoomState, String consultingRoomStateDescription) {
		this.idConsultingRoomState = idConsultingRoomState;
		this.consultingRoomStateDescription = consultingRoomStateDescription;
	}

	public String getIdConsultingRoomState() {
		return idConsultingRoomState;
	}

	public void setIdConsultingRoomState(String idConsultingRoomState) {
		this.idConsultingRoomState = idConsultingRoomState;
	}

	public String getConsultingRoomStateDescription() {
		return consultingRoomStateDescription;
	}

	public void setConsultingRoomStateDescription(String consultingRoomStateDescription) {
		this.consultingRoomStateDescription = consultingRoomStateDescription;
	}
}
