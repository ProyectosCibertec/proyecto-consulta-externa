package interfaces;

import java.util.ArrayList;

import models.Personal;

public interface PersonalInterface {
<<<<<<< HEAD
	public int addPersonal(Personal personal);
	public int updatePersonal(Personal personal);
	public int deletePersonal(String id);
	public Personal getPersonal(String id);
	public ArrayList<Personal> listByPersonalState(String id);
	public ArrayList<Personal> listBySpeciality(String id);
=======

	public Personal verify(String user);

	public int add(Personal personal);

	public int update(Personal personal);

	public int delete(String id);

	public Personal get(String id);

>>>>>>> b1901dc7890f2fb832d3dffdd6fe26d18d07612d
}
