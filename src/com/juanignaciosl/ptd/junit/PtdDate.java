package com.juanignaciosl.ptd.junit;

import java.util.Calendar;
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
		Calendar nextDay = Calendar.getInstance();
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

}
