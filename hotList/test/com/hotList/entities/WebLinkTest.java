package com.hotList.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.hotList.manager.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {

		// Test 1 : porn in url -- false
		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-porn--part-2.html",
				"http://www.javaworld.com");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("For porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// Test 2 : porn in title -- false

		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger---part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("For porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// Test 3 : adult in host -- false

		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger---part-2.html",
				"http://www.adult.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// Test 4 : adult in url ,but not in host part -- true

		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertTrue("For adult in url , but not host - isKidFriendlyEligible() must return true", isKidFriendlyEligible);

		// Test 5 : adult in title only -- true

		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger---part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertTrue("For adult in title - isKidFriendlyEligible() must return true", isKidFriendlyEligible);

	}

}
