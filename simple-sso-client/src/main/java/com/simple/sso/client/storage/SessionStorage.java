package com.simple.sso.client.storage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author yanxiang.huang 2019-02-14 10:06:09
 */
public enum SessionStorage {
	INSTANCE;
	private Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	
	public void set(String token, HttpSession session) {
		map.put(token, session);
	}
	
	public HttpSession get(String token) {
		if (map.containsKey(token)) {
			return map.remove(token);
		}
		return null;
	}
}