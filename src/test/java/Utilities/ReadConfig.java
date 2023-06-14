package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	//properties file read karnyasathi object create karne
	
	Properties properties;
	String path="D:\\Project\\Pramod Automation Project 2023\\eclipse\\eclipse\\BDD\\Config.properties";
	
	// constructor tayar karne
	
    public ReadConfig() {                 //constructor
    	try {
    	properties=new Properties();      //object la initialize karne.
    	
    	
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);             //properties file load karne.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    // Base url ki value read karne.
    
    public String getbaseUrl() {
    String value=properties.getProperty("baseUrl");	//value read karne ani ti value string return karte
    
    //value null ahe ka te check karne mhnun if waprle.
    if(value!=null)
    	return value;
    else
    	throw new RuntimeException("url not specified in config file.");
    }
    
    // browser read karne.
    public String getBrowser() {
        String value=properties.getProperty("browser");	//value read karne ani ti value string return karte
        
        //value null ahe ka te check karne mhnun if waprle.
        if(value!=null)
        	return value;
        else
        	throw new RuntimeException("url not specified in config file.");
    
}
}
