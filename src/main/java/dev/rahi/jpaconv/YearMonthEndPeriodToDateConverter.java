package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Date;
import java.time.YearMonth;

/**
 * Year-Month to {@link Date} converter. Stores 2021-02 as 2021-02-28 in DB.
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-22
 * @see YearMonthToDateConverter
 */
@Converter
public class YearMonthEndPeriodToDateConverter implements AttributeConverter<YearMonth, Date> {

	@Override
	public Date convertToDatabaseColumn(YearMonth val) {
		return val == null ? null : Date.valueOf(val.atEndOfMonth());
	}

	@Override
	public YearMonth convertToEntityAttribute(Date data) {
		return data == null ? null : YearMonth.from(data.toLocalDate());
	}

}
