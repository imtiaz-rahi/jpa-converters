package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2019-01-16
 */
@Converter
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate val) {
		return val == null ? null : Date.valueOf(val);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date data) {
		return data == null ? null : data.toLocalDate();
	}
}