package fr.ftravaglia.demo.mokitoinjection.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Use reflexion for change value of attribut.
 * @author ftravaglia
 *
 */
public class InjectionHelper {

	/**
	 * Set 'newFieldValue' as value for the field 'fieldName' on the object 'object'.
	 * 
	 * @param object
	 * @param fieldName
	 * @param newFieldValue
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void setField(Object object, String fieldName, Object newFieldValue) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Field field = object.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);

		// Use for modify the final attribut
		final Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(object, newFieldValue);
	}
}
