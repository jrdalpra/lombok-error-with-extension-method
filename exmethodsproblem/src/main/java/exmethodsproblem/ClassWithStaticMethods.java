package exmethodsproblem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.SneakyThrows;

public class ClassWithStaticMethods {

	private static final DateFormat DEFAULT_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy");

	public static boolean isNull(Object object) {
		return object == null;
	}

	public static String asString(Object object) {
		return isNull(object) ? "" : object.toString();
	}

	public static Date asDate(Object object) {
		return asDate(object, DEFAULT_FORMATTER);
	}

	@SneakyThrows
	public static Date asDate(Object object, DateFormat formatter) {
		return isNull(object) ? null : formatter.parse(asString(object));
	}

}
