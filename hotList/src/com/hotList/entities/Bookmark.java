package com.hotList.entities;

import com.hotList.constants.KidsFriendlyStatus;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profileUrl;
    private KidsFriendlyStatus isKidFriendlyStatus = KidsFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	
	public abstract boolean isKidFriendlyEligible();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public KidsFriendlyStatus getIsKidFriendlyStatus() {
		return isKidFriendlyStatus;
	}

	public void setIsKidFriendlyStatus(KidsFriendlyStatus isKidFriendlyStatus) {
		this.isKidFriendlyStatus = isKidFriendlyStatus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
}
