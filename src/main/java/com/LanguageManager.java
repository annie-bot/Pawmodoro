package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LanguageManager {
    private final Properties messages;

    public LanguageManager(String language) {
        messages = new Properties();
        loadMessages(language);
    }

    private void loadMessages(String language) {
        String resourceName = language.equals("pt") ? "messages_pt.properties" : "messages_en.properties";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo de propriedades.");
                return;
            }
            messages.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getMessage(String key) {
        return messages.getProperty(key);
    }
}