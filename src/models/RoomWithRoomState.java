package models;

public class RoomWithRoomState {
	private String idConsultingRoom;
	private String privateRoomDescription;
	private String idRoomState;
	private String roomStateDescription;
	
	public RoomWithRoomState() {

	}

	public RoomWithRoomState(String idConsultingRoom, String privateRoomDescription, String idRoomState,
			String roomStateDescription) {
		this.idConsultingRoom = idConsultingRoom;
		this.privateRoomDescription = privateRoomDescription;
		this.idRoomState = idRoomState;
		this.roomStateDescription = roomStateDescription;
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

	public String getIdRoomState() {
		return idRoomState;
	}

	public void setIdRoomState(String idRoomState) {
		this.idRoomState = idRoomState;
	}

	public String getRoomStateDescription() {
		return roomStateDescription;
	}

	public void setRoomStateDescription(String roomStateDescription) {
		this.roomStateDescription = roomStateDescription;
	}
}
