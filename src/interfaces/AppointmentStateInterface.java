package interfaces;

import java.util.ArrayList;

import models.AppointmentState;

public interface AppointmentStateInterface {
		public int addAppointmentState(String appointmentStateT);
		public ArrayList<AppointmentState> listAppointmentState();
		public int removeAppointmentState(int idAppointmentState);
}
