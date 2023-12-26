package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2019-01-16
 */
@Converter
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime val) {
		return val == null ? null : Timestamp.valueOf(val);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp data) {
		return data == null ? null : data.toLocalDateTime();
	}
}