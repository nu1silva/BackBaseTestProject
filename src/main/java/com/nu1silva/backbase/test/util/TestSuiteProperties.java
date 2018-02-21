package com.nu1silva.backbase.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to get the test suite related properties from
 * test-suite.properties
 */
public class TestSuiteProperties {

    private static final Properties properties = new Properties();
    private static TestSuiteProperties instance;

    static {
        try {
            getResourceStream();
            instance = new TestSuiteProperties();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to read file. Locator mappings not set");
        }
    }

    private TestSuiteProperties() {
    }

    public static TestSuiteProperties getInstance() {
        return instance;
    }

    private static Properties getResourceStream() throws IOException {
        InputStream inputStream = TestSuiteProperties.class.getResourceAsStream("/test-suite.properties");
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
