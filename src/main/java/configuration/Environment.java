package configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Environment {
    private static Logger logger = LoggerFactory.getLogger(Environment.class);
    private HashMap<String, String> map = new HashMap<>();
    private static Environment instance = null;

    private Environment() {
        String env = System.getProperty("env", "qa").toLowerCase();
        Properties properties = new Properties();
        try {
            logger.info("Fetching the environmental details from :environment."+ env +".properties");
            properties.load(new FileInputStream("src/main/java/configuration/properties/environment."+
                    env +".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> propertyNames = properties.stringPropertyNames();
        for(String key: propertyNames){
            map.put(key, properties.getProperty(key));
        }
    }

    public static Environment getInstance(){
        if(instance == null){
            instance = new Environment();
        }
        return instance;
    }

    public HashMap<String, String> getEnvMap(){
        return map;
    }
}
