package com.hotList.controllers;

import com.hotList.entities.Bookmark;
import com.hotList.entities.User;
import com.hotList.manager.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance  = new BookmarkController();
	private BookmarkController() {}
	
	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}

}
