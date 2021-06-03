package interfaces;

import models.*;

public interface UserInterface {

	public User validateAccess(String user, String pass);

	public int createUser(NewUser u);

	public User getUser();
}
