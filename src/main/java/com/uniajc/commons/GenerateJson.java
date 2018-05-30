package com.uniajc.commons;

import com.google.gson.Gson;

public class GenerateJson {

	public static final GenerateJson JSON = new GenerateJson();
	
	public static GenerateJson getJson() {
		return JSON;
	}

	public String respondeOBJSON(Object i) {
		return new Gson().toJson(i);
	}

}
