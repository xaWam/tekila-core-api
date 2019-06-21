package com.jaravir.tekila.base.config;

import java.util.Properties;

public class Config {
	private Properties props;

	public void onPostConstruct() {
		this.props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream("/META-INF/application.properties"));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	public String getProperty (ConfigProperty prop) {
		return props.getProperty(prop.name().replace('_', '-').toLowerCase());	
	}
	
	public String getPropertyByName (String key) {
		return this.props.getProperty(key);
	}	
}
