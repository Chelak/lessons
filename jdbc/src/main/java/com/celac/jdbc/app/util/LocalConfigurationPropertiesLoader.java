package com.celac.jdbc.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LocalConfigurationPropertiesLoader {

    private static Properties properties;

    private LocalConfigurationPropertiesLoader() {

    }

    public static Properties getInstance() {
        if (properties == null) {
            properties = loadProperties();
            return properties;
        }
        return properties;
    }

    private static Properties loadProperties() {
        System.out.println("Start load Properties");
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final Path propertyFile = Paths.get("application.properties");
        Properties appProps = new Properties();
        System.out.println("Load Properties from file" + propertyFile.toString());
        try (InputStream stream = classLoader.getResourceAsStream("application.properties")) {
            appProps.load(stream);
            printToSystemOutput(appProps);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        return appProps;
    }

    private static Properties loadFromFile(String filename) {
        Path configLocation = Paths.get(filename);
        System.out.println("Config location: " + configLocation.toString());
        Properties appProps = new Properties();
        try (InputStream stream = Files.newInputStream(configLocation)) {
            appProps.load(stream);
            printToSystemOutput(appProps);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        return appProps;
    }

    private static void printToSystemOutput(Properties config) throws IOException {
        config.store(System.out, "Loaded properties:");
    }
}
