package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


/**
 * Convert any {@link Object} to JSON string and vice-versa.
 * 
 * @author Imtiaz Rahi
 * @since 2019-01-16
 */
@Converter
public class SetToStringConverter implements AttributeConverter<Set<String>, String> {

	@Override
	public String convertToDatabaseColumn(Set<String> meta) {
		if (meta == null || meta.isEmpty()) return null;
		return String.join(",", meta);
	}

	@Override
	public Set<String> convertToEntityAttribute(String data) {
		if (data == null || data.isEmpty()) return null;
		return new TreeSet<>(Arrays.asList(data.split(",")));
	}

}
