package models;

public class ConsultingRoom {
	private String idConsultingRoom;
	private String privateRoomDescription;
	private String idPrivateRoomState;

	public ConsultingRoom() {

	}

	public ConsultingRoom(String idConsultingRoom, String privateRoomDescription, String idPrivateRoomState) {
		this.idConsultingRoom = idConsultingRoom;
		this.privateRoomDescription = privateRoomDescription;
		this.idPrivateRoomState = idPrivateRoomState;
	}

	public String getIdConsultingRoom() {
		return idConsultingRoom;
	}

	public void setIdConsultingRoom(String idConsultingRoom) {
		this.idConsultingRoom = idConsultingRoom;
	}

	public String getPrivateRoomDescription() {
		return privateRoomDescription;
	}

	public void setPrivateRoomDescription(String privateRoomDescription) {
		this.privateRoomDescription = privateRoomDescription;
	}

	public String getIdPrivateRoomState() {
		return idPrivateRoomState;
	}

	public void setIdPrivateRoomState(String idPrivateRoomState) {
		this.idPrivateRoomState = idPrivateRoomState;
	}
}
