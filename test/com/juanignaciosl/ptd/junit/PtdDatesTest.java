package com.juanignaciosl.ptd.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
		assertEquals(january2, january1.nextDay());
	}

	@Test
	public void theDayBeforeJanuary2IsJanuary1() throws ParseException {
		assertEquals(january1, january2.previousDay());
	}

	@Test
	public void theDayBeforeTheDayAfterJanuary1IsJanuary1()
			throws ParseException {
		assertEquals(january1, january1.nextDay().previousDay());
	}

	@Test
	public void theDayAfterJanuary1IsAfterIt() throws ParseException {
		assertTrue(january1.nextDay().after(january1));
	}

	@Test
	public void twoEqualDatesAreNotTheSameObject() throws ParseException {
		final PtdDate otherJanuary1 = new PtdDate(SDF.parse("01/01/2013"));
		assertEquals(january1, otherJanuary1);
	}

	@Test
	public void canRetrieveJanuary1Epoch() throws ParseException {
		assertNotNull(january1.getEpoch());
	}

}
