package com.hotList;

import java.util.*;

import com.hotList.constants.KidsFriendlyStatus;
import com.hotList.constants.UserType;
import com.hotList.controllers.BookmarkController;
import com.hotList.entities.Bookmark;
import com.hotList.entities.User;
import com.hotList.partner.Shareable;

public class view {
	public static void browse(User user, List<List<Bookmark>> bookmarks) {

		System.out.println("\n" + user.getEmail() + " is Browsing item ....");

		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// Bookmarking !!				
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked -- " + bookmark);
					}

					
					if (user.getUserType().equals(UserType.EDITOR)
							|| user.getUserType().equals(UserType.CHIEF_EDITOR)) {
						
						// Mark as Kid - Friendly
						if (bookmark.isKidFriendlyEligible()
								|| bookmark.getIsKidFriendlyStatus().equals(KidsFriendlyStatus.UNKNOWN)) {
							KidsFriendlyStatus KidFriendlyStatus = getKidsFriendlyStatusDecision(bookmark);
							
							if(!KidFriendlyStatus.equals(KidsFriendlyStatus.UNKNOWN)) {
								BookmarkController.getInstance().setKidFriendlyStatus(user,KidFriendlyStatus,bookmark);
								
							}
						}
						
						//Sharing		
						if(bookmark.getIsKidFriendlyStatus().equals(KidsFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
							boolean isShared = getShareDecision();
							
							if(isShared) {
								BookmarkController.getInstance().share(user,bookmark);
							}
						}
					}
				}
			}
		}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;	
	}

	private static KidsFriendlyStatus getKidsFriendlyStatusDecision(Bookmark bookmark) {
		 double randomVal = Math.random();
	     
		    return randomVal < 0.4 ? KidsFriendlyStatus.APPROVED :
		        (randomVal >= 0.4 && randomVal < 0.8) ? KidsFriendlyStatus.REJECTED :
		            KidsFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}
}
