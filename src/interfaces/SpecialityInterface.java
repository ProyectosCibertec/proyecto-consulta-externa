package interfaces;

import java.util.ArrayList;

import models.Speciality;

public interface SpecialityInterface {
	public int addSpeciality(String specialityT);
	public ArrayList<Speciality> listSpeciality();
	public int removeSpeciality(int idSpeciality);
}
