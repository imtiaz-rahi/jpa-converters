package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * https://thorben-janssen.com/jpa-tips-map-duration-attribute/
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-23
 */
@Converter
public class DurationToLongConverter implements AttributeConverter<Duration, Long> {
	@Override
	public Long convertToDatabaseColumn(Duration val) {
		return val == null ? null : val.toNanos();
	}

	@Override
	public Duration convertToEntityAttribute(Long data) {
		return data == null ? null : Duration.of(data, ChronoUnit.NANOS);
	}
}
