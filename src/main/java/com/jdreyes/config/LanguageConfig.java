package com.jdreyes.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LanguageConfig {
    private static LanguageMenus LANGUAGE;

    private static Map<String, String> ENGLSIH_TO_SPAHISH= new HashMap(){{
        put("hola", "hello");
        put("adios", "bye");
    }};
}
