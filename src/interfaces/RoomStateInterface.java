package interfaces;

import java.util.ArrayList;

import models.RoomState;

public interface RoomStateInterface {
	public int addRoomState(String RoomStateT);
	public ArrayList<RoomState> listRoomState();
	public int removeRoomState(int idRoomState);
}
