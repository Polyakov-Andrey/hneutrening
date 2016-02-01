package com.rozdolskyi.traininghneu.enums;

public enum LessonType {
	
	LECTURE("L"), PRACTICE("P");
	
	private String name;
	
	private LessonType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
