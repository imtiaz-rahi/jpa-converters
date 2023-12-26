package dev.rahi.jpaconv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dev.rahi.jpaconv.LocalDateConverter;

public class LocalDateConverterTest {
	private LocalDateConverter converter;

	@DataProvider
	public Object[][] data() {
		return new Object[][] {
			new Object[] { LocalDate.of(2016, Month.FEBRUARY, 29), 2016, Calendar.FEBRUARY, 29 },
			new Object[] { LocalDate.of(2017, Month.NOVEMBER, 30), 2017, Calendar.NOVEMBER, 30 }
		};
	}

	@Test(dataProvider = "data")
	public void convertToDatabaseColumn(LocalDate dow, int year, int month, int day) {
		Date sqlDate = converter.convertToDatabaseColumn(dow);
		Calendar rs = Calendar.getInstance();
		rs.setTime(sqlDate);
		assertEquals(rs.get(Calendar.YEAR), year);
		assertEquals(rs.get(Calendar.MONTH), month);
		assertEquals(rs.get(Calendar.DAY_OF_MONTH), day);
        assertThat(rs.get(Calendar.HOUR_OF_DAY)).isEqualTo(0);
	}

	@Test(dataProvider = "data")
	public void convertToEntityAttribute(LocalDate dow, int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		LocalDate localDate = converter.convertToEntityAttribute(new Date(cal.getTimeInMillis()));
		assertThat(localDate).isEqualTo(dow);
	}

	@BeforeClass
	public void beforeClass() {
		converter = new LocalDateConverter();
	}

}
