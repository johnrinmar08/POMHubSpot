package com.qa.hubspot.util;

public class TimeUtil {

	public static void shortWait() {

		try {
			Thread.sleep(3000L);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void medWait() {

		try {
			Thread.sleep(8000L);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void longWait() {

		try {
			Thread.sleep(10000L);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
