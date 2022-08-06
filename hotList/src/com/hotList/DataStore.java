package com.hotList;

import java.util.*;

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

	private static List<User> users = new ArrayList<User>();

	public static List<User> getUsers() {
		return users;
	}

	private static List<List<Bookmark>> Bookmarks = new ArrayList<List<Bookmark>>();

	public static List<List<Bookmark>> getBookmarks() {
		return Bookmarks;
	}

	private static List<UserBookmark> userBookmarks = new ArrayList<>();

	public static void add(UserBookmark userBookmark) {
       userBookmarks.add(userBookmark);
	}

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {
		List<String> data = new ArrayList<String>();
		
    	IOUtil.read(data, "User.txt");
    	for (String row : data) {
    		String[] values = row.split("\t");
    		
    		Gender gender = Gender.MALE;
    		if (values[5].equals("f")) {
    			gender = Gender.FEMALE;
    		} else if (values[5].equals("t")) {
    			gender = Gender.TRANSGENDER;
    		}
    			
    		User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender,values[6]);
    		users.add(user);
    	}
	}
	
	private static void loadWebLinks() {
		List<String> data = new ArrayList<String>();
    	IOUtil.read(data, "WebLink.txt");
    	List<Bookmark> BookmarkList = new ArrayList<>();
    	
    	for (String row : data) {
    		String[] values = row.split("\t");
    		Bookmark bookmark = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
    	    BookmarkList.add(bookmark);
    	}
	    Bookmarks.add(BookmarkList);
	}
	
	private static void loadMovies() {
		List<String> data = new ArrayList<String>();
    	IOUtil.read(data, "Movie.txt");
    	List<Bookmark> BookmarkList = new ArrayList<>();
    	
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] cast = values[3].split(",");
    		String[] directors = values[4].split(",");
    		Bookmark bookmark = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, MovieGenre.valueOf(values[5]), Double.parseDouble(values[6])/*, values[7]*/);
    		BookmarkList.add(bookmark);
    	}
    	Bookmarks.add(BookmarkList);
	}
	
	private static void loadBooks() {		    	
		List<String> data = new ArrayList<String>();
    	IOUtil.read(data, "Book.txt");
    	List<Bookmark> BookmarkList = new ArrayList<>();
    	
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] authors = values[4].split(",");
    		Bookmark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, BookGenre.valueOf(values[5]), Double.parseDouble(values[6])/*, values[7]*/);
    		BookmarkList.add(bookmark);
    	}
    	Bookmarks.add(BookmarkList);
    }	
}
