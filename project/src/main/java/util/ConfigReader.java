package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	private final static Logger log = LogManager.getLogger();

    public static String getWebsiteConfig(String propertyName) {
        return getPropertyValue("website.properties", propertyName);
    }
    private static String getPropertyValue(String filename, String propertyName) {
        String propertyValue = null;

        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(filename)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException ex) {
        	log.info(ex.toString());
            ex.printStackTrace();
        }

        return propertyValue;
    }
    
   
}
