package Yarns;

public class YarnEncriptKey extends Thread {
	private String password;

	public YarnEncriptKey() {

	}

	public YarnEncriptKey(String password) {
		this.password = password;
	}

	public String encript() {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");

			byte[] array = md.digest(password.getBytes());

			StringBuffer sb = new StringBuffer();
			for (byte element : array) {
				sb.append(Integer.toHexString((element & 0Xff) | 0X100).substring(1, 3));
			}

			return sb.toString();

		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Error to create encript password -> " + e.getMessage());
		}
		return null;
	}
}
