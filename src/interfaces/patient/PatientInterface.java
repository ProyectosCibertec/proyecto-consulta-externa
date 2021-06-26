package interfaces.patient;

import java.util.ArrayList;

import models.patient.Patient;
import models.patient.PatienteType;

public interface PatientInterface {

	public int register(Patient P);

	public int update(Patient P);

	public int delete(String id);

	public Patient codeGenerate();

	public PatienteType getById(String code);

	public ArrayList<PatienteType> listAll();

	public ArrayList<PatienteType> getByName(String name);

	public ArrayList<PatienteType> getByDate(String start, String end);
}
