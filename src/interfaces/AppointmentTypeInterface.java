package interfaces;

import java.util.ArrayList;

import models.AppointmentType;

public interface AppointmentTypeInterface {
	public int addAppointmentType(String appointmentTypeT);
	public ArrayList<AppointmentType> listAppointmentType();
	public int removeAppointmentType(int idAppointmentType);
}
