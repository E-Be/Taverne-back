package service;

import exception.CheckLongException;

public class Check {
	
	public static void checkLong(Long id) {
		if (id == null || id < 0) {
			throw new CheckLongException();
		}
	}
	
	public static void checkString(Long id) {
		if (id == null || id < 0) {
			throw new CheckLongException();
		}
	}

}
