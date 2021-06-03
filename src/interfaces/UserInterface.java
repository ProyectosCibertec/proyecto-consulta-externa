package interfaces;

import models.*;

public interface UserInterface {

	public User validateAccess(String user, String pass);

	public int createUser(newUser u);

	public User getUser();
}
