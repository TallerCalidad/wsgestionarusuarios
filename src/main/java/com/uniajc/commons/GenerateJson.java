package com.uniajc.commons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import net.shibboleth.utilities.java.support.service.ServiceException;

public class GenerateJson {
	protected static final Logger LOGGER = LogManager.getRootLogger();
	public static final GenerateJson JSON = new GenerateJson();
	
	public static GenerateJson getJson() {
		return JSON;
	}

	public String respondeOBJSON(Object i) {
		
		try {
			if (i!=null) {
				return new Gson().toJson(i);
			}else {
				return "";
			}
		} catch (Throwable t) {

			String msg = "unable to convert data from object into json: " + i.toString();
			LOGGER.warn(msg);
			throw new ServiceException(msg);

		}
		
	}

}
