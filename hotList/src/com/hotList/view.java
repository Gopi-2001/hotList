package com.hotList;

import com.hotList.constants.KidsFriendlyStatus;
import com.hotList.constants.UserType;
import com.hotList.controllers.BookmarkController;
import com.hotList.entities.Bookmark;
import com.hotList.entities.User;

public class view {
	public static void browse(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is Browsing item ....");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// Bookmarking !!
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked -- " + bookmark);
					}

					// Mark as Kid - Friendly
					if (user.getUserType().equals(UserType.EDITOR)
							|| user.getUserType().equals(UserType.CHIEF_EDITOR)) {
						if (bookmark.isKidFriendlyEligible()
								|| bookmark.getIsKidFriendlyStatus().equals(KidsFriendlyStatus.UNKNOWN)) {
							String KidFriendlyStatus = getKidsFriendlyStatusDecision(bookmark);
							
							if(!KidFriendlyStatus.equals(KidsFriendlyStatus.UNKNOWN)) {
								bookmark.setIsKidFriendlyStatus(KidFriendlyStatus);
								
								System.out.println("Kid-Friendly Status : " + KidFriendlyStatus + ", " + bookmark);
							}
						}
					}
				}
			}
		}
	}

	private static String getKidsFriendlyStatusDecision(Bookmark bookmark) {
		 double randomVal = Math.random();
	     
		    return randomVal < 0.4 ? KidsFriendlyStatus.APPROVED :
		        (randomVal >= 0.4 && randomVal < 0.8) ? KidsFriendlyStatus.REJECTED :
		            KidsFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}
}
