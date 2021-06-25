package interfaces;

import models.*;

public interface UserInterface {

	public User validateAccess(String user, String pass);

	public User userExists(String user);

	public int userCreate(NewUser u);

	public User userGenerate();

	public int changedUserPassword(User u);
}
