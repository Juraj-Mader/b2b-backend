package com.example.b2b.controller;

import com.example.b2b.model.dto.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final String appName;
    private final String appVersion;

    public PublicController(@Value("${spring.application.name}") String appName,
                            @Value("${app.version}") String appVersion) {
        this.appName = appName;
        this.appVersion = appVersion;
    }
    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("UP", appName, appVersion, Instant.now());
    }
}
