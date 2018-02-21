package com.nu1silva.backbase.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to get the element related properties from
 * locator.properties
 */
public class ElementLocatorProperties {

    private static final Properties properties = new Properties();
    private static ElementLocatorProperties instance;

    static {
        try {
            getResourceStream();
            instance = new ElementLocatorProperties();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to read file. Locator mappings not set");
        }
    }

    private ElementLocatorProperties() {
    }

    public static ElementLocatorProperties getInstance() {
        return instance;
    }

    private static Properties getResourceStream() throws IOException {
        InputStream inputStream = ElementLocatorProperties.class.getResourceAsStream("/locator.properties");
        if (inputStream.available() > 0) {
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } else {
            return null;
        }
    }

    public String getElement(String key) {
        return properties.getProperty(key);
    }
}
