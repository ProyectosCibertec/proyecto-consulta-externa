package models;

public class RoomState {
	private String idRoomState;
	private String roomStateDescription;
	
	public RoomState() {

	}

	public RoomState(String idRoomState, String roomStateDescription) {
		this.idRoomState = idRoomState;
		this.roomStateDescription = roomStateDescription;
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
