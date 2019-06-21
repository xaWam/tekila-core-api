package com.jaravir.tekila.module.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by sajabrayilov on 06.04.2015.
 */
public class ChargeItemRegister {
    private final static String mappingFile = "chargeable_item_mapping.xml";
    private final static Properties properties;
    private final static ChargeItemRegister handle;
    private final static List<String> keyList;

    static {
        properties = new Properties();
        try {
            properties.loadFromXML(ChargeItemRegister.class.getResourceAsStream("chargeable_item_mapping.xml"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        List<Object> tmp = new ArrayList<>(properties.keySet());

        keyList = new ArrayList<>();

        for (Object entry : tmp) {
            keyList.add((String) entry);
        }

        handle = new ChargeItemRegister();
    }

    private ChargeItemRegister() {

    }

    public static ChargeItemRegister getInstance() {
        return handle;
    }

    public String getMappedClass (String key) {
        return (String) properties.get(key.toLowerCase());
    }

    public List<String> getKeys () {
        return keyList;
    }
}
