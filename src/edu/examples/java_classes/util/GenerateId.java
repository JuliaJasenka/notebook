package edu.examples.java_classes.util;

public final class GenerateId {
	
	private GenerateId() {}
	
	private static int nextId = 0;
	
	public static int nextId() {
		return ++nextId;
	}

}
