package interfaces;

import models.Patient;

public interface PatientInterface {
	public int add(Patient patient);
	public int update(Patient patient);
	public int delete(String id);
	public Patient get(String id);
}
