package com.hotList;

import com.hotList.entities.Bookmark;
import com.hotList.entities.User;
import com.hotList.manager.BookmarkManager;
import com.hotList.manager.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1. Loading Data ....");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		//System.out.println("Printing Data ...");
		//printUserData();
		//printBookmarkData();

	}

	private static void printBookmarkData() {

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}

	}

	private static void printUserData() {

		for (User user : users) {
			System.out.println(user);
		}

	}
	private static void startBookmarking() {
		System.out.println("\n2. Bookmarking ...");
		
		for(User user : users) {
			view.bookmark(user, bookmarks);
		}
		
	}
	public static void main(String[] args) {
		loadData();
        startBookmarking();
	}

	

}
