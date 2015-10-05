package exmethodsproblem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.experimental.ExtensionMethod;

@ExtensionMethod(value = { ClassWithStaticMethods.class }, suppressBaseMethods = false)
public class ClassThatUsesTheExtensionMethodThatWorksFine {

	private static Convert<Date, String> getAnonymousClass() {
		return new Convert<Date, String>() {

			public String process(Date from) {

				System.out.println("01/01/2015".asDate());
				System.out.println(Boolean.TRUE.asDate());

				parseToUtilDate(from);

				return from.toString();
			}

			private java.util.Date parseToUtilDate(Object date) {
				try {
					return isNullOrEmpty(date) ? null : date.asDate();
				} catch (Exception e) {
					return null;
				}
			}

			private boolean isNullOrEmpty(Object date) {
				return date.isNull() || date.asString().isEmpty();
			}
		};
	}
}
