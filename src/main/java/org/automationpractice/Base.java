package org.automationpractice;

import java.io.FileInputStream;
import java.util.Properties;

public class Base {

    public String getPropertyKeyValue(String key){
        String value=null;
        try {
            FileInputStream fis = new FileInputStream(".//src//main//resources//objectRepositary//object.properties");
            Properties pObj = new Properties();
            pObj.load(fis);
            value= pObj.getProperty(key);
            fis.close();
        }
        catch (Exception ex){
            System.out.println("Exception occurred "+ex);
        }
        return value;
    }



}
