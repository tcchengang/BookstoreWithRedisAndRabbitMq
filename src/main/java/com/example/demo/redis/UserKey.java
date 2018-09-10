package com.example.demo.redis;

public class UserKey extends BasePrefix{

	private UserKey(String prefix) {
		super(prefix);
	}
	private UserKey(int time,String prefix) {
		super(time,prefix);
	}
	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
	public static UserKey token = new UserKey(3600*24,"token");
}
