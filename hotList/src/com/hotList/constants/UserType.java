package com.hotList.constants;

public enum UserType {
	CHIEF_EDITOR("chiefeditor"),
	 USER("user"),
	 EDITOR("editor");
	 
	 private UserType(String name) {
		 this.name = name;
	 }
	 private String name;
	 public String getName() {
		 return name;
	 }	
}
