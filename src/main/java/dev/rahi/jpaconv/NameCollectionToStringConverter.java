package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Collection;


/**
 * Convert any collection (array, list) of complex string (which may contain COMMA) to SEMI-COLON separated string and vice-versa.
 * 
 * @author Imtiaz Rahi
 * @since 2021-01-07
 * @see CollectionToStringConverter
 */
@Converter
public class NameCollectionToStringConverter implements AttributeConverter<Collection<String>, String> {
	public static String DELIMITER = ";";

	@Override
	public String convertToDatabaseColumn(Collection<String> meta) {
		if (meta == null || meta.isEmpty()) return null;
		return String.join(DELIMITER, meta);
	}

	@Override
	public Collection<String> convertToEntityAttribute(String data) {
		if (data == null || data.isEmpty()) return null;
		return Arrays.asList(data.split(DELIMITER));
	}

}
