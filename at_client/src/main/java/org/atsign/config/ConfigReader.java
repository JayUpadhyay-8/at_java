package org.atsign.config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import org.yaml.snakeyaml.Yaml;

/**
 * Loads, reads and returns properties from the configuration file in the resources
 */
public class ConfigReader {
    private Map<String, Object> config;
    private Map<String,String>propertyMap;
    
    public String getProperty(String property, String subProperty) throws StreamReadException, DatabindException, FileNotFoundException{
        if (config == null){
            loadConfig();
        }
        propertyMap = (Map<String, String>) config.get(property);
        return propertyMap.get(subProperty);
    }

    public String getProperty(String property) throws StreamReadException, DatabindException, FileNotFoundException{
        if (config == null){
            loadConfig();
        }
        return (String) config.get(property);
    }

    /**
     * Loads configuration properties from the yaml provided in the java/src/main/resources
     * Stores these key-value pairs in the config map
     * @throws StreamReadException
     * @throws DatabindException
     * @throws FileNotFoundException
     */
    public void loadConfig() throws StreamReadException, DatabindException, FileNotFoundException{
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("config.yaml");
        Yaml configYaml = new Yaml();
        config = configYaml.load(inputStream);
    }
}