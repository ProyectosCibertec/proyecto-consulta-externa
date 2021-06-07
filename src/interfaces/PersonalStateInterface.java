package interfaces;

import java.util.ArrayList;

import models.PersonalState;

public interface PersonalStateInterface {
	public int addPersonalState(String personalStateT);
	public ArrayList<PersonalState> listPersonalState();
	public int removePersonalState(int idPersonalState);
}
