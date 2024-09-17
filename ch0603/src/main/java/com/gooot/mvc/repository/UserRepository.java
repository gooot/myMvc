package com.gooot.mvc.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.gooot.mvc.model.User;

public class UserRepository {
	private static Map<String , User> users =new HashMap<>();

	public static void save(User user){
		users.put(user.getUserId(),user);

	}

	public static Collection<User> findAll() {
		return users.values();
	}
}
