package util;

public class ErrorFactory {
	
	private ErrorFactory() {}
	
	public static String produceError(Class<?> cls, String reason, long id) {
		return "Error : " + reason + "( " + cls.getName() + ", " + id + " )";
	}
}
