package com.hotList;

import com.hotList.constants.BookGenre;
import com.hotList.constants.Gender;
import com.hotList.constants.MovieGenre;
import com.hotList.constants.UserType;
import com.hotList.entities.Bookmark;
import com.hotList.entities.User;
import com.hotList.entities.WebLink;
import com.hotList.entities.UserBookmark;
import com.hotList.manager.BookmarkManager;
import com.hotList.manager.UserManager;
import com.hotList.util.IOUtil;

public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;

	private static User[] users = new User[TOTAL_USER_COUNT];

	public static User[] getUsers() {
		return users;
	}

	private static Bookmark[][] Bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];

	public static Bookmark[][] getBookmarks() {
		return Bookmarks;
	}

	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex = 0;

	public static void add(UserBookmark userBookmark) {
       userBookmarks[bookmarkIndex] = userBookmark;
       bookmarkIndex++;
	}

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {
		String[] data = new String[TOTAL_USER_COUNT];
    	IOUtil.read(data, "User.txt");
    	int rowNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		
    		int gender = Gender.MALE;
    		if (values[5].equals("f")) {
    			gender = Gender.FEMALE;
    		} else if (values[5].equals("t")) {
    			gender = Gender.TRANSGENDER;
    		}
    			
    		users[rowNum++] = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
    	}
	}
	
	private static void loadWebLinks() {
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "WebLink.txt");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		Bookmarks[0][colNum++] = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
    	}
	}
	
	private static void loadMovies() {
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Movie.txt");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] cast = values[3].split(",");
    		String[] directors = values[4].split(",");
    		Bookmarks[1][colNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
    	}
	}
	
	private static void loadBooks() {		    	
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Book.txt");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] authors = values[4].split(",");
    		Bookmarks[2][colNum++] = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
    	}
    }	
}
