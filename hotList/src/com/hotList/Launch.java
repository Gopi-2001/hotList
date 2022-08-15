package com.hotList;

import java.util.*;

import com.hotList.bgjobs.WebpageDownloaderTask;
import com.hotList.entities.Bookmark;
import com.hotList.entities.User;
import com.hotList.manager.BookmarkManager;
import com.hotList.manager.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;

	private static void loadData() {
		System.out.println("1. Loading Data ....");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
	}

	private static void printBookmarkData() {

		for (List<Bookmark> bookmarkList : bookmarks) {
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
	private static void start() {
		
		for(User user : users) {
			view.browse(user, bookmarks);
		}
		
	}
	public static void main(String[] args) {
		loadData();
        start();
        
      //  runDownLoaderJob();
	}

	private static void runDownLoaderJob() {
		WebpageDownloaderTask task = new WebpageDownloaderTask(true);
		
		(new Thread(task)).start();
	}

	

}
