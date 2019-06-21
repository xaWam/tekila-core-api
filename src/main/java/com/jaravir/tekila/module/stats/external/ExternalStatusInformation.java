package com.jaravir.tekila.module.stats.external;

import java.util.Properties;

/**
 * Created by sajabrayilov on 11/4/2015.
 */
public class ExternalStatusInformation {
    private Properties properties;

    public ExternalStatusInformation() {
        this.properties = new Properties();
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }

    public void addProperty (String name, Object value) {
        properties.put(name, value);
    }
}
