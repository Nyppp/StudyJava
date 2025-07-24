package com.example.envdemo.controller;

import com.example.envdemo.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class InfoController {

    // TODO: 필요한 의존성 주입
    private final AppConfig appConfig;
    private final Environment env;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    public InfoController(AppConfig appConfig, Environment env){
        this.appConfig = appConfig;
        this.env = env;
    }

    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();

        info.put("profile", activeProfile);
        info.put("timestamp", new Date());

        info.put("app", Map.of(
                "name", appConfig.getName(),
                "version", appConfig.getVersion()
        ));

        info.put("api", Map.of(
                "url", appConfig.getApi().getUrl(),
                "keyMasked", maskSensitive(appConfig.getApi().getKey()),
                "keyLength", appConfig.getApi().getKey().length()
        ));

        String dbUrl = env.getProperty("spring.datasource.url");
        info.put("database", Map.of(
                "url", maskDatabaseUrl(dbUrl),
                "connected", dbUrl != null
        ));

        return info;
    }

    private String maskSensitive(String value) {
        if(value==null || value.length() < 4){
            return "***";
        }
        int visibleLength = Math.min(4, value.length()/4);
        return value.substring(0,visibleLength) + "*".repeat(value.length() - visibleLength);
    }

    private String maskDatabaseUrl(String url){
        if(url==null) return "NOT_CONFIGURED";

        if(url.contains("@")) {
            return url.replaceAll("://([^:]+):([^@]+)@", "://$1:****@");
        }
        return url;
    }
}
