package com.hotList.dao;

import java.util.*;

import com.hotList.DataStore;
import com.hotList.entities.Bookmark;
import com.hotList.entities.UserBookmark;
import com.hotList.entities.WebLink;

public class BookmarkDao {
	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
	
	//In real application, we would have SQL or hibernate Queries
		public List<WebLink> getAllWebLinks(){
			List<WebLink> result = new ArrayList<>();
			List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
			List<Bookmark> allWebLinks = bookmarks.get(0);
			
			for(Bookmark bookmark : allWebLinks) {
				result.add((WebLink)bookmark);
			}
			
			return result;
		}
		
		public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus){
			List<WebLink> result = new ArrayList<>();
			
			List<WebLink> allWebLink = getAllWebLinks();
			
			for(WebLink webLink : allWebLink) {
				if(webLink.getDownloadStatus().equals(downloadStatus)) {
					result.add(webLink);
				}
			}
			
			return result;
		}
}
