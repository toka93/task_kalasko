package util;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;


public class JsonDataReader 

 {
	static String path = System.getProperty("user.dir");


	private  static StringBuffer dataFile=new StringBuffer().append(path).append(File.separator)
	.append("Data").append(File.separator).append("TestData.json");
	
	
	private  static String dataFilePath = dataFile.toString();
	
	private final static Logger log = LogManager.getLogger();

    public static String getValue(String parameter) {
    	  String value=null;
    	try {
    		log.info(dataFilePath.toString());
            // Read the JSON file into a string
            String json = new Scanner(new FileReader(dataFilePath)).useDelimiter("\\Z").next();

            // Parse the JSON string into a JSONObject
            JSONObject jsonObject = new JSONObject(json);

            // Get the value of the "name" key
             value = jsonObject.getString(parameter);

            // Print the value of the "name" key
            log.info("value from file :"+value);
        } catch (Exception e) {
        	 log.info(e.getMessage());
          
        }
        
        return value;
    }
}