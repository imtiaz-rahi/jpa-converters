package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Year;

/**
 * Converts {@link Year} to short and back.
 * 
 * https://vladmihalcea.com/java-time-year-month-jpa-hibernate/
 * @author Imtiaz Rahi
 * @since 2020-12-24
 */
@Converter
public class YearToShortConverter implements AttributeConverter<Year, Short> {

	@Override
	public Short convertToDatabaseColumn(Year val) {
		return val == null ? null : (short) val.getValue();
	}

	@Override
	public Year convertToEntityAttribute(Short data) {
		return data == null ? null : Year.of(data);
	}
}