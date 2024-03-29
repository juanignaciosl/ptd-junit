package com.juanignaciosl.ptd.junit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class PtdDate {

	private final Calendar date;

	public PtdDate(Date date) {
		this.date = Calendar.getInstance();
		this.date.setTime(date);
	}

	public PtdDate(Calendar date) {
		this(date.getTime());
	}

	public PtdDate nextDay() {
		return new PtdDate(sumDays(1));
	}

	public PtdDate previousDay() {
		return new PtdDate(sumDays(-1));
	}
	
	private Calendar sumDays(int increment) {
		final Calendar nextDay = Calendar.getInstance();
		nextDay.setTime(date.getTime());
		nextDay.add(Calendar.DAY_OF_MONTH, increment);
		return nextDay;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PtdDate other = (PtdDate) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	public boolean after(PtdDate other) {
		return this.date.after(other.date);
	}

	public Date getEpoch() {
		return date.getTime();
	}

	public Collection<PtdDate> month() {
		final Collection<PtdDate> month = new ArrayList<PtdDate>();
		final Calendar day = (Calendar) date.clone();
		for(int i = 1; i <= day.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			day.set(Calendar.DAY_OF_MONTH, i);
			month.add(new PtdDate(day.getTime()));
		}
		return month;
	}
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			"dd/MM/yyyy");

	@Override
	public String toString() {
		return SDF.format(date.getTime());
	}
	
	

}
