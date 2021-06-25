package interfaces;

import java.util.ArrayList;

import models.MedicationState;

public interface MedicationStateInterface {
	public int addMedicationState(String MedicationStateT);
	public ArrayList<MedicationState> listMedicationState();
	public int removeMedicationState(int idMedicationState);
}
