package com.juanignaciosl.ptd.junit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class PtdDatesTest {
	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			"dd/MM/yyyy");

	private PtdDate january1;
	private PtdDate january2;

	@Before
	public void setUp() throws ParseException {
		january1 = new PtdDate(SDF.parse("01/01/2013"));
		january2 = new PtdDate(SDF.parse("02/01/2013"));
	}

	@Test
	public void theDayAfterJanuary1IsJanuary2() throws ParseException {
		assertThat(january1.nextDay(), equalTo(january2));
		assertThat(january1.nextDay(), is(equalTo(january2)));
	}

	@Test
	public void theDayBeforeJanuary2IsJanuary1() throws ParseException {
		assertThat(january2.previousDay(), equalTo(january1));
	}

	@Test
	public void theDayBeforeTheDayAfterJanuary1IsJanuary1()
			throws ParseException {
		assertThat(january1.nextDay().previousDay(), equalTo(january1));
	}

	@Test
	public void theDayAfterJanuary1IsAfterIt() throws ParseException {
		assertTrue(january1.nextDay().after(january1));
	}

	@Test
	public void twoEqualDatesAreNotTheSameObject() throws ParseException {
		final PtdDate otherJanuary1 = new PtdDate(SDF.parse("01/01/2013"));
		assertThat(otherJanuary1, not(sameInstance(january1)));
	}

	@Test
	public void canRetrieveJanuary1Epoch() throws ParseException {
		assertThat(january1.getEpoch(), notNullValue());
		assertThat(january1.getEpoch(), not(nullValue()));
	}

	@Test
	public void january1MonthContainsJanuary1() {
		assertThat(january1.month(), hasItem(january1));
	}

}
