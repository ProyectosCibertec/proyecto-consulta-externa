package interfaces;

import models.Personal;

public interface PersonalInterface {

	public Personal verify(String user);

	public int add(Personal personal);

	public int update(Personal personal);

	public int delete(String id);

	public Personal get(String id);

}
