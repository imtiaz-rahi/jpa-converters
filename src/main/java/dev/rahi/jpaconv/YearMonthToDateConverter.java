package dev.rahi.jpaconv;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Date;
import java.time.YearMonth;

/**
 * Year-Month to {@link Date} converter. Stores 2020-11 as 2020-11-01 in DB. <br>
 * For ending of a period, use {@link YearMonthEndPeriodToDateConverter}.
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-22
 * @see YearMonthEndPeriodToDateConverter
 */
@Converter
public class YearMonthToDateConverter implements AttributeConverter<YearMonth, Date> {

	@Override
	public Date convertToDatabaseColumn(YearMonth val) {
		return val == null ? null : Date.valueOf(val.atDay(1));
	}

	@Override
	public YearMonth convertToEntityAttribute(Date data) {
		return data == null ? null : YearMonth.from(data.toLocalDate());
	}

}
