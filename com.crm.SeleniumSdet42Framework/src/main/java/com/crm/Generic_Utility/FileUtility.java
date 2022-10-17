package com.crm.Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtility {
    /**
     * The Method is used to get the common data from the property file
     * @param Key
     * @return
     * @throws IOException
     */ 
	public String getPropertyKeyValue(String Key) throws IOException
	{
		//FileInputStream fis = new FileInputStream("./commondata.property");
		FileInputStream fis = new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
		
	}
	

}
