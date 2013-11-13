package com.juanignaciosl.ptd.junit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DaysIn2013PtdDateMonthTest {

	@Parameters
	public static Collection<Object[]> daysInMonth() {
		return Arrays.asList(new Object[][] { { 1, 31 }, { 2, 28 }, { 3, 31 },
				{ 4, 30 }, { 5, 31 }, { 6, 30 }, { 7, 31 }, { 8, 31 },
				{ 9, 30 }, { 10, 31 }, { 11, 30 }, { 12, 31 }, });
	}

	private int month;
	private int expectedDays;

	public DaysIn2013PtdDateMonthTest(int month, int expectedDays) {
		this.month = month;
		this.expectedDays = expectedDays;
	}

	@Test
	public void monthHasExpectedDays() throws ParseException {
		assertThat(new PtdDate(firstDayOfMonth(month)).month().size(),
				is(equalTo(expectedDays)));
	}

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			"dd/MM/yyyy");

	private Date firstDayOfMonth(int month) throws ParseException {
		return SDF.parse("01/" + month  + "/2013");
	}

}
