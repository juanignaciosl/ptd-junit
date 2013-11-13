package com.juanignaciosl.ptd.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.Assert;

import org.junit.Test;

public class PtdDatesTest {

	@Test
	public void theDayAfterJanuary1IsJanuary2() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final PtdDate january1 = new PtdDate(sdf.parse("01/01/2013"));
		final PtdDate january2 = new PtdDate(sdf.parse("02/01/2013"));

		Assert.assertEquals(january2, january1.nextDay());
	}

	@Test
	public void theDayBeforeJanuary2IsJanuary1() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final PtdDate january1 = new PtdDate(sdf.parse("01/01/2013"));
		final PtdDate january2 = new PtdDate(sdf.parse("02/01/2013"));

		Assert.assertEquals(january1, january2.previousDay());
	}

	@Test
	public void theDayBeforeTheDayAfterJanuary1IsJanuary1()
			throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final PtdDate january1 = new PtdDate(sdf.parse("01/01/2013"));

		Assert.assertEquals(january1, january1.nextDay().previousDay());
	}

	@Test
	public void theDayAfterJanuary1IsAfterIt() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final PtdDate january1 = new PtdDate(sdf.parse("01/01/2013"));

		Assert.assertTrue(january1.nextDay().after(january1));
	}
	
	@Test
	public void twoEqualDatesAreNotTheSameObject() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final PtdDate january1 = new PtdDate(sdf.parse("01/01/2013"));
		final PtdDate otherJanuary1 = new PtdDate(sdf.parse("01/01/2013"));

		Assert.assertEquals(january1, otherJanuary1);
	}
	
	@Test
	public void canRetrieveJanuary1Epoch() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final PtdDate january1 = new PtdDate(sdf.parse("01/01/2013"));

		Assert.assertNotNull(january1.getEpoch());
	}

}
