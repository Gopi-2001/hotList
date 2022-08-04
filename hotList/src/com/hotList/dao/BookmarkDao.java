package com.hotList.dao;

import com.hotList.DataStore;
import com.hotList.entities.Bookmark;
import com.hotList.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
}
