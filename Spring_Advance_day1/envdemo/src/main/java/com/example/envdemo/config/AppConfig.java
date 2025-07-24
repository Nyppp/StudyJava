package com.example.envdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Component
@ConfigurationProperties(prefix = "app")
@Validated
public class AppConfig {

    @NotBlank(message="앱 이름은 필수입니다.")
    private String name;

    private String version = "1.0.0";

    @Valid
    @NotNull(message = "API 설정은 필수입니다.")
    private ApiConfig api = new ApiConfig();

    // TODO: Getter/Setter 추가
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ApiConfig getApi() {
        return api;
    }

    public void setApi(ApiConfig api) {
        this.api = api;
    }

    public static class ApiConfig {
        // TODO: 필수값 검증 어노테이션 추가
        @NotBlank(message = "API 키는 필수입니다.")
        private String key;
        @NotNull(message = "API URL은 필수입니다.")
        private String url;

        // TODO: Getter/Setter 추가

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
