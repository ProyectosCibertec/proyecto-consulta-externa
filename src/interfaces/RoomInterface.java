package interfaces;

import java.util.ArrayList;

import models.Room;

public interface RoomInterface {
	public int addRoom(Room room);
	public ArrayList<Room> listRoom();
	public int removeRoom(String idRoom);
	public int updateRoom(Room room);
}
