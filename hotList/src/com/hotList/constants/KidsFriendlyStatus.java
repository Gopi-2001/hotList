package com.hotList.constants;

public enum KidsFriendlyStatus {
	APPROVED("approved"), REJECTED("rejected"), UNKNOWN("unknow");

	private KidsFriendlyStatus(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}
}
