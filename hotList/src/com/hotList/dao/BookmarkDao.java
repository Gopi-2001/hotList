package com.hotList.dao;

import com.hotList.DataStore;
import com.hotList.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
