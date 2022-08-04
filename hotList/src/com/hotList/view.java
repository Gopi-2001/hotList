package com.hotList;

import com.hotList.controllers.BookmarkController;
import com.hotList.entities.Bookmark;
import com.hotList.entities.User;

public class view {
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is Bookmarking ....");
		for (int i = 0; i < DataStore.TOTAL_USER_COUNT; i++) {
            int typeOffset = (int)(Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
            
            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
            
             BookmarkController.getInstance().saveUserBookmark(user,bookmark);
            
            System.out.println(bookmark);
		}
	}
}
