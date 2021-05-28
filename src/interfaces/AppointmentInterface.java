package interfaces;

import models.Appointment;

public interface AppointmentInterface {
	public int add(Appointment appointment);
	public int update(Appointment appointment);
	public int delete(String id);
	public Appointment get(String id);
}
