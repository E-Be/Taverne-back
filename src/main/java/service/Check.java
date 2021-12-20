package service;

import exception.CheckLongException;
import exception.CheckStringException;

public class Check {
	
	public static void checkLong(Long id) {
		if (id == null || id < 0) {
			throw new CheckLongException();
		}
	}
	
	public static void checkString(String str) {
		if (str == null) {
			throw new CheckStringException();
		}
	}

}
