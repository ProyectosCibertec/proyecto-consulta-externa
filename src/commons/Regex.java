package commons;

public class Regex {

	String value, regex;
	String phone = "[0-9]{9}";
	String email = "[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
	String weight = "[0-9]{1,3}$|^[0-9]{1,3}\\.[0-9]{1,2}$";
	String fullName = "^[a-zA-Z\\s]*$";

	public Regex() {
	}

	public Regex(String value, String regex) {
		this.value = value;
		this.regex = regex;
	}

	public boolean regexMatch(String value, String... regex) {
		String newRegex = regex.length > 0 ? regex[0] : "other";
		boolean isTrue = false;
		switch (newRegex) {
		case "phone":
			isTrue = value.matches(this.phone);
			break;
		case "email":
			isTrue = value.matches(this.email);
			break;
		case "decimal":
			isTrue = value.matches(this.weight);
			break;
		default:
			isTrue = value.matches(this.fullName);
			break;
		}
		return isTrue;
	}
}
