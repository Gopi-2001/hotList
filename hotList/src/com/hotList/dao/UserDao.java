package com.hotList.dao;

import java.util.List;

import com.hotList.DataStore;
import com.hotList.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
