package com.automation.testutilities;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigRead {
	private static Properties defaultProps = new Properties();
	  static {
	    try {
	    	String currentDir = System.getProperty("user.dir");
			String filepath=currentDir+"/src/test/resources/configuration/config.properties";
	        FileInputStream in = new FileInputStream(filepath);
	        defaultProps.load(in);
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  }
	  public static String getProperty(String key) {
	    return defaultProps.getProperty(key);
	  }
}
