package interfaces;

import java.util.ArrayList;

import models.Personal;

public interface PersonalInterface {
	public int addPersonal(Personal personal);

	public int updatePersonal(Personal personal);

	public int deletePersonal(String id);

	public Personal getPersonal(String id);

	public Personal getPersonalWithUser(String user);

	public ArrayList<Personal> listByPersonalState(String id);

	public ArrayList<Personal> listBySpeciality(String id);

	public Personal verify(String user);
	
	public ArrayList<Personal> listPersonalByName(String name);
}
