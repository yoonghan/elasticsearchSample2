package com.self.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JSONUtil {
	private JSONUtil(){
	}

	private static final GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	private static final Gson		 api 		 = gsonBuilder.create();
	public static String toString(Object value){
		return api.toJson(value);
	}

	public static <T> T toJSON(Class<T> classOfT,String value){
		return api.fromJson(value, classOfT);
	}
	
	public static final GsonBuilder getGsonBuilder(){
		return gsonBuilder;
	}
}