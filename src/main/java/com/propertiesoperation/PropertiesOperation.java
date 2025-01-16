package com.propertiesoperation;

import java.util.Properties;

public class PropertiesOperation {
    public PropertiesOperation(){
        
    }
    Properties propertiesOperation = new Properties();

    protected  String getPropertyValue(String filepath, String key) {
        try {
            propertiesOperation.load(PropertiesOperation.class.getResourceAsStream(filepath));
            return propertiesOperation.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Property not found");
        }
    }
    //  "/config.properties"


}
