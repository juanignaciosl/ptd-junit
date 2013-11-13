package com.juanignaciosl.ptd.junit;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class PtdRunningJUnitTest {

	@Test
	public void thisPasses() {

	}

	@Test(timeout = 200)
	@Ignore
	public void thisWontPassSinceItWontEnd() throws InterruptedException {
		while(true);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void youCantReadElement0AtEmptyArrayList() {
		new ArrayList().get(0);
	}
	

}
