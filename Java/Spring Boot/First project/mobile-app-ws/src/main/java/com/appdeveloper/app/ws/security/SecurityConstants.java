package com.appdeveloper.app.ws.security;

import com.appdeveloper.app.ws.SpringApplicationContext;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	
	public static String getTokenSecret() {
		
		AppPropeties appPropeties = (AppPropeties) SpringApplicationContext.getBean("AppPropeties");
		return appPropeties.getTokenSecret();
	}
}