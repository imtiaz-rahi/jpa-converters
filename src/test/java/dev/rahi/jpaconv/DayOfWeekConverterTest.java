package dev.rahi.jpaconv;

import static java.time.DayOfWeek.*;
import static org.testng.Assert.assertEquals;

import java.time.DayOfWeek;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dev.rahi.jpaconv.DayOfWeekConverter;

public class DayOfWeekConverterTest {
	private DayOfWeekConverter converter;

	@DataProvider
	public Object[][] data() {
		return new Object[][] { new Object[] { THURSDAY, 4 }, new Object[] { SATURDAY, 6 }, new Object[] { MONDAY, 1 }, new Object[] { null, null } };
	}

	@Test(dataProvider = "data")
	public void convertToDatabaseColumn(DayOfWeek dow, Integer dayno) {
		assertEquals(converter.convertToDatabaseColumn(dow), dayno);
	}

	@Test(dataProvider = "data")
	public void convertToEntityAttribute(DayOfWeek dow, Integer dayno) {
		assertEquals(converter.convertToEntityAttribute(dayno), dow);
	}

	@BeforeClass
	public void beforeClass() {
		converter = new DayOfWeekConverter();
	}

}
