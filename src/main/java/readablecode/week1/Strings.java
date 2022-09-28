package readablecode.week1;

public class Strings {

	public static String capitalize(String str) {
		String ret = str;
		if (ret == null || ret.length() == 0) {
			return ret;
		}
		if (ret.length() == 1) {
			return ret.toUpperCase();
		}
		return ret.substring(0, 1).toUpperCase() + ret.substring(1);
	}
}